package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class updateSalary extends JFrame implements ActionListener, ItemListener {
    Choice id;
    JLabel name;
    JTextField basic, tfliving, tfovertime, tfother, date;
    JButton update, back, search;
    updateSalary(){
        getContentPane().setBackground(new Color(33, 42, 49));
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee ID");
        searchlbl.setBounds(20, 20, 160, 20);
        searchlbl.setForeground(new Color(116, 141, 146));
        add(searchlbl);

        id = new Choice();
        id.setBounds(180, 20, 80, 20);
        id.addItemListener(this);
        add(id);
        
        
        /*search = new JButton("Search");
        search.setBounds(280, 20, 80, 20);
        search.addActionListener(this);
        add(search);*/
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                id.add(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel namelbl = new JLabel("Name");
        namelbl.setBounds(20, 60, 160, 30);
        namelbl.setForeground(new Color(116, 141, 146));
        add(namelbl);
       
        
        name = new JLabel();
        name.setBounds(180, 60, 180, 30);
        name.setForeground(new Color(116, 141, 146));
        add(name);
        
        JLabel basiclbl = new JLabel("Basic Salary");
        basiclbl.setBounds(20, 120, 160, 30);
        basiclbl.setForeground(new Color(116, 141, 146));
        add(basiclbl);
        
        basic = new JTextField();
        basic.setBounds(180, 120, 180, 30);
        basic.setForeground(new Color(116, 141, 146));
        add(basic);
        
        JLabel livinglbl = new JLabel("Living Allowance");
        livinglbl.setBounds(20, 180, 160, 30);
        livinglbl.setForeground(new Color(116, 141, 146));
        add(livinglbl);
        
        tfliving = new JTextField();
        tfliving.setBounds(180, 180, 180, 30);
        tfliving.setForeground(new Color(116, 141, 146));
        add(tfliving);
        
        JLabel overtimelbl = new JLabel("Overtime Allowance");
        overtimelbl.setBounds(20, 240, 160, 30);
        overtimelbl.setForeground(new Color(116, 141, 146));
        add(overtimelbl);
        
        tfovertime = new JTextField();
        tfovertime.setBounds(180, 240, 180, 30);
        tfovertime.setForeground(new Color(116, 141, 146));
        add(tfovertime);
        
        JLabel otherlbl = new JLabel("Other Allowances");
        otherlbl.setBounds(20, 300, 160, 30);
        otherlbl.setForeground(new Color(116, 141, 146));
        add(otherlbl);
        
        tfother = new JTextField();
        tfother.setBounds(180, 300, 180, 30);
        tfother.setForeground(new Color(116, 141, 146));
        add(tfother);
        
         JLabel datelbl = new JLabel("Date");
        datelbl.setBounds(20, 360, 160, 30);
        datelbl.setForeground(new Color(116, 141, 146));
        add(datelbl);
        
        date = new JTextField();
        date.setBounds(180, 360, 180, 30);
        date.setForeground(new Color(116, 141, 146));
        add(date);
        
        try{
            conn c = new conn();
            String query = "select *from salary where id = '" +id+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                name.setText(rs.getString("name"));
                basic.setText(rs.getString("salary"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/salary1.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(380, 20, 450, 450);
        add(image);
        
        update = new JButton ("Update");
        update.setFont(new Font("serif",Font.PLAIN, 18));
        update.setBounds(80, 400, 100, 30);
        update.setBackground(new Color(18, 78, 102));
        update.setForeground(new Color(116, 141, 146));
        update.addActionListener(this);
        add(update);


        back = new JButton("Back");
        back.setBounds(220, 400, 100, 30);
        back.setFont(new Font("serif",Font.PLAIN,18));
        back.setBackground(new Color(18, 78, 102));
        back.setForeground(new Color(116, 141, 146));
        back.addActionListener(this);
        add(back);
        
        
        
        setSize(800, 500);
        setLocation(220, 120);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String cid = id.getSelectedItem();
            String salary = basic.getText();
            String living = tfliving.getText();
            String overtime = tfovertime.getText();
            String other = tfother.getText();
            String query = "update salary set basic="+salary+", living="+living+", overtime="+overtime+", other="+other+" where id="+id.getSelectedItem();

            try{
                conn con = new conn();
                
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated Succesfully");
                setVisible(false);
                new salary();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }/*else
            
            if(ae.getSource() == search){
                
            String query = "select * from employee where id = '"+id.getSelectedItem()+"'";
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    name.setText(rs.getString("name"));
                    basic.setText(rs.getString("salary"));
                    tfliving.setText(rs.getString("living"));
                    tfovertime.setText(rs.getString("overtime"));
                    tfother.setText(rs.getString("other"));
            }} catch(Exception e){
                e.printStackTrace();
            }
        }*/
        else {
            setVisible(false);
            new salary();
        } 
    }
      public void itemStateChanged(ItemEvent ie)
    {
        try{
           conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from salary where id="+id.getSelectedItem());
            if(rs.next()){
                name.setText(rs.getString("name"));
                basic.setText(rs.getString("basic"));
                tfliving.setText(rs.getString("living"));
                tfovertime.setText(rs.getString("overtime"));
                tfother.setText(rs.getString("other"));
         
            }
       }catch(Exception ee){
           ee.printStackTrace();
       }
        
        
    }
    public static void main(String[] args){
        new updateSalary();
    }
}
