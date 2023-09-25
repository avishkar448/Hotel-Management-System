package hotel_management_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Customer_Form extends JFrame implements ActionListener {

    JLabel heading,cid,no,name,gender,country,aroom,cin,time,deposit,phone,email;
    JComboBox idcb;
    JTextField ntf,nmtf,cotf,dtf,ptf,etf;
    JRadioButton m,f;
    Choice croom;
    JButton submit,back;

    Customer_Form(){
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        //Title
        heading=new JLabel("CUSTOMER FORM");
        heading.setBounds(350,10,300,35);
        heading.setFont(new Font("Oswald",Font.BOLD,20));
        this.add(heading);

        //Customer id
        cid=new JLabel("Customer ID:");
        cid.setBounds(35,80,100,20);
        cid.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(cid);

        String option[]={"Aadhar-Card","Pan-Card","Voter-id card"};
        idcb=new JComboBox(option);
        idcb.setBounds(200,80,150,25);
        idcb.setBackground(Color.WHITE);
        this.add(idcb);

        //Number
        no=new JLabel("Number:");
        no.setBounds(35,120,100,20);
        no.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(no);

        ntf=new JTextField();
        ntf.setBounds(200,120,150,25);
        this.add(ntf);

        //Name
        name=new JLabel("Name:");
        name.setBounds(35,160,100,20);
        name.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(name);

        nmtf=new JTextField();
        nmtf.setBounds(200,160,150,25);
        this.add(nmtf);

        //gender
        gender=new JLabel("GENDER");
        gender.setBounds(35,200,100,20);
        gender.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(gender);

        m=new JRadioButton("Male");
        m.setBounds(200,200,70,20);
        m.setFont(new Font("Oswald",Font.PLAIN,15));
        m.setBackground(Color.WHITE);
        m.setFocusable(false);
        this.add(m);

        f=new JRadioButton("Female");
        f.setBounds(290,200,100,20);
        f.setFont(new Font("Oswald",Font.PLAIN,15));
        f.setBackground(Color.WHITE);
        f.setFocusable(false);
        this.add(f);

        //select one option from male or female
        ButtonGroup bg=new ButtonGroup();
        bg.add(m);
        bg.add(f);
        //Phone no
        phone=new JLabel("Phone no:");
        phone.setBounds(35,280,100,20);
        phone.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(phone);

        ptf=new JTextField();
        ptf.setBounds(200,280,150,25);
        this.add(ptf);

        //E-mail
        email=new JLabel("E-mail:");
        email.setBounds(35,240,100,20);
        email.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(email);

        etf=new JTextField();
        etf.setBounds(200,240,150,25);
        this.add(etf);



        //Country
        country=new JLabel("Country:");
        country.setBounds(35,320,100,20);
        country.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(country);

        cotf=new JTextField();
        cotf.setBounds(200,320,150,25);
        this.add(cotf);

        //Aloocated room
        aroom=new JLabel("Room No:");
        aroom.setBounds(35,360,100,20);
        aroom.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(aroom);

        croom=new Choice();
        try{
            MyConnection conn=new MyConnection();
            String query="Select * from room where availability= 'Available'";

            ResultSet set= conn.stmt.executeQuery(query);
            while (set.next()){
                croom.add(set.getString("room_no"));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        croom.setBounds(200,360,150,25);
        this.add(croom);

        //Check in Time
        cin=new JLabel("Check-in Time:");
        cin.setBounds(35,400,150,20);
        cin.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(cin);

        Date d=new Date();
        time=new JLabel(""+d);
        time.setBounds(200,400,150,20);
        time.setFont(new Font("Oswald",Font.BOLD,13));
        this.add(time);

        //Deposit
        deposit=new JLabel("Deposit:");
        deposit.setBounds(35,440,100,20);
        deposit.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(deposit);

        dtf=new JTextField();
        dtf.setBounds(200,440,150,25);
        this.add(dtf);

        //submit Button
        submit=new JButton("Submit");
        submit.setBounds(275,510,120,30);
        submit.setForeground(Color.white);
        submit.setBackground(new Color(34,167,240));
        submit.setFont(new Font("Oswald",Font.BOLD,15));
        submit.setFocusable(false);
        submit.addActionListener(this);
        this.add(submit);


        //back Button
        back=new JButton("Back");
        back.setBounds(425,510,120,30);
        back.setForeground(Color.white);
        back.setBackground(new Color(127,255,0));
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        // Customer Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/customer.png"));
        Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,80,500,400);
        this.add(image);

        this.setUndecorated(true);
        this.setResizable(false);
        this.setBounds(250,50,900,600);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String id=(String) idcb.getSelectedItem();
            String number=ntf.getText();
            String nm=nmtf.getText();
            String gen=null;
            if(m.isSelected()){
                gen="Male";
            } else if (f.isSelected()) {
                gen="Female";
            }
            String em=etf.getText();
            String phn=ptf.getText();
            String coun=cotf.getText();
            String room=croom.getSelectedItem();
            String ct=time.getText();
            String dep=dtf.getText();

            try {
                String query1="insert into customer values('"+id+"','"+number+"','"+nm+"','"+gen+"', '"+em+"','"+phn+"','"+coun+"','"+room+"','"+ct+"','"+dep+"')";
                String query2="update room set availability ='Occupied' where room_no ='"+room+"'";

                MyConnection conn=new MyConnection();

                conn.stmt.executeUpdate(query1);
                conn.stmt.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"New Customer is addes successfully!");

                this.setVisible(false);
                new Reception();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

        }
        else if (e.getSource()==back) {
                this.setVisible(false);
                new Reception();
        }
    }

    public static void main(String[] args) {
        new Customer_Form();
    }


}
