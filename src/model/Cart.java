package model;

import menuItems.ItemGroup;
import menuItems.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static final ArrayList<ItemGroup> items = new ArrayList<>();
    private static int totalPrice = 0;

    private Cart() {}

    public static void add(MenuItem item, int quantity) {
        boolean found = false;
        for (ItemGroup itemGroup : items) {
            if (itemGroup.getItem().equals(item)) {
                itemGroup.setQuantity(itemGroup.getQuantity() + quantity);
                found = true;
                break;
            }
        }
        if (!found) {
            items.add(new ItemGroup(item, quantity));
        }
        totalPrice += item.getPrice() * quantity;
    }

    public static void remove(ItemGroup itemGroup) {
        items.remove(itemGroup);
        totalPrice -= itemGroup.getItem().getPrice();
    }

    public static void clear() {
        OrderHistory.addOrder(new Order(items, totalPrice));
        items.clear();
        totalPrice = 0;
    }

    public static void changeQuantity(ItemGroup itemGroup, int quantity) {
        int index = items.indexOf(itemGroup);
        int beforeQuantity = itemGroup.getQuantity();
        int quantityDiff = quantity - beforeQuantity;
        itemGroup.setQuantity(quantity);
        totalPrice += itemGroup.getItem().getPrice() * quantityDiff;
        items.set(index, itemGroup);
    }

    public static List<ItemGroup> getItemGroups() {
        return items;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }
}
