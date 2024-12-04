package view;

import menuItems.ItemGroup;
import menuItems.MenuItem;
import model.Cart;

import static java.lang.System.out;

public class CartView extends View {
    private static int getChoice() {
        out.println("<<장바구니>>");
        for (ItemGroup itemGroup : Cart.getItemGroups()) {
            MenuItem item = itemGroup.getItem();
            out.println(item.getName() + " x" + itemGroup.getQuantity() + ": " + item.getPrice() * itemGroup.getQuantity() + "원");
        }
        out.println("총 금액: " + Cart.getTotalPrice() + "원");
        out.println("(1)체크 아웃 (2)뒤로 가기 (3)메인 메뉴");
        return scanner.nextInt();
    }

    static void viewCart() {
        switch (getChoice()) {
            case 1 -> PaymentView.viewCheckout();
            case 2,3 -> OrderView.viewCategory();
            default -> out.println(WRONG_CHOICE);
        }
    }

    static void viewCart(MenuItem lastViewItem) {
        switch (getChoice()) {
            case 1 -> PaymentView.viewCheckout();
            case 2 -> OrderView.viewItemDetails(lastViewItem);
            case 3 -> OrderView.viewCategory();
            default -> out.println(WRONG_CHOICE);
        }
    }
}
