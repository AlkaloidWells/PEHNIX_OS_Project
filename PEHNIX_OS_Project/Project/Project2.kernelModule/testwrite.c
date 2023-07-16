#include<stdio.h>
#include<string.h>

int main(){
	FILE *fp;
	int v=0;
	int val;
	char s[20],ch;
	
	fp = fopen("/proc/mtest","w+");
	
	while(1){
		scanf("%s",s);
		if(strcmp(s,"print")==0){
			rewind(fp);
			while((ch=fgetc(fp))!=EOF){
				printf("%c",ch);
			}
			//ch=fgetc(fp);
			printf("%d\n",v);
		}else if(strncmp(s,"write",5)==0){
			scanf("%d",&val);
			fprintf(fp,"writeval %lx %d\n",(unsigned long)&v,val);
			//fprintf(fp,"findpage %lx\n",(unsigned long)&v);
			fflush(fp);
		}
		else if(strcmp(s,"exit")==0)break;
	}
	
	fclose(fp);
	return 0;
}