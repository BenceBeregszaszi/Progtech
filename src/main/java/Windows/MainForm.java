package Windows;

import Abstract.Decorator;
import Classes.Decorators.*;
import Classes.LoggerClass;
import Classes.Pizza;
import Classes.Users;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private JTextField tb_selected_pizza;
    private JButton btn_rendel;
    private JButton cornButton;
    private JButton hamButton;
    private JButton mushroomButton;
    private JButton pepperoniButton;
    private JButton btn_salami;

    private Users user;
    static private Decorator pizza;
    private List<Decorator> temp;

    private Pizza addDecorator(String order){
        int id = Integer.parseInt(order.split(" ")[0]);
        String name = order.split(" ")[1] + " " + order.split(" ")[2];
        int price = Integer.parseInt(order.split(" ")[3]);
        int diameter = Integer.parseInt(order.split(" ")[5]);
        Pizza p = new Pizza(id, name, price, diameter);
        return p;
    }

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
        temp = new ArrayList<>();
        setMinimumSize(new Dimension(1024, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Pizza[] pizza_array = Pizza.GetPizza();
        pizza_list.setModel(new DefaultComboBoxModel(pizza_array));
        setLocationRelativeTo(null);
        setVisible(true);
        if (this.user != null && user.getPosition_id() == 1){
            setEnable();
        }
        else if (this.user != null && user.getPosition_id() == 2){
            setDisabled();
            btn_orders.setVisible(true);
            btn_cart.setVisible(true);
            btn_login.setVisible(false);
            btn_register.setVisible(false);
            logoutButton.setVisible(true);
        }
        else setDisabled();

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
                dispose();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoggerClass.LogoutLog(user.getUsername());
                setDisabled();
                user = null;
                logged_in.setText("");
            }
        });
        btn_cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartForm cart = new CartForm(temp,user.getUsername());
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
                ToppingsForm toppings = new ToppingsForm();
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
        pizza_list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tb_selected_pizza.setText(pizza_list.getSelectedValue().toString());
            }
        });
        btn_salami.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza t = addDecorator(tb_selected_pizza.getText());
                pizza = new Salami(t);
                pizza.pizza_number = t.getNumber();
                pizza.topping = 3;
                temp.add(pizza);
                tb_selected_pizza.setText(pizza.toString());
            }
        });
        pepperoniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza t = addDecorator(tb_selected_pizza.getText());
                pizza = new Pepperoni(t);
                pizza.pizza_number = t.getNumber();
                pizza.topping = 2;
                temp.add(pizza);
                tb_selected_pizza.setText(pizza.toString());
            }
        });
        mushroomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza t = addDecorator(tb_selected_pizza.getText());
                pizza = new Mushroom(t);
                pizza.pizza_number = t.getNumber();
                pizza.topping = 5;
                temp.add(pizza);
                tb_selected_pizza.setText(pizza.toString());
            }
        });
        hamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza t = addDecorator(tb_selected_pizza.getText());
                pizza = new Ham(t);
                pizza.pizza_number = t.getNumber();
                pizza.topping = 1;
                temp.add(pizza);
                tb_selected_pizza.setText(pizza.toString());
            }
        });
        cornButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza t = addDecorator(tb_selected_pizza.getText());
                pizza = new Corn(t);
                pizza.pizza_number = t.getNumber();
                pizza.topping = 4;
                temp.add(pizza);
                tb_selected_pizza.setText(pizza.toString());
            }
        });
        btn_rendel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pizza != null && user != null) {
                    CartForm cart = new CartForm(temp,user.getUsername());
                    cart.setVisible(true);
                }else if (pizza != null && user == null){
                    user = new Users();
                    user.setUsername("user");
                    CartForm cart = new CartForm(temp,user.getUsername());
                    cart.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(main_panel,"Nem válaztottál ki pizzát!");
                }
            }
        });
    }




    public static void main(String[] args) {
        MainForm mainForm = new MainForm(null);
    }
}
