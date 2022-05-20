package Windows;

import Classes.Pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pizzas extends JDialog{
    private JList list1;
    private JButton btn_confirm;
    private JTextField tb_name;
    private JTextField tb_price;
    private JTextField tb_diameter;
    private JPanel pizzas_panel;

    public Pizzas() {
        setTitle("");
        setContentPane(pizzas_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Pizza[] pizza_array = Pizza.GetPizza();
        list1.setModel(new DefaultComboBoxModel(pizza_array));
        setLocationRelativeTo(null);
        setVisible(true);
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza.AddPizza(tb_name.getText(), Integer.parseInt(tb_price.getText()), Integer.parseInt(tb_diameter.getText()));
            }
        });
    }
}
