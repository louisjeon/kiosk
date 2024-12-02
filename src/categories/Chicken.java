package categories;

import menuItems.ChickenItems.CheongYangMayo;
import menuItems.ChickenItems.Fried;
import menuItems.ChickenItems.Rose;
import menuItems.MenuItem;

public class Chicken extends Category {
    public Chicken() {
        this.name = "치킨";
        this.items = new MenuItem[]{new CheongYangMayo(), new Fried(), new Rose()};
    }
}
