
package quiz;


/**
 *
 * @author Shruti
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Changepw extends JFrame
{
    
    
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    
    public static void main(String[] args) {
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
        
    }
    public Changepw()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 950, 490);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("change profile");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);
        

        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);
       
        
        JLabel lblId = new JLabel("ID");
        lblId.setForeground(Color.BLACK);
        lblId.setBackground(Color.CYAN);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblId.setBounds(250,166, 193, 52);
        contentPane.add(lblId);
        


        JLabel lblPassword = new JLabel("New Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblPassword.setBounds(250,300, 193, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("update");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 73);
        btnNewButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = textField.getText();
                String password = passwordField.getText();
                 try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root", "");
                    Statement mystmt3=connection.createStatement();
                    PreparedStatement st = (PreparedStatement)connection.prepareStatement("update student SET password=? where id=?");
                    st.setString(1,password);
                    st.setString(2,id);
                    int rs = st.executeUpdate();
                        JOptionPane.showMessageDialog(btnNewButton, "updated successfully");
                        new Rules("");
                }
                catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }
            
        });
        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
        
        
    }
    
    
    
    
}
