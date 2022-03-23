package com.company;

import com.opencsv.bean.CsvBindByName;

public class Item {
    @CsvBindByName(column = "Barcode")
    private String barcode;

    @CsvBindByName(column = "Author/Artist")
    private String author;

    @CsvBindByName(column = "Title")
    private String title;

    @CsvBindByName(column = "Year")
    private String year;

    @CsvBindByName(column = "ISBN")
    private String ISBN;

    @Override
    public String toString() {
        return "Item{" +
                "barcode='" + barcode + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
