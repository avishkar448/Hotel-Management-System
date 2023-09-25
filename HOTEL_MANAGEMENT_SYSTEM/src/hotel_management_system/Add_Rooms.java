package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Rooms extends JFrame implements ActionListener {

    JLabel title,rno,av,cl,rprice,bt;
    JButton add,cancle;
    JTextField rnotf,rptf;
    JComboBox clc,bdc,avc;

    Add_Rooms(){
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        //Title
        title=new JLabel("Add Rooms");
        title.setFont(new Font("Oswald",Font.BOLD,20));
        title.setBounds(150,20,200,20);
        this.add(title);

        //Room number
        rno=new JLabel("Room no.");
        rno.setFont(new Font("Oswald",Font.BOLD,15));
        rno.setBounds(60,80,120,30);
        this.add(rno);

        rnotf=new JTextField();
        rnotf.setBounds(200,80,150,30);
        this.add(rnotf);

        //Room avalaible or not
        av=new JLabel("Available");
        av.setFont(new Font("Oswald",Font.BOLD,15));
        av.setBounds(60,130,120,30);
        this.add(av);

        String option[]={"Available","Occupied"};
        avc=new JComboBox(option);
        avc.setBounds(200,130,150,30);
        avc.setBackground(Color.white);
        this.add(avc);

        //Cleaning status
        cl=new JLabel("Cleaning status");
        cl.setFont(new Font("Oswald",Font.BOLD,15));
        cl.setBounds(60,180,120,30);
        this.add(cl);

        String cleanoption[]={"Cleaned","Dirty"};
        clc=new JComboBox(cleanoption);
        clc.setBounds(200,180,150,30);
        clc.setBackground(Color.white);
        this.add(clc);

        //Room Price
        rprice=new JLabel("Price");
        rprice.setFont(new Font("Oswald",Font.BOLD,15));
        rprice.setBounds(60,230,120,30);
        this.add(rprice);

        rptf=new JTextField();
        rptf.setBounds(200,230,150,30);
        this.add(rptf);

        //Bed Type
        bt=new JLabel("Bed Type");
        bt.setFont(new Font("Oswald",Font.BOLD,15));
        bt.setBounds(60,280,120,30);
        this.add(bt);

        String bdoption[]={"Single Bed","Double Bed"};
        bdc=new JComboBox(bdoption);
        bdc.setBounds(200,280,150,30);
        bdc.setBackground(Color.white);
        this.add(bdc);

        //Add Button
        add=new JButton("Add");
        add.setBounds(60,350,130,30);
        add.setForeground(Color.white);
        add.setBackground(new Color(34,167,240));
        add.setFocusable(false);
        add.addActionListener(this);
        this.add(add);

        //Cancel Button
        cancle=new JButton("Cancle");
        cancle.setBounds(220,350,130,30);
        cancle.setForeground(Color.white);
        cancle.setBackground(new Color(192,57,43));
        cancle.setFocusable(false);
        cancle.addActionListener(this);
        this.add(cancle);

        //Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/room.png"));
        Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel im=new JLabel(i3);
        im.setBounds(400,10,500,400);
        this.add(im);



        this.setBounds(250,100,940,470);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String roomno= rnotf.getText();
            String avilability=(String) avc.getSelectedItem();
            String status =(String) clc.getSelectedItem();
            String price=rptf.getText();
            String type=(String) bdc.getSelectedItem();

            try{
                MyConnection conn=new MyConnection();
                String query="insert into room values('"+roomno+"','"+avilability+"','"+status+"','"+price+"', '"+type+"')";


                conn.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Room added Succesfully");
                this.setVisible(false);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Add_Rooms();
    }


}
