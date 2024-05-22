/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.rkfms;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author gs671
 */
public class UpdateCourse extends JFrame implements ActionListener {
     UpdateCourse()
     {
      initComponents();
     }
     JButton delDetails,updateCname,updateCfee,back;
     JLabel heading;
    public void initComponents()
    {
     setLayout(null);
     getContentPane().setBackground(Color.white);
     
    heading=new JLabel("Menu for Updating Course");
    heading.setBounds(200,0,200,40);
    heading.setForeground(Color.BLUE);
    add(heading);
    
    delDetails=new JButton("Delete a entry from Record");
    delDetails.setBounds(200,60,200,30);
    delDetails.addActionListener(this);
    add(delDetails);
    
    
    updateCname=new JButton("Update Course name");
    updateCname.setBounds(200,100,200,30);
    updateCname.addActionListener(this);
    add(updateCname);
    
    updateCfee=new JButton("Update Course Fee");
    updateCfee.setBounds(200,140,200,30);
    updateCfee.addActionListener(this);
    add(updateCfee);
    
    back=new JButton("Back");
    back.setBounds(200,180,200,30);
    back.addActionListener(this);
    add(back);
    
    setVisible(true);
    setSize(700,700);
   
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
        Course1 c1=new Course1();
        c1.setVisible(true);
        this.dispose();
        }
        if(e.getSource()==updateCfee)
        {
        Cfee c1=new Cfee();
        c1.setVisible(true);
        this.dispose();}
        if(e.getSource()==updateCname)
        {
            Cname c1=new Cname();
            c1.setVisible(true);
            this.dispose();
        }
        if(e.getSource()==delDetails)
        {
         DeleteARecord r1=new DeleteARecord();
         r1.setVisible(true);
         this.dispose();
        }
    }
    public static void main(String args[])
    {
     new UpdateCourse();
    }
}
