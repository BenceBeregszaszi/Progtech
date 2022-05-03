package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JDialog{

    private JTextField textField1;
    private JTextField textField2;
    private JButton registerButton;
    private JButton cancelButton;
    private JPanel RegisterPanel;

    public Register(){
        setTitle("Registration");
        setContentPane(RegisterPanel);
        setMinimumSize(new Dimension(800,500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
