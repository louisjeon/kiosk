package model;

import menuItems.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static ArrayList<MenuItem> items;
    private static int totalPrice = 0;

    public static void add(MenuItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public static void remove(MenuItem item) {
        items.remove(item);
        totalPrice -= item.getPrice();
    }

    public static void clear() {
        items.clear();
        totalPrice = 0;
    }

    public static List<MenuItem> getItems() {
        return items;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }
}
