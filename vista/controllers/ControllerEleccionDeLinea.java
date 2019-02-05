package controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;

import persistencias.ArchivoLineasDeTiempo;

public class ControllerEleccionDeLinea {
	
	private Stage stage;
	private boolean nuevo;
	private LineaDeTiempo linea;
	private ArchivoLineasDeTiempo archivo = new ArchivoLineasDeTiempo();	
	private String nombreArchivo;
	@FXML private TextField t1;
	@FXML private Label l1,l2;
	@FXML private Button b1;
	
	
	public void setStage( Stage stage) {
		this.stage = stage;
	}
	
	public void botonNuevoProyecto() {
		linea = new LineaDeTiempo();
		
		this.nuevo = true;
		t1.setDisable(false);
		t1.setText("");
		l2.setText("Escribe nombre de la mueva linea");
		l1.setText("");
		b1.setDisable(false);
		
	}
	
	public void botonContinuarProyecto() {
		t1.setDisable(false);
		this.nuevo=false;
		l2.setText("Escribe el nombre del proyecto a cargar");
		l1.setText("");
		b1.setDisable(false);
		
	}
	
	public void botonSalir() {
		
		this.stage.close();
	}
	
	 public void handleBton(ActionEvent e) {
	        try {
	            Desktop.getDesktop().browse(new URI("http://www.google.com"));
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        } catch (URISyntaxException e1) {
	            e1.printStackTrace();
	        }
	 }
	    
	
	public int botonConfirmar() throws IOException {
		this.nombreArchivo = t1.getText();
	
		try {
			if (!this.nuevo)  this.linea = archivo.recuperar(this.nombreArchivo+".obj");
		} catch (Exception e) {		
			this.actualizar();
			l2.setText("No existe ese nombre de archivo");
			return 1;
		}
	
		Stage stage1 = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaMenuPrincipal.fxml"));
		Parent root = loader.load();
		ControllerMenuPrincipal controller = loader.getController();
		controller.setStage(stage1);
		controller.setLineaDeTiempo(linea);
		controller.setNombreArchivo(this.nombreArchivo);
		stage1.setScene(new Scene(root,1200,640));
		stage1.show();
		//this.stage.setScene(new Scene(root,1200,640));
		return 0;
	}
	
	public void actualizar() {
		Button nuevo = new Button();
		nuevo.setScaleX(100);
	
		t1.setDisable(true);
		t1.setText("Biblia");
		l1.setText("");
		l2.setText("");
		b1.setDisable(true);
		b1.setOnMousePressed(circleOnMousePressedEventHandler);
		
               
	}
	
    EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
            new EventHandler<MouseEvent>() {
     
            @Override
            public void handle(MouseEvent t) {
            	System.out.println(t.getSceneX());
              /*  orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
                orgTranslateY = ((Circle)(t.getSource())).getTranslateY();*/
            }
        };
        
        EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
            new EventHandler<MouseEvent>() {
     
        	@Override
            public void handle(MouseEvent t) {
            	System.out.println(t.getSceneX());
            	System.out.println(t.getSceneY());
            /*    double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;
                 
                ((Circle)(t.getSource())).setTranslateX(newTranslateX);
                ((Circle)(t.getSource())).setTranslateY(newTranslateY);*/
            }
        };
	

}
