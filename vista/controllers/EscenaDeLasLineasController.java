package controllers;

import java.io.IOException;
import java.util.ArrayList;

import eventos.Evento;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;

public class EscenaDeLasLineasController {
	

	
	private Stage stage;
	private LineaDeTiempo lineas;
	private ArrayList<Evento> lineaTemporal;
	private ArrayList<Button>listaBotones = new ArrayList<Button>(); 
	private ArrayList<Text>listaDeNombres = new ArrayList<Text>(); 
	private ArrayList<Text>listaDeFechas = new ArrayList<Text>(); 
	private  int indiceDeCorrido ;
	@FXML private Text n1,n2,n3,n4,n5,n6,n7,n8;
	@FXML private Button b1,b2,b3,b4,b5,b6,b7,b8;
	@FXML private Text a1,a2,a3,a4,a5,a6,a7,a8;
	@FXML private Text Descripcion;

	
	public void setStage(Stage stage) {
		this.stage = stage;		
	}

	public void setLinea(LineaDeTiempo linea) {
		this.lineas = linea ;	
	}

	public void actualizar() {
		
		this.lineaTemporal = lineas.getLineaDeEventos();						
		llenarBotones();
		llenarNombres();
		llenarFechas();

		if (lineaTemporal.size() <= 9) {
			
				for(int i = 0; i < lineaTemporal.size()-1   ;i++) {	
					listaDeNombres.get(i).setText(lineaTemporal.get(i).getNombre());
					listaDeFechas.get(i).setText(lineaTemporal.get(i).getFechaString() );			
					listaBotones.get(i).setVisible(true);							
				}
				
		}else {

				for(int i =0 ; i < 8  ;i++) {	
					listaDeNombres.get(i).setText(lineaTemporal.get(i+this.indiceDeCorrido).getNombre());
					listaDeFechas.get(i).setText(lineaTemporal.get(i+this.indiceDeCorrido).getFechaString() );			
					listaBotones.get(i).setVisible(true);
				}
			
		}
		
		Descripcion.setVisible(false);
				
	}
	
	private void llenarFechas() {	
		listaDeFechas.add(a1);
		listaDeFechas.add(a2);
		listaDeFechas.add(a3);
		listaDeFechas.add(a4);
		listaDeFechas.add(a5);
		listaDeFechas.add(a6);
		listaDeFechas.add(a7);
		listaDeFechas.add(a8);
			
	}

	private void llenarNombres() {
		listaDeNombres.add(n1);
		listaDeNombres.add(n2);
		listaDeNombres.add(n3);
		listaDeNombres.add(n4);
		listaDeNombres.add(n5);
		listaDeNombres.add(n6);
		listaDeNombres.add(n7);
		listaDeNombres.add(n8);
		
	}

	private void llenarBotones() {
		b1.setVisible(false);
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		b5.setVisible(false);
		b6.setVisible(false);
		b7.setVisible(false);
		b8.setVisible(false);
		
		listaBotones.add(b1);
		listaBotones.add(b2);
		listaBotones.add(b3);
		listaBotones.add(b4);
		listaBotones.add(b5);
		listaBotones.add(b6);
		listaBotones.add(b7);
		listaBotones.add(b8);
			
	}

	public void botonMostrarDescripcion() {		
		Descripcion.setText(lineaTemporal.get(0).getDescripcion() );
		Descripcion.setVisible(true);

	}
	
	public void botonVolver() throws IOException {
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("/controllers/Escena1.fxml"));
		Parent root = loader.load();
		Controller1 controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLineaDeTiempo(lineas);
		this.stage.setScene(new Scene(root ,260, 350));
		
	}
	public void botonSiguiente() throws IOException {
		
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("/controllers/EscenaDelasLineas.fxml"));
		Parent root = loader.load();
		EscenaDeLasLineasController controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(lineas);
    	controller.setIndice(this.indiceDeCorrido+1);
    	controller.actualizar();
   
		this.stage.setScene(new Scene(root,1200,640));
	}
	
	public void botonAnterior() throws IOException {
		
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("/controllers/EscenaDelasLineas.fxml"));
		Parent root = loader.load();
		EscenaDeLasLineasController controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(lineas);
    	controller.setIndice(this.indiceDeCorrido-1);
    	controller.actualizar();
   
		this.stage.setScene(new Scene(root,1200,640));
	}
	
	public void setIndice(int numero) {
		this.indiceDeCorrido = numero;
		if (	this.indiceDeCorrido < 0 ) 	this.indiceDeCorrido = 0 ;
	}

}
