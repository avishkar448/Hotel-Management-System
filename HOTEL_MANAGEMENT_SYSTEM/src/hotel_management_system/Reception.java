package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    JButton ncust,troom,cinfo,cout,ustatus,rstatus,sroom,back;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        //Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/hotel_res.png"));
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
        JLabel l=new JLabel("RECEPTION");
        l.setBounds(30,7,2500,25);
        l.setForeground(Color.white);
        l.setFont(new Font("serif",Font.BOLD,18));
        p.add(l);

        //Custome form button
        ncust =new JButton("Customer Form");
        ncust.setBounds(1050,90,200,50);
        ncust.setBackground(new Color(44,52,80));
        ncust.setFocusable(false);
        ncust.setFont(new Font("Oswald",Font.BOLD,15));
        ncust.setForeground(new Color(255,140,0));
        ncust.addActionListener(this);
        image.add(ncust);


        //Total Rooms Button
        troom =new JButton("Rooms");
        troom.setBounds(1050,170,200,50);
        troom.setBackground(new Color(44,52,80));
        troom.setFocusable(false);
        troom.setFont(new Font("Oswald",Font.BOLD,15));
        troom.addActionListener(this);
        troom.setForeground(new Color(255,140,0));
        image.add(troom);

        //Search room
        sroom =new JButton("Search Room");
        sroom.setBounds(1050,250,200,50);
        sroom.setBackground(new Color(44,52,80));
        sroom.setFocusable(false);
        sroom.setFont(new Font("Oswald",Font.BOLD,15));
        sroom.setForeground(new Color(255,140,0));
        sroom.addActionListener(this);
        image.add(sroom);

        //Room info
        rstatus =new JButton("Update Room Status");
        rstatus.setBounds(1050,330,200,50);
        rstatus.setBackground(new Color(44,52,80));
        rstatus.setFocusable(false);
        rstatus.setFont(new Font("Oswald",Font.BOLD,15));
        rstatus.setForeground(new Color(255,140,0));
        rstatus.addActionListener(this);
        image.add(rstatus);

        //Pending status
        ustatus =new JButton("Update Customer");
        ustatus.setBounds(1050,410,200,50);
        ustatus.setBackground(new Color(44,52,80));
        ustatus.setFocusable(false);
        ustatus.setFont(new Font("Oswald",Font.BOLD,15));
        ustatus.setForeground(new Color(255,140,0));
        ustatus.addActionListener(this);
        image.add(ustatus);

        //Total customer
        cinfo =new JButton("Customers Info");
        cinfo.setBounds(1050,490,200,50);
        cinfo.setBackground(new Color(44,52,80));
        cinfo.setFocusable(false);
        cinfo.setFont(new Font("Oswald",Font.BOLD,15));
        cinfo.addActionListener(this);
        cinfo.setForeground(new Color(255,140,0));
        image.add(cinfo);

        //Checkout
        cout =new JButton("Checkout");
        cout.setBounds(1050,570,200,50);
        cout.setBackground(new Color(44,52,80));
        cout.setFocusable(false);
        cout.setFont(new Font("Oswald",Font.BOLD,15));
        cout.setForeground(new Color(255,140,0));
        cout.addActionListener(this);
        image.add(cout);


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
        if(e.getSource()==ncust){
            new Customer_Form();
        }
        else if (e.getSource()==troom) {
            new Rooms_info();
        }
        else if (e.getSource()==cinfo) {
            new CustomerInfo();
        } else if (e.getSource()==sroom) {
            new Search_Room();
        } else if (e.getSource()==ustatus) {
            new UpdateCheck();
        } else if (e.getSource()==rstatus) {
            new UpdateRoom();
        } else if (e.getSource()==cout) {
            new CheckOut();
        }
        else {
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Reception();
    }


}
