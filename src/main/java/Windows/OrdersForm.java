package Windows;

import Classes.Orders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdersForm  extends JDialog{
    private JList list1;
    private JButton btn_delete;
    private JButton btn_cancel;
    private JPanel orders_panel;

    public OrdersForm() {
        setTitle("");
        setContentPane(orders_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Orders[] orders_list = Orders.Read();
        list1.setModel(new DefaultComboBoxModel(orders_list));
        setLocationRelativeTo(null);
        setVisible(true);
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String order = list1.getSelectedValue().toString();
                String id = order.split(" ")[0];
                int orderd_id = Integer.parseInt(id);
                Orders.Delete(orderd_id);
                Orders[] orders_list = Orders.Read();
                list1.setModel(new DefaultComboBoxModel(orders_list));
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
