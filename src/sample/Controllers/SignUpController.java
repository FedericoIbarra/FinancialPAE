package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.DataModels.User;
import sample.I18N;
import sample.Session;
import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML TextField tf_name;
    @FXML TextField tf_user;
    @FXML TextField tf_email;
    @FXML TextField tf_email2;
    @FXML PasswordField tf_pass;
    @FXML PasswordField tf_pass2;
    @FXML AnchorPane gp;
    @FXML Label lb_name;
    @FXML Label lb_user;
    @FXML Label lb_pass;
    @FXML Label lb_pass2;
    @FXML Label lb_email;
    @FXML Label lb_email2;
    @FXML Button bt_send;
    @FXML Button bt_leng;

    private ResourceBundle currentRB;
    private User newUser;
    private List<User> usersList;
    private String redLine = "-fx-border-color: #2A2B24 #2A2B24 RED #2A2B24;";

    /**
     * Initialize method.
     */
    @FXML
    public void initialize(){
        usersList = Session.getSession().loadUsers();
        changeLenguage();

    }

    /**
     * Method for Back button.
     * @param actionEvent action of the button.
     * @throws IOException if FXML is not found.
     */
    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        gp.getChildren().setAll(gp2);
    }

    /**
     * Change language method.
     * Change the local variables.
     */
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

    /**
     * Change language method.
     * Change the global Resource Bundle.
     */
    public void swap(ActionEvent actionEvent) {
        I18N.getInstance().setLocale(new Locale(currentRB.getString("leng")));
        changeLenguage();
    }

    public void send(ActionEvent actionEvent) throws IOException {
        if(nullVerification() && equalsVerification(tf_pass, tf_pass2) && equalsVerification(tf_email, tf_email2) && alredyExists(tf_user.getText())) {

            newUser = new User(tf_name.getText(), tf_user.getText(), tf_pass.getText(), tf_email.getText());
            Session.getSession().pushUser(newUser);
            usersList = null;
            AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
            gp.getChildren().setAll(gp2);
        }

        System.out.println(newUser);
        
    }

    /**
     * Compare if the text of two TextFiels are equal and change it's color of not.
     * @param tf1 TextField 1.
     * @param tf2 TextField 2.
     * @return true if equal, false if not.
     */
    private boolean equalsVerification(TextField tf1, TextField tf2) {

        if(tf1.getText().equals(tf2.getText())) {
            return true;
        } else {
            tf1.setStyle(redLine);
            tf2.setStyle(redLine);
            return false;
        }
    }
    
    private boolean nullVerification() {
        boolean result = true;

        if (tf_user.getText().isEmpty()) {
            tf_user.setStyle(redLine);
            result = false;
        }

        if (tf_email.getText().isEmpty()) {
            tf_email.setStyle(redLine);
            result = false;
        }

        if (tf_email2.getText().isEmpty()) {
            tf_email2.setStyle(redLine);
            result = false;
        }

        if(tf_name.getText().isEmpty()) {
            tf_name.setStyle(redLine);
            result = false;
        }

        if(tf_pass.getText().isEmpty()) {
            tf_pass.setStyle(redLine);
            result = false;
        }

        if(tf_pass2.getText().isEmpty()) {
            tf_pass2.setStyle(redLine);
            result = false;
        }

        return result;
    }



    /**
     * Compare the user name with the list.
     * @param usr given username.
     * @return true if is matched.
     */
    private boolean alredyExists(String usr) {

        if(usersList.stream().anyMatch(e -> usr.equals(e.getUsername()))) {
            tf_user.setStyle("-fx-border-color: #2A2B24 #2A2B24 RED #2A2B24;");
            return false;
        } else {
            return true;
        }

    }
}
