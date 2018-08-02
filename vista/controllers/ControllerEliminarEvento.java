package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import excepciones.NoSeEncontroElEvento;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;
import persistencias.ArchivoLineasDeTiempo;

public class ControllerEliminarEvento {
	
	private Stage stage;
	private LineaDeTiempo linea;
	ArchivoLineasDeTiempo archivo = new ArchivoLineasDeTiempo();	
	@FXML private TextField t1;
	@FXML private Text labelAlerta;

	public void setStage(Stage stage) {
		this.stage = stage;
		
	}

	public void setLineaDeTiempo(LineaDeTiempo linea) {
		this.linea = linea;
		
	}
	
	public void botonVolver() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaMenuPrincipal.fxml") );
		Parent root = loader.load();
		ControllerMenuPrincipal controller = loader.getController();
		controller.setStage(this.stage);
		controller.setLineaDeTiempo(this.linea);
		this.stage.setScene(new Scene(root,1200,640) );
		
	}
	
	public void botonEliminar() throws FileNotFoundException, IOException {
		System.out.println(t1.getText());
		int resultado = linea.eliminarEvento(t1.getText());
		if ( resultado == 1) 	labelAlerta.setText("No se encontro el evento , Vuelva a ingresar o regrese al Menu Principal");
		else {
			archivo.guardar(linea);
			labelAlerta.setText("Se Elimino Ex�tosamente!");
			t1.clear();
		}
	}

}
