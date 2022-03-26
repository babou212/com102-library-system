package com.company;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

/**
 // * Java beans data class for serialization and deserialization
 // * Author Dylan Cree
 */

public class Item implements Serializable {
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

    public Item() {
    }

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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
