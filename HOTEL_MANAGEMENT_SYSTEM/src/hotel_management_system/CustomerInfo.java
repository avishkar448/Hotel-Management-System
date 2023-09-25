package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);


        JLabel l=new JLabel("Customer Information");
        l.setBounds(450,20,400,30);
        l.setFont(new Font("Oswald",Font.BOLD,20));
        this.add(l);

        JLabel l1=new JLabel("Document");
        l1.setBounds(20,80,100,20);
        this.add(l1);

        JLabel l2=new JLabel("Number");
        l2.setBounds(150,80,100,20);
        this.add(l2);

        JLabel l3=new JLabel("Name");
        l3.setBounds(260,80,100,20);
        this.add(l3);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(360,80,100,20);
        this.add(l4);

        JLabel l5=new JLabel("Email");
        l5.setBounds(470,80,100,20);
        this.add(l5);

        JLabel l6=new JLabel("Phone no");
        l6.setBounds(560,80,100,20);
        this.add(l6);

        JLabel l7=new JLabel("Country");
        l7.setBounds(680,80,100,20);
        this.add(l7);

        JLabel l8=new JLabel("Room no");
        l8.setBounds(790,80,100,20);
        this.add(l8);

        JLabel l9=new JLabel("Check-in-time");
        l9.setBounds(880,80,100,20);
        this.add(l9);

        JLabel l10=new JLabel("Deposit");
        l10.setBounds(1000,80,100,20);
        this.add(l10);

        //Table for data
        table=new JTable();
        table.setBounds(0,100,1100,400);
        this.add(table);

        try{
            MyConnection conn=new MyConnection();
            ResultSet set=conn.stmt.executeQuery("select * from customer");

            table.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        //back button
        back=new JButton("Back");
        back.setBounds(500,560,100,30);
        back.setBackground(new Color(127,255,0));
        back.setForeground(Color.white);
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(120,70,1100,620);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==back){
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new CustomerInfo();
    }


}


