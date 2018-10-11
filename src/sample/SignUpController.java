package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML AnchorPane gp;

    @FXML Label lb_name;
    @FXML Label lb_user;
    @FXML Label lb_pass;
    @FXML Label lb_pass2;
    @FXML Label lb_email;
    @FXML Label lb_email2;

    @FXML Button bt_send;
    @FXML Button bt_leng;

    ResourceBundle currentRB;


    @FXML
    public void initialize(){

        changeLenguage();

    }

    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("login.fxml"));
        gp.getChildren().setAll(gp2);
    }

    public void changeLenguage () {
        currentRB = I18N.getInstance().getResources();
        lb_name.setText(currentRB.getString("name"));
        lb_user.setText(currentRB.getString("usrname"));
        lb_pass.setText(currentRB.getString("password"));
        lb_pass2.setText(currentRB.getString("confirm").concat(currentRB.getString("password")));
        lb_email.setText(currentRB.getString("email"));
        lb_email2.setText(currentRB.getString("confirm").concat(currentRB.getString("email")));
        bt_send.setText(currentRB.getString("send"));
        bt_leng.setText(currentRB.getString("leng"));

    }
}
