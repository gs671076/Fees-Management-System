/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.rkfms;

import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author gs671
 */
public class CourseDetails extends JFrame implements ActionListener{
    JButton back,view;
    JTable table;
    JScrollPane jsp;
    CourseDetails(String s1)
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

        view = new JButton("View");
        view.setBounds(20, 70, 80, 20);
        view.addActionListener(this);
        add(view);
        back= new JButton("Back");
        back.setBounds(100, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        // Initializing the JFrame settings
        setSize(1300, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
             
    }
         public void fetchTableData() {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/rkfms?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection con = DriverManager.getConnection(url, "root", "gaurav@123");
            String sql = "select * from course";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view) {
            fetchTableData();
        }
        else if(e.getSource()==back){
        AddFees f1=new AddFees();
        f1.setVisible(true);
        this.dispose();
        
    }}
    public static void main(String args[])
    {
    new CourseDetails("Course");
    }
    
}
