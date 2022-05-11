package Windows;

import Classes.Deliveries;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delivery extends JDialog{
    private JList list1;
    private JButton btn_confirm;
    private JTextField tb_location;
    private JTextField tb_name;
    private JPanel delivery_panel;
    private JButton btn_delete;

    public Delivery() {
        setTitle("Delivery");
        setContentPane(delivery_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Deliveries[] deliveries_list = Deliveries.Read();
        list1.setModel(new DefaultComboBoxModel(deliveries_list));
        setVisible(true);
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deliveries.Create(tb_location.getText(), tb_name.getText());
                repaint();
            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String splitname = tb_name.getText();
                String name = splitname.split("-")[1];
                Deliveries.Delete(name);
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tb_name.setText(list1.getSelectedValue().toString());
            }
        });
    }
}
