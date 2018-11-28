package sample.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.I18N;
import sample.Session;

import java.io.IOException;
import java.util.ResourceBundle;

public class MainScreenController {

    private ResourceBundle currentRB;
    @FXML
    AnchorPane gp;
    @FXML
    Button bt_logOut;
    @FXML
    Button bt_Remove;
    @FXML
    Button bt_add;
    @FXML
    Button bt_state;
    @FXML
    Button bt_balance;
    @FXML
    Button bt_graphics;
    @FXML
    Label lb_title;
    @FXML
    Button bt_entries;
    @FXML
    Label lb_name;


    /**
     * Initialize method.
     */
    @FXML
    public void initialize() {

        changeLenguage();

    }

    /**
     * Change language method.
     * Change the global Resource Bundle adn local variables.
     */
    private void changeLenguage() {
        currentRB = I18N.getInstance().getResources();
        lb_name.setText(Session.getSession().getUser());
        bt_logOut.setText(currentRB.getString("logOut"));
        bt_Remove.setText(currentRB.getString("remove"));
        bt_add.setText("     " + currentRB.getString("adddata"));
        bt_entries.setText("    " + currentRB.getString("showtable"));
        bt_state.setText("     " + currentRB.getString("generate").concat(" ").concat(currentRB.getString("resultState")));
        bt_balance.setText("    " + currentRB.getString("generate").concat(" ").concat(currentRB.getString("generalBalance")));
        bt_graphics.setText("    " + currentRB.getString("generate").concat(" ").concat(currentRB.getString("graphics")));
        lb_title.setText("                    " + currentRB.getString("selectoption"));

    }

    /**
     * Method for Log Out button.
     * @param actionEvent action of the button.
     * @throws IOException if FXML is not found.
     */
    public void logOut(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        gp.getChildren().setAll(gp2);
    }

    /**
     * Method used to remove an specific user
     * @param actionEvent action of the button.
     * @throws IOException if FXML is not found.
     */
    public void removeUser(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        System.out.println(Session.getSession().getUser());
        Session.getSession().removeUses();
        gp.getChildren().setAll(gp2);
    }

    /**
     * Method for AddInfo button.
     * @param actionEvent action of button.
     * @throws IOException if FXML is not found.
     */
    public void add(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/EntryView.fxml"));
        gp.getChildren().setAll(gp2);
    }

    /**
     * Method for ResultsState button.
     * @param actionEvent action of button.
     */
    public void state(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/GenerateState.fxml"));
        gp.getChildren().setAll(gp2);
        System.out.println("Si jala state");
    }

    /**
     * Method for GeneralBalance button.
     * @param actionEvent action of button.
     */
    public void balance(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load (getClass().getResource("../Views/GenerateBalanceControlerDates.fxml"));
        gp.getChildren().setAll(gp2);
        System.out.println("Si jala balance");
    }

    /**
     * Method for ShowGraphics button.
     * @param actionEvent action of button.
     */
    public void graphics(ActionEvent actionEvent) throws IOException {

        AnchorPane gp2 = FXMLLoader.load (getClass().getResource("../Views/GraphicsView.fxml"));
        gp.getChildren().setAll(gp2);

        System.out.println("Si jala graphics");
    }


    /**
     * Method for ShowTable Button.
     * @param actionEvent show table action for button.
     */
    public void showTable(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load (getClass().getResource("../Views/TableView.fxml"));
        gp.getChildren().setAll(gp2);

    }
}
