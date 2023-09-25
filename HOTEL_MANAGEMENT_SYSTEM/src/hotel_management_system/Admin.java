package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

  //  JButton ncust,troom,cinfo,cout,ustatus,rstatus,sroom,back;
    JButton room,budget,emp,back;
    Admin(){
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        //Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/admin.png"));
        Image i2=i1.getImage().getScaledInstance(1366,730,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1366,730);
        this.add(image);

        //logo
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("Images/m1.png"));
        Image i8=i7.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image1=new JLabel(i9);
        image1.setBounds(30,450,400,350);
        image.add(image1);

        //Panel
        JPanel p=new JPanel();
        p.setBounds(0,0,1366,35);
        p.setBackground(new Color(139,0,0));
        p.setLayout(null);
        image.add(p);

        //Hotel management label
        JLabel l=new JLabel("ADMIN");
        l.setBounds(30,7,2500,25);
        l.setForeground(Color.white);
        l.setFont(new Font("serif",Font.BOLD,18));
        p.add(l);

        //Custome form button
        emp =new JButton("Employee Management");
        emp.setBounds(1050,250,200,50);
        emp.setBackground(new Color(44,62,80));
        emp.setFocusable(false);
        emp.setFont(new Font("Oswald",Font.BOLD,15));
        emp.setForeground(new Color(255,140,0));
        emp.addActionListener(this);
        image.add(emp);


        //Total Rooms Button
        budget =new JButton("Budget");
        budget.setBounds(1050,330,200,50);
        budget.setBackground(new Color(44,52,80));
        budget.setFocusable(false);
        budget.setFont(new Font("Oswald",Font.BOLD,15));
        budget.addActionListener(this);
        budget.setForeground(new Color(255,140,0));
        image.add(budget);

        //Search room
        room =new JButton("Rooms");
        room.setBounds(1050,410,200,50);
        room.setBackground(new Color(44,52,80));
        room.setFocusable(false);
        room.setFont(new Font("Oswald",Font.BOLD,15));
        room.setForeground(new Color(255,140,0));
        room.addActionListener(this);
        image.add(room);

        //Back
        back=new JButton("Back");
        back.setBounds(620,650,150,40);
        back.setBackground(new Color(127,255,0));
        back.setForeground(Color.white);
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.addActionListener(this);
        back.setFocusable(false);
        image.add(back);


        this.setUndecorated(true);
        this.setBounds(0,0,1366,730);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==emp){
            new Employee_Management();
        }
        else if (e.getSource()==budget) {
            new Budget_Management();
        }
        else if (e.getSource()==room) {
            new Room_Management();
        }
        else {
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Admin();
    }


}

