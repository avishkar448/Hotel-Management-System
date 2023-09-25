package hotel_management_system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Employee extends JFrame implements ActionListener {


    JTextField nmtf,atf,stf,ptf,etf,adtf,ftf,dobtf,edtf,idtf;
    JRadioButton m,f;
    JComboBox cbj;
    JButton submit,back;

    Add_Employee(){
        getContentPane().setBackground(Color.WHITE);

        //Title
        JLabel l=new JLabel("Employee Form");
        l.setBounds(280,0,150,30);
        l.setFont(new Font("Oswald",Font.BOLD,20));
        this.add(l);

        //Name
        JLabel name=new JLabel("NAME:");
        name.setBounds(60,50,120,30);
        name.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(name);

        nmtf=new JTextField();
        nmtf.setBounds(200,50,150,30);
        nmtf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(nmtf);

        //Age
        JLabel age=new JLabel("AGE:");
        age.setBounds(60,100,120,30);
        age.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(age);

        atf=new JTextField();
        atf.setBounds(200,100,150,30);
        atf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(atf);

        //Gender
        JLabel gender=new JLabel("GENDER:");
        gender.setBounds(60,150,120,30);
        gender.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(gender);

        m=new JRadioButton("Male");
        m.setBounds(200,150,70,30);
        m.setFont(new Font("Oswald",Font.PLAIN,15));
        m.setBackground(Color.WHITE);
        m.setFocusable(false);
        this.add(m);

        f=new JRadioButton("Female");
        f.setBounds(290,150,100,30);
        f.setFont(new Font("Oswald",Font.PLAIN,15));
        f.setBackground(Color.WHITE);
        f.setFocusable(false);
        this.add(f);

        //select one option from male or female
        ButtonGroup bg=new ButtonGroup();
        bg.add(m);
        bg.add(f);

        //Job
        JLabel job=new JLabel("JOB:");
        job.setBounds(60,200,120,30);
        job.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(job);

        String str[]={"Front Desk Clerks","HouseKeeping","Kitchen Staff",
                "Room Service","Chefs","Waiter","Manager", "Accountant"};

        cbj=new JComboBox(str);
        cbj.setBounds(200,200,150,30);
        cbj.setBackground(Color.WHITE);
        this.add(cbj);

        //Salary
        JLabel salary=new JLabel("SALARY:");
        salary.setBounds(60,250,120,30);
        salary.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(salary);

        stf=new JTextField();
        stf.setBounds(200,250,150,30);
        stf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(stf);

        //Phone no
        JLabel phone=new JLabel("PHONE:");
        phone.setBounds(60,300,120,30);
        phone.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(phone);

        ptf=new JTextField();
        ptf.setBounds(200,300,150,30);
        ptf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(ptf);

        //E-mail
        JLabel email=new JLabel("E-mail:");
        email.setBounds(60,350,120,30);
        email.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(email);

        etf=new JTextField();
        etf.setBounds(200,350,150,30);
        etf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(etf);

        //Adhar number
        JLabel adhar=new JLabel("Adhar No:");
        adhar.setBounds(60,400,120,30);
        adhar.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(adhar);

        adtf=new JTextField();
        adtf.setBounds(200,400,150,30);
        adtf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(adtf);

        //Father name
        JLabel fname=new JLabel("FATHER NAME:");
        fname.setBounds(400,50,120,30);
        fname.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(fname);

        ftf=new JTextField();
        ftf.setBounds(540,50,150,30);
        ftf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(ftf);

        //Date of birth
        JLabel birth=new JLabel("DATE OF BIRTH:");
        birth.setBounds(400,100,120,30);
        birth.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(birth);

        dobtf=new JTextField();
        dobtf.setBounds(540,100,150,30);
        dobtf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(dobtf);

        //Education
        JLabel education=new JLabel("EDUCATION:");
        education.setBounds(400,150,120,30);
        education.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(education);

        edtf=new JTextField();
        edtf.setBounds(540,150,150,30);
        edtf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(edtf);

        //Employe Id
        JLabel id=new JLabel("Employee ID:");
        id.setBounds(400,200,120,30);
        id.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(id);

        idtf=new JTextField();
        idtf.setBounds(540,200,150,30);
        idtf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(idtf);

        //Image
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("Images/emp1.png"));
        Image i1=i.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(420,220,250,250);
        this.add(image);

        //Submit button
        submit=new JButton("Submit");
        submit.setBackground(new Color(34,167,240));
        submit.setForeground(Color.WHITE);
        submit.setBounds(210,480,150,30);
        submit.setFont(new Font("Oswald",Font.BOLD,15));
        submit.addActionListener(this);
        submit.setFocusable(false);
        this.add(submit);

        //back Button
        back=new JButton("Back");
        back.setBounds(395,480,150,30);
        back.setForeground(Color.white);
        back.setBackground(new Color(127,255,0));
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        this.setBounds(150,20,800,600);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==submit){
            String empid=idtf.getText();
            String name=nmtf.getText();
            String father=ftf.getText();
            String age=atf.getText();
            String birth=dobtf.getText();
            String educ=edtf.getText();
            String salary=stf.getText();
            String phone=ptf.getText();
            String email=etf.getText();
            String adhar=adtf.getText();


            String gender=null;
            if(m.isSelected()){
                gender="Male";
            } else if (f.isSelected()) {
                gender="Female";
            }

            String job=(String) cbj.getSelectedItem();

            try{
                MyConnection conn=new MyConnection();

                String query="insert into employee values('"+empid+"','"+name+"','"+father+"','"+birth+"','"+age+"','"+gender+"','"+educ+"','"+job+"', '"+phone+"','"+email+"','"+adhar+"','"+salary+"')";

                conn.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Employee added Succesfully");
                this.setVisible(false);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        } else if (e.getSource()==back) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Add_Employee();
    }


}
