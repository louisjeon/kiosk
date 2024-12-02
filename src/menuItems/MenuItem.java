package menuItems;

public abstract class MenuItem {
    protected String name;
    protected String description;
    protected int price;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
