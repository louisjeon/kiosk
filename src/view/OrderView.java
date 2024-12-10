package view;

import categories.Category;
import static java.lang.System.out;

import menuItems.ItemGroup;
import menuItems.MenuItem;
import model.Cart;
import model.Menu;
import model.Order;
import model.OrderHistory;

import java.util.List;

public class OrderView extends View {

    private OrderView() {}

    public static void viewWelcome() throws InterruptedException {
        out.println("소공포차에 오신 것을 환영합니다.");
        viewChooseCategory();
    }

    private static void viewChooseCategory() throws InterruptedException {
        out.println("메뉴 카테고리를 선택해주세요.");
        StringBuilder str = new StringBuilder();
        Category[] categories = Menu.getCategories();
        for (int i = 0; i < categories.length; i++) {
            str.append("(").append(i + 1).append(")").append(categories[i].getName()).append(" ");
        }
        str.append("(").append(categories.length+1).append(")장바구니 확인 ");
        str.append("(").append(categories.length+2).append(")주문내역 확인");
        out.println(str);
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < categories.length) {
            Menu.setCurrentCategory(categories[choice]);
            OrderView.viewItems();
        } else if (choice == categories.length) {
            CartView.viewCart();
        } else if (choice == categories.length + 1) {
            OrderView.viewOrderHistory();
        } else {
            out.println(WRONG_CHOICE);
            viewChooseCategory();
        }
    }

    private static void viewItems() throws InterruptedException {
        out.println("아이템을 선택해주세요.");
        StringBuilder str = new StringBuilder();
        MenuItem[] items = Menu.getCurrentItems();
        for (int i = 0; i < items.length; i++) {
            str.append("(").append(i + 1).append(")").append(items[i].getName()).append(" ");
        }
        str.append("(").append(items.length+1).append(")").append("뒤로 가기");
        out.println(str);
        MenuItem selectedItem = items[scanner.nextInt() - 1];
        viewItemDetails(selectedItem);
    }

    private static void viewAfterAddToCart(MenuItem item) throws InterruptedException {
        out.println("(1)장바구니 확인 (2)더 담기 (3)메인 메뉴로");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> CartView.viewCart();
            case 2 -> viewAddToCart(item);
            case 3 -> OrderView.viewWelcome();
            default -> out.println(WRONG_CHOICE);
        }
    }

    private static void viewAddToCart(MenuItem item) throws InterruptedException {
        out.println("장바구니에 담을 개수를 입력해주세요.");
        int quantity = scanner.nextInt();
        if (quantity <= 0) {
            out.println(WRONG_CHOICE);
            viewAddToCart(item);
        } else {
            Cart.add(item, quantity);
            out.println("장바구니에 담겼습니다.");
            viewAfterAddToCart(item);
        }}

    public static void viewItemDetails(MenuItem item) throws InterruptedException {
        out.println(item.getName());
        out.println("가격: " + item.getPrice());
        out.println(item.getDescription());
        out.println("(1)장바구니 담기 (2)장바구니 확인 (3)메인 메뉴로");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> viewAddToCart(item);
            case 2 -> CartView.viewCart(item);
            case 3 -> OrderView.viewWelcome();
            default -> out.println(WRONG_CHOICE);
        }
    }

    public static void viewOrderHistory() throws InterruptedException {
        out.println("<<주문 내역>>");
        StringBuilder str = new StringBuilder();
        List<Order> orderHistory = OrderHistory.getOrders();
        if (orderHistory.isEmpty()) {
            str.append("주문 내역이 비어있습니다.");
        } else {
            for (Order order : orderHistory) {
                str.append("[주문 번호 ").append(order.getOrderNumber()).append("]");
                List<ItemGroup> itemGroupList = order.getItems();
                for (ItemGroup itemGroup: itemGroupList) {
                    MenuItem item = itemGroup.getItem();
                    str.append("\n").append(item.getName()).append(" x").append(itemGroup.getQuantity()).append(" = ").append(item.getPrice() * itemGroup.getQuantity()).append("원");
                }
                str.append("\n총 금액: ").append(order.getTotalPrice()).append("원");
            }
        }
        out.println(str);
        out.println("(1) 뒤로 가기 (2) 장바구니");
        int choice = scanner.nextInt() - 1;
        if (choice == 0) {
            viewWelcome();
        } else if (choice == 1) {
            CartView.viewCart();
        }
    }
}
