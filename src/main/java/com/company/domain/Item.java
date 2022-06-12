package com.company.domain;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public final class Item implements Serializable {

    @CsvBindByName(column = "Barcode")
    private String barcode;

    @CsvBindByName(column = "Author/Artist")
    private String author;

    @CsvBindByName(column = "Title")
    private String title;

    @CsvBindByName(column = "Year")
    private String year;

    @CsvBindByName(column = "Type")
    private String type;

    @CsvBindByName(column = "ISBN")
    private String ISBN;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "barcode='" + barcode + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", type='" + type + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    public String getBarcode() {
        return barcode;
    }

    public String getType() {
        return type;
    }
}
