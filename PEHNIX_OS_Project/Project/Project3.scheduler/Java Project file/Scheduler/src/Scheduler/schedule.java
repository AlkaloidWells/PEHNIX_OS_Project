/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dr. Alkaloid Wells
 */
public class schedule extends javax.swing.JFrame {

    /**
     * Creates new form schedule1
     */
    public schedule() {
        initComponents();
        tableshow();
    }
    Connection con;
     PreparedStatement pst;
     ResultSet rs;
     ResultSetMetaData rss;
     DefaultTableModel Df;
     Connection con1;
     PreparedStatement pst1;
     ResultSet rs1;
     Connection con2;
     PreparedStatement pst2;
     ResultSet rs2;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBtime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAtime = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtpro = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InputT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        outT1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        outT2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Compare Scheduling Algorithm Here");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Proces information"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtBtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 189, 148, -1));

        jLabel3.setText("Arival Time");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 108, -1, -1));

        jLabel4.setText("Bus Time");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 164, -1, -1));
        jPanel2.add(txtAtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 133, 148, -1));

        jButton1.setText("Edit");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        jLabel6.setText("Priority");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 215, -1, -1));
        jPanel2.add(txtpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 235, 148, -1));

        jButton7.setText("Clear");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jButton8.setText("Add");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 77, 148, -1));

        jLabel2.setText("Proces Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 57, -1, -1));

        jButton2.setText("FCFS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("SJFP");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("SJFN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("RR");

        jLabel5.setText("QT");

        InputT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "PN", "AT", "BT", "PL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(InputT);

        outT1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "WT", "TA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(outT1);

        outT2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "AWT", "ATA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(outT2);

        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setText("Clear");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButton6)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jButton9)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)
                                    .addComponent(jLabel5))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(jButton5)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     private void tableshow()// throws ClassNotFoundException, SQLException
             {
                 int c;
                 try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
                pst = con.prepareStatement("select * from pinfo");
                rs = pst.executeQuery();
                rss = rs.getMetaData();
                c = rss.getColumnCount();
                c = c+1;
                Df = (DefaultTableModel)InputT.getModel();
                Df.setRowCount(0);
                while(rs.next())
                 {
                             Vector v2 = new Vector();
                             for (int j =0; j<= c; j++)
                             {
                                 v2.add(rs.getString("pname"));
                                 v2.add(rs.getInt("Atime"));
                                 v2.add(rs.getInt("Btime"));
                                 v2.add(rs.getInt("Pleve"));
                                 
                             }
                             Df.addRow(v2);
                        
                 }
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
  private void FCFS()
  {
      int c;
                 try {
                     

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
                pst = con.prepareStatement("select * from pinfo");
                rs = pst.executeQuery();
                rss = rs.getMetaData();
                c = rss.getColumnCount();
                c =c+1;
                System.out.println(c);  
                int pid[] = {0};
                pid = new int[c]; // process ids
                int ar[] = {0};
                ar = new int[c]; // arrival times
                int bt[]= {0};
                 bt = new int[c];  // burst or execution times
                int ct[]= {0};
                ct = new int[c]; // completion times
                int ta[] = {0}; 
                ta = new int[c]; // turn around times
                int wt[] = {0};
                wt = new int[c]; // waiting times
                int temp;
                float avgwt=0,avgta=0;
                //Df = (DefaultTableModel)InputT.getModel();
                //Df.setRowCount(0);
                while(rs.next())
                 {
                             //Vector v2 = new Vector();
                             for (int j =0; j< c; j++)
                             {
                                ar[j] = rs.getInt("Atime");
                                bt[j]= rs.getInt("Btime");
                                pid[j] = j+1;
                             }
                            // Df.addRow(v2);
                        
                 }
    for(int i = 0 ; i <c; i++)
    {
        int j;
    for(j=1; j < c-(i+1) ; j++)
    {
    if( ar[j] > ar[j+1] )
    {
    temp = ar[j];
    ar[j] = ar[j+1];
    ar[j+1] = temp;
    temp = bt[j];
    bt[j] = bt[j+1];
    bt[j+1] = temp;
    temp = pid[j];
    pid[j] = pid[j+1];
    pid[j+1] = temp;
    }
    }
    
    for(i = 0 ; i < c; i++)
    {
    if( i == 0)
    {
    ct[i] = ar[i] + bt[i];    
    }
    else
    {
    if( ar[i] > ct[i-1])
    {
    ct[i] = ar[i] + bt[i];
    }
    else
    ct[i] = ct[i-1] + bt[i];
    }
    ta[i] = ct[i] - ar[i]; // turnaround time= completion time- arrival time
    wt[i] = ta[i] - bt[i]; // waiting time= turnaround time- burst time
    avgwt += wt[i]; // total waiting time
    avgta += ta[i];
        Class.forName("com.mysql.jdbc.Driver");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
        pst1 = con1.prepareStatement("insert into calval(Ttim, Wtime)value(?, ?)");
        pst1.setInt(1, ta[i]);
        pst1.setInt(2, wt[i]);
        pst1.execute();
     // total turnaround time
    }
    avgwt = avgwt/c;
    avgta = avgta/c;
        con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
        pst2 = con1.prepareStatement("insert into avgcal(ATtime, AWtime)value(?, ?)");
        pst2.setFloat(1, avgta);
        pst2.setFloat(2, avgwt);
        pst2.executeUpdate();
    
}
                
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            } 
     
     
       
  }
  private void SJFN()
  { 
      int n;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
            pst = con.prepareStatement("select * from pinfo");
            rs = pst.executeQuery();
            rss = rs.getMetaData();
            n = rss.getColumnCount();
            n =n+1;
            int pid[] = new int[n];
            int at[] = new int[n]; // at means arrival time
            int bt[] = new int[n]; // bt means burst time
            int ct[] = new int[n]; // ct means complete time
            int ta[] = new int[n]; // ta means turn around time
            int wt[] = new int[n]; //wt means waiting time
            int f[] = new int[n]; // f means it is flag it checks process is completed or not
            int st=0, tot=0;
            float avgwt=0, avgta=0;

        while(rs.next())
            {
                      //Vector v2 = new Vector();
                 for (int j =0; j< n; j++)
                       {
                          at[j] = rs.getInt("Atime");
                          bt[j]= rs.getInt("Btime");
                          pid[j] = j+1;
                       }
                            // Df.addRow(v2);
                        
            }

boolean a = true;
while(true)
{
int c=n, min=999;
if (tot == n) // total no of process = completed process loop will be terminated
break;

for (int i=0; i<n; i++)
{
/*
* If i'th process arrival time <= system time and its flag=0 and burst<min
* That process will be executed first
*/
        if ((at[i] <= st) &&(f[i] == 0) &&(bt[i]<min))
        {
        min=bt[i];
        c=i;
        }
        }

        /* If c==n means c value can not updated because no process arrival time<system time so we increase the system time */
        if (c==n)
        st++;
        else
        {
        ct[c]=st+bt[c];
        st+=bt[c];
        ta[c]=ct[c]-at[c];
        wt[c]=ta[c]-bt[c];
        f[c]=1;
        tot++;
        }
        }

//System.out.println("\npid  arrival brust  complete turn waiting");
for(int i=0;i<n;i++)
{
        Class.forName("com.mysql.jdbc.Driver");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
        pst1 = con1.prepareStatement("insert into calval(Ttim, Wtime)value(?, ?)");
        pst1.setInt(1, ta[i]);
        pst1.setInt(2, wt[i]);
        pst1.execute();
        avgwt+= wt[i];
        avgta+= ta[i];
//System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);
}
        avgwt = avgwt/n;
        avgta = avgta/n;
        con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
        pst2 = con1.prepareStatement("insert into avgcal(ATtime, AWtime)value(?, ?)");
        pst2.setFloat(1, avgta);
        pst2.setFloat(2, avgwt);
        pst2.executeUpdate();
        //sc.close();

        // total turnaround time
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
      
  }
  
private void display()
  {
      
                 int c=0;
                 try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
                pst = con.prepareStatement("select * from calval");
                rs = pst.executeQuery();
                rss = rs.getMetaData();
                c = rss.getColumnCount();
                c = c+1;
                Df = (DefaultTableModel)outT1.getModel();
                Df.setRowCount(0);
                while(rs.next())
                 {
                             Vector v2 = new Vector();
                             for (int j =0; j<= c; j++)
                             {
 
                                 v2.add(rs.getInt("Wtime"));
                                 v2.add(rs.getInt("Ttim"));
                                 
                                 
                             }
                             Df.addRow(v2);
                        
                 }
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
  
  }
private void SJFP()
{ int n =0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
             pst = con.prepareStatement("select * from pinfo");
            rs = pst.executeQuery();
            rss = rs.getMetaData();
            n = rss.getColumnCount();
            n =n+1;
            
        int pid[] = new int[n];  // it takes pid of process
        int at[] = new int[n];  // at means arrival time
        int bt[] = new int[n]; // bt means burst time
        int ct[] = new int[n]; // ct means complete time
        int ta[] = new int[n]; // ta means turn around time
        int wt[] = new int[n]; // wt means waiting time
        int f[] = new int[n]; // f means it is flag it checks process is completed or not
        int k[]= new int[n]; // it is also stores brust time
        int i, st=0, tot=0;
        float avgwt=0, avgta=0;
         while(rs.next())
            {
                      //Vector v2 = new Vector();
                
                            for (i=0;i<n;i++)
                        {
                            at[i] = rs.getInt("Atime");
                            bt[i]= rs.getInt("Btime");
                            pid[i] = i+1;
                            k[i]= bt[i];
                            f[i]= 0;
                        }
            
            }
  
    while(true){
        int min=99,c=n;
        if (tot==n)
            break;
        for ( i=0;i<n;i++)
        {
        if ((at[i]<=st) &&(f[i]==0) &&(bt[i]<min))
        {
        min=bt[i];
        c=i;
         }
            }
            if (c==n)
                st++;
            else
            {
                bt[c]--;
                st++;
            if (bt[c]==0)
            {
                ct[c]= st;
                f[c]=1;
                tot++;
            }
             }
                }

            for(i=0;i<n;i++)
            {
            ta[i] = ct[i] - at[i];
             wt[i] = ta[i] - k[i];
                avgwt+= wt[i];
                avgta+= ta[i];
            }
    
        System.out.println("pid  arrival  burst  complete turn waiting");
        for(i=0;i<n;i++)
        {
             Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
            pst1 = con1.prepareStatement("insert into sjfp(Ta, Wt)value(?, ?)");
            pst1.setInt(1, ta[i]);
            pst1.setInt(2, wt[i]);
            pst1.execute();
        }
            float av = avgta/n;
            float am  = avgwt/n;
            con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
            pst2 = con1.prepareStatement("insert into avgcal(ATtime, AWtime)value(?, ?)");
            pst2.setFloat(1, av);
            pst2.setFloat(2, am);
            pst2.executeUpdate();
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
     
}
  private void display1()
  {
       int c;
                 try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
                pst = con.prepareStatement("select * from avgcal");
                rs = pst.executeQuery();
                rss = rs.getMetaData();
                c = rss.getColumnCount();
                c = c+1;
                Df = (DefaultTableModel)outT2.getModel();
                Df.setRowCount(0);
                while(rs.next())
                 {
                             Vector v2 = new Vector();
                             for (int j =0; j<= c; j++)
                             {
                                 
                                 v2.add(rs.getFloat("AWtime"));
                                 v2.add(rs.getFloat("ATtime"));
                                 
                                 
                             }
                             Df.addRow(v2);
                        
                 }
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
  
  }
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        if(txtName.getText().length()== 0)
        {
            JOptionPane.showMessageDialog(this, "Please specify process name");
        }
        else if(txtAtime.getText().length()== 0)
        {
            JOptionPane.showMessageDialog(this, "Please specify Arrival Time");
        }
        else if(txtBtime.getText().length()== 0)
        {
            JOptionPane.showMessageDialog(this, "Please Specify Bus Time");
        }
        else
        {
            try {

                int plevel = 0;
                String pname = txtName.getText();
                int atime = Integer.parseInt(txtAtime.getText());
                int  btime = Integer.parseInt(txtBtime.getText());
                plevel = Integer.parseInt(txtpro.getText());

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
                pst = con.prepareStatement("insert into pinfo(pname, Atime, Btime, Pleve)values(?,?,?,?)");

                pst.setString(1, pname);
                pst.setInt(2, atime);
                pst.setInt(3, btime);
                pst.setInt(4, plevel);
                pst.executeUpdate();
                txtName.setText("");
                txtAtime.setText("");
                txtBtime.setText("");
                //txtpro.setText("");
                tableshow();
                txtName.requestFocus();
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            FCFS();
            display();
            display1();
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
                pst = con.prepareStatement("delete from pinfo");
                pst.execute();
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
                pst = con.prepareStatement("delete from calval");
                pst.execute();
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
                pst = con.prepareStatement("delete from avgcal");
                pst.execute();
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        SJFN();
         display();
            display1();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         SJFP();
         
                 int c=0;
                 try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduler","root","");
                pst = con.prepareStatement("select * from sjfp");
                rs = pst.executeQuery();
                rss = rs.getMetaData();
                c = rss.getColumnCount();
                c = c+1;
                Df = (DefaultTableModel)outT1.getModel();
                Df.setRowCount(0);
                while(rs.next())
                 {
                             Vector v2 = new Vector();
                             for (int j =0; j<= c; j++)
                             {
 
                                 v2.add(rs.getInt("Wt"));
                                 v2.add(rs.getInt("Ta"));
                                 
                                 
                             }
                             Df.addRow(v2);
                        
                 }
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
         display1();
 
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InputT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable outT1;
    private javax.swing.JTable outT2;
    public javax.swing.JTextField txtAtime;
    public javax.swing.JTextField txtBtime;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtpro;
    // End of variables declaration//GEN-END:variables
}
