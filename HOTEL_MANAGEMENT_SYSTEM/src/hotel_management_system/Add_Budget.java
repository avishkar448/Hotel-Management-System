package hotel_management_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Add_Budget extends JFrame implements ActionListener {
    JComboBox cbj;
    JTextField btf;
    JButton submit,back;

    Add_Budget(){
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

        //Submit button
        submit=new JButton("Submit");
        submit.setBackground(new Color(34,167,240));
        submit.setForeground(Color.WHITE);
        submit.setBounds(50,320,130,40);
        submit.setFont(new Font("Oswald",Font.BOLD,15));
        submit.addActionListener(this);
        submit.setFocusable(false);
        this.add(submit);

        //back Button
        back=new JButton("Back");
        back.setBounds(200,320,130,40);
        back.setForeground(Color.white);
        back.setBackground(new Color(127,255,0));
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        this.setBounds(100,120,700,400);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String dep=(String) cbj.getSelectedItem();
            String buget=btf.getText();

            try{
                MyConnection conn=new MyConnection();
                String query="insert into department values ('"+dep+"','"+buget+"')";

                conn.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"added Succesfully");
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
            new Add_Budget();
    }


}
