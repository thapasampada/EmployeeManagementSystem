package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class removeRecords extends JFrame implements ActionListener{
    JLabel labelempId, labelname, lblname, labelphone, lblphone, labelemail, lblemail;
    Choice EmpId;
    JButton delete, back;
    removeRecords(){
        getContentPane().setBackground(new Color(116, 141, 146));
        setLayout(null);
        
        labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 50, 150, 30);
        labelempId.setFont(new Font("serif", Font.BOLD, 22));
        labelempId.setForeground(new Color(33, 42, 49));
        add(labelempId);
        
        EmpId = new Choice();
        EmpId.setBounds(200, 50, 150, 30);
        EmpId.setFont(new Font("serif", Font.BOLD, 22));
        EmpId.setForeground(new Color(33, 42, 49));
        add(EmpId);
        
        try{
            conn c = new conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                EmpId.add(rs.getString("id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        labelname = new JLabel("Employee Id");
        labelname.setBounds(50, 100, 200, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        labelname.setForeground(new Color(33, 42, 49));
        add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(200, 100, 150, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 18));
        lblname.setForeground(new Color(33, 42, 49));
        add(lblname);
        
        labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        labelphone.setForeground(new Color(33, 42, 49));
        add(labelphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(200, 150, 150, 30);
        lblphone.setFont(new Font("serif", Font.PLAIN, 18));
        lblphone.setForeground(new Color(33, 42, 49));
        add(lblphone);
        
        labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        labelemail.setForeground(new Color(33, 42, 49));
        add(labelemail);
        
        lblemail = new JLabel();
        lblemail.setBounds(200, 200, 150, 30);
        lblemail.setFont(new Font("serif", Font.PLAIN, 18));
        lblemail.setForeground(new Color(33, 42, 49));
        add(lblemail);
        
        try{
            conn c = new conn();
            String query = "select * from employee where id = '"+EmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        EmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
               try{
            conn c = new conn();
            String query = "select * from employee where id = '"+EmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        } 
            }
        });
        
        delete = new JButton("Delete");
        delete.setFont(new Font("serif", Font.PLAIN, 20));
        delete.setBounds(420, 500, 280, 30);
        delete.setBackground(new Color(18, 78, 102));
        delete.setForeground(new Color(116, 141, 146));
        delete.addActionListener(this);
        add(delete);

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
        if(ae.getSource() == delete){
            try{
                conn c = new conn();
                String query = "delete from employee where id = '"+EmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee information deleted succesfilly");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new records();
        }
    }
    public static void main(String[] args){
        new removeRecords();
    }
}
