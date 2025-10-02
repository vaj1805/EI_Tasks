package TASK_1.structural_design.Decorator;

// File: SugarDecorator.java (Concrete Decorator)
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with sugar";
    }
}
