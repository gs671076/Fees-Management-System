/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.rkfms;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author gs671
 */
public class EditCourse extends JFrame implements ActionListener{
    JButton back,submit;
    String courseName,courseFee;
    JLabel l_id,l_cn,l_cf;
    JTextField txt_id,txt_cn,txt_cf;
    int id=0,r;
    EditCourse()
    {
    initComponents();
    r=getId();
    r++;
    txt_id.setText(Integer.toString(r));
    }
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
   
   l_cn=new JLabel("Course Name");
   l_cn.setBounds(100,50,100,25);
   add(l_cn);
   
    l_cf=new JLabel("Course Fee");
   l_cf.setBounds(100,90,100,25);
   add(l_cf);
   
     l_id=new JLabel("ID");
     l_id.setBounds(100,10,100,25);
     add(l_id);
   
     txt_cn=new JTextField();
     txt_cn.setBounds(300,50,100,25);
     add(txt_cn);
   
     txt_cf=new JTextField();
     txt_cf.setBounds(300,90,100,25);
     add(txt_cf);
   
     txt_id=new JTextField();
     txt_id.setBounds(300,10,100,25);
     add(txt_id);
   
   setVisible(true);
   setSize(700,700);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   }
   int getId()
   {
     ResultSet rs=null;

    try
    {
     Class.forName("com.mysql.cj.jdbc.Driver");
     String url="jdbc:mysql://localhost:3306/rkfms";
     Connection con=DriverManager.getConnection(url,"root","gaurav@123");
     String Query="select max(id) from course";
     PreparedStatement st=con.prepareStatement(Query);
     rs=st.executeQuery(Query);
     while(rs.next())
     {
     id=rs.getInt(1);
     
     }
     }
    catch(Exception e)
    {
     e.printStackTrace();
    }
    return id;
    }
   
   public void insertData()
   {
   try
   {
    courseName=txt_cn.getText();
    courseFee=txt_cf.getText();
   Class.forName("com.mysql.cj.jdbc.Driver");
   String url="jdbc:mysql://localhost:3306/rkfms";
   Connection con=DriverManager.getConnection(url,"root","gaurav@123");
   String query="insert into course values(?,?,?)";
   PreparedStatement st=con.prepareStatement(query);
   st.setInt(1,r);
   st.setString(2,courseName);
   st.setString(3,courseFee);
   int i=st.executeUpdate();
   if(i>0)
   {
   JOptionPane.showMessageDialog(this,"Record Inserted Successfully");
   }
   else
   {
      JOptionPane.showMessageDialog(this,"Record is not Inserted Successfully");

   }
   
   }
   catch(Exception e)
   {
   e.printStackTrace();
   }
   }
   public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==submit)
    {
        insertData();
    }
    if(e.getSource()==back)
    {
     Course1 d1=new Course1();
     d1.setVisible(true);
     this.dispose(); //
    }
   }
   public static void main(String args[])
   {
   new EditCourse();
   }
}
