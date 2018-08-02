package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;
import persistencias.ArchivoLineasDeTiempo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller1  {
	
	private Stage stage;
	private LineaDeTiempo linea ;

    
    public void  agregarEvento() throws IOException {
    
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Escena2.fxml"));
    	Parent root = loader.load();
    	Controller2 controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(linea);
    	stage.setScene(new Scene(root,600,325));
      	
    }
    
    public void  salirDelPrograma() {
    	this.stage.close();
    }

    public void  verLineasDeTiempo() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaDelasLineas.fxml"));
    	Parent root = loader.load();
    	
    	EscenaDeLasLineasController controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(linea);
    	controller.setIndice(0);
    	controller.actualizar();
    	
    	stage.setScene(new Scene(root,1200,640));
    	
    	linea.mostrarEventos();
    	System.out.println("-----------");
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }

	public void setLineaDeTiempo(LineaDeTiempo linea) {		
		this.linea = linea;	
		
	}
	
	public void botonEliminarEvento() {
		
	}
	
	public void botonModificarEvento() {
		
	}
 
}