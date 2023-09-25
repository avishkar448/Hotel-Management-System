package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Rooms_info extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Rooms_info(){
        getContentPane().setBackground(Color.WHITE);


        JLabel l1=new JLabel("Room no");
        l1.setBounds(60,10,100,20);
        this.add(l1);

        JLabel l2=new JLabel("Avaliibility");
        l2.setBounds(220,10,100,20);
        this.add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(410,10,100,20);
        this.add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(570,10,100,20);
        this.add(l4);

        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(740,10,100,20);
        this.add(l5);

        //Table for data
        table=new JTable();
        table.setBounds(0,40,845,450);
        this.add(table);

        try{
            MyConnection conn=new MyConnection();
            ResultSet set=conn.stmt.executeQuery("select * from room");

            table.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

       //back button
        back=new JButton("Back");
        back.setBounds(370,520,100,30);
        back.setBackground(new Color(127,255,0));
        back.setForeground(Color.white);
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(255,70,850,620);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==back){
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Rooms_info();
    }


}
