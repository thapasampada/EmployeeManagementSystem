package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;

public class updateRecords extends JFrame implements ActionListener {
    Random ran = new Random();
    int num = ran.nextInt(999999);

    JButton update, back;
    JTextField tfpost, tfeducation, tffname, tfaddress, tfphone, tfemail, tfdegree;
    JLabel lblid;
    String empId;

    updateRecords(String empId){
        this.empId = empId;
        getContentPane().setBackground(new Color(116, 141, 146));
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Records");
        heading.setBounds(380, 40, 600, 80);
        heading.setFont(new Font("serif", Font.BOLD, 38));
        heading.setForeground(new Color(33, 42, 49));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(100, 150,150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        JLabel lblname = new JLabel ();
        lblname.setBounds(260, 150, 200, 30);
        lblname.setFont(new Font("serif",Font.PLAIN, 18));
        add(lblname);

        JLabel labelfname = new JLabel("Fathers Name");
        labelfname.setBounds(640, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(800, 150, 200, 30);
        tffname.setFont(new Font("serif",Font.PLAIN, 18));
        add(tffname);

        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(100, 200,150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(260, 200, 200, 30);
        lbldob.setFont(new Font("serif",Font.PLAIN, 18));
        add(lbldob);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(640, 200, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(800, 200, 200, 30);
        tfaddress.setFont(new Font("serif",Font.PLAIN, 18));
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone no");
        labelphone.setBounds(100, 250, 150, 30);
        labelphone.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(260, 250, 200, 30);
        tfphone.setFont(new Font("serif",Font.PLAIN, 18));
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(640, 250, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(800, 250, 200, 30);
        tfemail.setFont(new Font("serif",Font.PLAIN, 18));
        add(tfemail);

        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(100, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        tfeducation = new JTextField();
        tfeducation.setBounds(260, 300, 200, 30);
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setFont(new Font("serif",Font.PLAIN, 18));
        add(tfeducation);

        JLabel labeldegree = new JLabel("Degree");
        labeldegree.setBounds(640, 300, 150, 30);
        labeldegree.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldegree);

        tfdegree = new JTextField();
        tfdegree.setBounds(800, 300, 200, 30);
        tfdegree.setFont(new Font("serif",Font.PLAIN, 18));
        add(tfdegree);

        JLabel labelid = new JLabel ("Employee ID");
        labelid.setBounds(100, 350, 150, 30);
        labelid.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelid);

        lblid = new JLabel (""+num);
        lblid.setBounds(260, 350, 200, 30);
        lblid.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblid);

        JLabel  labelpost = new JLabel("Job Position");
        labelpost.setBounds(640, 350, 150, 30);
        labelpost.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelpost);

        tfpost = new JTextField();
        tfpost.setBounds(800, 350, 200, 30);
        tfpost.setFont(new Font("serif",Font.PLAIN, 18));
        add(tfpost);

        JLabel labeljoined = new JLabel("Joined date");
        labeljoined.setBounds(640, 400, 150, 30);
        labeljoined.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeljoined);

        JLabel lbljoined = new JLabel();
        lbljoined.setBounds(800, 400, 200, 30);
        lbljoined.setFont(new Font("serif",Font.PLAIN, 18));
        add(lbljoined);

        try{
            conn c = new conn();
            String query = "select *from employee where id = '" +empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdegree.setText(rs.getString("degree"));
                lblid.setText(rs.getString("id"));
                tfpost.setText(rs.getString("post"));
                lbljoined.setText(rs.getString("joined"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }


        update = new JButton("Update");
        update.setFont(new Font("serif", Font.PLAIN, 20));
        update.setBounds(420, 500, 280, 30);
        update.setBackground(new Color(18, 78, 102));
        update.setForeground(new Color(116, 141, 146));
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setFont(new Font("serif", Font.PLAIN, 20));
        back.setBounds(720, 500, 280, 30);
        back.setBackground(new Color(18, 78, 102));
        back.setForeground(new Color(116, 141, 146));
        back.addActionListener(this);
        add(back);

        setSize(1120, 630);
        setLocation(80, 40);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String fname = tffname.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String degree = tfdegree.getText();
            String post = tfpost.getText();
            try{
                conn con = new conn();
                String query = "update employee set fname = '"+fname+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"',degree = '"+degree+"', post = '"+post+"' where id = '"+empId+"'";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated Succesfully");
                setVisible(false);
                new viewRecords();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new records();
        } 
    }
    public static void main(String[] args) {
        new updateRecords("");
    }
}
