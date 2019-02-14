
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/*
 * Name:        James Horton
 * Date:        02/14/2019
 * 
 */

/**
 *
 * @author jh0375800
 */
public class LambdaHandlerDemo extends Application{
    @Override
    public void start(Stage primaryStage){
        // variables
        Text text = new Text(40, 40, "Programming is Fun!!");
        Pane pane = new Pane(text);
        
        // HBox for 4 buttons
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        HBox hBox = new HBox(btUp, btDown, btLeft, btRight);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        
        BorderPane borderPane = new BorderPane(pane);
        borderPane.setBottom(hBox);
        
        // create and register up handler
        btUp.setOnAction((ActionEvent e) -> {
                text.setY(text.getY() > 10 ? text.getY() - 5 : 10);
        }); // end of handle
        
        // create and register down handler
        btDown.setOnAction(e -> {
                text.setY(text.getY() < pane.getHeight() ? text.getY() + 5 : pane.getHeight());
        });  // end of handle
       
        // create and register left handler
        btLeft.setOnAction(e -> {
                // text.setX(text.getX() > 0 ? text.getX() - 5 : 0);
                // alternative either above or below....
                double newX;
                if(text.getX() > 0){
                    newX = text.getX() - 5;
                } // end of if
                else
                    newX = 0;
                text.setX(newX);
           
        });  // end of handle
        
            // this is an inner class event handler
            // create and register left handler
        btRight.setOnAction(e -> {
                text.setX(text.getX() < pane.getWidth() - 100
                        ? text.getX() + 5 : pane.getWidth() - 100);       
        }); // end of handle
        
        
        
        
        Scene scene = new Scene(borderPane, 400, 350);
        primaryStage.setTitle("AnonymousHandlerDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);// TODO code application logic here
    } // end of main
    
} // end of class