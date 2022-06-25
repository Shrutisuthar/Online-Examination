
package quiz;

/**
 *
 * @author Shruti
 */


import java.awt.Color;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Quiz extends JFrame implements ActionListener
{
     JButton b1,b2;
     JTextField t1,t2;
    Quiz()
    {
        setBounds(500,200,1000,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("quiz/icons/1.jpg"));
        JLabel s1 = new JLabel(il); 
        
        s1.setBounds(0,0,600,500);
        add(s1);
        
        JLabel s2 = new JLabel("Java Quiz");
        s2.setFont(new Font("Viner Hand ITC",Font.BOLD, 30));    
        s2.setForeground(Color.blue);
        s2.setBounds(650, 40, 300, 35);
        add(s2);
        
        JLabel s3 = new JLabel("Login First");
        s3.setFont(new Font("Raleway",Font.BOLD, 18));    
        s3.setForeground(Color.blue);
        s3.setBounds(700, 130, 300, 20);
        add(s3);
       
        
       b1 = new JButton("Login");
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);
        b1.setBounds(630, 300, 120, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Exits");
        b2.setForeground(Color.white);
        b2.setBackground(Color.blue);
        b2.setBounds(810, 300, 120, 25);
        b2.addActionListener(this);
        add(b2);
        
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new Quiz();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == b1)
        {
            //String name = t1.getText();
            this.setVisible(false);
            //new Userlogin();
                    EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Userlogin frame = new Userlogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        }
        else
        {
            System.exit(0);
        }
    }
    
}
