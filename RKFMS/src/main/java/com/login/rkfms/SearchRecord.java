/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.rkfms;
import java.awt.Choice;
import java.awt.Color;
import java.sql.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.*;
import net.proteanit.sql.*;

/**
 *
 * @author gs671
 */
public class SearchRecord extends JFrame implements ActionListener{
    
    JButton back,search;
    JTable table;
    JScrollPane jsp;
   Choice rollno; 

    SearchRecord(String s1)
    {
    super(s1);
    initComponents();
    }
    public void initComponents()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);

    table = new JTable();
        jsp = new JScrollPane(table);
        jsp.setBounds(1, 100, 1250, 500);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        back= new JButton("Back");
        back.setBounds(100, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        rollno = new Choice(); 
        rollno.setBounds(180,20,150,20); 
        add(rollno); 
        try{ 
        Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/rkfms?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection con = DriverManager.getConnection(url, "root", "gaurav@123");
            String sql ="select * from fees_details"; 
            PreparedStatement st = con.prepareStatement(sql);
       ResultSet rs = st.executeQuery("select * from fees_details"); 
       while(rs.next()){ 
        rollno.add(rs.getString("roll_no")); 
        } 
         }catch(Exception e){ 
          e.printStackTrace(); 
         } 


        // Initializing the JFrame settings
        setSize(1300, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
             
    }
    public void fetchDetails()
    {
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/rkfms?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection con = DriverManager.getConnection(url, "root", "gaurav@123");
            String sql ="select * from fees_details where roll_no ='"+rollno.getSelectedItem()+"'"; 
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==search)
     {
     fetchDetails();
     }
     else if(ae.getSource()==back)
     {
     AddFees a1=new AddFees();
     a1.setVisible(true);
     this.dispose();
     }
    }
    public static void main(String args[])
    {
    new SearchRecord("Search");
    }
    
}
