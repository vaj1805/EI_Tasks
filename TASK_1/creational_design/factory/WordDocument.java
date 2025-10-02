package factory;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Word document opening.....");
    }
    public void save() {
        System.out.println("Saving Word document....");
    }
}
