/*
 * Name:            James Horton
 * Date:            01/31/2019
 * Assignment:      Class practice
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 *
 * @author jh0375800
 */
public class MyJavaFX extends Application {
    @Override
    public void start(Stage primaryStage){
        Button btOK = new Button("OK");         // this node is a button
        
        Scene scene = new Scene(btOK, 200, 250);
        
        primaryStage.setTitle("MyJavaFX");      // title of our window
        primaryStage.setScene(scene);           // set up our scene
        primaryStage.show();                    // display the stage
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // netbeans needs something here to display the above code
        launch(args);
    } // end of main
    
} // end of class MyJavaFX
