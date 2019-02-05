package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;


import java.io.IOException;

public class ControllerMenuPrincipal  {
	
	private Stage stage;
	private LineaDeTiempo linea ;
	private String nombreArchivo;

    
    public void  agregarEvento() throws IOException {
    
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaAgregarEvento.fxml"));
    	Parent root = loader.load();
    	ControllerAgregarEvento controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(linea);
    	controller.setNombreArchivo(this.nombreArchivo);
    	
    	stage.setScene(new Scene(root,1200,640));
      	
    }
    
    public void  salirDelPrograma() throws IOException {
    	
    	this.stage.close();
    /*	FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaEleccionDeLinea.fxml"));
    	Parent root = loader.load();
    	ControllerEleccionDeLinea controller = loader.getController();
    	controller.setStage(stage);
    	controller.actualizar();
    	stage.setScene(new Scene(root,1200,640));*/
    }

    public void  verLineasDeTiempo() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaDelasLineas.fxml"));
    	Parent root = loader.load();
    	
    	ControllerDeLasLineas controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(linea);
    	controller.setNombreArchivo(this.nombreArchivo);
    	controller.setIndice(0);
 
    	if ( this.linea.cantidadDeEventos()==0 ) System.out.println("No hay nada para mostrar");
    	else {
    		controller.actualizar();
    			
    		stage.setScene(new Scene(root,1200,800));		
    		stage.setX(200);
    		stage.setY(0);
    	}
    	
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }

	public void setLineaDeTiempo(LineaDeTiempo linea) {		
		this.linea = linea;	
		
	}
	

	public void setNombreArchivo(String nombreArchivo) {
	
		this.nombreArchivo = nombreArchivo;

		
	}

 
}