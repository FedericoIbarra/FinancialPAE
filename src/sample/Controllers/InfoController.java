package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class InfoController {

    @FXML AnchorPane gp;

    /**
     * Return event utton event.
     * @param actionEvent for the button.
     * @throws IOException if the FXML is not found.
     */
    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        gp.getChildren().setAll(gp2);
    }
}
