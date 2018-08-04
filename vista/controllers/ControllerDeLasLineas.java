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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;

public class ControllerDeLasLineas {

	private Stage stage;
	private LineaDeTiempo lineas;
	private String nombreArchivo;
	private ArrayList<Evento> lineaTemporal;
	private ArrayList<Button>listaBotones = new ArrayList<Button>(); 
	private ArrayList<Text>listaDeNombres = new ArrayList<Text>(); 
	private ArrayList<Text>listaDeFechas = new ArrayList<Text>(); 
	private  int indiceDeCorrido ;
	private int indiceUno,indiceDos;
	private boolean diferenciaBoton;
	@FXML private Text n1,n2,n3,n4,n5,n6,n7,n8;
	@FXML private Button b1,b2,b3,b4,b5,b6,b7,b8;
	@FXML private Text a1,a2,a3,a4,a5,a6,a7,a8;
	@FXML private Text Descripcion;
	@FXML private ImageView imagenVie;
	@FXML private Label diferenciaLabel;
	
	
	public void setStage(Stage stage) {
		this.stage = stage;		
	}

	public void setLinea(LineaDeTiempo linea) {
		this.lineas = linea ;	
	}

	public void actualizar() {	
	
		this.lineaTemporal = lineas.getLineaDeEventos();	
		
		diferenciaLabel.setText("");
		diferenciaBoton = false;
		llenarBotones();
		llenarNombres();
		llenarFechas();
		
		for(int i =0 ; i <  (lineaTemporal.size() - indiceDeCorrido) && i < 8 ;i++) {	
			listaDeNombres.get(i).setText(lineaTemporal.get(i+this.indiceDeCorrido).getNombre());
			listaDeFechas.get(i).setText(lineaTemporal.get(i+this.indiceDeCorrido).getFechaString() );			
			listaBotones.get(i).setVisible(true);
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
		listaBotones.add(0,b1);
		listaBotones.add(1,b2);
		listaBotones.add(2,b3);
		listaBotones.add(3,b4);
		listaBotones.add(4,b5);
		listaBotones.add(5,b6);
		listaBotones.add(6,b7);
		listaBotones.add(7,b8);
		
 		for(int i=0 ;i< 8;i++) 	listaBotones.get(i).setVisible(false);
 				
 		b1.setOnAction(e -> { this.botonesEventos(0);} );
 		b2.setOnAction(e -> { this.botonesEventos(1);} );
 		b3.setOnAction(e -> { this.botonesEventos(2);} );
 		b4.setOnAction(e -> { this.botonesEventos(3);} );
 		b5.setOnAction(e -> { this.botonesEventos(4);} );
 		b6.setOnAction(e -> { this.botonesEventos(5);} );
 		b7.setOnAction(e -> { this.botonesEventos(6);} );
 		b8.setOnAction(e -> { this.botonesEventos(7);} );
				
	}
	private void botonesEventos (int indice) {
		botonMostrarDescripcion(indice);
		if (diferenciaBoton ) {
			indiceDos = this.indiceDeCorrido+indice;
			this.calculardiferencia();
			this.diferenciaBoton = false;
		}else 	indiceUno = this.indiceDeCorrido+indice;
	}

	public void botonMostrarDescripcion(int indice) {		
		Descripcion.setText(lineaTemporal.get(indice+ this.indiceDeCorrido).getDescripcion() );
		Descripcion.setVisible(true);
		String nombre= lineaTemporal.get(indice+this.indiceDeCorrido).getFoto();
		imagenVie.setImage(new Image("/imagenes/"+nombre));

	}
	
	public void botonVolver() throws IOException {
		
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("/controllers/EscenaMenuPrincipal.fxml"));
		Parent root = loader.load();
		ControllerMenuPrincipal controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLineaDeTiempo(lineas);
    	controller.setNombreArchivo(this.nombreArchivo);
    	
		this.stage.setScene(new Scene(root ,1200,640));
		
	}
	public void botonSiguiente() throws IOException {
		
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("/controllers/EscenaDelasLineas.fxml"));
		Parent root = loader.load();
		ControllerDeLasLineas controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(lineas);
    	controller.setIndice(this.indiceDeCorrido+1);
    	controller.setNombreArchivo(this.nombreArchivo);
    	controller.actualizar();
   
