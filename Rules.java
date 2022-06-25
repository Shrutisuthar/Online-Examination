package quiz;

/**
 *
 * @author Shruti
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    JButton b1, b2;

    Rules(String username) {
        setBounds(500, 200, 1000, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel i1 = new JLabel("Welcome " + username + " to Java Quiz");
        i1.setBounds(50, 40, 300, 35);
        i1.setFont(new Font("Raleway", Font.BOLD, 20));
        i1.setForeground(Color.blue);
        add(i1);

        JLabel i2 = new JLabel("Rules:");
        i2.setBounds(50, 70, 300, 35);
        i2.setFont(new Font("Raleway", Font.BOLD, 18));
        i2.setForeground(Color.pink);
        add(i2);

        JLabel i3 = new JLabel("");
        i3.setBounds(50, 20, 900,500 );
        i3.setFont(new Font("Raleway", Font.BOLD, 16));
        i3.setForeground(Color.black);
        i3.setText(
                "<html>" + "1. You have 5 minutes to complete this quiz" + "<br>" + "2. for updating your profile click on <b>Update</b>" + "<br>"
                + "3. For starting the quiz click on Start" + "<br>"
                + "</html>"
        );
        add(i3);

        b1 = new JButton("Update");
        b1.setBounds(50, 350, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Start");
        b2.setBounds(200, 350, 100, 30);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Rules("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            this.setVisible(false);
            
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Changepw f = new Changepw();
                    f.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        } else {
            this.setVisible(false);            
            new OnlineTest("Online Test Of Java").setVisible(true);
        }
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
