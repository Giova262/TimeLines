package controllers;

import javafx.stage.Stage;

public class ControllerConfirmacion {
	private boolean eleccion=false;
	private Stage stage;
	
	
	public void botonSi() {
		this.eleccion = true;	
		System.out.println(eleccion);
		this.stage.close();
	}
	
	public void botonNo() {
		this.eleccion = false;
		System.out.println(eleccion);
		this.stage.close();
	}
	
	public boolean getEleccion() {
		return this.eleccion;
	}

	public void setStage(Stage stage) {
		this.stage = stage;	
	}
	
}
