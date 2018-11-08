package sample.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.DataModels.Entry;
import sample.I18N;
import sample.Session;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EntryController {

    private ResourceBundle currentRB;
    private boolean categoryisSelected;
    private boolean subcategoryisSelected;
    private int categoryInteger;
    private int subcategoryInteger;
    @FXML AnchorPane gp;
    @FXML Label lb_title;
    @FXML Label lb_amount;
    @FXML Label lb_category;
    @FXML Label lb_subcat;
    @FXML Label lb_reference;
    @FXML Label lb_name;
    @FXML Button bt_add;
    @FXML ComboBox cb_categories;
    @FXML ComboBox cb_subcategories;
    @FXML TextField tf_reference;
    @FXML TextField tf_amount;

    private ObservableList<String> categories = FXCollections.observableArrayList();
    private ObservableList<String> subcategories;

    /**
     * Initialize method for the view.
     */
    @FXML
    public void initialize(){
        categoryisSelected = false;
        subcategoryisSelected = false;
        changeLenguage();
        fillCategories();
    }

    /**
     * Change the local variables language.
     */
    private void changeLenguage() {
        currentRB = I18N.getInstance().getResources();
        lb_name.setText(Session.getSession().getUser());
        lb_title.setText(currentRB.getString("entry"));
        lb_reference.setText(currentRB.getString("reference"));
        lb_category.setText(currentRB.getString("category"));
        lb_subcat.setText(currentRB.getString("subcategory"));
        lb_amount.setText(currentRB.getString("amount"));
        bt_add.setText(currentRB.getString("adddata"));
    }

    private void fillCategories() {
        categories.add(currentRB.getString("act"));
        categories.add(currentRB.getString("pas"));
        categories.add(currentRB.getString("patr"));
        cb_categories.setItems(categories);
        cb_categories.getSelectionModel().selectedIndexProperty().addListener(changeCategory);
        cb_subcategories.getSelectionModel().selectedIndexProperty().addListener(changeSubcategory);
    }

    /**
     * Listener for the Category ComboBox.
     */
    private ChangeListener<Number> changeCategory = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            subcategories = FXCollections.observableArrayList();
            categoryisSelected = true;
            categoryInteger = newValue.intValue();

            if (newValue.intValue() == 0) {
               subcategories.add(currentRB.getString("cash"));
               subcategories.add(currentRB.getString("tempinv"));
               subcategories.add(currentRB.getString("ee"));
               subcategories.add(currentRB.getString("inv"));
               subcategories.add(currentRB.getString("other"));
            } else if (newValue.intValue() == 1){
                subcategories.add(currentRB.getString("debtcp"));
                subcategories.add(currentRB.getString("debtlp"));
                subcategories.add(currentRB.getString("provider"));
                subcategories.add(currentRB.getString("rbp"));
                subcategories.add(currentRB.getString("other"));
            } else if (newValue.intValue() == 2) {
                subcategories.add(currentRB.getString("captsoc"));
                subcategories.add(currentRB.getString("reserv"));
                subcategories.add(currentRB.getString("util"));
            }


           cb_subcategories.setItems(subcategories);

        }
    };

    /**
     * Change subcategory listener.
     */
    private ChangeListener<Number> changeSubcategory = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            subcategoryisSelected = true;
            subcategoryInteger = newValue.intValue();

        }
    };


    /**
     * Log Out button event.
     * @param actionEvent for the button.
     * @throws IOException if FXML file is not found.
     */
    public void logOut(ActionEvent actionEvent) throws IOException {
        AnchorPane newAP = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        gp.getChildren().setAll(newAP);
    }

    /**
     * Submit data button
     * @param actionEvent click on the button.
     * @throws IOException if FXML file is not found.
     */
    public void submitData(ActionEvent actionEvent) throws IOException {
        if (verifyEmpty()){
            Session.getSession().pushEntry(new Entry(tf_reference.getText(), categoryInteger, subcategoryInteger, Float.valueOf(tf_amount.getText()), LocalDate.now()));
            AnchorPane newAP = FXMLLoader.load(getClass().getResource("../Views/MainScreen.fxml"));
            gp.getChildren().setAll(newAP);
        }

    }

    /**
     * Verrifies not null.
     * @return boolean.
     */
    private boolean verifyEmpty() {

        boolean result = true;

        if(tf_reference.getText().isEmpty()) {
            tf_reference.setStyle("-fx-border-color: #2A2B24 #2A2B24 RED #2A2B24;");
            result =  false;
        }

        if (tf_amount.getText().isEmpty()){
            tf_amount.setStyle("-fx-border-color: #2A2B24 #2A2B24 RED #2A2B24;");
            result =  false;
        }

        if (!categoryisSelected) {
            result =  false;
        }

        if (!subcategoryisSelected) {
            result =  false;
        }

        return result;
    }
}
