
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class home extends JFrame implements ActionListener{
        JButton records, salary, attendance, back;
    home(){
        getContentPane().setBackground(new Color(33, 42, 49));
        setLayout(null);

        JLabel heading = new JLabel("Employee Management System");
        heading.setFont(new Font("serif",Font.PLAIN,42));
        heading.setBounds(280, 40, 600, 60);
        heading.setForeground(new Color(116, 141, 146));
        add(heading);


        records = new JButton ("Records");
        records.setFont(new Font("serif",Font.PLAIN,28));
        records.setBounds(160, 200, 160, 50);
        records.setBackground(new Color(18, 78, 102));
        records.setForeground(new Color(116, 141, 146));
        records.addActionListener(this);
        add(records);

        salary = new JButton ("Salary");
        salary.setFont(new Font("serif",Font.PLAIN, 28));
        salary.setBounds(360, 200, 160, 50);
        salary.setBackground(new Color(18, 78, 102));
        salary.setForeground(new Color(116, 141, 146));
        salary.addActionListener(this);
        add(salary);

        attendance = new JButton("Attendance");
        attendance.setFont(new Font("serif",Font.PLAIN,28));
        attendance.setBounds(160, 340, 160, 50);
        attendance.setBackground(new Color(18, 78, 102));
        attendance.setForeground(new Color(116, 141, 146));
        attendance.addActionListener(this);
        add(attendance);


        back = new JButton("Log Out");
        back.setBounds(180, 480, 260, 50);
        back.setFont(new Font("serif",Font.PLAIN,28));
        back.setBackground(new Color(18, 78, 102));
        back.setForeground(new Color(116, 141, 146));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/employee.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(420, 20, 800, 709);
        add(image);

        setSize(1120, 630);
        setLocation(80, 40);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == records){
        setVisible(false);
        new records();
      } else if(ae.getSource() == salary){
          setVisible(false);
          new salary();

      } else if(ae.getSource() == attendance){

      }else if(ae.getSource() == back){
        setVisible(false);
        new welcome();
      }
    }
    public static void main(String[] args){
        new home();
    }
}
