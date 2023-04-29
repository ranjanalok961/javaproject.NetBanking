package project.info;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class JPopupMenuDemo {
    public static void main(String[] args) {
        JFrame app = new JFrame();
        JButton organization = new JButton("Organization");
        app.add(organization);
        app.setSize(400, 400);
        app.setLayout(new GridLayout(2, 1));
        app.setVisible(true);
        organization.setVisible(true);
        JPopupMenu menu = new JPopupMenu("Menu");
        JLabel status = new JLabel();
        status.setHorizontalTextPosition(SwingConstants.CENTER);
        status.setVerticalTextPosition(SwingConstants.CENTER);
        app.add(status);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText(e.getActionCommand());
                status.setVisible(true);
            }
        };
        JMenuItem enquire = new JMenuItem("Enquire");
        enquire.addActionListener(listener);
        JMenuItem aboutUs = new JMenuItem("About Us");
        aboutUs.addActionListener(listener);
        JMenuItem home = menu.add("Home");
        home.addActionListener(listener);
        JMenuItem contactUs = menu.add(new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText(e.getActionCommand());
                status.setVisible(true);
            }
        });
        menu.add(enquire);
        menu.add(aboutUs);
        menu.add(contactUs);
        home.setText("Home. Index - " + menu.getComponentIndex(home));
        enquire.setText("Enquire. Index - " + menu.getComponentIndex(enquire));
        aboutUs.setText("About Us. Index - " + menu.getComponentIndex(aboutUs));
        contactUs.setText("Contact Us. Index - " + menu.getComponentIndex(contactUs));
        menu.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                status.setText("Popup menu is visible now.");
                status.setVisible(true);
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                status.setText("Popup menu is invisible now.");
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                status.setText("Popup menu is cancelled now.");
            }
        });
        organization.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menu.show(app, e.getX(), e.getY());
            }
        });
    }
}