package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;


public class Budget_view extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Budget_view(){
        getContentPane().setBackground(Color.WHITE);

        JLabel l1=new JLabel("Department");
        l1.setBounds(100,10,100,20);
        l1.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(l1);

        JLabel l2=new JLabel("Budget");
        l2.setBounds(370,10,100,20);
        l2.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(l2);

        //Table for data
        table=new JTable();
        table.setBounds(0,40,600,400);
        this.add(table);

        try{
            MyConnection conn=new MyConnection();
            ResultSet set=conn.stmt.executeQuery("select * from department");

            table.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        //back button
        back=new JButton("Back");
        back.setBounds(230,550,100,30);
        back.setBackground(new Color(127,255,0));
        back.setForeground(Color.white);
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(400,70,600,600);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==back){
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Budget_view();
    }


}
