package view;

import menuItems.MenuItem;
import model.Cart;

import static java.lang.System.out;

public class CartView extends View{
    static void viewCart() {
        for (MenuItem item : Cart.getItems()) {
            out.println(item.getName() + ": " + item.getPrice() + "원");
        }
        out.println("총 금액: " + Cart.getTotalPrice() + "원");
        out.println("(1)체크 아웃 (2)뒤로 가기");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> PaymentView.viewCheckout();
            case 2 -> OrderView.viewCategory();
            default -> out.println(WRONG_CHOICE);
        }
    }

    static void viewCart(MenuItem lastViewItem) {
        for (MenuItem item : Cart.getItems()) {
            out.println(item.getName() + ": " + item.getPrice() + "원");
        }
        out.println("총 금액: " + Cart.getTotalPrice() + "원");
        out.println("(1)체크 아웃 (2)뒤로 가기");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> PaymentView.viewCheckout();
            case 2 -> OrderView.viewItemDetails(lastViewItem);
            default -> out.println(WRONG_CHOICE);
        }
    }
}
