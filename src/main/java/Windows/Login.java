package Windows;

import Classes.DataNode;
import Classes.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog{
    private JPanel login;
    private JLabel lb_login;
    private JTextField tf_username;
    private JLabel lb_passsword;
    private JLabel lb_username;
    private JTextField tf_password;
    private JButton btn_cancel;
    private JButton btn_login;

    public Login(){
        setTitle("Main");
        setContentPane(login);
        setMinimumSize(new Dimension(800,500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send to db
                MainForm.setUser(Users.Login());
            }
        });
    }
    public void buildWindow(){

    }
}
