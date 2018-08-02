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

    
    public void  agregarEvento() throws IOException {
    
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaAgregarEvento.fxml"));
    	Parent root = loader.load();
    	ControllerAgregarEvento controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(linea);
    	stage.setScene(new Scene(root,1200,640));
      	
    }
    
    public void  salirDelPrograma() {
    	this.stage.close();
    }

    public void  verLineasDeTiempo() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaDelasLineas.fxml"));
    	Parent root = loader.load();
    	
    	ControllerDeLasLineas controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(linea);
    	controller.setIndice(0);
 
    	if ( this.linea.cantidadDeEventos()==0 ) System.out.println("No hay nada para mostrar");
    	else {
    		controller.actualizar();
    		stage.setScene(new Scene(root,1200,640));
    	}
    	
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }

	public void setLineaDeTiempo(LineaDeTiempo linea) {		
		this.linea = linea;	
		
	}
	
	public void botonEliminarEvento() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaEliminarEvento.fxml"));
		Parent root = loader.load();
		ControllerEliminarEvento controller = loader.getController();
		controller.setStage(this.stage);
		controller.setLineaDeTiempo(this.linea);
		
		this.stage.setScene(new Scene(root,1200,640));
		
		
	}
	
	public void botonModificarEvento() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaModificarEvento.fxml"));
			Parent root = loader.load();
			ControllerModificarEvento controller = loader.getController();
			controller.setStage(stage);
			controller.setLineaDeTiempo(linea);
			controller.actualizar();
			this.stage.setScene(new Scene(root,1200,640));
	}
 
}