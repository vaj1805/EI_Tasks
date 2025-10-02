package TASK_1.behavioural_design.Strategy;

public class Main {
     public static void main(String[] args) {
        System.out.println("--- Strategy Pattern Demo ---");
        ShoppingCart cart = new ShoppingCart();

        // Pay with Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(150);

        System.out.println();

        // Change strategy and pay with PayPal
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(220);
    }
}
