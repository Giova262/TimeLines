package aplicacion;

import controllers.ControllerEleccionDeLinea;
import controllers.ControllerMenuPrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lineasDeTiempo.LineaDeTiempo;
import persistencias.ArchivoLineasDeTiempo;

public class Aplicacion extends Application {

	 public static void main(String[] args) {
	        launch(args);
	    }
	 
    @Override
    public void start(Stage primaryStage) throws Exception{
    	/*
     
    	ArchivoLineasDeTiempo archivo = new ArchivoLineasDeTiempo();	
    	LineaDeTiempo linea ;
    	try {
    		 linea = archivo.recuperar("LineaDeTiempoDatos.obj");
		} catch (Exception e) {
			 linea = new LineaDeTiempo();
		}
  
       //Creo el loader apartir del fxml especifico
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/EscenaMenuPrincipal.fxml"));     
       //Cargo en root el layot del fxml
       Parent root = loader.load();     
       //ahora cargo en un controller el controlador de esa fxml para modificarlo
       ControllerMenuPrincipal controller = loader.getController();     
       //llamo funciones seters del controlador para pasarle parametros
       controller.setStage(primaryStage);
       controller.setLineaDeTiempo(linea);
       //creo la escena poniendole el layout del fxml
        Scene scene = new Scene(root,1200,640);    
        //pongo la escena en el stage
        primaryStage.setTitle("Linea De Tiempo");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    	
    	   FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/EscenaEleccionDeLinea.fxml"));     
           //Cargo en root el layot del fxml
           Parent root = loader.load();     
           //ahora cargo en un controller el controlador de esa fxml para modificarlo
           ControllerEleccionDeLinea controller = loader.getController();     
           //llamo funciones seters del controlador para pasarle parametros
           controller.setStage(primaryStage);
           controller.actualizar();
           //creo la escena poniendole el layout del fxml
            Scene scene = new Scene(root,1200,640);    
            //pongo la escena en el stage
            primaryStage.setTitle("Linea De Tiempo");
            primaryStage.setScene(scene);
            primaryStage.show();
              
    }

}
