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
        exceptionLogger.error(exceptionMessage);
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

    public static void CreateToppingsLog(String name, int price) {
        toppingsLogger.info("New topping with" + name + price + "Ft");
        System.out.println("New topping with" + name + price + "Ft");
    }

    public static void LoginLog(String name){
        usersLogger.info("User " + name + " logged in");
        System.out.println("User " + name + " logged in");
    }

    public static void RegisterLog(String name){
        usersLogger.info("New user " + name);
        System.out.println("New user " + name);
    }

    public static void LogoutLog(String name){
        usersLogger.info("User " + name + " logged out");
        System.out.println("User " + name + " logged out");
    }
}
