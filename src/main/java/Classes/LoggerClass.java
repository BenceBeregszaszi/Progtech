package Classes;

import org.apache.log4j.Logger;

public class LoggerClass {
    private static Logger deliveryLogger = Logger.getLogger(Deliveries.class);
    private static Logger ordersLogger = Logger.getLogger(Orders.class);
    private static Logger pizzaLogger = Logger.getLogger(Pizza.class);
    private static Logger toppingsLogger = Logger.getLogger(Toppings.class);
    private static Logger usersLogger = Logger.getLogger(Users.class);
    private static Logger exceptionLogger = Logger.getLogger(Exception.class);

    public static void DeliveriesCreateLog(String location, String name) {
        deliveryLogger.info(String.format("Delivery created with %s location and %s name",location, name ));
        System.out.println(location + " city" + name + " company");
    }

    public static void DeliveriesDeleteLog(String name) {
        deliveryLogger.info(String.format("Delivery deleted with %s name", name));
        System.out.println(name + " company deleted");
    }

    public static void ExceptionLog(String exceptionMessage) {
        exceptionLogger.info(exceptionMessage);
        System.out.println(exceptionMessage);
    }

    public static void OrdersAddLog(){
        ordersLogger.info("New order");
        System.out.println("New order with");
    }

    public static void OrdersDeleteLog() {
        ordersLogger.info("Order deleted");
        System.out.println("Order with");
    }

    public static void PizzaCreateLog(String name, int price, int diameter) {
        pizzaLogger.info("New pizza created with " + name + price + "Ft" + diameter + "cm");
        System.out.println("New pizza created with " + name + price + "Ft" + diameter + "cm");
    }

    public static void CreateToppingsLog() {
        toppingsLogger.info("New topping");
        System.out.println("New toppings with");
    }

    public static void LoginLog(){
        usersLogger.info("User logged in");
        System.out.println("User logged in");
    }

    public static void RegisterLog(){
        usersLogger.info("User registered");
        System.out.println("User registered");
    }

    public static void LogoutLog(){
        usersLogger.info("User logged out");
        System.out.println("User logged out");
    }
}
