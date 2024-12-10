package model;

import menuItems.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderNumber;
    private final ArrayList<ItemGroup> items = new ArrayList<>();
    private final int totalPrice;

    public Order(List<ItemGroup> items, int price) {
        this.orderNumber = OrderHistory.getOrdersCount() + 1;
        this.items.addAll(items);
        this.totalPrice = price;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<ItemGroup> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
