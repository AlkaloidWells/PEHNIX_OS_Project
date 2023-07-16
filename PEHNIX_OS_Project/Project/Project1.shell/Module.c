
/********** Dr Alkaloid wells Including Necessary Header Files **********/

#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <string.h>
#include <readline/readline.h>
#include <readline/history.h>
#include <errno.h>
#include <fcntl.h>
#include <signal.h>

/********** Declaring  All Global variables **********/

int fd;
static char *args[512];
static char prompt[512];
char *history_file;
char *input_buffer;
char *cmd_exec[512];
int flag, len;
char cwd[1024];
int bckgrnd_flag;
pid_t pid;
int no_of_lines;
int environmment_flag;
int flag_without_pipe,  output_redirection, input_redirection;
int status;
char *input_redirection_file;
char *output_redirection_file;


/********** Declaring All Function we will be making use off  **********/

void clear_variables(); 
void print_history_list ();
void environmment();
void set_environment_variables();
void change_directory();
void help();
char *skipwhite (char* );
void tokenize_by_space (char *);
void tokenize_redirect_input_output(char *);
void tokenize_redirect_input(char *);
void tokenize_redirect_output(char *);
char *skip_double_quote(char* );
static int execute_inbuild_commands(char *, int, int, int);
void tokenize_by_pipe ();
static int execute_command(int, int, int, char *);
void shell_prompt(); 
void sigintHandler(int );
void check_for_bckgrnd ();

/********** Function Definitions **********/

/* This function handles the interrupt signals */

void sigintHandler(int sig_num) {

    signal(SIGINT, sigintHandler);
    fflush(stdout);
    return;
}


/* This function initializes the global variables */

void clear_variables() {

	fd = 0;
	flag = 0;
	len = 0;
	no_of_lines = 0;
	flag_without_pipe = 0;
	output_redirection = 0;
	input_redirection = 0;
	cwd[0] = '\0';
	prompt[0] = '\0';
 	pid = 0;
	environmment_flag = 0;
}

/* This function prints the comand history when "history" command is given */

void print_history_list () {
  	
  	register HIST_ENTRY **the_list;
    	register int i;

    the_list = history_list ();
    if (the_list)
    	for (i = 0; the_list[i]; i++)
            printf ("%d: %s\n", i + history_base, the_list[i]->line);
    return;
}
  void help()
  {
  	printf("\n*****wellcome to the shell program*****\n");
  	printf("\nThe shell excute bouth buildin \nand external comand like :");
  	printf("\n -cd\n -ls\n -help\n -exit\n -Input and output redirction(<, >)\n -Piping(|)");
  	printf("\nall order general unix comands\nwe also have history feature use the arrow keys");
  	printf("\nUse at your own risk\n");
  }
  
/* This function is used to create the Shell Prompt */

void shell_prompt() {

	if (getcwd(cwd, sizeof(cwd)) != NULL) {

		strcpy(prompt, "alkaloid_shell: ");
		strcat(prompt, cwd);
		strcat(prompt, "$ ");
	}
	else {

		perror("Error in getting curent working directory: ");
	}
	return;
}

/* This function is used to skip the white spaces in the input string */

char *skipwhite (char* str) {

	int i = 0, j = 0;
	char *temp;
	if (NULL == (temp = (char *) malloc(sizeof(str)*sizeof(char)))) {
		perror("Memory Error: ");
		return NULL;
	}

	while(str[i++]) {

		if (str[i-1] != ' ')
			temp[j++] = str[i-1];
	}
	temp[j] = '\0';
	return temp;
}

/* This function is used to skip the double quote characters (") in the
   input string */

char *skip_double_quote (char *str) {

	int i = 0, j = 0;
	char *temp;
	if (NULL == (temp = (char *) malloc(sizeof(str)*sizeof(char)))) {
		perror("Memory Error: ");
		return NULL;
	}

	while(str[i++]) {

		if (str[i-1] != '"')
			temp[j++] = str[i-1];
	}
	temp[j] = '\0';
	return temp;
}

/* This function is used to change directory when "cd" command is 
   executed */

void change_directory() {

	char *home_dir = "/home";

	if ((args[1]==NULL) || (!(strcmp(args[1], "~") && strcmp(args[1], "~/"))))
		chdir(home_dir);
	else if (chdir(args[1]) < 0)
		perror("No such file or directory: ");

}

/* This function is used to execute the inbuild commands. It also calls 
   the "execute_command" function when the command to be executed doesn't
   fall under inbuild commands */

static int execute_inbuild_commands (char *cmd_exec, int input, int isfirst, int islast) {

	char *new_cmd_exec;

	new_cmd_exec = strdup(cmd_exec);

	tokenize_by_space (cmd_exec);
	check_for_bckgrnd ();

	if (args[0] != NULL) {
		if (!(strcmp(args[0], "exit") && strcmp(args[0], "quit")))
			exit(0);

		if (strcmp(args[0], "echo")) {

			cmd_exec = skip_double_quote(new_cmd_exec);
			tokenize_by_space(cmd_exec);
		}

		if (!strcmp("cd", args[0])) {

			change_directory();
			return 1;
		}

		if (!strcmp(args[0], "history")) {
			
			print_history_list();
			return 1;
		}
		 if(!strcmp(args[0], "help")) {
			
			help();
			return 1;
		}
	}
	return (execute_command(input, isfirst, islast, new_cmd_exec));
}

