package model;

import menuItems.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private static final ArrayList<Order> history = new ArrayList<>();

    private OrderHistory() {}

    public static void addOrder(Order order) {
        history.add(order);
    }

    public static List<Order> getOrders() {
        return history;
    }

    public static int getOrdersCount() {
        return history.size();
    }
}
