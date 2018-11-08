package sample.DataModels;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class Entry implements Serializable {

    private final String reference;
    private final Integer category;
    private final Integer subcategory;
    private final Float amount;
    private final LocalDate date;

    public Entry(String reference, int category, int subcategory, float amount, LocalDate date) {

        this.reference = reference;
        this.category = category;
        this.subcategory = subcategory;
        this.amount = amount;
        this.date = date;

    }

    public String getReference() {
        return reference;
    }

    public int getCategory() {
        return category;
    }

    public int getSubcategory() {
        return subcategory;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDate getDate(){
        return date;
    }

}
