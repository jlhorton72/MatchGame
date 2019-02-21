import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionDemo extends Application {
        // Create a pane 
    StackPane pane = new StackPane();
        // Create a circle
    Circle circle = new Circle(125, 100, 50);
        // Create a rectangle
    Rectangle rectangle = new Rectangle(0, 0, 25, 50);
    
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {    

    rectangle.setFill(Color.ORANGE);    

    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    pane.getChildren().add(rectangle);
    // Add circle and rectangle to the pane
    pane.getChildren().add(circle);          
    
     
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 140, 140);
    primaryStage.setTitle("PathTransitionDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    pane.widthProperty().addListener(ov -> resize());
    pane.heightProperty().addListener(ov -> resize());
    
  } // end of start
  
  private void resize(){
      double length = Math.min(pane.getWidth(), pane.getHeight());
      circle.setRadius(length / 2 - 15);
      rectangle.setWidth(length - 30);
      rectangle.setHeight(length - 30);
  } // end of resize
  
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  } // end of main
} // end of class