package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.ResourceBundle;

public class LoginController {

    @FXML TextField tf_user;
    @FXML PasswordField tf_password;
    @FXML Label lb_pass;
    @FXML Label lb_user;
    @FXML Label lb_or;
    @FXML Button bt_login;
    @FXML Button bt_signup;
    @FXML AnchorPane gp;
    @FXML Button bt_leng;

    ResourceBundle currentRB;


    @FXML
    public void initialize(){

        changeLenguage();

    }

    public void signUp(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        gp.getChildren().setAll(gp2);
    }

    public void changeLenguage() {
        currentRB = I18N.getInstance().getResources();
        lb_pass.setText(currentRB.getString("password"));
        lb_user.setText(currentRB.getString("user"));
        bt_login.setText(currentRB.getString("signin"));
        bt_signup.setText(currentRB.getString("signup"));
        lb_or.setText(currentRB.getString("or"));
        bt_leng.setText(currentRB.getString("leng"));
    }

    public void signIn(ActionEvent actionEvent) throws IOException {
        AnchorPane newAP = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        gp.getChildren().setAll(newAP);
    }
}
