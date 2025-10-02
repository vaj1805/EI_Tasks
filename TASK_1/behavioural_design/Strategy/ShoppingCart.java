package TASK_1.behavioural_design.Strategy;

public class ShoppingCart {
     private PaymentStrategy paymentStrategy;

    // Client can set the strategy
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        System.out.println("Total amount to be paid: " + amount);
        // Delegate the payment to the current strategy
        paymentStrategy.pay(amount);
    }
}
