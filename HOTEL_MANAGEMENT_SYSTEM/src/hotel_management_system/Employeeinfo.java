package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Employeeinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back,select;
    JComboBox cbj;
    Employeeinfo(){
        getContentPane().setBackground(Color.WHITE);

        //title
        JLabel title=new JLabel("Employee Information");
        title.setFont(new Font("Oswald",Font.BOLD,20));
        title.setBounds(450,20,250,30);
        this.add(title);

        //xxx
        JLabel job=new JLabel("JOB:");
        job.setBounds(60,50,40,30);
        this.add(job);


        String str[]={"Front Desk Clerks","HouseKeeping","Kitchen Staff",
                "Room Service","Chefs","Waiter","Manager", "Accountant"};

        cbj=new JComboBox(str);
        cbj.setBounds(120,50,120,20);
        cbj.setBackground(Color.WHITE);
        this.add(cbj);

        //-----
        JLabel l9=new JLabel("Employee ID");
        l9.setBounds(10,100,100,20);
        this.add(l9);

        JLabel l1=new JLabel("Name");
        l1.setBounds(110,100,100,20);
        this.add(l1);

        JLabel l10=new JLabel("Father Name");
        l10.setBounds(190,100,100,20);
        this.add(l10);

        JLabel l11=new JLabel("Date_of_birth");
        l11.setBounds(280,100,100,20);
        this.add(l11);

        JLabel l2=new JLabel("Age");
        l2.setBounds(400,100,100,20);
        this.add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(470,100,100,20);
        this.add(l3);

        JLabel l12=new JLabel("Education");
        l12.setBounds(560,100,100,20);
        this.add(l12);

        JLabel l4=new JLabel("job");
        l4.setBounds(660,100,100,20);
        this.add(l4);

        JLabel l5=new JLabel("Phone no");
        l5.setBounds(740,100,100,20);
        this.add(l5);

        JLabel l6=new JLabel("Email");
        l6.setBounds(840,100,100,20);
        this.add(l6);

        JLabel l7=new JLabel("Adhar no");
        l7.setBounds(930,100,100,20);
        this.add(l7);

        JLabel l8=new JLabel("Salary");
        l8.setBounds(1010,100,100,20);
        this.add(l8);

        //Table for data
        table=new JTable();
        table.setBounds(0,120,1100,400);
        this.add(table);

        try{
            MyConnection conn=new MyConnection();
            ResultSet set=conn.stmt.executeQuery("select * from employee");

            table.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


        //select button
        select=new JButton("Select");
        select.setBackground(new Color(34,167,240));
        select.setForeground(Color.WHITE);
        select.setBounds(400,550,100,30);
        select.setFont(new Font("Oswald",Font.BOLD,15));
        select.addActionListener(this);
        select.setFocusable(false);
        this.add(select);

        //back button
        back=new JButton("Back");
        back.setBounds(550,550,100,30);
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

        if(e.getSource()==select){
            String job =(String) cbj.getSelectedItem();
            try{
                MyConnection conn=new MyConnection();
                ResultSet set=conn.stmt.executeQuery("select * from employee where job='"+job+"'");

                table.setModel(DbUtils.resultSetToTableModel(set));
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Employeeinfo();
    }


}

