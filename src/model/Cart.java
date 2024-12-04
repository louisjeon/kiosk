package model;

import menuItems.ItemGroup;
import menuItems.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static final ArrayList<ItemGroup> items = new ArrayList<>();
    private static int totalPrice = 0;

    public static void add(MenuItem item, int quantity) {
        items.add(new ItemGroup(item, quantity));
        totalPrice += item.getPrice() * quantity;
    }

    public static void remove(MenuItem item) {
        items.remove(item);
        totalPrice -= item.getPrice();
    }

    public static void clear() {
        items.clear();
        totalPrice = 0;
    }

    public static List<ItemGroup> getItemGroups() {
        return items;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }
}
