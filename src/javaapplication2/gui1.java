/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sapna singh
 */
package javaapplication2;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

public class gui1 extends javax.swing.JFrame {
    
        private Connection connect = null;
        private Statement statement = null;
        private PreparedStatement preparedStatement = null;
        private ResultSet resultSet = null;
        
    /**
     * Creates new form NewJFrame
     */
    public gui1(){
        initComponents();     
            try {
                write_table();
            } catch (Exception ex) {
                Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
     private void close() {
                try {
                        if (resultSet != null) {
                                resultSet.close();
                        }

                        if (statement != null) {
                                statement.close();
                        }

                        if (connect != null) {
                                connect.close();
                        }
                } catch (Exception e) {

                }
        }
    
    
   public void write_table() throws Exception
    {
          try {
                        // This will load the MySQL driver, each DB has its own driver
                        Class.forName("com.mysql.jdbc.Driver");
                        // Setup the connection with the DB
                        connect = DriverManager
                                        .getConnection("jdbc:mysql://localhost/ipl-1?"
                                                        + "user=root&password=Abhijeet05");

                        // Statements allow to issue SQL queries to the database
                        statement = connect.createStatement();
                        // Result set get the result of the SQL query
                        resultSet = statement
                                        .executeQuery("Select * from player_info, player_season where player_info.PLAYER_ID=player_season.PLAYER_ID");                                              
                        
                        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                        model1.setRowCount(0);  
                        
                        while (resultSet.next()) {                       
                        int play_id = resultSet.getInt("PLAYER_ID");
                        String play_name = resultSet.getString("PLAYER_NAME");
                        String role = resultSet.getString("ROLE");
                        int indian = resultSet.getInt("INDIAN");
                        play_id = resultSet.getInt("PLAYER_ID");
                        String team =resultSet.getString("TEAM");
                        int cost= resultSet.getInt("COST");
                        int cap= resultSet.getInt("CAP");
                        
                       model1.addRow(new Object[]{play_id,play_name,role,indian,team,cost,cap});                  
                      
                }
                } catch (Exception e) {
                                       throw e;
                } finally {
                        close();
                }        
    }
   
   
    public static String check(String id[],String role[],String cost[],String fp[],String capped[])
{

System.out.println(role.length);
if(role.length!=11) return "Player Limit Incorrect";
System.out.println(role.length);

int bats=0,bowl=0,keep=0,ar=0,cap=0,foreign=0;
long tc=0;
 
int f[]=new int[100];
 
for(int i=0;i<100;i++)
{
	f[i]=0;
}
 
for(int i=0;i<11;i++)
{
	int temp=Integer.parseInt(id[i]);
	f[temp]++;
	if(f[temp]>1) return "Duplicate Players";
	if("0".equals(capped[i])) cap++;
	if("0".equals(fp[i])) foreign++;
	tc+=Long.parseLong(cost[i]);
	if("Batsman".equals(role[i])) bats++;
	else if("Bowler".equals(role[i])) bowl++;
	else if("All".equals(role[i])) ar++;
	else keep++;
}
 
String ans="";
 
if(tc>100000000) return "Total cost limit exceeded. Mallaya Spotted.";
if(foreign>5) return "Foreign player Limit Exceeded";
if(cap==0) return "No Uncapped Player";
if(bats<2 || bats>5) return "Incorrect no. of batsman";
if(bowl<2 || bowl>5) return "Incorrect no. of bowlers";
if(keep==0) return "No keeper";

if(ar>4) return "Incorrect no. of all-rounders";
 
return "Team Created Successfully !!! ";
 
}
   
     
   public void printAllr(String s) throws Exception
   {
       try {
                        // This will load the MySQL driver, each DB has its own driver
                        Class.forName("com.mysql.jdbc.Driver");
                        // Setup the connection with the DB
                        connect = DriverManager
                                        .getConnection("jdbc:mysql://localhost/ipl-1?"
                                                        + "user=root&password=Abhijeet05");

                        // Statements allow to issue SQL queries to the database
                        statement = connect.createStatement();
                        // Result set get the result of the SQL query
                        resultSet = statement
                                        .executeQuery("Select * from player_info, player_season where player_info.PLAYER_ID=player_season.PLAYER_ID and player_info.ROLE='"+s+"'");                                              
                        
                        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                        model1.setRowCount(0);                     
                       
                        while (resultSet.next()) {                       
                        int play_id = resultSet.getInt("PLAYER_ID");
                        String play_name = resultSet.getString("PLAYER_NAME");
                        String role = resultSet.getString("ROLE");
                        int indian = resultSet.getInt("INDIAN");
                        play_id = resultSet.getInt("PLAYER_ID");
                        String team =resultSet.getString("TEAM");
                        int cost= resultSet.getInt("COST");
                        int cap= resultSet.getInt("CAP");
                        
                        model1.addRow(new Object[]{play_id,play_name,role,indian,team,cost,cap});                  
                      
                }
                } catch (Exception e) {
                                       throw e;
                } finally {
                        close();
                }
   }
   public void printii(String s) throws Exception
   {
       try {
                        // This will load the MySQL driver, each DB has its own driver
                        Class.forName("com.mysql.jdbc.Driver");
                        // Setup the connection with the DB
                        connect = DriverManager
                                        .getConnection("jdbc:mysql://localhost/ipl-1?"
                                                        + "user=root&password=Abhijeet05");

                        // Statements allow to issue SQL queries to the database
                        statement = connect.createStatement();
                        // Result set get the result of the SQL query
                        resultSet = statement
                                        .executeQuery("Select * from player_info, player_season where player_info.PLAYER_ID=player_season.PLAYER_ID and player_info.INDIAN="+s);                                              
                        
                        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                        model1.setRowCount(0);                     
                       
                        while (resultSet.next()) {                       
                        int play_id = resultSet.getInt("PLAYER_ID");
                        String play_name = resultSet.getString("PLAYER_NAME");
                        String role = resultSet.getString("ROLE");
                        int indian = resultSet.getInt("INDIAN");
                        play_id = resultSet.getInt("PLAYER_ID");
                        String team =resultSet.getString("TEAM");
                        int cost= resultSet.getInt("COST");
                        int cap= resultSet.getInt("CAP");
                        
                        model1.addRow(new Object[]{play_id,play_name,role,indian,team,cost,cap});                    
                      
                }
                } catch (Exception e) {
                                       throw e;
                } finally {
                        close();
                }
   }
   public void printTeam(String s) throws Exception
   {
       try {
                        // This will load the MySQL driver, each DB has its own driver
                        Class.forName("com.mysql.jdbc.Driver");
                        // Setup the connection with the DB
                        connect = DriverManager
                                        .getConnection("jdbc:mysql://localhost/ipl-1?"
                                                        + "user=root&password=Abhijeet05");

                        // Statements allow to issue SQL queries to the database
                        statement = connect.createStatement();
                        // Result set get the result of the SQL query
                        resultSet = statement
                                        .executeQuery("Select * from player_info, player_season where player_info.PLAYER_ID=player_season.PLAYER_ID and player_season.TEAM="+"'"+s+"'");                                              
                        
                        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                        model1.setRowCount(0);                     
                       
                        while (resultSet.next()) {                       
                        int play_id = resultSet.getInt("PLAYER_ID");
                        String play_name = resultSet.getString("PLAYER_NAME");
                        String role = resultSet.getString("ROLE");
                        int indian = resultSet.getInt("INDIAN");
                        play_id = resultSet.getInt("PLAYER_ID");
                        String team =resultSet.getString("TEAM");
                        int cost= resultSet.getInt("COST");
                        int cap= resultSet.getInt("CAP");
                        
                        model1.addRow(new Object[]{play_id,play_name,role,indian,team,cost,cap});                    
                      
                }
                } catch (Exception e) {
                                       throw e;
                } finally {
                        close();
                }
   }
   
   public void printCU(String s) throws Exception
   {
       try {
                        // This will load the MySQL driver, each DB has its own driver
                        Class.forName("com.mysql.jdbc.Driver");
                        // Setup the connection with the DB
                        connect = DriverManager
                                        .getConnection("jdbc:mysql://localhost/ipl-1?"
                                                        + "user=root&password=Abhijeet05");

                        // Statements allow to issue SQL queries to the database
                        statement = connect.createStatement();
                        // Result set get the result of the SQL query
                        resultSet = statement
                                        .executeQuery("Select * from player_info, player_season where player_info.PLAYER_ID=player_season.PLAYER_ID and player_season.CAP="+s);                                              
                        
                        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                        model1.setRowCount(0);                     
                       
                        while (resultSet.next()) {                       
                        int play_id = resultSet.getInt("PLAYER_ID");
                        String play_name = resultSet.getString("PLAYER_NAME");
                        String role = resultSet.getString("ROLE");
                        int indian = resultSet.getInt("INDIAN");
                        play_id = resultSet.getInt("PLAYER_ID");
                        String team =resultSet.getString("TEAM");
                        int cost= resultSet.getInt("COST");
                        int cap= resultSet.getInt("CAP");
                        
                        model1.addRow(new Object[]{play_id,play_name,role,indian,team,cost,cap});                    
                      
                }
                } catch (Exception e) {
                                       throw e;
                } finally {
                        close();
                }
   }
   
   
   public void insertdb(String id[],String team_name) throws Exception
   {
       try {
                        // This will load the MySQL driver, each DB has its own driver
                        Class.forName("com.mysql.jdbc.Driver");
                        // Setup the connection with the DB
                        connect = DriverManager
                                        .getConnection("jdbc:mysql://localhost/ipl-1?"
                                                        + "user=root&password=Abhijeet05");

                        // Statements allow to issue SQL queries to the database
                        statement = connect.createStatement();
                        // Result set get the result of the SQL query                        
                        preparedStatement = connect
                                        .prepareStatement("insert into  teams values (" +"'"+team_name +"'"+","+ id[0]+","+id[1]+","+id[2]+","+id[3]+","+id[4]+","+id[5]+","+id[6]+","+id[7]+","+id[8]+","+id[9]+","+id[10]+")");                                              
                         preparedStatement.executeUpdate();
                        System.out.println(team_name);                          
                      
                
                } catch (Exception e) {
                                       throw e;
                } finally {
                        close();
                }
   }
   
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
       
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1.setText(" ");
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                            },
            new String [] {
                "Id", "Player_name", "Role", "Indian","Team","Cost","Capped"
            }
        ));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        setTitle("Team Builder");
       jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            if(!event.getValueIsAdjusting())
            try
            {              
                        String play_id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                        String play_name = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                        String role = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                        String indian = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();                      
                        String team =jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
                        String cost= jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
                        String cap= jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();
                        
                       DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();                        
                       model3.addRow(new Object[]{play_id,play_name,role,indian,team,cost,cap});
                       
                       int totalcost=0;
                       for(int i=0;i<model3.getRowCount();i++)
                       {
                           totalcost+=Integer.parseInt(model3.getValueAt(i,5).toString());
                       }
                       totalcost=10000000-totalcost;
                       jLabel1.setText("Players:"+model3.getRowCount()+ " Budget: "+totalcost);
                       
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    });
        
        
        
        
        
        
        
        jScrollPane1.setViewportView(jTable1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {                
            },
            new String [] {
                "Id", "Player_name", "Role", "Indian","Team","Cost","Capped"
            }
        ));
        jTable3.setShowHorizontalLines(false);
        jTable3.setShowVerticalLines(false);
        jTable3.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane3.setViewportView(jTable3);

        jLabel1.setText("Budget: 10000000");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KBA", "Keeper", "Batsman", "All Rounder","Bowler" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               
               String s= (String) jComboBox1.getSelectedItem();
               
                if("Keeper".equals(s))
                {
                    try {
                        System.out.println("ballah");
                        printAllr("Keeper");
                    } catch (Exception ex) {
                        Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if("Batsman".equals(s))
                {
                     try {
                       printAllr("Batsman");
                    } catch (Exception ex) {
                        Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if("All Rounder".equals(s))
                {
                    try {
                         printAllr("All");
                    } catch (Exception ex) {
                        Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if("KBA".equals(s))
                {
                   try {
                       write_table();
                   } catch (Exception ex) {
                       Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                else
                {
                    try {
                       printAllr("Bowler");
                   } catch (Exception ex) {
                       Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "D/I", "Indian", "International" }));
        
         jComboBox2.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               
               String s= (String) jComboBox2.getSelectedItem();
               if(!s.equals("D/I"))
               try {
                   if(s.equals("Indian"))
                   printii("1");
                   else
                   printii("0");
               } catch (Exception ex) {
                   Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
               }
               else
                   try {
                       write_table();
               } catch (Exception ex) {
                   Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        });
        
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C/U", "Capped", "Uncapped" }));
        
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               
               String s= (String) jComboBox3.getSelectedItem();
               if(!s.equals("C/U"))
               try {
                   if(s.equals("Capped"))
                   printCU("1");
                   else
                   printCU("0");
               } catch (Exception ex) {
                   Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
               }
               else
                   try {
                       write_table();
               } catch (Exception ex) {
                   Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        });
        
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Team", "SRH", "RCB", "DD", "MI", "KXIP", "RPS", "KKR", "GL" }));
        
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               
               String s= (String) jComboBox4.getSelectedItem();
               if(!s.equals("Team"))
               try {
                   printTeam(s);
               } catch (Exception ex) {
                   Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
               }
               else
                   try {
                       write_table();
               } catch (Exception ex) {
                   Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        });
         jButton1.setText("Clear");
         
        jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {               
                 DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
                 model3.setRowCount(0);               
           }              
        });
         
         
       jButton2.setText("Make Team");       
       jTextField1.setText("Insert Team Name");
       
        jButton2.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {               
                 DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
                 
                 String id[]= new String[11];
                 String role[]= new String[11];
                 String cost[]= new String[11];
                 String fp[]= new String[11];
                 String capped[]= new String[11];
                 int fl=0;
                 if(model3.getRowCount()!=11)
                 { 
                 jLabel1.setText("Wrong Number of Players="+model3.getRowCount());
                 fl=1;
                 }
                 
                 if(fl==0)
                 {
                        for(int i=0;i<model3.getRowCount();i++)
                        {
                            for(int j=0;j<model3.getColumnCount();j++)
                            {
                                if(j==0)
                                id[i]=model3.getValueAt(i,j).toString();
                                else if(j==2)
                                role[i]=model3.getValueAt(i,j).toString();
                                else if(j==3)
                                fp[i]=model3.getValueAt(i, j).toString();
                                else if(j==5)
                                cost[i]=model3.getValueAt(i,j).toString();
                                else if(j==6)
                                capped[i]=model3.getValueAt(i,j).toString();  
                            }       
                           
                        }

                        String res= check(id,role,cost,fp,capped);

                        jLabel1.setText(res);

                        if(res.equals("Team Created Successfully !!! "))
                        {
                            try {
                               insertdb(id,jTextField1.getText());
                            } catch (Exception ex) {
                                Logger.getLogger(gui1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                 }
           }              
        });
       
       
       
       
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }                       

    /**
     * @param args the command line arguments
     * @throws java.lang.Exceptions
     */
    public static void main(String args[]) throws Exception{
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
            java.util.logging.Logger.getLogger(gui1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}

