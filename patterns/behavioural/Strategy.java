package patterns.behavioural;

/*
 * Strategy: lets you selecting an algorithm's behaviour at runtime.
 */

interface PaymentStrategy {
    public void pay();
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("payment from credit card");
    }
}

class NetBankingPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("payment from net banking");
    }
}

class UPIPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("payment from UPI");
    }
}

class Cart {
    void checkout(PaymentStrategy payment) {
        payment.pay();
    }
}

class ClientStrategy {
    public static void main(String[] args) {
        PaymentStrategy paymentStrategy = new NetBankingPayment();

        Cart cart = new Cart();
        cart.checkout(paymentStrategy);
    }
}