package sample.Controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.I18N;
import sample.Session;
import sample.DataModels.Entry;

public class GenerateBalanceControlerDates {
	@FXML
	AnchorPane gp;
	@FXML
	Label lb_title;
	@FXML
	Button b_Generate;
	@FXML
	Label lb_from;
	@FXML
	Label lb_to;
	@FXML
	Label lb_balance;

	@FXML
	Label lb_activos;
	@FXML
	Label lb_pasivos;
	@FXML
	Label lb_capital;
	@FXML
	Label lb_total;
	@FXML
	Label lb_Ractivos;
	@FXML
	Label lb_Rpasivos;
	@FXML
	Label lb_Rcapital;
	@FXML
	Label lb_Rtotal;

	@FXML
	DatePicker dp_from;
	@FXML
	DatePicker dp_to;

	@FXML
	Button exit;

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
		lb_from.setText(currentRB.getString("from"));
		lb_to.setText(currentRB.getString("to"));
		lb_title.setText(currentRB.getString("selectdates"));
		b_Generate.setText(currentRB.getString("generate"));
		lb_balance
				.setText("    " + currentRB.getString("generate").concat(" " + currentRB.getString("generalBalance")));
		lb_activos.setText(currentRB.getString("actives"));
		lb_pasivos.setText(currentRB.getString("passives"));
		lb_capital.setText(currentRB.getString("capitals"));
		lb_total.setText(currentRB.getString("totals"));
		exit.setText(currentRB.getString("graphicButtonExit"));
	}


	public void generate(ActionEvent actionEvent) {
		// Observable list con los datos de entradas
		ObservableList<Entry> entradas = Session.getSession().getData(false);

		// Local Date
		LocalDate ld_from = dp_from.getValue();
		LocalDate ld_to = dp_to.getValue();

		// Datos
		double activos = 0;
		double pasivos = 0;
		double capital = 0;
		double total = 0;

		for (int i = 0; i < entradas.size(); i++) {
			if ((entradas.get(i).getDate().isAfter(ld_from) || entradas.get(i).getDate().isEqual(ld_from))
					&& (entradas.get(i).getDate().isBefore(ld_to) || entradas.get(i).getDate().isEqual(ld_to))) {
				System.out.println("entro we " + entradas.get(i).getDate().toString());
				if (entradas.get(i).getCategory() == 0) {
					activos = activos + entradas.get(i).getAmount();
				}
				if (entradas.get(i).getCategory() == 1) {
					pasivos = pasivos + entradas.get(i).getAmount();
				}
				if (entradas.get(i).getCategory() == 2) {
					capital = capital + entradas.get(i).getAmount();
				}
			}
		}
		total = activos - (pasivos + capital);

		lb_Ractivos.setText("$ "+String.valueOf(activos));
		lb_Rpasivos.setText("$ "+String.valueOf(pasivos));
		lb_Rcapital.setText("$ "+String.valueOf(capital));
		lb_Rtotal.setText("$ "+String.valueOf(total));
	}
}
