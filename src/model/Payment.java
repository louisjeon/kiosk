package model;

import paymentMethods.*;

public class Payment {
    private static final PaymentMethod[] paymentMethods = new PaymentMethod[]{new CreditCard(), new KakaoPay(), new Payco(), new TossPay()};
    private static PaymentMethod currentPaymentMethod;

    private Payment() {}

    public static PaymentMethod[] getPaymentMethods() {
        return paymentMethods;
    }

    public static void setCurrentPaymentMethod(PaymentMethod paymentMethod) {
        currentPaymentMethod = paymentMethod;
    }

    public static PaymentMethod getCurrentPaymentMethod() {
        return currentPaymentMethod;
    }
}
