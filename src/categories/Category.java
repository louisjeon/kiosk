package categories;

import menuItems.MenuItem;

public abstract class Category {
    protected String name;
    protected MenuItem[] items;

    public String getName() {
        return name;
    }

    public MenuItem[] getItems() {
        return items;
    }
}
