package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee_Management extends JFrame implements ActionListener {

    JButton add,update,back,view;
    Employee_Management(){

        //Set Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/employee.png"));
        Image i2=i1.getImage().getScaledInstance(862,461,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,862,461);
        this.add(image);

        //add button
        add=new JButton("Add");
        add.setBounds(650,90,130,40);
        add.setBackground(new Color(34,167,240));
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Oswald",Font.BOLD,15));
        add.addActionListener(this);
        add.setFocusable(false);
        image.add(add);

        //update button
        update=new JButton("Update");
        update.setBounds(650,150,130,40);
        update.setBackground(new Color(255,215,0));
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Oswald",Font.BOLD,15));
        update.addActionListener(this);
        update.setFocusable(false);
        image.add(update);

        //view
        view=new JButton("View");
        view.setBounds(650,210,130,40);
        view.setBackground(new Color(238,130,238));
        view.setForeground(Color.WHITE);
        view.setFont(new Font("Oswald",Font.BOLD,15));
        view.addActionListener(this);
        view.setFocusable(false);
        image.add(view);

        //back button
        back=new JButton("Back");
        back.setBounds(650,270,130,40);
        back.setBackground(new Color(127,255,0));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.addActionListener(this);
        back.setFocusable(false);
        image.add(back);

        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(100,100,862,461);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){
            new Add_Employee();
        } else if (e.getSource()==update) {
            new Update_employee();
        } else if (e.getSource()==view) {
            new Employeeinfo();
        }
        else {
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Employee_Management();
    }


}
