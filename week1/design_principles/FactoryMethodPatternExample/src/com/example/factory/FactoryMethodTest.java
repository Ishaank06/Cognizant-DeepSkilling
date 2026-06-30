package com.example.factory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Factory Method Design Pattern ===");

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.buildDocument();
        wordDoc.save();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.buildDocument();
        pdfDoc.save();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.buildDocument();
        excelDoc.save();
        excelDoc.close();

        System.out.println("\n=== Factory Method Pattern Verification Complete ===");
    }
}
