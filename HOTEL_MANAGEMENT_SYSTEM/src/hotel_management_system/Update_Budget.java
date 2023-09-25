package hotel_management_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Update_Budget extends JFrame implements ActionListener {
    JComboBox cbj;
    JTextField btf;
    JButton select,back,update,delete;

    Update_Budget(){
        getContentPane().setBackground(Color.WHITE);
        //Add Budget
        JLabel l=new JLabel("Add Budget");
        l.setBounds(250,40,400,30);
        l.setFont(new Font("Oswald",Font.BOLD,25));
        this.add(l);

        //Set Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/rupee.png"));
        Image i2=i1.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(360,40,350,350);
        this.add(image);

        //Department name
        JLabel department=new JLabel("Department:");
        department.setBounds(40,120,120,30);
        department.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(department);

        String str[]={"Front Office Department","HouseKeeping Department","Food and Beverange Service Department",
                "Food production Department","Engineering and Maintenance Department","Accounts and Credit Department"
                ,"Security Department","HR Department","Sales and Marketing Department","Purchas Department",
                "Information Technology"};

        cbj=new JComboBox(str);
        cbj.setBounds(200,120,150,30);
        cbj.setBackground(Color.WHITE);
        this.add(cbj);

        //Budget
        JLabel budget=new JLabel("Budget:");
        budget.setBounds(40,180,120,30);
        budget.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(budget);

        btf=new JTextField();
        btf.setBounds(200,180,150,30);
        btf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(btf);

        //Date
        JLabel d=new JLabel("Time:");
        d.setBounds(40,240,150,20);
        d.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(d);

        Date date=new Date();
        JLabel time=new JLabel(""+date);
        time.setBounds(200,240,150,20);
        time.setFont(new Font("Oswald",Font.BOLD,13));
        this.add(time);

        //select button
        select=new JButton("Select");
        select.setBackground(new Color(34,167,240));
        select.setForeground(Color.WHITE);
        select.setBounds(50,300,130,40);
        select.setFont(new Font("Oswald",Font.BOLD,15));
        select.addActionListener(this);
        select.setFocusable(false);
        this.add(select);

        //update button
        update=new JButton("Update");
        update.setBackground(new Color(255,215,0));
        update.setForeground(Color.WHITE);
        update.setBounds(200,300,130,40);
        update.setFont(new Font("Oswald",Font.BOLD,15));
        update.addActionListener(this);
        update.setFocusable(false);
        this.add(update);


        //delete Button
        delete=new JButton("Delete");
        delete.setBounds(50,360,130,40);
        delete.setForeground(Color.white);
        delete.setBackground(new Color(139,0,0));
        delete.setFont(new Font("Oswald",Font.BOLD,15));
        delete.setFocusable(false);
        delete.addActionListener(this);
        this.add(delete);

        //back Button
        back=new JButton("Back");
        back.setBounds(200,360,130,40);
        back.setForeground(Color.white);
        back.setBackground(new Color(127,255,0));
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        this.setBounds(100,120,700,450);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==select){
            String dept=(String) cbj.getSelectedItem();

            try{
                MyConnection conn=new MyConnection();
                String query="select * from department where department='"+dept+"'";

                ResultSet set=conn.stmt.executeQuery(query);
                while(set.next()){
                    btf.setText(set.getString("budget"));

                }
            }
            catch(Exception ex){
                ex.printStackTrace();

            }
            }
        else if (e.getSource()==update) {
            String budget=btf.getText();

            try{
                MyConnection conn=new MyConnection();
                conn.stmt.executeUpdate("update department set budget='"+budget+"'");

                JOptionPane.showMessageDialog(null,"Data update successfully");
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if (e.getSource()==delete) {
            String query="delete from department where department='"+cbj.getSelectedItem()+"'";

            try{
                MyConnection conn=new MyConnection();
                conn.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"deleted successfully!!");

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
        new Update_Budget();
    }


}

