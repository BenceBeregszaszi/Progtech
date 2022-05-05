package Windows;

import Classes.Pizza;
import Classes.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainForm extends JFrame{

    private JButton btn_login;
    private JList pizza_list;
    private JButton btn_register;
    private JPanel main_panel;
    private JLabel logged_in;
    private JButton logoutButton;
    private JButton btn_cart;
    private JButton btn_orders;
    private JButton btn_delivery;
    private JButton btn_toppings;
    private JButton btn_pizzas;
    private Users user;

    private void setEnable(){
        logged_in.setText(this.user.getUsername());
        btn_cart.setVisible(true);
        logoutButton.setVisible(true);
        btn_orders.setVisible(true);
        btn_delivery.setVisible(true);
        btn_toppings.setVisible(true);
        btn_pizzas.setVisible(true);
        btn_login.setVisible(false);
        btn_register.setVisible(false);
    }
    private void setDisabled(){
        btn_cart.setVisible(false);
        logoutButton.setVisible(false);
        btn_orders.setVisible(false);
        btn_delivery.setVisible(false);
        btn_toppings.setVisible(false);
        btn_pizzas.setVisible(false);
        btn_login.setVisible(true);
        btn_register.setVisible(true);
    }


    public MainForm(Users users) {
        this.user = users;
        setTitle("Main");
        setContentPane(main_panel);
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        Pizza[] array = Pizza.GetPizza();
        pizza_list.setModel(new DefaultComboBoxModel(array));
        if (this.user != null){
            setEnable();
        }
        else{
            setDisabled();
        }

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login loginpanel = new Login();
                loginpanel.setVisible(true);
                dispose();
            }
        });
        btn_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register registerpanel = new Register();
                registerpanel.setVisible(true);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDisabled();
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
        MainForm mainForm = new MainForm(null);
    }
}
