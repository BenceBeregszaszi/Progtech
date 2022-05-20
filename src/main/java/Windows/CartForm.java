package Windows;

import Abstract.Decorator;
import Classes.*;
import Classes.Observers.OrdersObserver;
import Interfaces.Observer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        setTitle("");
        setContentPane(cart_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Deliveries[] deliveries_list = Deliveries.Read();
        list2.setModel(new DefaultComboBoxModel(deliveries_list));
        list1.setModel(new DefaultComboBoxModel(pizza.toArray()));
        setLocationRelativeTo(null);
        setVisible(true);
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decorator = pizza.get(list1.getSelectedIndex());
                decorator.Add(new OrdersObserver(decorator, user, list2.getSelectedValue().toString().split(" ")[0]));
                try {
                    decorator.Notify();
                    pizza.remove(list1.getSelectedIndex());
                    list1.setModel(new DefaultComboBoxModel(pizza.toArray()));
                } catch (Exception ex) {
                    LoggerClass.ExceptionLog(ex.getMessage());
                }
            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pizza.remove(list1.getSelectedIndex());
                list1.setModel(new DefaultComboBoxModel(pizza.toArray()));
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
