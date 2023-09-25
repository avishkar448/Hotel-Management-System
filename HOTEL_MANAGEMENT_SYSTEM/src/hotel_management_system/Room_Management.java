package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Room_Management extends JFrame implements ActionListener {

    JButton add,back,view;
    Room_Management(){

        //Set Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/room1.png"));
        Image i2=i1.getImage().getScaledInstance(750,461,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,750,461);
        this.add(image);


        //Title
        JLabel l=new JLabel("Room Management");
        l.setBounds(170,370,400,30);
        l.setFont(new Font("Oswald",Font.BOLD,40));
        image.add(l);

        //add button
        add=new JButton("Add");
        add.setBounds(580,150,130,40);
        add.setBackground(new Color(34,167,240));
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Oswald",Font.BOLD,15));
        add.addActionListener(this);
        add.setFocusable(false);
        image.add(add);

        //view
        view=new JButton("View");
        view.setBounds(580,210,130,40);
        view.setBackground(new Color(238,130,238));
        view.setForeground(Color.WHITE);
        view.setFont(new Font("Oswald",Font.BOLD,15));
        view.addActionListener(this);
        view.setFocusable(false);
        image.add(view);

        //back button
        back=new JButton("Back");
        back.setBounds(580,270,130,40);
        back.setBackground(new Color(127,255,0));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.addActionListener(this);
        back.setFocusable(false);
        image.add(back);

        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(100,100,750,461);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){
            new Add_Rooms();
        }
        else if (e.getSource()==view) {
            new Rooms_info();
        }
        else {
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Room_Management();
    }


}
