/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.login.rkfms;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;

/**
 *
 * @author gs671
 */
public class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public void displayCashFirst()
    {
     dd.setVisible(false);
     cheque.setVisible(false);
     bank.setVisible(false);
     txt_dd.setVisible(false);
     txt_cheque.setVisible(false);
     txt_bank1.setVisible(false);
 
    }
    boolean validation()
    {
    if(txt_rename.getText().equals(""))
    {
    JOptionPane.showMessageDialog(this,"Please Enter Reciever name first.");
    return false;
    }
    if(c_date.getDate()==null)
            {
            JOptionPane.showMessageDialog(this,"Please Enter Date first.");
            return false;
            }
    if(txt_amt.getText().equals("")||txt_amt.getText().matches("[0-9]+")==false)
    {
    JOptionPane.showMessageDialog(this,"Please Enter correct Amount.");
    return false;
    }
    if(cb_mod.getSelectedItem().toString().equalsIgnoreCase("cheque"))
    {
      if(txt_cheque.getText().equals("")||txt_cheque.getText().matches("[0-9]+")==false)
    {
    JOptionPane.showMessageDialog(this,"Please Enter Cheque number first.");
    return false;
    }
      if(txt_bank1.getText().equals(""))
    {
    JOptionPane.showMessageDialog(this,"Please Enter Bank name first.");
    return false;
    }}
    
      if(cb_mod.getSelectedItem().toString().equalsIgnoreCase("DD"))
    {
      if(txt_dd.getText().equals("")||txt_dd.getText().matches("[0-9]+")==false)
    {
    JOptionPane.showMessageDialog(this,"Please Enter DD number first.");
    return false;
    }
      if(txt_bank1.getText().equals(""))
    {
    JOptionPane.showMessageDialog(this,"Please Enter Bank name first.");
    return false;
    }
    }
    return true;
    }
    public void fillComboBox()
    {
    try
    {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url="jdbc:mysql://127.0.0.1:3306/rkfms?zeroDateTimeBehavior=CONVERT_TO_NULL";
    Connection con=DriverManager.getConnection(url,"root","gaurav@123");
    String sql="select cname from course";
    PreparedStatement st=con.prepareStatement(sql);
    ResultSet rs=st.executeQuery();
    while(rs.next())
    {
    cb_mod1.addItem(rs.getString("cname"));
    }
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    }
    public int getRNO()
    {
        int rno=0;
    try
    {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url="jdbc:mysql://127.0.0.1:3306/rkfms?zeroDateTimeBehavior=CONVERT_TO_NULL";
    Connection con=DriverManager.getConnection(url,"root","gaurav@123");
    String sql="select max(reciept_no) from fees_details";
    PreparedStatement st=con.prepareStatement(sql);
    ResultSet rs=st.executeQuery();
    if(rs.next()==true)
    {
     rno=rs.getInt(1);
    }
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return rno;
    }
    




public class NumberToWordsConverter {

	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public static final String[] tens = { 
			"", 		// 0
			"",		// 1
			"Twenty", 	// 2
			"Thirty", 	// 3
			"Forty", 	// 4
			"Fifty", 	// 5
			"Sixty", 	// 6
			"Seventy",	// 7
			"Eighty", 	// 8
			"Ninety" 	// 9
	};

	public static String convert(final int n) {
		if (n < 0) 
                {
			return "Minus " + convert(-n);
		}

		if (n < 20) 
                {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

	public static void main(final String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Amount : ");
		int n=sc.nextInt();

		
		System.out.println( convert(n)+ " Only");

	
	}
}
public String insertData()
{
 int receiptno=Integer.parseInt(txt_rn.getText());
 String sname=txt_rename.getText();
 int rollno=Integer.parseInt(txt_roll.getText());
 String paymentmode=cb_mod.getSelectedItem().toString();
 String chequeno=txt_cheque.getText();
 String bankname=txt_bank1.getText();
 String ddno=txt_dd.getText();
 String coursename=cb_mod1.getSelectedItem().toString();
 String gst=gst2.getText();
  float total=Float.parseFloat(txt_total.getText());
 SimpleDateFormat sd1=new  SimpleDateFormat("yyyy-MM-dd");
  String date1=sd1.format(c_date.getDate());
 float amount=Float.parseFloat(txt_amt.getText()); 
 float cgst=Float.parseFloat(txt_cgst.getText());
 float sgst=Float.parseFloat(txt_sgst.getText());
   String totalinwords=txt_tw.getText();
   String remark=Remarks1.getText();
    int y1=Integer.parseInt(year1.getText());
 int y2=Integer.parseInt(year2.getText());
 String status="";
  try
    {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url="jdbc:mysql://127.0.0.1:3306/rkfms?zeroDateTimeBehavior=CONVERT_TO_NULL";
    Connection con=DriverManager.getConnection(url,"root","gaurav@123");
    String sql="insert into fees_details value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement st=con.prepareStatement(sql);
    st.setInt(1,receiptno);
    st.setString(2,sname);
    st.setInt(3,rollno);
    st.setString(4,paymentmode);
    st.setString(5,chequeno);
    st.setString(6,bankname); 
    st.setString(7,ddno);
    st.setString(8,coursename);
    st.setString(9,gst);
    st.setFloat(10,total);
    st.setString(11,date1);
    st.setFloat (12, amount);
    st.setFloat(13,cgst);
    st.setFloat(14,sgst);
    st.setString(15,totalinwords);
    st.setString(16,remark);
    st.setInt(17,y1);
    st.setInt(18, y2);
    int c=st.executeUpdate();
    if(c==1)
    {
    status="Success";
    }
    else
    {
    status="Fail";
    }
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return status;
}
    AddFees() {
        initComponents();
        displayCashFirst();
        this.fillComboBox();
        int r=this.getRNO();
        r++;
        txt_rn.setText(Integer.toString(r));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Home = new javax.swing.JButton();
        Home1 = new javax.swing.JButton();
        lg = new javax.swing.JButton();
        Home3 = new javax.swing.JButton();
        Home4 = new javax.swing.JButton();
        Home5 = new javax.swing.JButton();
        bk = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        mod = new javax.swing.JLabel();
        dd = new javax.swing.JLabel();
        cheque = new javax.swing.JLabel();
        cb_mod = new javax.swing.JComboBox<>();
        txt_dd = new javax.swing.JTextField();
        lbl_reciept_num = new javax.swing.JLabel();
        c_date = new com.toedter.calendar.JDateChooser();
        date = new javax.swing.JLabel();
        txt_rn = new javax.swing.JTextField();
        gst2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Remarks1 = new javax.swing.JTextField();
        rename = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_rename = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_tw = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        print = new javax.swing.JButton();
        txt_roll = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        year1 = new javax.swing.JTextField();
        year2 = new javax.swing.JTextField();
        txt_amt = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        txt_sgst = new javax.swing.JTextField();
        gst1 = new javax.swing.JLabel();
        bank = new javax.swing.JLabel();
        txt_bank1 = new javax.swing.JTextField();
        txt_cheque = new javax.swing.JTextField();
        mod1 = new javax.swing.JLabel();
        cb_mod1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);

        Home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Home.setText("Search Record");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        Home1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Home1.setText("Home");
        Home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home1ActionPerformed(evt);
            }
        });

        lg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lg.setText("Logout");
        lg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgActionPerformed(evt);
            }
        });

        Home3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Home3.setText("Edit Course");
        Home3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home3ActionPerformed(evt);
            }
        });

        Home4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Home4.setText("Course List");
        Home4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home4ActionPerformed(evt);
            }
        });

        Home5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Home5.setText("View All Record");
        Home5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home5ActionPerformed(evt);
            }
        });

        bk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bk.setText("Back");
        bk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mod.setText("Mode Of Payment");
        jPanel2.add(mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        dd.setText("DD No.");
        jPanel2.add(dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 60, 10));

        cheque.setText("Cheque No.");
        jPanel2.add(cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, -1));

        cb_mod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "CASH", "UPI", "CHEQUE" }));
        cb_mod.setSelectedIndex(1);
        cb_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_modActionPerformed(evt);
            }
        });
        jPanel2.add(cb_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));
        jPanel2.add(txt_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 80, -1));

        lbl_reciept_num.setText("Reciept Number");
        jPanel2.add(lbl_reciept_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 97, -1));
        jPanel2.add(c_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 130, -1));

        date.setText("Date");
        jPanel2.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 97, -1));
        jPanel2.add(txt_rn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 80, -1));

        gst2.setText("AVCDD1234");
        jPanel2.add(gst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 97, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(Remarks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 160, 50));

        rename.setText("Reciever Name");
        jPanel3.add(rename, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 170, 20));

        jLabel7.setText("Reciever Signature");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 110, 20));

        jLabel12.setText("Sr No.");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator1.setAlignmentY(10.0F);
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 180, 20));
        jSeparator1.getAccessibleContext().setAccessibleDescription("");

        jSeparator2.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 117, 490, -1));

        jLabel13.setText("HEAD");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabel15.setText("Amount");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 60, 20));
        jPanel3.add(txt_rename, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 170, -1));

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 150, -1));

        jLabel16.setText("Roll Number");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 97, 20));

        jLabel17.setText("to Year");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 60, 20));

        jLabel18.setText("CGST 7%");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 97, 20));

        jLabel19.setText("SGST 7%");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 97, 20));

        jSeparator3.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator3.setAlignmentY(10.0F);
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 490, 30));

        jLabel20.setText("Total Amount");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 97, 20));
        jPanel3.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 90, -1));

        jLabel21.setText("Total Amount in Words");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 140, 20));
        jPanel3.add(txt_tw, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 270, -1));

        jLabel22.setText("Remarks");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 50, 20));

        jSeparator4.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator4.setAlignmentY(10.0F);
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 180, 20));

        print.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel3.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));
        jPanel3.add(txt_roll, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 120, 30));

        jLabel23.setText("From Year");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 60, 20));
        jPanel3.add(year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 80, -1));
        jPanel3.add(year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 80, -1));

        txt_amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amtActionPerformed(evt);
            }
        });
        jPanel3.add(txt_amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 142, 110, 30));
        jPanel3.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 180, 120, -1));
        jPanel3.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 210, 120, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 490, 390));

        gst1.setText("GSTIN");
        jPanel2.add(gst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 97, -1));

        bank.setText("Bank Name");
        jPanel2.add(bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 97, -1));
        jPanel2.add(txt_bank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 80, -1));
        jPanel2.add(txt_cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 80, -1));

        mod1.setText("Course");
        jPanel2.add(mod1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        cb_mod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mod1ActionPerformed(evt);
            }
        });
        jPanel2.add(cb_mod1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 110, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Home5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Home1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        SearchRecord s1=new SearchRecord("Search");
        s1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void Home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home1ActionPerformed
        // TODO add your handling code here:
        HomePage h1=new HomePage();
        h1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Home1ActionPerformed

    private void lgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgActionPerformed
        // TODO add your handling code here:
        Login l1=new Login();
        l1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lgActionPerformed

    private void Home3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home3ActionPerformed
        // TODO add your handling code here:
        Course1 c1=new Course1();
        c1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Home3ActionPerformed

    private void Home4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home4ActionPerformed
        // TODO add your handling code here:
          CourseDetails c1=  new CourseDetails("Course");
         c1.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_Home4ActionPerformed

    private void Home5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home5ActionPerformed
        // TODO add your handling code here:
        ViewDetails v1=new ViewDetails("Records");
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Home5ActionPerformed

    private void bkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkActionPerformed
        // TODO add your handling code here:
        HomePage h1=new HomePage();
        h1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bkActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
     if(validation()==true)
     {
      String s=insertData();
      if(s.equals("Success"))
      {
      JOptionPane.showMessageDialog(this,"Record Inserted Succesfully");
      }
      else
      {
      JOptionPane.showMessageDialog(this,"Record Not Inserted Succesfully");
      }
     }
    }//GEN-LAST:event_printActionPerformed

    private void cb_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_modActionPerformed
        if(cb_mod.getSelectedIndex()==0)
        {
         dd.setVisible(true);
         txt_dd.setVisible(true);
         bank.setVisible(true);
         txt_bank1.setVisible(true);
         cheque.setVisible(false);
         txt_cheque.setVisible(false);
         
        }
        if(cb_mod.getSelectedIndex()==1)
        {
         dd.setVisible(false);
         cheque.setVisible(false);
         bank.setVisible(false);
         txt_dd.setVisible(false);
         txt_cheque.setVisible(false);
         txt_bank1.setVisible(false);
        }
        if(cb_mod.getSelectedIndex()==3)
        {
         dd.setVisible(false);
         cheque.setVisible(true);
         bank.setVisible(true);
         txt_dd.setVisible(false);
         txt_cheque.setVisible(true);
         txt_bank1.setVisible(true);
        }
        if(cb_mod.getSelectedIndex()==2)
        {
         dd.setVisible(false);
         txt_dd.setVisible(false);
         bank.setVisible(false);
         txt_bank1.setVisible(false);
         cheque.setVisible(false);
         txt_cheque.setVisible(false);
        }
    }//GEN-LAST:event_cb_modActionPerformed

    private void cb_mod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mod1ActionPerformed
              // TODO add your handling code here:
              jTextField8.setText(cb_mod1.getSelectedItem().toString());
    }//GEN-LAST:event_cb_mod1ActionPerformed

    private void txt_amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amtActionPerformed
        // TODO add your handling code here:
         String s1=txt_amt.getText();
        float amt=Float.parseFloat(s1);
        
        float cgst=amt*(0.07f);
        float sgst=amt*(0.07f);
        
        txt_cgst.setText(Float.toString(cgst));
        txt_sgst.setText(Float.toString(sgst));
        
        
        float t=amt+cgst+sgst;
        
        txt_total.setText(Float.toString(t));
       txt_tw.setText(NumberToWordsConverter.convert((int)t));
    }//GEN-LAST:event_txt_amtActionPerformed

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JButton Home1;
    private javax.swing.JButton Home3;
    private javax.swing.JButton Home4;
    private javax.swing.JButton Home5;
    private javax.swing.JTextField Remarks1;
    private javax.swing.JLabel bank;
    private javax.swing.JButton bk;
    private com.toedter.calendar.JDateChooser c_date;
    private javax.swing.JComboBox<String> cb_mod;
    private javax.swing.JComboBox<String> cb_mod1;
    private javax.swing.JLabel cheque;
    private javax.swing.JLabel date;
    private javax.swing.JLabel dd;
    private javax.swing.JLabel gst1;
    private javax.swing.JLabel gst2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lbl_reciept_num;
    private javax.swing.JButton lg;
    private javax.swing.JLabel mod;
    private javax.swing.JLabel mod1;
    private javax.swing.JButton print;
    private javax.swing.JLabel rename;
    private javax.swing.JTextField txt_amt;
    private javax.swing.JTextField txt_bank1;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cheque;
    private javax.swing.JTextField txt_dd;
    private javax.swing.JTextField txt_rename;
    private javax.swing.JTextField txt_rn;
    private javax.swing.JTextField txt_roll;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_tw;
    private javax.swing.JTextField year1;
    private javax.swing.JTextField year2;
    // End of variables declaration//GEN-END:variables
}
