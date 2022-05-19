package Windows;

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
    private JButton btn_cancel;
    private JButton btn_login;
    private JPasswordField tf_password;

    public Login(){
        setTitle("Login");
        setContentPane(login);
        setMinimumSize(new Dimension(800,500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainForm main = new MainForm(null);
                main.setVisible(true);
                dispose();
            }
        });
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Users users = Users.Login(tf_username.getText(), tf_password.getText());
                    MainForm main = new MainForm(users);
                    main.setVisible(true);
                    dispose();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(login,"Nem megfelelő felhasználónév vagy jelszó");
                }

            }
        });
    }
}
