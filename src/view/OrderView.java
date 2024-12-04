package view;

import categories.Category;
import static java.lang.System.out;
import menuItems.MenuItem;
import model.Cart;
import model.Menu;

public class OrderView extends View {

    private OrderView() {}

    public static void viewCategory() {
        out.println("소공포차에 오신 것을 환영합니다.");
        out.println("메뉴 카테고리를 선택해주세요.");
        StringBuilder str = new StringBuilder();
        Category[] categories = Menu.getCategories();
        for (int i = 0; i < categories.length; i++) {
            str.append("(").append(i + 1).append(")").append(categories[i].getName()).append(" ");
        }
        str.append("(").append(categories.length).append(") 카트 확인");
        out.println(str);
        int choice = scanner.nextInt() - 1;
        if (choice < categories.length) {
            Menu.setCurrentCategory(categories[choice]);
            OrderView.viewItemDetails(OrderView.viewItems());
        } else if (choice == categories.length) {
            CartView.viewCart();
        }
    }

    private static MenuItem viewItems() {
        out.println("아이템을 선택해주세요.");
        StringBuilder str = new StringBuilder();
        MenuItem[] items = Menu.getCurrentItems();
        for (int i = 0; i < items.length; i++) {
            str.append("(").append(i + 1).append(")").append(items[i].getName()).append(" ");
        }
        str.append("(").append(items.length).append(")").append("뒤로 가기");
        out.println(str);
        return items[scanner.nextInt()];
    }

    static void viewItemDetails(MenuItem item) {
        out.println(item.getName());
        out.println("가격: " + item.getPrice());
        out.println(item.getDescription());
        out.println("(1)장바구니 담기 (2)장바구니 확인 (3)메인 메뉴로");
        int choice = scanner.nextInt() - 1;
        switch (choice) {
            case 1 -> Cart.add(item);
            case 2 -> CartView.viewCart(item);
            case 3 -> OrderView.viewCategory();
            default -> out.println(WRONG_CHOICE);
        }
    }
}
