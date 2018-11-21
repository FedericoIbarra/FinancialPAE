package sample.DataModels;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import sample.I18N;
import java.io.Serializable;
import java.util.ResourceBundle;

public class EntryTable implements Serializable {

    private final SimpleStringProperty reference;
    private final SimpleStringProperty category;
    private final SimpleStringProperty subcategory;
    private final SimpleFloatProperty amount;
    private final SimpleStringProperty date;

    private ResourceBundle currentRB;

    /**
     * Constructor for EntryTable class.
     * @param entry converts from Entry to EntryTable.
     */
    public EntryTable(Entry entry) {

        currentRB = I18N.getInstance().getResources();

        this.reference = new SimpleStringProperty(entry.getReference());
        

        if(entry.getCategory() == 0) {
            category = new SimpleStringProperty(currentRB.getString("act"));

            if (entry.getSubcategory() == 0) subcategory = new SimpleStringProperty(currentRB.getString("cash"));
            else if (entry.getSubcategory() == 1) subcategory = new SimpleStringProperty(currentRB.getString("tempinv"));
            else if (entry.getSubcategory() == 2) subcategory = new SimpleStringProperty(currentRB.getString("ee"));
            else if (entry.getSubcategory() == 3) subcategory = new SimpleStringProperty(currentRB.getString("inv"));
            else if (entry.getSubcategory() == 4) subcategory = new SimpleStringProperty(currentRB.getString("other"));
            else subcategory = null;

        } else if (entry.getCategory() == 1) {
            category = new SimpleStringProperty(currentRB.getString("pas"));

            if (entry.getSubcategory() == 0) subcategory = new SimpleStringProperty(currentRB.getString("debtcp"));
            else if (entry.getSubcategory() == 1) subcategory = new SimpleStringProperty(currentRB.getString("debtlp"));
            else if (entry.getSubcategory() == 2) subcategory = new SimpleStringProperty(currentRB.getString("provider"));
            else if (entry.getSubcategory() == 3) subcategory = new SimpleStringProperty(currentRB.getString("rpb"));
            else if (entry.getSubcategory() == 4) subcategory = new SimpleStringProperty(currentRB.getString("other"));
            else subcategory = null;

        } else if (entry.getCategory() == 2) {
            category = new SimpleStringProperty(currentRB.getString("patr"));

            if (entry.getSubcategory() == 0) subcategory = new SimpleStringProperty(currentRB.getString("captsoc"));
            else if (entry.getSubcategory() == 1) subcategory = new SimpleStringProperty(currentRB.getString("reserv"));
            else if (entry.getSubcategory() == 2) subcategory = new SimpleStringProperty(currentRB.getString("util"));
            else subcategory = null;
        } else {
            category = null;
            subcategory = null;
        }

        this.amount = new SimpleFloatProperty(entry.getAmount());
        this.date = new SimpleStringProperty(entry.getDate().toString());

    }


    /**
     * Getters and Setters.
     */

    public SimpleStringProperty referenceProperty() {
        return reference;
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public SimpleStringProperty subcategoryProperty() {
        return subcategory;
    }

    public SimpleFloatProperty amountProperty() {
        return amount;
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }





}