/* This function is used to parse the input when both input redirection 
   ["<"] and output redirection [">"] are present */

void tokenize_redirect_input_output (char *cmd_exec) {

	char *val[128];
	char *new_cmd_exec, *s1, *s2;
	new_cmd_exec = strdup(cmd_exec);

	int m = 1;
	val[0] = strtok(new_cmd_exec, "<");
	while ((val[m] = strtok(NULL,">")) != NULL) m++;

	s1 = strdup(val[1]);
	s2 = strdup(val[2]);

	input_redirection_file = skipwhite(s1);
	output_redirection_file = skipwhite(s2);

	tokenize_by_space (val[0]);
	return;
}

/* This function is used to parse the input when only input redirection
   ["<"] is present */

void tokenize_redirect_input (char *cmd_exec) {

	char *val[128];
	char *new_cmd_exec, *s1;
	new_cmd_exec = strdup(cmd_exec);

	int m = 1;
	val[0] = strtok(new_cmd_exec, "<");
	while ((val[m] = strtok(NULL,"<")) != NULL) m++;

	s1 = strdup(val[1]);
	input_redirection_file = skipwhite(s1);

	tokenize_by_space (val[0]);
	return;
}

/* This function is used to parse the input when only output redirection
   [">"] is present */

void tokenize_redirect_output (char *cmd_exec) {

	char *val[128];
	char *new_cmd_exec, *s1;
	new_cmd_exec = strdup(cmd_exec);

	int m = 1;
	val[0] = strtok(new_cmd_exec, ">");
	while ((val[m] = strtok(NULL,">")) != NULL) m++;

	s1 = strdup(val[1]);
	output_redirection_file = skipwhite(s1);

	tokenize_by_space (val[0]);
	return;
}

/* This function is used to create pipe and execute the non-inbuild
   commands using execvp */

static int execute_command (int input, int first, int last, char *cmd_exec) {

	int mypipefd[2], ret, input_fd, output_fd;

	if (-1 == (ret = pipe(mypipefd))) {
		perror("pipe error: ");
		return 1;
	}

	pid = fork();

	if (pid == 0) {

		if (first == 1 && last == 0 && input == 0) {
			
			dup2 (mypipefd[1], 1);
		}
		else if (first == 0 && last == 0 && input != 0) {

			dup2 (input, 0);
			dup2 (mypipefd[1], 1);
		}
		else {

			dup2 (input, 0);
		}

		if (strchr(cmd_exec, '<') && strchr(cmd_exec, '>')) {

			input_redirection = 1;
			output_redirection = 1;
			tokenize_redirect_input_output (cmd_exec);
		}
		else if (strchr(cmd_exec, '<')) {

			input_redirection = 1;
			tokenize_redirect_input (cmd_exec);
		}
		else if (strchr(cmd_exec, '>')) {

			output_redirection = 1;
			tokenize_redirect_output (cmd_exec);
		}

		if (output_redirection) {

			if ((output_fd = creat(output_redirection_file, 0644)) < 0) {

				fprintf(stderr, "Failed to open %s for writing\n", output_redirection_file);
				return (EXIT_FAILURE);
			}
			dup2 (output_fd, 1);
			close (output_fd);
			output_redirection = 0;
		}

		if (input_redirection) {

			if ((input_fd = open(input_redirection_file, O_RDONLY, 0)) < 0) {

				fprintf(stderr, "Failed to open %s for reading\n", input_redirection_file);
				return (EXIT_FAILURE);
			}
			dup2 (input_fd, 0);
			close (input_fd);
			input_redirection = 0;
		}
		
		check_for_bckgrnd ();

		if (!strcmp (args[0], "echo")) {
			//echo_calling(cmd_exec);
		}
		else if (execvp(args[0], args) < 0) {
			fprintf(stderr, "%s: Command not found\n",args[0]);
		}
		exit(0);
	}

	else {

		if (bckgrnd_flag == 0)
			waitpid(pid,0,0);
	}

	if (last == 1)
		close(mypipefd[0]);

	if (input != 0)
		close(input);

	close(mypipefd[1]);
	return (mypipefd[0]);
}

/* This function tokenizes the input string based on white-space [" "] */

void tokenize_by_space (char *str) {

	int m = 1;

	args[0] = strtok(str, " ");
	while ((args[m] = strtok(NULL," ")) != NULL) m++;
	args[m] = NULL;
}

/* This is function is used to check whether the process should be run
   foreground or background */

void check_for_bckgrnd () {

	int i = 0;
	bckgrnd_flag = 0;
	
	while (args[i] != NULL) {
		if (!strcmp(args[i], "&")) {
			bckgrnd_flag = 1;
			args[i] = NULL;
			break;
		}
		i++;
	}

}

/* This function tokenizes the input string based on pipe ["|"] */

void tokenize_by_pipe() {

	int i, n = 1, input = 0, first = 1;

	cmd_exec[0] = strtok(input_buffer, "|");
	while ((cmd_exec[n] = strtok(NULL, "|")) != NULL) n++;

	cmd_exec[n] = NULL;
	
	for (i = 0; i < n-1; i++) {

		input = execute_inbuild_commands(cmd_exec[i], input, first, 0);	
		first = 0;
	} 

	input = execute_inbuild_commands(cmd_exec[i], input, first, 1);
	return;
}


