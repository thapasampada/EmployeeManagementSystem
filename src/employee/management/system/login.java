
package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener {
    JButton Login, Clear, Back;
    JTextField tfadmin;
    JPasswordField tfpassword;
    login(){
        getContentPane().setBackground(new Color(33, 42, 49));
        setLayout(null);

        JLabel heading = new JLabel("LOG-IN");
        heading.setBounds(340,40, 400, 40);
        heading.setFont(new Font("serif",Font.PLAIN, 40));
        heading.setForeground(new Color(116, 141, 146));
        add(heading);

        JLabel adminusername = new JLabel("User Name:");
        adminusername.setBounds(180, 120, 180,30);
        adminusername.setFont(new Font("serif",Font.PLAIN, 22));
        adminusername.setForeground(new Color(116, 141, 146));
        add(adminusername);
        tfadmin = new JTextField();
        tfadmin.setBounds(320, 120, 200, 30);
        tfadmin.setFont(new Font("serif",Font.PLAIN, 18));
        add(tfadmin);

        JLabel adminpassword = new JLabel("Password:");
        adminpassword.setBounds(180, 180, 180,30);
        adminpassword.setFont(new Font("serif",Font.PLAIN, 22));
        adminpassword.setForeground(new Color(116, 141, 146));
        add(adminpassword);
        tfpassword = new JPasswordField();
        tfpassword.setBounds(320, 180, 200, 30);
        tfpassword.setFont(new Font("serif",Font.PLAIN, 18));
        add(tfpassword);

        Login = new JButton("LogIn");
        Login.setBounds(320, 260, 80, 30);
        Login.addActionListener(this);
        add(Login);

        Clear = new JButton("Clear");
        Clear.setBounds(440, 260, 80, 30);
        Clear.addActionListener(this);
        add(Clear);

        Back = new JButton("Back");
        Back.setBounds(320, 310, 200, 30);
        Back.addActionListener(this);
        add(Back);

        setSize(800, 400 );
        setLocation(300, 160);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Clear){
            tfadmin.setText("");
            tfpassword.setText("");
        }
        else if(ae.getSource() == Back){
            setVisible(false);
            new welcome();
        }
        else try{
            conn c = new conn();
            String username = tfadmin.getText();
            String password = tfpassword.getText();

            String query = "select* from login where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                setVisible(false);
                new home();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String args[]){
        new login();
    }
}
