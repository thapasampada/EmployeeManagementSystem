
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


import com.toedter.calendar.JDateChooser;

public class addRecords extends JFrame implements ActionListener {
    Random ran = new Random();
    int num = ran.nextInt(999999);

    JButton clear, done, back;
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfdegree;
    JDateChooser dcdob, dcjoined;
    JComboBox cbeducation, cbpost;
    JLabel lblid;

    addRecords(){
        getContentPane().setBackground(new Color(116, 141, 146));
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Records");
        heading.setBounds(380, 40, 600, 80);
        heading.setFont(new Font("serif", Font.BOLD, 38));
        heading.setForeground(new Color(33, 42, 49));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(100, 150,150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField ();
        tfname.setBounds(260, 150, 200, 30);
        tfname.setFont(new Font("serif",Font.PLAIN, 18));
        add(tfname);

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

        dcdob = new JDateChooser();
        dcdob.setBounds(260, 200, 200, 30);
        dcdob.setFont(new Font("serif",Font.PLAIN, 18));
        add(dcdob);

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

        String courses[] = {"Phd","Masters","Bachelors","Diploma","SLC"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(260, 300, 200, 30);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setFont(new Font("serif",Font.PLAIN, 18));
        add(cbeducation);

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

        String post[]={"Manager","Web Developer","Graphics Designer","Network Architetctures","Software Engineer","Cloud Engineer","Security Analysts","IT Director"};
        cbpost = new JComboBox(post);
        cbpost.setBounds(800, 350, 200, 30);
        cbpost.setFont(new Font("serif",Font.PLAIN, 18));
        add(cbpost);


        JLabel labeljoined = new JLabel("Joined date");
        labeljoined.setBounds(640, 400, 150, 30);
        labeljoined.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeljoined);

        dcjoined = new JDateChooser();
        dcjoined.setBounds(800, 400, 200, 30);
        dcjoined.setFont(new Font("serif",Font.PLAIN, 18));
        add(dcjoined);

        clear = new JButton("Clear");
        clear.setFont(new Font("serif", Font.PLAIN, 20));
        clear.setBounds(100, 500, 280, 30);
        clear.setBackground(new Color(18, 78, 102));
        clear.setForeground(new Color(116, 141, 146));
        clear.addActionListener(this);
        add(clear);

        done = new JButton("Done");
        done.setFont(new Font("serif", Font.PLAIN, 20));
        done.setBounds(420, 500, 280, 30);
        done.setBackground(new Color(18, 78, 102));
        done.setForeground(new Color(116, 141, 146));
        done.addActionListener(this);
        add(done);

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
        if(ae.getSource() == clear){
            tfname.setText("");
            tffname.setText("");
            tfaddress.setText("");
            dcdob.setDate(null);
        }else if(ae.getSource() == done){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String degree = tfdegree.getText();
            String empid = lblid.getText();
            String post = (String) cbpost.getSelectedItem();
            String joined = ((JTextField) dcjoined.getDateEditor().getUiComponent()).getText();

            try{
                conn con = new conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+degree+"','"+empid+"','"+post+"','"+joined+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Succesfully");
                setVisible(false);
                new records();
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
        new addRecords();
    }
}
