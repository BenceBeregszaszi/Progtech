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
    }
    public String szamit(){
        return "Hello world";
    }

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
    }
}
