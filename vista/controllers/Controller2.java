package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import eventos.Evento;
import fechas.Fecha;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;
import persistencias.ArchivoLineasDeTiempo;

public class Controller2   {

	private Stage stage;
	private LineaDeTiempo linea ;
	ArchivoLineasDeTiempo archivo = new ArchivoLineasDeTiempo();	
	
	@FXML private TextField t1;
	@FXML private TextField t2;
	@FXML private TextField t3;
	@FXML private TextField t4;
	@FXML private TextArea t5;
	
	
	public void siguienteBoton() throws IOException {
		
		this.actualizarDatos();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Escena1.fxml"));
    	Parent root = loader.load();
    	Controller1 controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLineaDeTiempo(linea);
    	
    	stage.setScene(new Scene(root,260,350));
    	
	}

	private void actualizarDatos() throws FileNotFoundException, IOException {
		
		String nombre = t1.getText();
		int dia  = Integer.parseInt(  t2.getText() );
		int mes  = Integer.parseInt(  t3.getText() );
		int anio  = Integer.parseInt(  t4.getText() );
		Fecha fecha = new Fecha(anio,mes,dia);
		String descripcion = t5.getText();
		
		Evento evento = new Evento(nombre,fecha,descripcion);	
		
		linea.agregarEvento(evento);
					
		archivo.guardar(linea);
			

			
	}

	public void setLinea(LineaDeTiempo linea) {
		this.linea = linea;	
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;	
	}

}
