/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
/**
 *
 * @author jh0375800
 */
public class ButtonInPane extends Application {
    @Override
    public void start(Stage primaryStage){
        // create a scene
        FlowPane pane = new FlowPane();
        pane.getChildren().add(new Button("OK"));
        pane.getChildren().add(new Button("Another"));
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("Button in a pane");
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
