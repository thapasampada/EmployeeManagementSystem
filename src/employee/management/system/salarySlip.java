package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;

public class salarySlip extends JFrame implements ActionListener {
    Choice cid;
    JTextArea text;
    JButton print, back;
    Font f;
    JPanel panel;
    
    salarySlip() {
        setLayout(null);
        
        f = new Font("arial", Font.BOLD, 16);
        
        cid = new Choice();
        cid.setBounds(240, 520, 160, 30);
        
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM salary");
            while (rs.next()) {
                cid.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblid = new JLabel("Select ID");
        lblid.setBounds(80, 520, 160, 30);
        lblid.setFont(f);
        
        print = new JButton("Generate Pay Slip");
        print.setBounds(440, 520, 200, 30);
        print.addActionListener(this);
        
        back = new JButton("Back"); // Initialize the back button
        back.setBounds(660, 520, 100, 30);
        back.addActionListener(this); // Add action listener for back button
        
        text = new JTextArea();
        JScrollPane sp = new JScrollPane(text);
        text.setEditable(false);
        text.setFont(f);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4, 10, 10)); // Updated to 4 columns
        panel.add(lblid);
        panel.add(cid);
        panel.add(print);
        panel.add(back);
        
        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        
        setSize(800, 600);
        setLocation(300, 40);
        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print) {
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("SELECT * FROM employee WHERE id='" + cid.getSelectedItem() + "'");
                
                if (rs.next()) {
                    String name = rs.getString("name");
                    rs.close();
                    rs = c.s.executeQuery("SELECT * FROM salary WHERE id='" + cid.getSelectedItem() + "'");
                    
                    if (rs.next()) {
                        double gross = 0;
                        Calendar now = Calendar.getInstance();
                        int month = now.get(Calendar.MONTH) + 1; // Months are 0-based
                        int year = now.get(Calendar.YEAR);

                        text.setText(" ----------------   PAY SLIP FOR THE MONTH OF " + month + ", " + year + "   ------------------------");
                        text.append("\n");
                        text.append("\n     Employee ID: " + rs.getString("id"));
                        text.append("\n     Employee Name: " + name);
                        text.append("\n----------------------------------------------------------------");
                        text.append("\n");
                 
                        double basic = rs.getDouble("basic");
                        text.append("\n                  BASIC SALARY: " + basic);
                        double living = rs.getDouble("living");
                        text.append("\n                  Living: " + living);
                        double overtime = rs.getDouble("overtime");
                        text.append("\n                  Overtime: " + overtime);
                        double other = rs.getDouble("other");
                        text.append("\n                  Other: " + other);

                        gross = overtime + living + other + basic;

                        text.append("\n-------------------------------------------------------");
                        text.append("\n");

                        text.append("\n       GROSS SALARY: " + gross + " ");
                        text.append("\n       Tax: 2.1% of gross " + (gross * 2.1 / 100));
                        text.append("\n -------------------------------------------------");
                        text.append("\n");
                        text.append("\n");
                        text.append("   (  Signature  )");
                    } else {
                        text.setText("No salary record found for the selected ID.");
                    }
                } else {
                    text.setText("No employee record found for the selected ID.");
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        } else if (e.getSource() == back) {
            
            this.dispose();
        }
    }
   
    public static void main(String[] args) {
        new salarySlip();
    }
}

