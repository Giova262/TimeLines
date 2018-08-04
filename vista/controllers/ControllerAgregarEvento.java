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

public class ControllerAgregarEvento   {

	private Stage stage;
	private LineaDeTiempo linea ;
	private String nombreArchivo;
	private ArchivoLineasDeTiempo archivo = new ArchivoLineasDeTiempo();		
	@FXML private TextField t1,t2,t3,t4;
	@FXML private TextArea t5;
	@FXML private TextField imagenName;

	
	public void siguienteBoton() throws IOException {
		
		this.actualizarDatos();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaMenuPrincipal.fxml"));
    	Parent root = loader.load();
    	ControllerMenuPrincipal controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLineaDeTiempo(linea);
    	controller.setNombreArchivo(this.nombreArchivo);
    	
    	stage.setScene(new Scene(root,1200,640));
    	
	}

	private void actualizarDatos() throws FileNotFoundException, IOException {
		
		String nombre = t1.getText();
		int dia  = Integer.parseInt(  t2.getText() );
		int mes  = Integer.parseInt(  t3.getText() );
		int anio  = Integer.parseInt(  t4.getText() );
		Fecha fecha = new Fecha(anio,mes,dia);
		String descripcion = t5.getText();
		String imagenNombre = imagenName.getText();
		
		Evento evento = new Evento(nombre,fecha,descripcion);	
		if( !  imagenNombre.equals("")) evento.agregarFoto(imagenNombre);
		
		linea.agregarEvento(evento);
					
		archivo.guardar(linea,nombreArchivo+".obj");
				
	}

	public void setLinea(LineaDeTiempo linea) {
		this.linea = linea;	
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;	
	}
	
	public void botonVolver() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaMenuPrincipal.fxml"));
    	Parent root = loader.load();
    	ControllerMenuPrincipal controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLineaDeTiempo(linea);
    	controller.setNombreArchivo(this.nombreArchivo); 	
    	stage.setScene(new Scene(root,1200,640));
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo= nombreArchivo;
	
	}

}
