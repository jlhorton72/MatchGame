/*
 * Name:        James Horton
 * Date:        02/05/2019
 * File:        ShowCircleCentered.java
 */
        // missing from her code is the package listing 14_5

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.Scene;

/**
 *
 * @author jh0375800
 */
public class ShowCircleCentered extends Application{
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        
        Circle circle = new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.AZURE);
        circle.setFill(Color.AQUAMARINE);
        
        pane.getChildren().add(circle);     // adds circle to pane
        
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("ShowCircleCentered");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main
    
} // end of class
