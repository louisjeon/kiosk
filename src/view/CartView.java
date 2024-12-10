package view;

import menuItems.ItemGroup;
import menuItems.MenuItem;
import model.Cart;

import java.util.List;

import static java.lang.System.out;

public class CartView extends View {
    private static int getChoice() {
        out.println("<<장바구니>>");
        for (ItemGroup itemGroup : Cart.getItemGroups()) {
            MenuItem item = itemGroup.getItem();
            out.println(item.getName() + " x" + itemGroup.getQuantity() + ": " + item.getPrice() * itemGroup.getQuantity() + "원");
        }
        out.println("총 금액: " + Cart.getTotalPrice() + "원");
        out.println("(1)수량 변경 (2)체크 아웃 (3)뒤로 가기 (4)메인 메뉴");
        return scanner.nextInt();
    }

    private static void selectChangeQuantity(List<ItemGroup> itemGroupList, int choice) throws InterruptedException {
        ItemGroup itemGroup = itemGroupList.get(choice);
        out.println("[수량 변경 아이템]");
        out.println(itemGroup.getItem().getName() + " x" + itemGroup.getQuantity() + ": " + itemGroup.getItem().getPrice() * itemGroup.getQuantity() + "원");
        out.println("변경할 수량을 입력해주세요.");
        int quantity = scanner.nextInt();
        if (quantity >= 0) {
            if (quantity == 0) {
                Cart.remove(itemGroup);
            } else {
                Cart.changeQuantity(itemGroup, quantity);
            }
            out.println("수량이 변경되었습니다.");
            out.println("(1)카트 확인 (2)메인 메뉴");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> viewCart();
                case 2 -> OrderView.viewWelcome();
                default -> out.println(WRONG_CHOICE);
            }
        } else {
            out.println(WRONG_CHOICE);
            selectChangeQuantity(itemGroupList, choice);
        }
    }

    private static void selectChangeQuantityItem() throws InterruptedException {
        if (Cart.getItemGroups().isEmpty()) {
            out.println("장바구니가 비어있습니다.");
            viewCart();
        } else {
            out.println("수량 변경 아이템 선택");
            List<ItemGroup> itemGroupList = Cart.getItemGroups();
            for (int i = 0; i < itemGroupList.size(); i++) {
                MenuItem item = itemGroupList.get(i).getItem();
                out.println("(" + (i + 1) + ")" + item.getName() + " x" + itemGroupList.get(i).getQuantity());
            }
            int choice = scanner.nextInt() - 1;
            if (choice < 0 || choice >= itemGroupList.size()) {
                out.println(WRONG_CHOICE);
                selectChangeQuantityItem();
            } else {
                selectChangeQuantity(itemGroupList, choice);
            }
        }
    }

    public static void viewCart() throws InterruptedException {
        switch (getChoice()) {
            case 1 -> selectChangeQuantityItem();
            case 2 -> {
                if (Cart.getItemGroups().isEmpty()) {
                    out.println("장바구니가 비어있습니다.");
                    viewCart();
                } else {
                    PaymentView.viewCheckout();
                }
            }
            case 3,4 -> OrderView.viewWelcome();
            default -> out.println(WRONG_CHOICE);
        }
    }

    public static void viewCart(MenuItem lastViewItem) throws InterruptedException {
        if (getChoice() == 3) {
            OrderView.viewItemDetails(lastViewItem);
        } else {
            viewCart();
        }
    }
}
