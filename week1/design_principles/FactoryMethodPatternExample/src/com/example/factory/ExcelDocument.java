package com.example.factory;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Spreadsheet (.xlsx)...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel Spreadsheet (writing workbook cells)...");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Spreadsheet.");
    }
}
