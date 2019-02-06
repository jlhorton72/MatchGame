/*
 * Name:        James Horton
 * Date:        02/05/2019
 * Assignment:  GUI Info Displayed 
 */
package gui_informationaldisplay;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 *
 * @author Redindianfred
 */
public class GUI_InformationalDisplay extends Application{
    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER); 
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5); 
        pane.setVgap(5.5); 
    
        
        pane.add(new Button("OK"), 1, 2);
        Image image = new Image("images/rubberDuck.jpg");
        ImageView imageView = new ImageView(image);
        pane.getChildren().add(imageView);
        Label label = new Label("What would you like to know about James Horton?");
        label.setFont(Font.font("Times New Roman", 
            FontWeight.BOLD, FontPosture.ITALIC, 20));
        pane.add(label, 0, 1);
        pane.add(new TextField(), 1, 1);
        
        
        
        Scene scene = new Scene(pane, 750, 750);
        primaryStage.setTitle("This be Me"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
        
        
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main
    
} // end of class
