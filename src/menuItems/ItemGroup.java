package menuItems;

public class ItemGroup {
    private MenuItem item;
    private int quantity;

    public ItemGroup(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
