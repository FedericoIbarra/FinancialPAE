package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class LoginController {

    @FXML TextField tf_user;
    @FXML PasswordField tf_password;
    @FXML AnchorPane gp;


    @FXML
    public void initialize(){
        //tf_password.getScene().getStylesheets().add("DarkTheme.css");

    }

    public void signUp(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        gp.getChildren().setAll(gp2);
    }
}