		this.stage.setScene(new Scene(root,1200,640));
	}
	
	public void botonAnterior() throws IOException {
		
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("/controllers/EscenaDelasLineas.fxml"));
		Parent root = loader.load();
		ControllerDeLasLineas controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(lineas);
    	controller.setIndice(this.indiceDeCorrido-1);
    	controller.setNombreArchivo(this.nombreArchivo);
    	controller.actualizar();
   
		this.stage.setScene(new Scene(root,1200,640));
	}
	
	public void setIndice(int numero) {
		
		this.lineaTemporal = lineas.getLineaDeEventos();		
		this.indiceDeCorrido = numero;
		
		if (	this.indiceDeCorrido < 0 ) 	this.indiceDeCorrido = 0 ;
		if (this.indiceDeCorrido >= lineaTemporal.size() ) 	 this.indiceDeCorrido = lineaTemporal.size() -1 ;
		
	}
	
	public void diferenciaBotton() {
		this.diferenciaBoton = true;
		
	}
	private void calculardiferencia() {
		
		this.lineaTemporal = lineas.getLineaDeEventos();	
		
		int anio2 = lineaTemporal.get(indiceDos).getFecha().getAnio();
		int anio1 = lineaTemporal.get(indiceUno).getFecha().getAnio();		
		int mes2 = lineaTemporal.get(indiceDos).getFecha().getMes();
		int mes1 = lineaTemporal.get(indiceUno).getFecha().getMes();	
		int dia2 = lineaTemporal.get(indiceDos).getFecha().getDia();
		int dia1 = lineaTemporal.get(indiceUno).getFecha().getDia();
		
		 int aniosTotales=0,mesesTotales=0;
		 int cantidadDiasDiferencia;
		 int cantidadDias1=0 ,cantidadDias2=0;
		 
		 for(int i =0 ; i < mes1 -1 ; i++) 	 cantidadDias1 = cantidadDias1 + 30 ;
		 cantidadDias1 = cantidadDias1 + dia1 ;
		 
		 for(int i =0 ; i < mes2 -1 ; i++) 	 cantidadDias2 = cantidadDias2 + 30 ;
		 cantidadDias2 = cantidadDias2 + dia2;
		 
		 if(  anio2 > anio1 )	 cantidadDiasDiferencia = ( 365* (anio2 -anio1) ) + ( cantidadDias2-cantidadDias1 );	 
		 else 	 cantidadDiasDiferencia = ( 365*( anio1 -anio2  ) ) + ( cantidadDias1-cantidadDias2 );
		 		
		 cantidadDiasDiferencia = Math.abs(cantidadDiasDiferencia);
		 
		 boolean condicion = true;
		 
		 while(condicion) {
			 cantidadDiasDiferencia = cantidadDiasDiferencia - 365 ;
			 if (cantidadDiasDiferencia > 0) aniosTotales =aniosTotales+1;
			 else {
				 cantidadDiasDiferencia=cantidadDiasDiferencia+365;
				 condicion = false;
			 }
		 }
		 
		 condicion = true;
		 
		 while(condicion) {
			 cantidadDiasDiferencia = cantidadDiasDiferencia - 30 ;
			 if (cantidadDiasDiferencia > 0) mesesTotales =mesesTotales+1;
			 else {
				 if(mesesTotales > 11) {
					 aniosTotales = aniosTotales +1 ;
					 mesesTotales = mesesTotales - 12 ;
				 }
				 cantidadDiasDiferencia=cantidadDiasDiferencia+30;
				 condicion = false;
			 }
		 }
		 	
		diferenciaLabel.setText("Diferencia Aproximada : "+ aniosTotales+" años "+
		mesesTotales+" meses "+ cantidadDiasDiferencia + " dias");
	}
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo= nombreArchivo;
	
	}

}
