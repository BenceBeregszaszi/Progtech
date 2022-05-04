package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toppings extends JDialog{
    private JList list1;
    private JTextField tb_price;
    private JTextField tb_name;
    private JButton btn_confirm;
    private JPanel toppings_panel;

    public Toppings() {
        setTitle("Toppings");
        setContentPane(toppings_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
