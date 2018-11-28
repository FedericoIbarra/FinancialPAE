package sample.Controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.I18N;
import sample.Session;
import sample.DataModels.Entry;

public class GraphicsController {
	@FXML
	AnchorPane gp;

	@FXML
	Label title;

	@FXML
	Pane graphic;

	@FXML
	Button exit;
	@FXML
	Button generate;

	@FXML
	LineChart lineC;

	@FXML
	TextField tf_year;

	private ResourceBundle currentRB;
	private XYChart.Series activesList = new XYChart.Series();
	private XYChart.Series passiveList = new XYChart.Series();
	private XYChart.Series patrimonyList = new XYChart.Series();
	private ObservableList<Entry> list;

	public void initialize() {

		list = Session.getSession().getData(false);
		lineC.getData().add(activesList);
		lineC.getData().add(passiveList);
		lineC.getData().add(patrimonyList);
		changeLenguage();

	}

	private void countActives(int year) {
		int activesCount = 0;
		int passivesCount = 0;
		int patrimonyCount = 0;
		int currentMonth = 1;

		LocalDate first = LocalDate.of(year, 1, 1);

		activesList.getData().clear();
		passiveList.getData().clear();
		patrimonyList.getData().clear();

		for (Entry e : list) {

			if (e.getDate().getMonthValue() == currentMonth && year == e.getDate().getYear()) {
				if (e.getCategory() == 0) {
					activesCount += e.getAmount();
				} else if (e.getCategory() == 1) {
					passivesCount += e.getAmount();
				} else if (e.getCategory() == 2) {
					patrimonyCount += e.getAmount();
				}
			} else if (year < e.getDate().getYear()) {

				System.out.println("Jalalalalalalaal");
				System.out.print(Month.of(12).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
				System.out.println(" " + activesCount + " " + passivesCount + " " + " " + patrimonyCount);

				activesList.getData().add(
						new XYChart.Data(Month.of(12).getDisplayName(TextStyle.SHORT, Locale.ENGLISH), activesCount));
				passiveList.getData().add(
						new XYChart.Data(Month.of(12).getDisplayName(TextStyle.SHORT, Locale.ENGLISH), passivesCount));
				patrimonyList.getData().add(
						new XYChart.Data(Month.of(12).getDisplayName(TextStyle.SHORT, Locale.ENGLISH), patrimonyCount));
				// e.getDate().getMonthValue();
				// Month m = Month.of(e.getDate().getMonthValue() -
				// 1).getDisplayName(TextStyle.SHORT, Locale.ENGLISH)

				return;
			} else if (year == e.getDate().getYear()) {

				System.out.print(
						Month.of(e.getDate().getMonthValue() - 1).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
				System.out.println(" " + activesCount + " " + passivesCount + " " + " " + patrimonyCount);

				activesList.getData().add(new XYChart.Data(
						Month.of(e.getDate().getMonthValue() - 1).getDisplayName(TextStyle.SHORT, Locale.ENGLISH),
						activesCount));
				passiveList.getData().add(new XYChart.Data(
						Month.of(e.getDate().getMonthValue() - 1).getDisplayName(TextStyle.SHORT, Locale.ENGLISH),
						passivesCount));
				patrimonyList.getData().add(new XYChart.Data(
						Month.of(e.getDate().getMonthValue() - 1).getDisplayName(TextStyle.SHORT, Locale.ENGLISH),
						patrimonyCount));

				activesCount = passivesCount = patrimonyCount = 0;

				currentMonth++;
			}

		}

	}

	private void changeLenguage() {

		currentRB = I18N.getInstance().getResources();
		title.setText(currentRB.getString("graphicsTitle"));
		exit.setText(currentRB.getString("graphicButtonExit"));
		generate.setText(currentRB.getString("graphicButtonGenerate"));
		activesList.setName(currentRB.getString("actives"));
		passiveList.setName(currentRB.getString("passives"));
		patrimonyList.setName(currentRB.getString("patr"));

	}

	public void generar(ActionEvent actionEvent) {
		System.out.println("Si jala generar");
		countActives(Integer.valueOf(tf_year.getText()));

	}

	public void exit(ActionEvent actionEvent) throws IOException {
		System.out.println("Jala salir");
		AnchorPane gp2 = FXMLLoader.load(getClass().getResource("../Views/MainScreen.fxml"));
		gp.getChildren().setAll(gp2);
	}
}
