/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
/**
 *
 * @author jh0375800
 */
public class FontDemo extends Application{
    public void start(Stage primaryStage){
        Pane pane = new StackPane();
        
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setStroke(Color.BURLYWOOD);
        circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
        // pane.getChildren().add(circle);
        
        // create a label
        Label label = new Label("JavaFX");
        label.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 20));
        pane.getChildren().addAll(circle, label);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("FontDemo");
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
