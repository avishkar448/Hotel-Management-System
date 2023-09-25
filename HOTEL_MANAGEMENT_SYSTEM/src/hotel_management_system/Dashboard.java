package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dashboard extends JFrame implements ActionListener {

    JButton b1,b2,b3;

    SimpleDateFormat time,day,date;
    JLabel timel,dayl,datel;
    String t,d,da;
    Dashboard(){
        getContentPane().setBackground(new Color(147,112,219));
        this.setBounds(0,0,1366,730);

        //Dashboard Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/dash.png"));
        Image i2=i1.getImage().getScaledInstance(1366,730, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel DashImage=new JLabel(i3);
        DashImage.setBounds(0,0,1366,730);
        this.add(DashImage);

        //Panel
        JPanel p=new JPanel();
        p.setBounds(0,0,1366,35);
        p.setBackground(new Color(44,62,80));
        p.setLayout(null);
        DashImage.add(p);

        //Hotel management label
        JLabel l=new JLabel("HOTEL MANAGEMENT SYSTEM");
        l.setBounds(10,7,2500,25);
        l.setForeground(new Color(255,140,0));
        l.setFont(new Font("serif",Font.BOLD,18));
        p.add(l);
//------------
        /*
        time=new SimpleDateFormat("hh:mm:ss a");

        timel=new JLabel();
        timel.setBounds(10,580,370,50);
        timel.setFont(new Font("verdana",Font.BOLD,50));
        timel.setForeground(Color.GREEN);
        timel.setBackground(Color.BLACK);
        timel.setOpaque(true);
        DashImage.add(timel);

        day=new SimpleDateFormat("EEEE");
        dayl=new JLabel();
        dayl.setBounds(70,640,400,35);
        dayl.setForeground(Color.white);
        dayl.setFont(new Font("verdana",Font.BOLD,35));
        DashImage.add(dayl);


        date=new SimpleDateFormat("MMMMM dd ,yyyy");
        datel=new JLabel();
        datel.setBounds(70,685,400,25);
        datel.setFont(new Font("verdana",Font.BOLD,25));
        datel.setForeground(Color.white);
        DashImage.add(datel);
        //------------


         */

//        //Cancel button
      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png"));
      Image i5=i4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      ImageIcon i6=new ImageIcon(i5);
      JLabel cancel=new JLabel(i6);
      cancel.setBounds(1330,7,20,20);
      cancel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent ae) {
              System.exit(0);
          }
      });
      p.add(cancel);


        //Resheption button
        b1=new JButton("RECEPTION");
        b1.setBounds(1050,250,200,60);
        b1.setFont(new Font("serif",Font.BOLD,20));
        b1.setFocusable(false);
        b1.setBackground(new Color(44,62,80));
        b1.setForeground(new Color(255,140,0));
        b1.addActionListener(this);
        DashImage.add(b1);

        //Add employe
        b2=new JButton("ADMIN");
        b2.setBounds( 1050,350,200,60);
        b2.setFont(new Font("serif",Font.BOLD,20));
        b2.setFocusable(false);
        b2.setBackground(new Color(44,62,80));
        b2.setForeground(new Color(255,140,0));
        b2.addActionListener(this);
        DashImage.add(b2);

        //Add Room
        b3=new JButton("EXIT");
        b3.setBounds(1050,450,200,60);
        b3.setFont(new Font("serif",Font.BOLD,20));
        b3.setFocusable(false);
        b3.setBackground(new Color(128,0,0));
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        DashImage.add(b3);

        //logo
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("Images/m1.png"));
        Image i8=i7.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image1=new JLabel(i9);
        image1.setBounds(1000,30,300,250);
        DashImage.add(image1);



        this.setUndecorated(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
      //  setTime();
    }
  /*
    public void setTime(){

        while(true){

            t=time.format(Calendar.getInstance().getTime());
            timel.setText(t);

            d=day.format(Calendar.getInstance().getTime());
            dayl.setText(d);

            da=date.format(Calendar.getInstance().getTime());
            datel.setText(da);
            try{
                Thread.sleep(1000);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

   */

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new Reception();
        } else if (e.getSource()==b2) {
            new Admin();
        } else if (e.getSource()==b3) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }


}
