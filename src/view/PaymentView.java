package view;

import model.Cart;
import model.Payment;
import paymentMethods.PaymentMethod;

import static java.lang.System.out;

public class PaymentView extends View {
    public static void viewCheckout() throws InterruptedException {
        out.println("결제 수단을 선택해주세요.");
        StringBuilder str = new StringBuilder();
        PaymentMethod[] paymentMethods = Payment.getPaymentMethods();
        for (int i = 0; i < paymentMethods.length; i++) {
            str.append("(").append(i + 1).append(")").append(paymentMethods[i].getName()).append(" ");
        }
        str.append("(").append(paymentMethods.length+1).append(")뒤로 가기");
        out.println(str);
        int choice = scanner.nextInt() - 1;
        if (choice < paymentMethods.length) {
            Payment.setCurrentPaymentMethod(paymentMethods[choice]);
            PaymentView.viewPayment();
        } else if (choice == paymentMethods.length) {
            CartView.viewCart();
        }
    }

    private static void viewPayment() throws InterruptedException {
        PaymentMethod paymentMethod = Payment.getCurrentPaymentMethod();
        out.println(paymentMethod.getName() + "로 결제합니다.");
        out.println("(1)확인 (2)뒤로 가기");
        int choice = scanner.nextInt() - 1;
        if (choice == 0) {
            out.println(paymentMethod +"로 결제중...");
            Thread.sleep(3000);
            out.println(paymentMethod+"로 결제를 완료하였습니다.");
            Cart.clear();
            OrderView.viewWelcome();
        } else if (choice == 1) {
            viewCheckout();
        }
    }
}
