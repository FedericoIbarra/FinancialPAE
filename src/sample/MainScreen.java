package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainScreen {

    private ResourceBundle currentRB;
    @FXML
    AnchorPane gp;

    @FXML
    Button bt_add;
    @FXML
    Button bt_state;
    @FXML
    Button bt_balance;
    @FXML
    Button bt_graphics;
    @FXML
    Button bt_leng;

    @FXML
    Label lb_title;


    @FXML
    public void initialize() {

        changeLenguage();

    }

    private void changeLenguage() {
        currentRB = I18N.getInstance().getResources();
        bt_add.setText("     " + currentRB.getString("adddata"));
        bt_state.setText("     " + currentRB.getString("generate").concat(currentRB.getString("resultState")));
        bt_balance.setText("    " + currentRB.getString("generate").concat(currentRB.getString("generalBalance")));
        bt_graphics.setText("    " + currentRB.getString("generate").concat(currentRB.getString("graphics")));
        lb_title.setText("                    " + currentRB.getString("selectoption"));
        bt_leng.setText(currentRB.getString("leng"));

        bt_leng.setOnAction(e -> {
            System.out.println("Si jala");
            I18N.getInstance().setLocale(new Locale(currentRB.getString("leng")));
            changeLenguage();
        });
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("login.fxml"));
        gp.getChildren().setAll(gp2);
    }

    public void add(ActionEvent actionEvent) {
        System.out.println("Si jala add");
    }

    public void state(ActionEvent actionEvent) {
        System.out.println("Si jala state");
    }

    public void balance(ActionEvent actionEvent) {
        System.out.println("Si jala balance");
    }


    public void graphics(ActionEvent actionEvent) {
        System.out.println("Si jala graphics");
    }


}
