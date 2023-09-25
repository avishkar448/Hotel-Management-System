package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField idtf,rtf,atf,cstf;
    JButton check,update,back;

    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Update Room Status");
        heading.setFont(new Font("Oswald",Font.BOLD,20));
        heading.setBounds(150,20,250,30);
        this.add(heading);

        //Customer Name
        JLabel name=new JLabel("Customer Name:");
        name.setBounds(50,90,150,20);
        name.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(name);

        ccustomer=new Choice();
        ccustomer.setBounds(220,90,150,25);
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
        id.setBounds(50,130,150,20);
        id.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(id);

        idtf=new JTextField();
        idtf.setBounds(220,130,150,25);
        this.add(idtf);

        //Customer room no
        JLabel room=new JLabel("Room No:");
        room.setBounds(50,170,150,20);
        room.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(room);

        rtf=new JTextField();
        rtf.setBounds(220,170,150,25);
        this.add(rtf);

        //Availability
        JLabel av=new JLabel("Availability:");
        av.setBounds(50,210,150,20);
        av.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(av);

        atf=new JTextField();
        atf.setBounds(220,210,150,25);
        this.add(atf);

        //Cleaning status
        JLabel cleaningStatus=new JLabel("Cleaning Status:");
        cleaningStatus.setBounds(50,250,150,20);
        cleaningStatus.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(cleaningStatus);

        cstf=new JTextField();
        cstf.setBounds(220,250,150,25);
        this.add(cstf);



        //check button
        check=new JButton("check");
        check.setBackground(new Color(255,215,0));
        check.setBounds(50,320,100,30);
        check.setForeground(Color.white);
        check.setFocusable(false);
        check.setFont(new Font("Oswald",Font.BOLD,14));
        check.addActionListener(this);
        this.add(check);

        //Update button
        update=new JButton("update");
        update.setBackground(new Color(255,140,0));
        update.setBounds(170,320,100,30);
        update.setForeground(Color.white);
        update.setFocusable(false);
        update.setFont(new Font("Oswald",Font.BOLD,14));
        update.addActionListener(this);
        this.add(update);

        //back button
        back=new JButton("back");
        back.setBounds(290,320,100,30);
        back.setForeground(Color.white);
        back.setBackground(new Color(127,255,0));
        back.setFocusable(false);
        back.setFont(new Font("Oswald",Font.BOLD,14));
        back.addActionListener(this);
        this.add(back);

        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(420,80,475,400);
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
                    rtf.setText(set.getString("room_no"));


                }
                ResultSet set1=conn.stmt.executeQuery("select * from room where room_no='"+rtf.getText()+"'");
                while(set1.next()){
                   atf.setText(set1.getString("availability"));
                   cstf.setText(set1.getString("Cleaning_Status"));
                }
            }
            catch(Exception ex){
                ex.printStackTrace();

            }
        }


        else if (e.getSource()==update) {

            String name=ccustomer.getSelectedItem();
            String available=atf.getText();
            String clstatus=cstf.getText();
            String room=rtf.getText();

            try{
                MyConnection conn=new MyConnection();
                conn.stmt.executeUpdate("update room set availability='"+available+"',Cleaning_Status='"+clstatus+"' where room_no='"+room+"'");

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
        new UpdateRoom();
    }


}
