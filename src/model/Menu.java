package model;

import categories.*;
import menuItems.MenuItem;

public class Menu {
    private static final Category[] categories = new Category[]{new Alcohol(), new Chicken(), new Snack(), new Tang()};
    private static Category currentCategory;

    public static Category[] getCategories() {
        return categories;
    }

    public static void setCurrentCategory(Category category) {
        currentCategory = category;
    }

    public static MenuItem[] getCurrentItems() {
        return currentCategory.getItems();
    }
}