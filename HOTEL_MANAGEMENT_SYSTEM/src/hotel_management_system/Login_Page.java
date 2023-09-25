package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Login_Page extends JFrame implements ActionListener {

    JTextField user;
    JPasswordField pass;
    JButton login,Cancel;
    JLabel l;

    Login_Page(){
        getContentPane().setBackground(new Color(44,62,80));
        this.setLayout(null);

        //Username
        JLabel username=new JLabel("Username");
        username.setBounds(40,60,100,30);
        username.setForeground(new Color(236,240,241));
        username.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(username);

        user=new JTextField();
        user.setBounds(150,60,150,30);
        user.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(user);

        //For Password
        JLabel Password=new JLabel("Password");
        Password.setBounds(40,110,100,30);
        Password.setForeground(new Color(236,240,241));
        Password.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(Password);

        pass=new JPasswordField();
        pass.setBounds(150,110,150,30);
        pass.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(pass);

        //login button
        login=new JButton("Login");
        login.setBounds(40,190,120,30);
        login.setBackground(new Color(34,167,240));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFocusable(false);
        this.add(login);

        //Cancel Button
        Cancel=new JButton("Cancel");
        Cancel.setBounds(180,190,120,30);
        Cancel.setBackground(new Color(192,57,43));
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFocusable(false);
        Cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
        this.add(Cancel);

        //Set Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/pass.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,40,200,200);
        this.add(image);

        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500,200,600,300);
        this.setVisible(true);

    }

    //Action for login button
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==login){
            String u= user.getText();
            String p= pass.getText();

            try{
                MyConnection c= new MyConnection();

                String query="select * from login where username = '"+ u +"'and password ='" + p +"'";

                ResultSet set =c.stmt.executeQuery(query);

                if(set.next()){
                    this.setVisible(false);
                    new Dashboard();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    this.setVisible(false);
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login_Page();
    }


}
