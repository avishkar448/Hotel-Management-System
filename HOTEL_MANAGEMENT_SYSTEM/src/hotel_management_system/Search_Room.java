package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Search_Room extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    Search_Room(){
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Search Room");
        text.setFont(new Font("Oswald",Font.BOLD,20));
        text.setBounds(400,20,200,30);
        this.add(text);

        // for bed type
        JLabel bedty=new JLabel("Bed Type");
        bedty.setBounds(50,80,100,20);
        this.add(bedty);


        bedType=new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(150,80,150,25);
        bedType.setBackground(Color.WHITE);
        this.add(bedType);

        available=new JCheckBox("available");
        available.setBounds(650,80,150,25);
        available.setBackground(Color.WHITE);
        available.setFocusable(false);
        this.add(available);

        JLabel l1=new JLabel("Room no");
        l1.setBounds(60,150,100,20);
        this.add(l1);

        JLabel l2=new JLabel("Avaliibility");
        l2.setBounds(220,150,100,20);
        this.add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(410,150,100,20);
        this.add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(600,150,100,20);
        this.add(l4);

        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(800,150,100,20);
        this.add(l5);

        //Table for data
        table=new JTable();
        table.setBounds(0,170,950,300);
        this.add(table);

        try{
            MyConnection conn=new MyConnection();
            ResultSet set=conn.stmt.executeQuery("select * from room");

            table.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        //Submit button
        submit=new JButton("Submit");
        submit.setBounds(350,600,120,30);
        submit.setForeground(Color.white);
        submit.setBackground(new Color(34,167,240));
        submit.setFont(new Font("Oswald",Font.BOLD,15));
        submit.setFocusable(false);
        submit.addActionListener(this);
        this.add(submit);


        //back button
        back=new JButton("Back");
        back.setBounds(500,600,120,30);
        back.setBackground(new Color(127,255,0));
        back.setForeground(Color.white);
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(255,40,950,650);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==submit){
            try{
                MyConnection conn=new MyConnection();

                String query1="select * from room where bed_type ='"+bedType.getSelectedItem()+"'";
                String query2="select * from room where availability ='Available' AND bed_type ='"+bedType.getSelectedItem()+"'";

                ResultSet set;
                if(available.isSelected()){
                    set=conn.stmt.executeQuery(query2);
                }
                else{
                    set=conn.stmt.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(set));
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            setVisible(false);
          //  new Reception();
        }
    }
    public static void main(String[] args) {
        new Search_Room();
    }


}

