/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.rkfms;

import java.awt.Choice;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author gs671
 */
public class Cname extends JFrame implements ActionListener {
    JButton back,submit;
    Cname()
    {
    initComponents();
    }
    JLabel l_id,l_cn;
    JTextField txt_cn;
    Choice id1; 
   
   public void initComponents()
   {
       setLayout(null);
   back=new JButton("Back");
   back.setBounds(10, 200, 100, 20);
   back.addActionListener(this);
   add(back);
   
   submit=new JButton("Submit");
   submit.setBounds(120,200,100,20);
   submit.addActionListener(this);
   add(submit);
   
   l_cn=new JLabel("Updated Course Name");
   l_cn.setBounds(100,50,200,25);
   add(l_cn);
   
   
     l_id=new JLabel("Choose ID ");
     l_id.setBounds(100,10,100,25);
     add(l_id);
   
     txt_cn=new JTextField();
     txt_cn.setBounds(300,50,100,25);
     add(txt_cn);
     
     id1=new Choice();
     id1.setBounds(300,10,100,25);
     add(id1);
     
     try{ 
        Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/rkfms?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection con = DriverManager.getConnection(url, "root", "gaurav@123");
            String sql ="select * from fees_details"; 
            PreparedStatement st = con.prepareStatement(sql);
       ResultSet rs = st.executeQuery("select * from course"); 
       while(rs.next()){ 
        id1.add(rs.getString("ID")); 
        } 
         }catch(Exception e){ 
          e.printStackTrace(); 
         } 
     
   
   setVisible(true);
   setSize(700,700);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   }
    public void updateDetails()
    {
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/rkfms?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection con = DriverManager.getConnection(url, "root", "gaurav@123");
            String sql ="update course set CNAME='"+txt_cn.getText()+"'"+"where ID ="+(id1.getSelectedIndex()+1)+""; 
            PreparedStatement st = con.prepareStatement(sql);
            int t=st.executeUpdate();          
            st.close();
            con.close();
            if(t>0)
            {
             JOptionPane.showMessageDialog(this,"Records are upadated now.");
            }
            else
            {
              JOptionPane.showMessageDialog(this,"Records are not upadated now.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   public void actionPerformed(ActionEvent e)
   {
       if(e.getSource()==submit)
       {
        updateDetails();
       }
       else
       {
       UpdateCourse u1=new UpdateCourse();
       u1.setVisible(true);
       this.dispose();
       }
   
   }
   public static void main(String args[])
   {
   new Cname();
   }
}
