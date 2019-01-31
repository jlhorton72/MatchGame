/*
 * Name:            James Horton
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 *
 * @author jh0375800
 */
public class MultipleStageDemo extends Application{
    @Override 
    public void start(Stage primaryStage){
        // create a scene and place button in scene
        Scene scene = new Scene(new Button("OK"), 200, 250);        // button is anonymous this way
        primaryStage.setTitle("MyJavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Stage stage = new Stage();
        stage.setTitle("Second Stage");
        // set a scnen with a button in the stage
        stage.setScene(new Scene(new Button("New Stage"), 200, 250));
        stage.show();
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        // TODO code application logic here
    }
    
}
