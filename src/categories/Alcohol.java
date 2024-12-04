package categories;

import menuItems.AlcoholItems.Beer;
import menuItems.AlcoholItems.Makgulli;
import menuItems.AlcoholItems.Soju;
import menuItems.MenuItem;

public class Alcohol extends Category {
    public Alcohol() {
        this.name = "주류";
        this.items = new MenuItem[]{new Beer(), new Makgulli(), new Soju()};
    }
}
