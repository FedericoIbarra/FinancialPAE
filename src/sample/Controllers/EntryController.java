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
import javafx.scene.layout.AnchorPane;
import sample.I18N;

import java.io.IOException;
import java.util.ResourceBundle;

public class EntryController {

    @FXML AnchorPane gp;
    private ResourceBundle currentRB;
    @FXML Label lb_title;
    @FXML Label lb_amount;
    @FXML Label lb_category;
    @FXML Label lb_subcat;
    @FXML Label lb_reference;
    @FXML Button bt_add;
    @FXML ComboBox cb_categories;
    @FXML ComboBox cb_subcategories;

    private ObservableList<String> categories = FXCollections.observableArrayList();
    private ObservableList<String> subcategories;

    /**
     * Initialize method for the view.
     */
    @FXML
    public void initialize(){
        changeLenguage();
        fillCategories();
    }

    /**
     * Change the local variables language.
     */
    private void changeLenguage() {
        currentRB = I18N.getInstance().getResources();
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
    }

    /**
     * Listener for the Category ComboBox.
     */
    private ChangeListener<Number> changeCategory = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            subcategories = FXCollections.observableArrayList();

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

    public void logOut(ActionEvent actionEvent) throws IOException {
        AnchorPane newAP = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        gp.getChildren().setAll(newAP);
    }

    public void submitData(ActionEvent actionEvent) throws IOException {
        AnchorPane newAP = FXMLLoader.load(getClass().getResource("../Views/MainScreen.fxml"));
        gp.getChildren().setAll(newAP);
    }
}
