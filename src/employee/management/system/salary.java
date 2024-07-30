package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class salary extends JFrame implements ActionListener {
    JLabel heading;
    JButton update, view, print, back;
    salary(){
        getContentPane().setBackground(new Color(116, 141, 146));
        setLayout(null);
        
        heading = new JLabel("Salary Panel");
        heading.setBounds(420, 40, 800, 60);
        heading.setFont(new Font("serif",Font.BOLD, 42));
        heading.setForeground(new Color(33, 42, 49));
        add(heading);
        
        update = new JButton("Update");
        update.setBounds(80, 200, 200, 50);
        update.setFont(new Font("serif",Font.PLAIN,28));
        update.setForeground(new Color(33, 42, 49));
        update.addActionListener(this);
        add(update);
        
        view = new JButton("View");
        view.setBounds(340, 200, 200, 50);
        view.setFont(new Font("serif",Font.PLAIN,28));
        view.setForeground(new Color(33, 42, 49));
        view.addActionListener(this);
        add(view);
        
        print = new JButton("Grnerate Slip");
        print.setBounds(80, 280, 200, 50);
        print.setFont(new Font("serif",Font.PLAIN,28));
        print.setForeground(new Color(33, 42, 49));
        print.addActionListener(this);
        add(print);
        
        back = new JButton("Back");
        back.setBounds(340, 280, 200, 50);
        back.setFont(new Font("serif",Font.PLAIN,28));
        back.setForeground(new Color(33, 42, 49));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/salary2.png"));
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
        new updateSalary();
      } else if(ae.getSource() == view){
          setVisible(false);
          new salary();

      } else if(ae.getSource() == print){

      }else if(ae.getSource() == back){
        setVisible(false);
        new home();
      }
    }
    public static void main(String[] args){
        new salary();
    } 
}
