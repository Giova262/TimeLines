package controllers;

import java.io.IOException;

import eventos.Evento;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;
import persistencias.ArchivoLineasDeTiempo;

public class ControllerModificarEvento {
	
	private Stage stage;
	private LineaDeTiempo linea;
	private String nombreEvento;
	private int ultimoIndice=0;
	ArchivoLineasDeTiempo archivo = new ArchivoLineasDeTiempo();	
	@FXML private TextField n1,dia,mes,anio,imagen,color;
	@FXML private TextArea nuevaDescp;
	@FXML private Button b1,b2;
	@FXML Label l1;
	private String nombreArchivo;

	
	public void botonConfirmar() {
		int diaNuevo = Integer.parseInt(this.dia.getText());
		int mesNuevo = Integer.parseInt(this.mes.getText());
		int anioNuevo = Integer.parseInt(this.anio.getText());
		String imagenNombre = imagen.getText();
		String colorBoton = color.getText();
		try {
		linea.modificarEvento(nombreEvento,imagenNombre,colorBoton, diaNuevo, mesNuevo, anioNuevo, nuevaDescp.getText());
		
		archivo.guardar(linea,this.nombreArchivo+".obj");
		n1.setText("");
		l1.setText("Se Modifico Correctamente!");
		this.actualizar();
		dia.setDisable(true);
		mes.setDisable(true);
		anio.setDisable(true);
		nuevaDescp.setDisable(true);		
		b2.setVisible(false);			
		imagen.setDisable(true);
		color.setDisable(true);
		
		}catch (Exception e) {
			l1.setText("Ocurrio un error, revise los datos ingresados");
		}
		
	}
	
	public void botonBuscar() {
		Evento evento = linea.buscarEvento(n1.getText());
		if(	evento  != null  ) {
			nombreEvento = n1.getText();
			n1.setDisable(true);
			dia.setDisable(false);
			dia.setText(   Integer.toString(    evento.getFecha().getDia()   )   );
			mes.setDisable(false);
			mes.setText(   Integer.toString(    evento.getFecha().getMes()   )   );
			anio.setDisable(false);
			anio.setText(   Integer.toString(    evento.getFecha().getAnio()   )   );
			nuevaDescp.setDisable(false);
			nuevaDescp.setText(    evento.getDescripcion()    );
			imagen.setVisible(true);
			color.setVisible(true);
			color.setText(evento.getColor());
			imagen.setText(evento.getFoto());
			b1.setVisible(false);
			b2.setVisible(true);
			l1.setText("Se encontro! complete los nuevos datos.");
		}
		else {
			 l1.setText("No se encontro el Evento");
			 
		}
	}
	
	public void botonVolver() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaDelasLineas.fxml"));
    	Parent root = loader.load();
    	
    	ControllerDeLasLineas controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(linea);
    	controller.setNombreArchivo(this.nombreArchivo);
    	controller.setIndice(this.ultimoIndice);
 
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
		
		public void actualizar() {
			n1.setDisable(false);
			b1.setVisible(true);					
			dia.setDisable(false);
			mes.setDisable(false);
			anio.setDisable(false);
			nuevaDescp.setDisable(false);		
			b2.setVisible(true);			
			imagen.setVisible(true);
			color.setVisible(true);
			
		}
		
		public void actualizarDatos() {
			Evento evento = linea.buscarEvento(this.nombreEvento);
			dia.setText(   Integer.toString(    evento.getFecha().getDia()   )   );
			mes.setText(   Integer.toString(    evento.getFecha().getMes()   )   );	
			anio.setText(   Integer.toString(    evento.getFecha().getAnio()   )   );		
			nuevaDescp.setText(    evento.getDescripcion()    );
			color.setText(evento.getColor());
			imagen.setText(evento.getFoto());
		}
		
		public void setNombreArchivo(String nombreArchivo) {
			this.nombreArchivo= nombreArchivo;
		
		}

		public void setNombreObjetivo(String nombre) {
			this.nombreEvento= nombre;
			
		}
		
		public void setUltimoIndice(int i) {
			this.ultimoIndice = i ;
		}

}
