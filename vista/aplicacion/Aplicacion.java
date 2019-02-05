package aplicacion;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controllers.ControllerEleccionDeLinea;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
 
/*
public class Aplicacion extends Application {
     
    Circle circle_Red, circle_Green, circle_Blue;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
     
    @Override
    public void start(Stage primaryStage) {
         
        //Create Circles
        circle_Red = new Circle(50.0f, Color.RED);
        circle_Red.setCursor(Cursor.HAND);
        circle_Red.setOnMousePressed(circleOnMousePressedEventHandler);
        circle_Red.setOnMouseDragged(circleOnMouseDraggedEventHandler);
         
        circle_Green = new Circle(50.0f, Color.GREEN);
        circle_Green.setCursor(Cursor.MOVE);
        circle_Green.setCenterX(150);
        circle_Green.setCenterY(150);
        circle_Green.setOnMousePressed(circleOnMousePressedEventHandler);
        circle_Green.setOnMouseDragged(circleOnMouseDraggedEventHandler);
         
        circle_Blue = new Circle(50.0f, Color.BLUE);
        circle_Blue.setCursor(Cursor.CROSSHAIR);
        circle_Blue.setTranslateX(300);
        circle_Blue.setTranslateY(100);
        circle_Blue.setOnMousePressed(circleOnMousePressedEventHandler);
        circle_Blue.setOnMouseDragged(circleOnMouseDraggedEventHandler);
                 
        Group root = new Group();
        root.getChildren().addAll(circle_Red, circle_Green, circle_Blue);
         
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 400,350));
         
        primaryStage.setTitle("java-buddy");
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
     
    EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
        	System.out.println(t.getSceneX());
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
            orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
        }
    };
    
    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
        new EventHandler<MouseEvent>() {
 
    	@Override
        public void handle(MouseEvent t) {
        	System.out.println(t.getSceneX());
        	System.out.println(t.getSceneY());
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
             
            ((Circle)(t.getSource())).setTranslateX(newTranslateX);
            ((Circle)(t.getSource())).setTranslateY(newTranslateY);
        }
    };
}*/

public class Aplicacion extends Application {

	 public static void main(String[] args) {
	        launch(args);
	    }
	 
	 
    @Override
    public void start(Stage primaryStage) throws Exception{
    		
    	primaryStage.setTitle("Linea de Tiempo");
    	primaryStage.getIcons().add(new Image("file:vista/imagenes/icono.png"));
    	
    	  FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/EscenaEleccionDeLinea.fxml"));     
          Parent root = loader.load();     

          ControllerEleccionDeLinea controller = loader.getController();     
          controller.setStage(primaryStage);
          controller.actualizar();    	
          
          Scene scene = new Scene(root,600,550);    
          scene.getStylesheets().add("Estilos.css");
          
          primaryStage.setTitle("Linea De Tiempo");
          primaryStage.setScene(scene);
          primaryStage.show();
              
    }

}
