package factory;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------Factory Pattern demo--------");
        // Create a Word document using its factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.manageDocument();

        System.out.println();

        // Create a PDF document using its factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.manageDocument();
    }
}


