package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;

import persistencias.ArchivoLineasDeTiempo;

public class ControllerEleccionDeLinea {
	
	private Stage stage;
	private boolean nuevo;
	private LineaDeTiempo linea;
	private ArchivoLineasDeTiempo archivo = new ArchivoLineasDeTiempo();	
	private String nombreArchivo;
	@FXML private TextField t1;
	@FXML private Label l1,l2;
	@FXML private Button b1;

	
	public void setStage( Stage stage) {
		this.stage = stage;
	}
	
	public void botonNuevoProyecto() {
		linea = new LineaDeTiempo();
		
		this.nuevo = true;
		t1.setDisable(false);
		t1.setText("");
		l2.setText("Nombre nuevo proyecto:");
		l1.setText("");
		b1.setDisable(false);
		
	}
	
	public void botonContinuarProyecto() {
		t1.setDisable(false);
		this.nuevo=false;
		l2.setText("Nombre del proyecto:");
		l1.setText("");
		b1.setDisable(false);
		
	}
	
	public void botonSalir() {
		this.stage.close();
	}
	
	public int botonConfirmar() throws IOException {
		this.nombreArchivo = t1.getText();
		System.out.println("BNombre del archivo sacado del text :"+this.nombreArchivo);
		
		try {
			if (!this.nuevo)  this.linea = archivo.recuperar(this.nombreArchivo+".obj");
		} catch (Exception e) {		
			this.actualizar();
			l1.setText("No existe ese nombre de archivo");
			return 1;
		}
	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaMenuPrincipal.fxml"));
		Parent root = loader.load();
		ControllerMenuPrincipal controller = loader.getController();
		controller.setStage(stage);
		controller.setLineaDeTiempo(linea);
		controller.setNombreArchivo(this.nombreArchivo);
		this.stage.setScene(new Scene(root,1200,640));
		return 0;
	}
	
	public void actualizar() {
		Button nuevo = new Button();
		nuevo.setScaleX(100);
	
		t1.setDisable(true);
		l1.setText("");
		l2.setText("");
		b1.setDisable(true);
	}

}
