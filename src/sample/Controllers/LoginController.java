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
import java.io.IOException;
import java.util.List;
import java.util.Locale;
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

    private ResourceBundle currentRB;
    private List<User> usersList;

    /**
     * Initialize method for the view.
     */
    @FXML
    public void initialize(){
        usersList = Session.getSession().loadUsers();
        changeLanguage();
    }

    /**
     * Compare the given password and user name with the list.
     * @param usr given username.
     * @param psw given password.
     * @return true if is matched.
     */
    private boolean compareUser(String usr, String psw) {
    	usersList = Session.getSession().loadUsers();
        return usersList.stream().anyMatch(e -> usr.equals(e.getUsername()) && psw.equals(e.getPassword()));
    }

    /**
     * Mehtod for button Sign Up.
     * @param actionEvent action for button.
     * @throws IOException if FXML file is not found.
     */
    public void signUp(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/SignUp.fxml"));
        gp.getChildren().setAll(gp2);
    }

    /**
     * Change the global Bundle and this views language.
     */
    private void changeLanguage() {
        currentRB = I18N.getInstance().getResources();
        lb_pass.setText(currentRB.getString("password"));
        lb_user.setText(currentRB.getString("user"));
        bt_login.setText(currentRB.getString("signin"));
        bt_signup.setText(currentRB.getString("signup"));
        lb_or.setText(currentRB.getString("or"));
        bt_leng.setText(currentRB.getString("leng"));
    }

    /**
     * Mehtod for button Sign In.
     * @param actionEvent action for button.
     * @throws IOException if FXML file is not found.
     */
    public void signIn(ActionEvent actionEvent) throws IOException {

        if(compareUser(tf_user.getText(), tf_password.getText())) {
            usersList = null;
            Session.getSession().setUser(tf_user.getText());
            AnchorPane newAP = FXMLLoader.load(getClass().getResource("../Views/MainScreen.fxml"));
            gp.getChildren().setAll(newAP);
        } else {
            tf_password.setStyle("-fx-border-color: #2A2B24 #2A2B24 RED #2A2B24;");
            tf_user.setStyle("-fx-border-color: #2A2B24 #2A2B24 RED #2A2B24;");
            System.err.println("No encontrado");
        }

    }

    /**
     * Mehtod for button Swap Language.
     * @param actionEvent action for button.
     * @throws IOException if FXML file is not found.
     */
    public void swap(ActionEvent actionEvent) {
        I18N.getInstance().setLocale(new Locale(currentRB.getString("leng")));
        changeLanguage();
    }

    /**
     * Mehtod for button Show Info.
     * @param actionEvent action for button.
     * @throws IOException if FXML file is not found.
     */
    public void showInfo(ActionEvent actionEvent) throws IOException {
        AnchorPane newAP = FXMLLoader.load(getClass().getResource("../Views/Info.fxml"));
        gp.getChildren().setAll(newAP);
    }

    /**
     * Methor for the Enter Key in textfields.
     * @param actionEvent Enter Key.
     * @throws IOException if FXML is not found.
     */
    public void enterKey(ActionEvent actionEvent) throws IOException {
        signIn(null);
    }
}
