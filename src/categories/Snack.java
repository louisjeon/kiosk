package categories;

import menuItems.MenuItem;
import menuItems.SnackItems.Myeongtae;
import menuItems.SnackItems.Nachocheese;
import menuItems.SnackItems.Tteokbokki;

public class Snack extends Category {
    public Snack() {
        this.name = "분식";
        this.items = new MenuItem[]{new Myeongtae(), new Nachocheese(), new Tteokbokki()};
    }
}
