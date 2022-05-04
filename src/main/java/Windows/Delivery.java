package Windows;

import Classes.Deliveries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delivery {
    private JList list1;
    private JButton btn_confirm;
    private JTextField tb_location;
    private JTextField tb_name;
    
    public Delivery() {
        setTitle("Delivery");
        setContentPane(delivery_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deliveries.Create(tb_location.getText(), tb_name.getText());
            }
        });
    }
}
