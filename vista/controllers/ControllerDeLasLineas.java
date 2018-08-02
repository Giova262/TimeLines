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
			
		/*Mejroar el codigo con algun ciclo for o algo similar muycho codigo repetido*/
		b1.setVisible(false);
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		b5.setVisible(false);
		b6.setVisible(false);
		b7.setVisible(false);
		b8.setVisible(false);
		
		b1.setOnAction(e -> {
			botonMostrarDescripcion(0);
			if (diferenciaBoton ) {
				indiceDos = this.indiceDeCorrido;
				this.calculardiferencia();
				this.diferenciaBoton = false;
			}else 	indiceUno = this.indiceDeCorrido;
		});
		b2.setOnAction(e -> {
			botonMostrarDescripcion(1);
			if (diferenciaBoton ) {
				indiceDos = this.indiceDeCorrido + 1;
				this.calculardiferencia();
				this.diferenciaBoton = false;
			}else 	indiceUno = this.indiceDeCorrido+1;
		});
		b3.setOnAction(e -> {
			botonMostrarDescripcion(2);
			if (diferenciaBoton ) {
				indiceDos = this.indiceDeCorrido+2;
				this.calculardiferencia();
				this.diferenciaBoton = false;
			}else 	indiceUno = this.indiceDeCorrido+2;
		});
		b4.setOnAction(e -> {
			botonMostrarDescripcion(3);
			if (diferenciaBoton ) {
				indiceDos = this.indiceDeCorrido+3;
				this.calculardiferencia();
				this.diferenciaBoton = false;
			}else 	indiceUno = this.indiceDeCorrido+3;
		});
		b5.setOnAction(e -> {
			botonMostrarDescripcion(4);
			if (diferenciaBoton ) {
				indiceDos = this.indiceDeCorrido+4;
				this.calculardiferencia();
				this.diferenciaBoton = false;
			}else 	indiceUno = this.indiceDeCorrido+4;
		});
		b6.setOnAction(e -> {
			botonMostrarDescripcion(5);
			if (diferenciaBoton ) {
				indiceDos = this.indiceDeCorrido+5;
				this.calculardiferencia();
				this.diferenciaBoton = false;
			}else 	indiceUno = this.indiceDeCorrido+5;
		});
		b7.setOnAction(e -> {
			botonMostrarDescripcion(6);
			if (diferenciaBoton ) {
				indiceDos = this.indiceDeCorrido+6;
				this.calculardiferencia();
				this.diferenciaBoton = false;
			}else 	indiceUno = this.indiceDeCorrido+6;
		});
		b8.setOnAction(e -> {
			botonMostrarDescripcion(7);
			if (diferenciaBoton ) {
				indiceDos = this.indiceDeCorrido+7;
				this.calculardiferencia();
				this.diferenciaBoton = false;
			}else 	indiceUno = this.indiceDeCorrido+7;
		});
		
		listaBotones.add(b1);
		listaBotones.add(b2);
		listaBotones.add(b3);
		listaBotones.add(b4);
		listaBotones.add(b5);
		listaBotones.add(b6);
		listaBotones.add(b7);
		listaBotones.add(b8);
			
	}

	public void botonMostrarDescripcion(int indice) {		
		Descripcion.setText(lineaTemporal.get(indice+ this.indiceDeCorrido).getDescripcion() );
		Descripcion.setVisible(true);
		String nombre= lineaTemporal.get(indice+this.indiceDeCorrido).getFoto();
		System.out.println("Nombre de la foto : "+ nombre);
		imagenVie.setImage(new Image("/imagenes/"+nombre));

	}
	
	public void botonVolver() throws IOException {
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("/controllers/EscenaMenuPrincipal.fxml"));
		Parent root = loader.load();
		ControllerMenuPrincipal controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLineaDeTiempo(lineas);
		this.stage.setScene(new Scene(root ,1200,640));
		
	}
	public void botonSiguiente() throws IOException {
		
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("/controllers/EscenaDelasLineas.fxml"));
		Parent root = loader.load();
		ControllerDeLasLineas controller = loader.getController();
    	controller.setStage(stage);
    	controller.setLinea(lineas);
    	controller.setIndice(this.indiceDeCorrido+1);
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
		
		int diferencia = Math.abs(anio2-anio1);
		
		diferenciaLabel.setText("La diferecian entre los dos eventos es : "+ diferencia );
	}

}
