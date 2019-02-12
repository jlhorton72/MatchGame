/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashSet;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
 *
 * @author jh0375800
 */
public class ControlCircleWithoutEventHandling extends Application{
    // class level variable
    private CirclePane circlePane = new CirclePane();
    @Override
    public void start(Stage primaryStage){
//        StackPane pane = new StackPane();
//        Circle circle = new Circle(50);
//        circle.setStroke(Color.BLACK);
//        circle.setFill(Color.WHITE);
//        pane.getChildren().add(circle);
        
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button ("Enlarge");
        Button btShrink = new Button ("Shrink");
        
        hBox.getChildren().addAll(btEnlarge, btShrink);
        
        // create and register the handler
        btEnlarge.setOnAction(new EnlargeHandler());
        btShrink.setOnAction(new ShrinkHandler());
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    } // end of start
        
    /**
     * This class handles events for our enlarge button
     * it is an inner class
     */
    class EnlargeHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            circlePane.enlarge();
        } // end of handle
    } // end of EnlargeHandler
    
    class ShrinkHandler implements EventHandler<ActionEvent>{
         @Override
        public void handle(ActionEvent e){
            circlePane.shrink();
        } // end of handle
    } // end of ShrinkHandler
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);// TODO code application logic here
    } // end of main
    
} // end of class ControlCircleWithoutEventHandling

class CirclePane extends StackPane {
    // class field
    private Circle circle = new Circle(50);
    
    // constructor for the class
    public CirclePane(){
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    } // end of constructor
    
    public void enlarge(){
        circle.setRadius(circle.getRadius() + 2);
    } // end of method enlarge
    
    public void shrink(){
        circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius());
    } // end of ,ethod shrink
    
} // end of CirclePane class
