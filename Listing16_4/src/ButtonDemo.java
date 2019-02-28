/*
 * Name:        James Horton
 * Date:        02/26/2019
 * Program:     button demo
 * Purpose:     demo some butons
 */
// added for git test

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author jh0375800
 */
public class ButtonDemo extends Application{
    // class level  (instance) variable
    protected Text text = new Text(50, 50, "JavaFX Programming");
    
    protected BorderPane getPane(){
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("Left", 
            new ImageView("Images/leftarrow.png"));
        Button btRight = new Button ("Right", 
            new ImageView("Images/rightarrow.png"));
        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");
        
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);
        
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);
        
        // action events will move text
        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));
        
        return pane;        // return pane to caller
    } // end of BorderPane
    
    @Override
    public void start (Stage primaryStage){
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("ButtonDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); 
    } // end of main
    
} // end of class Button demo
