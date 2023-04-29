package project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;

public class changePassword extends JFrame {

    changePassword() {
        Container con = getContentPane();
        con.setLayout(null);

        ImageIcon im = new ImageIcon(getClass().getResource("wood.jpg"));
        JLabel label = new JLabel(im);
        label.setBounds(0, 0, 400, 300);
        add(label);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setSize(400, 300);
        panel.setLocation(0, 0);
        panel.setLayout(null);
        label.add(panel);

        JLabel email = new JLabel("Enter email id : ");
        email.setBounds(100, 50, 200, 30);
        email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(email);

        JTextField emailfield = new JTextField();
        emailfield.setBounds(100, 85, 200, 30);
        panel.add(emailfield);

        JButton change = new JButton("Submit");
        change.setBounds(100, 115, 100, 25);
        panel.add(change);

        JPanel panel2 = new JPanel();
        panel2.setVisible(false);
        panel2.setOpaque(false);
        panel2.setSize(400, 300);
        panel2.setLocation(0, 0);
        panel2.setLayout(null);
        label.add(panel2);

        JLabel setpassword = new JLabel("Set Password  : ");
        setpassword.setBounds(100, 50, 200, 30);
        setpassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel2.add(setpassword);

        JTextField setpasswordfield = new JTextField();
        setpasswordfield.setBounds(100, 80, 200, 30);
        panel2.add(setpasswordfield);

        JLabel confirmpassword = new JLabel("Confirm Password : ");
        confirmpassword.setBounds(100, 110, 200, 30);
        confirmpassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel2.add(confirmpassword);

        JTextField confirmpasswordfield = new JTextField();
        confirmpasswordfield.setBounds(100, 140, 200, 30);
        panel2.add(confirmpasswordfield);

        JButton submit = new JButton("Submit");
        submit.setBounds(100, 175, 100, 25);
        panel2.add(submit);

        change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String em = emailfield.getText();
                panel.setVisible(false);
                panel2.setVisible(true);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String pass = confirmpasswordfield.getText();
                        String pass1 = setpasswordfield.getText();
                        System.out.println(pass);
                        System.out.println(pass1);
                        System.out.println(em);
                        if (!pass.equals(pass1)) {
                            JOptionPane.showMessageDialog(panel2, "Password not matching ! ");
                            System.exit(0);
                        }
                        try {
                            Connection con1 = (Connection) DriverManager
                                    .getConnection("jdbc:mysql://localhost:3306/login", "root",
                                            "ranjan5044");

                            String sql = "UPDATE bank set pass= ? where email= ?";
                            PreparedStatement st = (PreparedStatement) con1.prepareStatement(sql);
                            st.setString(1, pass);
                            st.setString(2, em);
                            int x = st.executeUpdate();
                            if (x == 1) {
                                JOptionPane.showMessageDialog(panel2, "Password Changed ! ");
                            }
                            con1.close();
                        } catch (Exception exception) {
                            System.out.println(exception);
                        }
                    }
                });
            }
        });

        setVisible(true);
        setLayout(null);
        setLocation(300, 150);
        setSize(400, 300);
    }

    public static void main(String[] args) {
        new changePassword();
    }
}
