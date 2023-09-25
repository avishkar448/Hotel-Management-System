package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField idtf,rtf,citf,dtf,petf,ptf,etf;
    JButton check,update,back;

    UpdateCheck(){
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Update Status");
        heading.setFont(new Font("Oswald",Font.BOLD,20));
        heading.setBounds(150,20,250,30);
        this.add(heading);

        //Customer Name
        JLabel name=new JLabel("Customer Name:");
        name.setBounds(50,80,150,20);
        name.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(name);

        ccustomer=new Choice();
        ccustomer.setBounds(220,80,150,25);
        ccustomer.setFont(new Font("Oswald",Font.PLAIN,15));
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

        //Customer ID
        JLabel id=new JLabel("ID:");
        id.setBounds(50,120,150,20);
        id.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(id);

        idtf=new JTextField();
        idtf.setBounds(220,120,150,25);
        this.add(idtf);

        //Customer Phone number
        JLabel phone=new JLabel("Phone no:");
        phone.setBounds(50,160,150,20);
        phone.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(phone);

        ptf=new JTextField();
        ptf.setBounds(220,160,150,25);
        this.add(ptf);

        //Customer Email
        JLabel email=new JLabel("E-mail:");
        email.setBounds(50,200,150,20);
        email.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(email);

        etf=new JTextField();
        etf.setBounds(220,200,150,25);
        this.add(etf);

        //Customer room no
        JLabel room=new JLabel("Room No:");
        room.setBounds(50,240,150,20);
        room.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(room);

        rtf=new JTextField();
        rtf.setBounds(220,240,150,25);
        this.add(rtf);

        //Customer check in time
        JLabel cit=new JLabel("Check in time:");
        cit.setBounds(50,280,150,20);
        cit.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(cit);

        citf=new JTextField();
        citf.setBounds(220,280,150,25);
        this.add(citf);

        //Customer paid amount
        JLabel paidamt=new JLabel("Paid amount:");
        paidamt.setBounds(50,320,150,20);
        paidamt.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(paidamt);

        dtf=new JTextField();
        dtf.setBounds(220,320,150,25);
        dtf.setForeground(new Color(0,100,0));
        dtf.setFont(new Font("Oswald",Font.BOLD,13));
        this.add(dtf);

        //Customer pending amount
        JLabel pendamt=new JLabel("Pending amount:");
        pendamt.setBounds(50,360,150,20);
        pendamt.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(pendamt);

        petf=new JTextField();
        petf.setBounds(220,360,150,25);
        petf.setForeground(Color.RED);
        petf.setFont(new Font("Oswald",Font.BOLD,13));
        this.add(petf);

        //check button
        check=new JButton("check");
        check.setBackground(new Color(255,215,0));
        check.setBounds(50,430,100,30);
        check.setForeground(Color.white);
        check.setFocusable(false);
        check.setFont(new Font("Oswald",Font.BOLD,14));
        check.addActionListener(this);
        this.add(check);

        //Update button
        update=new JButton("update");
        update.setBackground(new Color(255,140,0));
        update.setBounds(170,430,100,30);
        update.setForeground(Color.white);
        update.setFocusable(false);
        update.setFont(new Font("Oswald",Font.BOLD,14));
        update.addActionListener(this);
        this.add(update);

        //back button
        back=new JButton("back");
        back.setBounds(290,430,100,30);
        back.setForeground(Color.white);
        back.setBackground(new Color(127,255,0));
        back.setFocusable(false);
        back.setFont(new Font("Oswald",Font.BOLD,14));
        back.addActionListener(this);
        this.add(back);

        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(420,80,475,500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            String name =ccustomer.getSelectedItem();
            try{
                MyConnection conn=new MyConnection();
                String query="select * from customer where name='"+name+"'";

                ResultSet set=conn.stmt.executeQuery(query);
                while(set.next()){
                    idtf.setText(set.getString("number"));
                    ptf.setText(set.getString("phone_no"));
                    etf.setText(set.getString("email"));
                    rtf.setText(set.getString("room_no"));
                    citf.setText(set.getString("check_in_time"));
                    dtf.setText(set.getString("deposit"));


                }
                ResultSet set1=conn.stmt.executeQuery("select * from room where room_no='"+rtf.getText()+"'");
                while(set1.next()){
                    String price=set1.getString("price");
                    int amountpaid=Integer.parseInt(price)-Integer.parseInt(dtf.getText());
                    petf.setText(""+amountpaid);
                }
            }
            catch(Exception ex){
             ex.printStackTrace();

            }
        }


        else if (e.getSource()==update) {

            String name=ccustomer.getSelectedItem();
            String id=idtf.getText();
            String phone=ptf.getText();
            String email=etf.getText();
            String room=rtf.getText();

            String deposit=dtf.getText();

            try{
                MyConnection conn=new MyConnection();
                conn.stmt.executeUpdate("update customer set deposit='"+deposit+"',number='"+id+"',phone_no='"+phone+"',email='"+email+"',room_no='"+room+"' where name='"+name+"'");

                JOptionPane.showMessageDialog(null,"Data update successfully");
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

        }
        else {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }


}
