package sample.DataModels;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class EntryTable implements Serializable {

    private final SimpleIntegerProperty category;
    private final SimpleIntegerProperty subcategory;
    private final SimpleFloatProperty amount;
    private final SimpleStringProperty date;

    public EntryTable(String reference, int category, int subcategory, float amount, LocalDate date) {

        this.reference = new SimpleStringProperty(reference);
        this.category = new SimpleIntegerProperty(category);
        this.subcategory = new SimpleIntegerProperty(subcategory);
        this.amount = new SimpleFloatProperty(amount);
        this.date = new SimpleStringProperty(date.toString());

    }

    private final SimpleStringProperty reference;

    public SimpleStringProperty referenceProperty() {
        return reference;
    }

    public SimpleIntegerProperty categoryProperty() {
        return category;
    }

    public SimpleIntegerProperty subcategoryProperty() {
        return subcategory;
    }

    public SimpleFloatProperty amountProperty() {
        return amount;
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }





}
