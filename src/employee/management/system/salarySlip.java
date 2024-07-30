package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 


public class salarySlip extends JFrame implements ActionListener {
    Choice cid;
    JTextArea text;
    JButton print, back;
    Font f;
    JPanel panel;
    
    salarySlip(){
        setLayout(null);
        
        f = new Font("arial",Font.BOLD,16);
        
        cid = new Choice();
        cid.setBounds(240, 520, 160, 30);
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                cid.add(rs.getString("id"));
            }
        }catch(Exception e){
            
        }
       
        
        JLabel lblid = new JLabel ("Select ID");
        lblid.setBounds(80, 520, 160, 30);
        lblid.setFont(f);
        
        print = new JButton("Generate Pay Slip");
        print.setBounds(440, 520, 200, 30);
        print.addActionListener(this);
        
        text = new JTextArea();
        JScrollPane sp = new JScrollPane(text);
        text.setEditable(false);
        text.setFont(f);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(1,3,10,10));
        panel.add(lblid);
        panel.add(cid);
        panel.add(print);
        panel.add(back);
        
        setLayout(new BorderLayout());
        add(sp,"Center");
        add(panel,"South");
        
        setSize(800, 600);
        setLocation(300, 40);
        setVisible(true);
    
    }
   
    public void actionPerformed(ActionEvent e) {
     
    	if(e.getSource() == print){
             
             
             try{
                  conn c = new conn();
                  ResultSet rs = c.s.executeQuery("select * from employee where id="+cid.getSelectedItem());
                  rs.next();
                  String name = rs.getString("name");
                  rs.close();
                  rs = c.s.executeQuery("select * from salary where id="+cid.getSelectedItem());
                  double gross=0;
                  /*java.util.Date d1 = new java.util.Date();
                    int month = d1.getMonth();
                    int year = d1.getYear();*/
                  while(rs.next()){
                        text.setText(" ----------------   PAY SLIP FOR THE MONTH OF \"+month+\" , \"+year+\"   ------------------------");
                        text.append("\n");
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

            }catch(Exception ee){
                ee.printStackTrace();
            }

            }
    }
   

    public static void main(String[] args){
        new salarySlip();
    }
}
