package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class attendancepanel extends JFrame implements ActionListener {
    JLabel heading;
    JButton update, view, back;
    attendancepanel(){
        getContentPane().setBackground(new Color(33, 42, 49));
        setLayout(null);
        
        heading = new JLabel("Attendance Panel");
        heading.setBounds(420, 40, 800, 60);
        heading.setFont(new Font("serif",Font.BOLD, 42));
        heading.setForeground(new Color(33, 42, 49));
        add(heading);
        
        update = new JButton("Update");
        update.setBounds(80, 200, 200, 50);
        update.setFont(new Font("serif",Font.PLAIN,28));
        update.setForeground(new Color(116, 141, 146));
        update.addActionListener(this);
        add(update);
        
        view = new JButton("View");
        view.setBounds(340, 200, 200, 50);
        view.setFont(new Font("serif",Font.PLAIN,28));
        view.setForeground(new Color(116, 141, 146));
        view.addActionListener(this);
        add(view);
        
        back = new JButton("Back");
        back.setBounds(340, 280, 200, 50);
        back.setFont(new Font("serif",Font.PLAIN,28));
        back.setForeground(new Color(116, 141, 146));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/attendance1.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(540, 120, 560, 455);
        add(image);
        
        setSize(1120, 630);
        setLocation(80, 40);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == update){
        setVisible(false);
        new addAttendance();
      } else if(ae.getSource() == view){
          setVisible(false);
          new viewAttendance();

      }else if(ae.getSource() == back){
        setVisible(false);
        new home();
      }
    }
        
    public static void main(String[] args){
        new attendancepanel();
    }
}
