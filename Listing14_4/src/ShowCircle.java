/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
/**
 *
 * @author jh0375800
 */
public class ShowCircle extends Application{
    @Override
    public void start(Stage primaryStage){
        // create a cricle
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.CADETBLUE);
        circle.setFill(Color.BEIGE);
        
        // create a pane to hold the circle
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        
        // create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Show Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end of start

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);            // TODO code application logic here
    } // end of main
    
} // end of class
