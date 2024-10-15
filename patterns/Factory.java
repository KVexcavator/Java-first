package patterns;

interface Document { void print(); }

class  PDFDocument implements Document {
  public void print(){ System.out.println("Печать PDF"); }  
}

class  WordDocument implements Document {
  public void print(){ System.out.println("Печать Word"); }  
}

abstract class DocumentFactory {
  public abstract Document createDocument();
}

class PDFDocumentFactory extends DocumentFactory {
  public Document createDocument(){
    return new PDFDocument();
  }  
}

class WordDocumentFactory extends DocumentFactory {
  public Document createDocument(){
    return new WordDocument();
  }  
}

public class Factory {
  public static void main(String[] args) {
    DocumentFactory factory = new PDFDocumentFactory();
    Document doc = factory.createDocument();
    doc.print();

    factory = new WordDocumentFactory();
    doc = factory.createDocument();
    doc.print();
  }
}