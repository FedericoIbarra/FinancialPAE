package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import sample.DataModels.EntryTable;
import sample.I18N;
import sample.Session;

import java.io.IOException;
import java.util.ResourceBundle;

public class TableController {

    private ObservableList<EntryTable> data = null;

    private ResourceBundle currentRB;

    @FXML TableView table;
    @FXML AnchorPane gp;
    @FXML Label lb_title;
    @FXML TableColumn col_reference;
    @FXML TableColumn col_category;
    @FXML TableColumn col_sub;
    @FXML TableColumn col_amount;
    @FXML TableColumn col_date;

    @FXML
    public void initialize(){

        changeLanguage();

        data = Session.getSession().getData(true);
        table.getItems().addAll(data);

    }

    private void changeLanguage() {

        currentRB = I18N.getInstance().getResources();
        lb_title.setText(currentRB.getString("entryTab"));
        col_reference.setText(currentRB.getString("reference"));
        col_category.setText(currentRB.getString("category"));
        col_sub.setText(currentRB.getString("subcategory"));
        col_amount.setText(currentRB.getString("amount"));
        col_date.setText(currentRB.getString("date"));


    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        AnchorPane newAP = FXMLLoader.load(getClass().getResource("../Views/MainScreen.fxml"));
        gp.getChildren().setAll(newAP);
    }
}
