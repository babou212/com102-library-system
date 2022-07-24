package com.company.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@Data
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
}
