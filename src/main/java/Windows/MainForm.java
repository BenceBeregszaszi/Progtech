package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{

    private JButton btn_login;
    private JList pizza_list;
    private JButton btn_register;
    private JPanel main_panel;


    public MainForm() {
        setTitle("Main");
        setContentPane(main_panel);
        setMinimumSize(new Dimension(1024,800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login loginpanel = new Login();
                loginpanel.setVisible(true);
            }
        });
         btn_register.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                Register registerpanel = new Register();
                registerpanel.setVisible(true);
            }
        });

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
    }
}
