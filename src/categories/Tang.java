package categories;

import menuItems.MenuItem;
import menuItems.TangItems.Amooktang;
import menuItems.TangItems.Bajiraktang;
import menuItems.TangItems.Budaechigae;

public class Tang extends Category {
    public Tang() {
        this.name = "탕";
        this.items = new MenuItem[]{new Amooktang(), new Bajiraktang(), new Budaechigae()};
    }
}
