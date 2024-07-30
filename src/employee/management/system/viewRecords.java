package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class viewRecords extends JFrame implements ActionListener {
    JTable table;
    Choice cemployeeid;
    JButton search, print, update,  back;
    viewRecords(){
        getContentPane().setBackground(new Color(116, 141, 146));
        setLayout(null);

        JLabel searchlbl = new JLabel("Search by Employee ID");
        searchlbl.setBounds(20, 20, 160, 20);
        add(searchlbl);

        cemployeeid = new Choice();
        cemployeeid.setBounds(180, 20, 150, 20);
        add(cemployeeid);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton ("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);


        table = new JTable();

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                cemployeeid.add(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            while(rs.next()){
                cemployeeid.add(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1120, 530);
        add(jsp);

        setSize(1120, 630);
        setLocation(80, 40);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from employee where id = '"+cemployeeid.getSelectedItem()+"'";
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == print){
            try{
                table.print();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new updateRecords(cemployeeid.getSelectedItem());

        }
        else if(ae.getSource() == back){
            setVisible(false);
            new records();
        }
    }
    public static void main(String[]args){
        new viewRecords();
    }
}
