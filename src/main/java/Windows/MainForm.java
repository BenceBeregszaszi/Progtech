package Windows;

import Classes.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{

    private JButton btn_login;
    private JList pizza_list;
    private JButton btn_register;
    private JPanel main_panel;
    public JLabel logged_in;
    private JButton logoutButton;
    private JButton btn_cart;
    private JButton btn_orders;
    private JButton btn_delivery;
    private JButton btn_toppings;
    private JButton btn_pizzas;
    private static Users user;

    public static void setUser(Users tempuser){
        user=tempuser;
    }


    public MainForm() {
        setTitle("Main");
        setContentPane(main_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login loginpanel = new Login();
                loginpanel.setVisible(true);
            }
        });
        btn_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register registerpanel = new Register();
                registerpanel.setVisible(true);
                logged_in.setText(user.getUsername());
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = null;
                logged_in.setText("");
            }
        });
        btn_cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartForm cart = new CartForm();
                cart.setVisible(true);
            }
        });
        btn_orders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdersForm orders = new OrdersForm();
                orders.setVisible(true);
            }
        });
        btn_delivery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delivery delivery = new Delivery();
                delivery.setVisible(true);
            }
        });
        btn_toppings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toppings toppings = new Toppings();
                toppings.setVisible(true);
            }
        });
        btn_pizzas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizzas pizzas = new Pizzas();
                pizzas.setVisible(true);
            }
        });
    }
    

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
    }
}
