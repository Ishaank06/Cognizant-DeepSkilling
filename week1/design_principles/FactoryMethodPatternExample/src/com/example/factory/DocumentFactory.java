package com.example.factory;

public abstract class DocumentFactory {
    public abstract Document createDocument();

    public Document buildDocument() {
        System.out.println("\nInitializing Document creation workflow...");
        Document doc = createDocument();
        doc.open();
        return doc;
    }
}
