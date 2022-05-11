package Windows;

import Classes.Deliveries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delivery extends JDialog{
    private JList list1;
    private JButton btn_confirm;
    private JTextField tb_location;
    private JTextField tb_name;
    private JPanel delivery_panel;
    
    public Delivery() {
        setTitle("Delivery");
        setContentPane(delivery_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Deliveries[] deliveries_list = Deliveries.GetDeliveries();
        list1.setModel(new DefaultComboBoxModel(deliveries_list));
        setVisible(true);
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deliveries.Create(tb_location.getText(), tb_name.getText());
            }
        });
    }
}
