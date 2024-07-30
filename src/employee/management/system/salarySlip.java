package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class salarySlip extends JFrame implements ActionListener {
    Choice cid;
    JTextArea text;
    JButton print, back;
    salarySlip(){
        setLayout(null);
        
        cid = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                cid.add(rs.getString("id"));
            }
        }catch(Exception e){
            
        }
        
        JLabel lblid = new JLabel ("Select ID");
        lblid.setBounds(80, 40, 120, 30);
        add(lblid);
        
        text = new JTextArea(30,50);
        JScrollPane jsp = new JScrollPane(text);
     
        Font f1 = new Font("arial",Font.BOLD,20);
        text.setFont(f1);
        
        print = new JButton("Generate Pay Slip");
    
        add(print,"South");
        add(jsp,"Center");
        print.addActionListener(this);
        
        setSize(800, 600);
        setLocation(300, 90);
    
    }
   
    public void actionPerformed(ActionEvent e) {
     
    	  
    		  
    	  
    	
        try{
            conn c = new conn();
         
            ResultSet rs = c.s.executeQuery("select * from employee where emp_id="+cid.getSelectedItem());
            rs.next();
            String name = rs.getString("name");
            rs.close();
         
            rs = c.s.executeQuery("select * from salary where id="+cid.getSelectedItem());
            double gross=0;
            
 
            java.util.Date d1 = new java.util.Date();
            int month = d1.getMonth();
            int year = d1.getYear();
            
            
            text.setText(" ----------------   PAY SLIP FOR THE MONTH OF "+month+" , "+year+"  ------------------------");
            text.append("\n");
  
            if(rs.next()){
          
                text.append("\n     Employee ID "+rs.getString("id"));
                text.append("\n     Employee Name "+name);
 
                text.append("\n----------------------------------------------------------------");
                text.append("\n");
                
                double basic = rs.getDouble("basic");
                text.append("\n                  BASIC SALARY : "+basic);
                double living = rs.getDouble("living");
                text.append("\n                  Living       : "+living);
                double overtime  = rs.getDouble("overtime");
                text.append("\n                  Overtime     : "+overtime);
                double other  = rs.getDouble("other");
                text.append("\n                  Other        : "+other);
                
                gross = overtime+living+other+basic;
                
                

                text.append("\n-------------------------------------------------------");
                text.append("\n");
 
                text.append("\n       GROSS SALARY :"+gross+"    ");
                text.append("\n       Tax   :   2.1% of gross "+ (gross*2.1/100));   
                text.append("\n -------------------------------------------------");
                text.append("\n");
                text.append("\n");    
                text.append("\n");
                text.append("   (  Signature  )      ");
               
            }
        }
    	  catch(Exception ee) {
            ee.printStackTrace();
        }
    	  
 
   
    }
        
        
       
       
       
    public static void main(String[] args){
        new salarySlip();
    }
}
