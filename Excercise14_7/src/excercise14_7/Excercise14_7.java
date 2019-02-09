/*
 * Name:            James Horton
 * Date:            02/05/2019
 * Assignment:      Excercise 14_7 Random 0 or 1 in 10 x 10 grid
 * File:            Excercise14_7.java
 */
package excercise14_7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Redindianfred
 */
public class Excercise14_7 extends Application{
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        int offsetX = 50;
        int offsetY = 50;
        
        Group group = new Group();        
        
        for (int lcv2 = 0; lcv2 < 10; lcv2 ++){
            for (int lcv = 0; lcv < 10; lcv++){
                int num = (int)Math.round(Math.random());
                String num1 = Integer.toString(num);
                
                Text text = new Text();
                text.setFont(Font.font("Times", FontPosture.REGULAR, 10));
                text.setFill(Color.BLUEVIOLET);
                text.setText(num1);
                text.setTextAlignment(TextAlignment.CENTER);
                Rectangle r = new Rectangle (50+ (lcv * offsetX), 50 + (lcv2 * offsetY) , 50, 50);
                r.setStroke(Color.BLACK);
                r.setFill(Color.WHITE);                
                pane.getChildren().addAll(r, text);

            } // end of for loop for a row of rectangles
        } // end of lcv 2
        
        
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("ShowText"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main
    
} // end of class


/* 14.7 (Display random 0 or 1) Write a program that displays a 10-by-10 
 * square matrix, as shown in Figure 14.45a. Each element in the matrix 
 * is 0 or 1, randomly generated. Display each number centered in a text 
 * field. Use TextField's setText method to set value 0 or 1 as a string.
 */