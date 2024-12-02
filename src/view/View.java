import categories.Category;
import menuItems.MenuItem;

import java.util.Iterator;
import java.util.Scanner;
import static java.lang.System.*;

public class KioskView {
    protected static final Scanner scanner = new Scanner(in);
    protected static final String WRONG_CHOICE = "올바르지 못한 선택지입니다.";

    public KioskView() {}

    public static void viewCategory() {
        out.println("소공포차에 오신 것을 환영합니다.");
        out.println("메뉴 카테고리를 선택해주세요.");
        String str = "";
        Category[] categories = Menu.getCategories();
        for (int i = 0; i < categories.length; i++) {
            str += "(" + (i + 1) + ")" + categories[i].getName() + " ";
        }
        str += "(" + categories.length + ") 카트 확인";
        out.println(str);
        int choice = scanner.nextInt();
        if (choice < categories.length) {
            Menu.setCurrentCategory(categories[choice]);
            KioskView.viewItemDetails(KioskView.viewItems());
        } else if (choice == categories.length) {
            viewCart();
        }
    }

    private static MenuItem viewItems() {
        out.println("아이템을 선택해주세요.");
        String str = "";
        MenuItem[] items = Menu.getCurrentItems();
        for (int i = 0; i < items.length; i++) {
            str += "(" + (i + 1) + ")" + items[i].getName() + " ";
        }
        out.println(str);
        return items[scanner.nextInt()];
    }

    private static void viewItemDetails(MenuItem item) {
        out.println(item.getName());
        out.println("가격: " + item.getPrice());
        out.println(item.getDescription());
        out.println("(1)장바구니 담기 (2)장바구니 확인 (3)메인 메뉴로");
        int choice = scanner.nextInt();
        if (choice == 1) {
            Cart.add(item);
        } else if (choice == 2) {
            viewCart(item);
        } else if (choice == 3) {
            KioskView.viewCategory();
        } else {
            out.println(WRONG_CHOICE);
        }
    }

    private static void viewCart() {
        Iterator cartIter = Cart.getItems().listIterator();
        while (cartIter.hasNext()) {
            MenuItem item = (MenuItem) cartIter.next();
            out.println(item.getName() + ": " + item.getPrice() + "원");
        }
        out.println("총 금액: " + Cart.getTotalPrice() + "원");
        out.println("(1)체크 아웃 (2)뒤로 가기");
        int choice = scanner.nextInt();
        if (choice == 1) {
            viewCheckout();
        } else if (choice == 2) {
            viewCategory();
        } else {
            out.println(WRONG_CHOICE);
        }
    }

    private static void viewCart(MenuItem lastViewItem) {
        Iterator cartIter = Cart.getItems().listIterator();
        while (cartIter.hasNext()) {
            MenuItem item = (MenuItem) cartIter.next();
            out.println(item.getName() + ": " + item.getPrice() + "원");
        }
        out.println("총 금액: " + Cart.getTotalPrice() + "원");
        out.println("(1)체크 아웃 (2)뒤로 가기");
        int choice = scanner.nextInt();
        if (choice == 1) {
            viewCheckout();
        } else if (choice == 2) {
            viewItemDetails(lastViewItem);
        } else {
            out.println(WRONG_CHOICE);
        }
    }

    private static void viewCheckout() {

    }
}
