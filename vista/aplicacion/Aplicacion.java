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
    		
    	   FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/EscenaEleccionDeLinea.fxml"));     
           Parent root = loader.load();     

          ControllerEleccionDeLinea controller = loader.getController();     
          controller.setStage(primaryStage);
          controller.actualizar();
  
           Scene scene = new Scene(root,1200,640);    
           primaryStage.setTitle("Linea De Tiempo");
           primaryStage.setScene(scene);
           primaryStage.show();
              
    }

}
