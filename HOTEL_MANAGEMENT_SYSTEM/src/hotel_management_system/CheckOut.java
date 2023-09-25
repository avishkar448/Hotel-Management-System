package hotel_management_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {

    JButton checkout,back,select;
    JLabel room_no,citime,cotime;
    JTextField idtf;
    Choice ccustomer;
    CheckOut(){
        getContentPane().setBackground(Color.WHITE);

        JLabel l=new JLabel("Checkout");
        l.setForeground(Color.black);
        l.setBounds(100,20,100,30);
        l.setFont(new Font("Oswald",Font.BOLD,20));
        this.add(l);

        //Customer name
        JLabel name=new JLabel("Name:");
        name.setBounds(30,80,100,30);
        name.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(name);

        ccustomer=new Choice();
        ccustomer.setBounds(150,80,150,25);
        ccustomer.setFont(new Font("Oswald",Font.PLAIN,13));
        this.add(ccustomer);

        try{
            MyConnection conn=new MyConnection();
            ResultSet set=conn.stmt.executeQuery("select * from customer");
            while(set.next()){
                ccustomer.add(set.getString("name"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();

        }


        //Customer id
        JLabel id=new JLabel("ID:");
        id.setBounds(30,120,100,30);
        id.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(id);

        idtf=new JTextField();
        idtf.setBounds(150,120,150,25);
        this.add(idtf);

        //Room no
        JLabel room=new JLabel("Room no:");
        room.setBounds(30,160,100,30);
        room.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(room);

        room_no=new JLabel();
        room_no.setBounds(150,160,100,30);
        this.add(room_no);

        //Check in time
        JLabel checkin=new JLabel("Check in time:");
        checkin.setBounds(30,200,100,30);
        checkin.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(checkin);

        citime=new JLabel();
        citime.setBounds(150,200,100,30);
        this.add(citime);

        //Check out time
        JLabel chout=new JLabel("Check Out time:");
        chout.setBounds(30,240,120,30);
        chout.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(chout);

        Date date=new Date();
        cotime=new JLabel(""+date);
        cotime.setBounds(150,240,150,30);
        this.add(cotime);



        //select button
        select=new JButton("Select");
        select.setBounds(180,350,120,30);
        select.setBackground(new Color(34,167,240));
        select.setForeground(Color.white);
        select.setFocusable(false);
        select.addActionListener(this);
        this.add(select);


        //Checkout button
        checkout=new JButton("Checkout");
        checkout.setBounds(320,350,120,30);
        checkout.setBackground(new Color(128,0,0));
        checkout.setForeground(Color.white);
        checkout.setFocusable(false);
        checkout.addActionListener(this);
        this.add(checkout);

        //back button
        back=new JButton("Back");
        back.setBounds(460,350,120,30);
        back.setBackground(new Color(127,255,0));
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        //Image
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("Images/checkout.jpg"));
        Image i1=i.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(350,20,430,300);
        this.add(image);

        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(300,150,800,400);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==checkout){
            String query="delete from customer where name ='"+ccustomer.getSelectedItem()+"'";
            String query2="update room set availability='Available' where room_no='"+room_no.getText()+"'";

            try{
                MyConnection conn=new MyConnection();
                conn.stmt.executeUpdate(query);
                conn.stmt.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Check out done!!");

            }
            catch(Exception ex){
                ex.printStackTrace();

            }
        } else if (e.getSource()==select) {
            String name =ccustomer.getSelectedItem();
            MyConnection conn=new MyConnection();

            try{

                String query="select * from customer where name='"+name+"'";

                ResultSet set=conn.stmt.executeQuery(query);
                while(set.next()){
                    idtf.setText(set.getString("number"));
                    room_no.setText(set.getString("room_no"));
                    citime.setText(set.getString("check_in_time"));


                }
            }
            catch (Exception ex){


            }
        }
        else {
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new CheckOut();
    }


}
