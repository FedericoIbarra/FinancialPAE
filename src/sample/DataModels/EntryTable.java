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

    public EntryTable(Entry entry) {

        this.reference = new SimpleStringProperty(entry.getReference());
        this.category = new SimpleIntegerProperty(entry.getCategory());
        this.subcategory = new SimpleIntegerProperty(entry.getSubcategory());
        this.amount = new SimpleFloatProperty(entry.getAmount());
        this.date = new SimpleStringProperty(entry.getDate().toString());

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
