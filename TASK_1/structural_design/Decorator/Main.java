package TASK_1.structural_design.Decorator;

// File: Main.java (Driver class)
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Decorator Pattern Demo ---");
        Coffee myCoffee = new SimpleCoffee();
        System.out.println(myCoffee.getDescription() + " costs $" + myCoffee.getCost());

        // Now, let's decorate it
        myCoffee = new MilkDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " costs $" + myCoffee.getCost());

        // Decorate it again!
        myCoffee = new SugarDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " costs $" + myCoffee.getCost());
    }
}