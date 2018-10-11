package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.ResourceBundle;

public class MainScreen {

    private ResourceBundle currentRB;
    @FXML AnchorPane gp;

    @FXML Button bt_add;
    @FXML Button bt_state;
    @FXML Button bt_balance;
    @FXML Button bt_graphics;
    @FXML Button bt_leng;

    @FXML Label lb_title;


    @FXML
    public void initialize(){

        changeLenguage();

    }

    private void changeLenguage () {
        currentRB = I18N.getInstance().getResources();
        bt_add.setText("     " +  currentRB.getString("adddata"));
        bt_state.setText("     " + currentRB.getString("generate").concat(currentRB.getString("resultState")));
        bt_balance.setText("    " + currentRB.getString("generate").concat(currentRB.getString("generalBalance")));
        bt_graphics.setText("    " + currentRB.getString("generate").concat(currentRB.getString("graphics")));
        lb_title.setText("                    " + currentRB.getString("selectoption"));
        bt_leng.setText(currentRB.getString("leng"));
    }

    public void logOut(ActionEvent actionEvent) {
    }
}
