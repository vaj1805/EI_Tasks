package TASK_1.structural_design.Decorator;

// File: SimpleCoffee.java (Concrete Component)
public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() { return 5.0; }
    @Override
    public String getDescription() { return "Simple coffee"; }
}