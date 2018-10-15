package sample.Controllers;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.I18N;

public class GenerateStateController 
{
	@FXML Label titulo;
	@FXML Label ventas;
	@FXML Label CVentas;
	@FXML Label GAdministracion;
	@FXML Label GVentas;
	@FXML Label GFinancieros;
	@FXML Button generar;
	@FXML TextField tfVentas;
	@FXML TextField tfCVentas;
	@FXML TextField tfGAdmimnistracion;
	@FXML TextField tfGVentas;
	@FXML TextField tfGFinancierots;
	@FXML Button salir;
	
	private ResourceBundle currentRB;
	
	 public void initialize() {

	        changeLenguage();

	    }
	 
	 private void changeLenguage() {
	        currentRB = I18N.getInstance().getResources();
	        titulo.setText(currentRB.getString("genEstadosResultados"));
	        ventas.setText(currentRB.getString("ventas"));
	        CVentas.setText(currentRB.getString("cVentas"));
	        GAdministracion.setText(currentRB.getString("GAdministracion"));
	        GVentas.setText(currentRB.getString("GVentas"));
	        GFinancieros.setText(currentRB.getString("GFinancieros"));
	        generar.setText(currentRB.getString("GenerarEstadoResultado"));
	        salir.setText(currentRB.getString("SalirEstadoResultado"));
	        
	    }
	 
	 public void generar(ActionEvent actionEvent) {
	        System.out.println("Si jala generar");
	    }
	 
	 public void salirEstadoResultado(ActionEvent actionEvent) {
	        System.out.println("Si jala salir");
	    }
	

	
	
	
}
