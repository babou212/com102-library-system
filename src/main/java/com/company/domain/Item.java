package com.company.domain;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

/**
 // * Java beans data class for serialization and deserialization
 // * Author Dylan Cree
 */

public class Item implements Serializable { // Serializable interface for java beans class

    @CsvBindByName(column = "Barcode") // @CsvBindByName openCSV command
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

    public Item() {   // No args constructor for java beans class
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
