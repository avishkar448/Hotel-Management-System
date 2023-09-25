package hotel_management_system;

import javax.swing.*;
import java.awt.*;

public class Hotel_Management_System extends JFrame {
    JProgressBar p;
    Hotel_Management_System(){
        getContentPane().setBackground(new Color(44,62,80));
        this.setLayout(null);

        //Hotel Label
        JLabel H=new JLabel("HOTEL");
        H.setBounds(50,90,1000,90);
        H.setForeground(Color.WHITE);
        H.setFont(new Font("serif",Font.BOLD,70));
        this.add(H);

        //Management label
        JLabel M=new JLabel("MANAGEMENT");
        M.setBounds(50,140,1000,90);
        M.setForeground(new Color(0,128,0));
        M.setFont(new Font("serif",Font.BOLD,40));
        this.add(M);

        //System label
        JLabel S=new JLabel("SYSTEM");
        S.setBounds(50,180,1000,90);
        S.setForeground(Color.WHITE);
        S.setFont(new Font("serif",Font.BOLD,40));
        this.add(S);

        //Name
        JLabel n=new JLabel("This System is designed and programmed by AVISHKAR GAWALI");
        n.setBounds(50,250,2000,30);
        n.setForeground(Color.white);
        n.setFont(new Font("serif",Font.BOLD,11));
        this.add(n);

        //Hotel image
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("Images/h1logo.png"));
        Image i1=i.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(400,20,300,300);
        this.add(image);

        //Progress bar
        p=new JProgressBar();
        p.setValue(0);
        p.setBounds(0,375,800,25);
        p.setStringPainted(true);
        p.setForeground(Color.green);
        p.setBackground(new Color(44,62,80));
        this.add(p);

        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300,100,800,400);
        this.setVisible(true);
        fill();
    }
    public void fill(){
        int count =0;
        while(count <= 100){
            p.setValue(count);
            try{
                Thread.sleep(500);
                if(count==100){
                    this.dispose();
                    new Login_Page();

                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            count +=10;
        }
        p.setString("WELCOME!!");
    }

    public static void main(String[] args) {
        new Hotel_Management_System();
    }
}
