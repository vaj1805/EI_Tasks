package factory;

public abstract class DocumentFactory {
    //Factory method.
    public abstract Document createDocument();

    public void manageDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
    }

}
