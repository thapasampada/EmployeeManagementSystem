package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class welcome extends JFrame implements ActionListener {
        JButton admin;
    welcome(){
        getContentPane().setBackground(new Color(33, 42, 49));
        setLayout(null);

        JLabel heading = new JLabel("Welcome to Employee Management System");
        heading.setFont(new Font("serif",Font.PLAIN,42));
        heading.setBounds(200, 40, 800, 60);
        heading.setForeground(new Color(116, 141, 146));
        add(heading);

        admin = new JButton("Admin Log-in");
        admin.setBounds(420, 540, 260, 40);
        admin.setFont(new Font("serif",Font.PLAIN, 28));
        admin.setBackground(new Color(18, 78, 102));
        admin.setForeground(new Color(116, 141, 146));
        admin.addActionListener(this);
        add(admin);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/employee3.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(140, 20, 800, 533);
        add(image);

        setSize(1120, 630);
        setLocation(80, 40);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == admin){
            setVisible(false);
            new login();
        }
    }
    public static void main(String[] args){
        new welcome();
    }
}
