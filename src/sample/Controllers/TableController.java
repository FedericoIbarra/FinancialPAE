package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.DataModels.EntryTable;
import sample.Session;

public class TableController {

    private ObservableList<EntryTable> data = null;

    @FXML TableView table;

    @FXML
    public void initialize(){
        data = Session.getSession().getData(true);

        System.out.println(data.size());

        table.getItems().addAll(data);

    }
}
