package Windows;

import Classes.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JDialog{

    private JTextField tb_username;
    private JTextField tb_password;
    private JButton registerButton;
    private JButton cancelButton;
    private JPanel RegisterP;

    public Register(){
        setTitle("Registration");
        setContentPane(RegisterP);
        setMinimumSize(new Dimension(800,500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Users.Create(tb_username.getText(), tb_password.getText());
                MainForm main = new MainForm(Users.Login(tb_username.getText(), tb_password.getText()));
                main.setVisible(true);
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
