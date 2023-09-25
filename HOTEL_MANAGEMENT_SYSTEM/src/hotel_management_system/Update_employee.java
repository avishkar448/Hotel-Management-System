package hotel_management_system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update_employee extends JFrame implements ActionListener {


    JTextField gtf,atf,stf,ptf,etf,adtf,ftf,dobtf,edtf,idtf,jtf;
    JButton update,back,delete,select;
    Choice upemp;

    Update_employee(){
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


        upemp=new Choice();
        upemp.setBounds(200,50,150,35);
        upemp.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(upemp);

        try{
            MyConnection conn=new MyConnection();
            ResultSet set=conn.stmt.executeQuery("select * from employee");
            while(set.next()){
                upemp.add(set.getString("name"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();

        }

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

        gtf=new JTextField();
        gtf.setBounds(200,150,150,30);
        gtf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(gtf);

        //Job
        JLabel job=new JLabel("JOB:");
        job.setBounds(60,200,120,30);
        job.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(job);

        jtf=new JTextField();
        jtf.setBounds(200,200,150,30);
        jtf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(jtf);


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
        email.setBounds(400,250,120,30);
        email.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(email);

        etf=new JTextField();
        etf.setBounds(540,250,150,30);
        etf.setFont(new Font("Oswald",Font.PLAIN,15));
        this.add(etf);

        //Adhar number
        JLabel adhar=new JLabel("Adhar No:");
        adhar.setBounds(400,300,120,30);
        adhar.setFont(new Font("Oswald",Font.BOLD,15));
        this.add(adhar);

        adtf=new JTextField();
        adtf.setBounds(540,300,150,30);
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

        //select button
        select=new JButton("Select");
        select.setBackground(new Color(34,167,240));
        select.setForeground(Color.WHITE);
        select.setBounds(70,400,130,40);
        select.setFont(new Font("Oswald",Font.BOLD,15));
        select.addActionListener(this);
        select.setFocusable(false);
        this.add(select);

        //update button
        update=new JButton("Update");
        update.setBackground(new Color(255,215,0));
        update.setForeground(Color.WHITE);
        update.setBounds(230,400,130,40);
        update.setFont(new Font("Oswald",Font.BOLD,15));
        update.addActionListener(this);
        update.setFocusable(false);
        this.add(update);

        //delete button
        delete=new JButton("Delete");
        delete.setBackground(new Color(139,0,0));
        delete.setForeground(Color.WHITE);
        delete.setBounds(390,400,130,40);
        delete.setFont(new Font("Oswald",Font.BOLD,15));
        delete.addActionListener(this);
        delete.setFocusable(false);
        this.add(delete);

        //back Button
        back=new JButton("Back");
        back.setBounds(550,400,130,40);
        back.setForeground(Color.white);
        back.setBackground(new Color(127,255,0));
        back.setFont(new Font("Oswald",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        this.setBounds(150,20,800,550);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == select) {
            String name =upemp.getSelectedItem();
            try{
                MyConnection conn=new MyConnection();
                String query="select * from employee where name='"+name+"'";

                ResultSet set=conn.stmt.executeQuery(query);
                while(set.next()){
                    idtf.setText(set.getString("employee_id"));
                    ftf.setText(set.getString("father_name"));
                    dobtf.setText(set.getString("date_of_birth"));
                    atf.setText(set.getString("age"));
                    gtf.setText(set.getString("gender"));
                    edtf.setText(set.getString("education"));
                    jtf.setText(set.getString("job"));
                    ptf.setText(set.getString("phone"));
                    etf.setText(set.getString("email"));
                    adtf.setText(set.getString("adhar"));
                    stf.setText(set.getString("salary"));


                }
            }
            catch(Exception ex){
                ex.printStackTrace();

            }
        } else if (e.getSource()==update) {
            String name=upemp.getSelectedItem();
            String id=idtf.getText();
            String ftname=ftf.getText();
            String dob=dobtf.getText();
            String age=atf.getText();
            String gender=gtf.getText();
            String ed=edtf.getText();
            String job=jtf.getText();
            String phone=ptf.getText();
            String email=etf.getText();
            String adhar=atf.getText();
            String salary=stf.getText();

            try{
                MyConnection conn=new MyConnection();
                conn.stmt.executeUpdate("update employee set employee_id='"+id+"',father_name='"+ftname+"',date_of_birth='"+dob+"',age='"+age+"',gender='"+gender+"',education='"+ed+"',job='"+job+"',phone='"+phone+"',email='"+email+"',adhar='"+adhar+"',salary='"+salary+"' where name='"+name+"'");

                JOptionPane.showMessageDialog(null,"Data update successfully");
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        } else if (e.getSource()==delete) {

            String query="delete from employee where name ='"+upemp.getSelectedItem()+"'";

            try{
                MyConnection conn=new MyConnection();
                conn.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Employee deleted successfully!!");

            }
            catch(Exception ex){
                ex.printStackTrace();

            }
        } else  {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Update_employee();
    }

}
