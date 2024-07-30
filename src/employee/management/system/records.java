
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class records extends JFrame implements ActionListener {
        JButton add, view, update, remove, back;
    records(){
        getContentPane().setBackground(new Color(33, 42, 49));
        setLayout(null);

        JLabel heading = new JLabel("Records");
        heading.setFont(new Font("serif",Font.PLAIN,42));
        heading.setBounds(500, 40, 600, 60);
        heading.setForeground(new Color(116, 141, 146));
        add(heading);


        add = new JButton("Add Record");
        add.setFont(new Font("serif",Font.PLAIN,28));
        add.setBounds(50, 200, 260, 50);
        add.setBackground(new Color(18, 78, 102));
        add.setForeground(new Color(116, 141, 146));
        add.addActionListener(this);
        add(add);

        view = new JButton("View Record");
        view.setFont(new Font("serif",Font.PLAIN, 28));
        view.setBounds(330, 200, 260, 50);
        view.setBackground(new Color(18, 78, 102));
        view.setForeground(new Color(116, 141, 146));
        view.addActionListener(this);
        add(view);

        update = new JButton("Update Record");
        update.setFont(new Font("serif",Font.PLAIN,28));
        update.setBounds(50, 340, 260, 50);
        update.setBackground(new Color(18, 78, 102));
        update.setForeground(new Color(116, 141, 146));
        update.addActionListener(this);
        add(update);

        remove = new JButton("Remove Record");
        remove.setFont(new Font("serif",Font.PLAIN,28));
        remove.setBounds(330, 340, 260, 50);
        remove.setBackground(new Color(18, 78, 102));
        remove.setForeground(new Color(116, 141, 146));
        remove.addActionListener(this);
        add(remove);

        back = new JButton("Back");
        back.setBounds(180, 480, 260, 50);
        back.setFont(new Font("serif",Font.PLAIN,28));
        back.setBackground(new Color(18, 78, 102));
        back.setForeground(new Color(116, 141, 146));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/form2.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(560, 130, 574, 435);
        add(image);

        setSize(1120, 630);
        setLocation(80, 40);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
            new addRecords();

        }else if(ae.getSource() == view){
            setVisible(false);
            new viewRecords();
        }else if(ae.getSource() == update){
            setVisible(false);
            new viewRecords();
        }else if(ae.getSource() == remove){
            setVisible(false);
            new removeRecords();
        }else{
            setVisible(false);
            new home();
        }

    }
    public static void main(String[] args){
        new records();
    }
}
