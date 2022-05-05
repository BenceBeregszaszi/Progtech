package Windows;

import Classes.Toppings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToppingsForm extends JDialog{
    private JList list1;
    private JTextField tb_price;
    private JTextField tb_name;
    private JButton btn_confirm;
    private JPanel toppings_panel;

    public ToppingsForm() {
        setTitle("Toppings");
        setContentPane(toppings_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toppings.Create(tb_name.getText(), Integer.parseInt(tb_price.getText()));
            }
        });
    }
}
