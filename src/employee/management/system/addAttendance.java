package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class addAttendance extends JFrame implements ActionListener, ItemListener {
    Choice cid, cattendance;
    JLabel cname;
    JButton update, back;
    addAttendance(){
        getContentPane().setBackground(new Color(33, 42, 49));
        setLayout(null);
        
         JLabel searchlbl = new JLabel("Search by Employee ID");
        searchlbl.setBounds(20, 20, 160, 20);
        searchlbl.setForeground(new Color(116, 141, 146));
        add(searchlbl);

        cid = new Choice();
        cid.setBounds(180, 20, 120, 20);
        cid.addItemListener(this);
        add(cid);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                cid.add(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel namelbl = new JLabel("Name");
        namelbl.setBounds(20, 60, 160, 30);
        namelbl.setForeground(new Color(116, 141, 146));
        add(namelbl);
       
        
        cname = new JLabel();
        cname.setBounds(180, 60, 180, 30);
        cname.setForeground(new Color(116, 141, 146));
        add(cname);
        
        JLabel basiclbl = new JLabel("Attendance");
        basiclbl.setBounds(20, 120, 160, 30);
        basiclbl.setForeground(new Color(116, 141, 146));
        add(basiclbl);
        
        cattendance = new Choice();
        cattendance.setBounds(200, 120, 100, 30);
        cattendance.add("Present");
        cattendance.add("Absent");
        add(cattendance);
        
        
       /* try{
            conn c = new conn();
            String query = "select *from attendance where id = '" +id+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                name.setText(rs.getString("name"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
*/
        
        update = new JButton ("Update");
        update.setFont(new Font("serif",Font.PLAIN, 18));
        update.setBounds(80, 200, 100, 30);
        update.setBackground(new Color(18, 78, 102));
        update.setForeground(new Color(116, 141, 146));
        update.addActionListener(this);
        add(update);


        back = new JButton("Back");
        back.setBounds(220, 200, 100, 30);
        back.setFont(new Font("serif",Font.PLAIN,18));
        back.setBackground(new Color(18, 78, 102));
        back.setForeground(new Color(116, 141, 146));
        back.addActionListener(this);
        add(back);
        
        
        
        setSize(800, 300);
        setLocation(220, 120);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String id = cid.getSelectedItem();
            String name = cname.getText();
            String attendance = cattendance.getSelectedItem();
            String date = new java.util.Date().toString();
            

            try{
                conn con = new conn();
                
                String query = "insert into attendance values('"+id+"','"+name+"','"+attendance+"','"+date+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated Succesfully");
                setVisible(false);
                new attendancepanel();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back) {
            setVisible(false);
            new attendancepanel();
        }
     }
        
     public void itemStateChanged(ItemEvent ie)
    {
        try{
           conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from employee where id="+cid.getSelectedItem());
            if(rs.next()){
                cname.setText(rs.getString("name"));
         
            }
       }catch(Exception ee){
           ee.printStackTrace();
       }
        
        
    }
    public static void main(String[] args){
            new addAttendance();
    }
    
}
