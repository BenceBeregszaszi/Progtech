package Windows;

import Abstract.Decorator;
import Classes.Pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CartForm extends JDialog{
    private JButton btn_cancel;
    private JButton btn_confirm;
    private JButton btn_delete;
    private JPanel cart_panel;
    private JTextField tb_ordered_pizza;

    public CartForm(Decorator pizza) {
        setTitle("Cart");
        setContentPane(cart_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        tb_ordered_pizza.setText(pizza.toString());
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //decorators.remove();
            }
        });
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
