package project.project2;

import javax.swing.*;
import java.awt.*;

public class homepage extends JFrame {
    Container container;
    ImageIcon img;
    JLabel backg;
    JPanel panel1;

    homepage() {
        container = getContentPane();
        container.setLayout(null);
        img = new ImageIcon(getClass().getResource("images.jpg"));
        backg = new JLabel(img);
        backg.setBounds(0, 0, 1200, 700);
        add(backg);

        panel1 = new JPanel();
        panel1.setBounds(400, 150, 400, 400);
        panel1.setBackground(new Color(0, 0, 0, 50));
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(50, Color.BLACK, Color.BLACK));
        backg.add(panel1);
    }

    public static void main(String[] args) {
        homepage frame = new homepage();
        frame.setTitle("Home apge");
        frame.setVisible(true);
        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.LIGHT_GRAY);
    }
}
