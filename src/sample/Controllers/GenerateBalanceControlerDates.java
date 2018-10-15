package sample.Controllers;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.I18N;

public class GenerateBalanceControlerDates {
	@FXML AnchorPane gp;
	@FXML Label lb_title;
	@FXML Button bt_leng;
	@FXML Button b_Generate;
	@FXML Label lb_from;
	@FXML Label lb_to;
	@FXML Label lb_balance;
	@FXML DatePicker dp_from;
	@FXML DatePicker dp_to;

	ResourceBundle currentRB;

	/**
	 * Initialize method.
	 */
	@FXML
	public void initialize() {
		changeLenguage();
	}

	/**
	 * Method for Back button.
	 *
	 * @param actionEvent
	 *            action of the button.
	 * @throws IOException
	 *             if FXML is not found.
	 */
    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/MainScreen.fxml"));
        gp.getChildren().setAll(gp2);
    }
	/**
	 * Change language method. Change the local variables.
	 */
	public void changeLenguage() {
		currentRB = I18N.getInstance().getResources();
		bt_leng.setText(currentRB.getString("leng"));
		lb_from.setText(currentRB.getString("from"));
		lb_to.setText(currentRB.getString("to"));
		lb_title.setText(currentRB.getString("selectdates"));
		b_Generate.setText(currentRB.getString("generate"));
		lb_balance.setText("    " + currentRB.getString("generate").concat(currentRB.getString("generalBalance")));
	}

	/**
	 * Change language method. Change the global Resource Bundle.

	 */
	public void swap(ActionEvent actionEvent) {
		I18N.getInstance().setLocale(new Locale(currentRB.getString("leng")));
		changeLenguage();
	}

	public void generate (ActionEvent actionEvent){
		System.out.println("Generate perrow");
	}
}
