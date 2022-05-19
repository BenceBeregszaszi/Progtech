package Windows;

import Abstract.Decorator;
import Classes.Deliveries;
import Classes.LoggerClass;
import Classes.Observers.OrdersObserver;
import Classes.Pizza;
import Classes.Users;
import Interfaces.Observer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartForm extends JDialog{
    private JButton btn_cancel;
    private JButton btn_confirm;
    private JButton btn_delete;
    private JPanel cart_panel;
    private JList list1;
    private JList list2;
    private JTextField tb_ordered_pizza;

    private Decorator decorator;



    public CartForm(List<Decorator> pizza, String user) {
        setTitle("Cart");
        setContentPane(cart_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Deliveries[] deliveries_list = Deliveries.Read();
        list2.setModel(new DefaultComboBoxModel(deliveries_list));
        list1.setModel(new DefaultComboBoxModel(pizza.toArray()));
        setVisible(true);
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decorator = pizza.get(list1.getSelectedIndex());
                decorator.Add(new OrdersObserver(decorator, user, list2.getSelectedValue().toString().split(" ")[0]));
                try {
                    decorator.Notify();
                } catch (Exception ex) {
                    LoggerClass.ExceptionLog(ex.getMessage());
                }
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
