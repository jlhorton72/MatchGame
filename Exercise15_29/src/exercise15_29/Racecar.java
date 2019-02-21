/*
 * Name:        James Horton
 * Date:        02/21/2019
 * 
 */
package exercise15_29;

import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Redindianfred
 */
public class Racecar extends Application{
    public double dur = 6000;
    @Override
    public void start(Stage primaryStage){
        
        // add parts of car to a pane
        Pane pane = new Pane();
        BorderPane bPane = new BorderPane();
        Car car = new Car();    
        pane.getChildren().add(car);
        bPane.setCenter(pane);     
        // addfunction to keys

        Text text = new Text(5,5,"");
        
        // Create transition path
        PathTransition pt = new PathTransition(
                Duration.millis(dur), new Line(bPane.getWidth() - 25,
                200, bPane.getWidth() - (bPane.getWidth() - 520), 200),
                car);
        pt.setNode(car);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();               
        Scene scene = new Scene(bPane, 500, 500);
        primaryStage.setTitle("RaceCar");
        primaryStage.setScene(scene);
        primaryStage.show();
         text.requestFocus();
        scene.setOnKeyPressed(e -> {   
            switch (e.getCode()) {
                case DOWN: pt.setRate(pt.getCurrentRate() - .1); break;
                case UP : pt.setRate(pt.getCurrentRate() + .1);break;
                default: pt.pause(); tempStop(); pt.play(); break;
                    // see Listing 15.9 for e.getCode() == KeyCode.UP.....
            } // end of switch        
        }); // end of setonkeypressed       
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); // TODO code application logic here
    } // end of main
    
        // no longer needed
    public double faster(){
        dur = dur + 5;
        System.out.println(dur);
        return dur;
    } // speed up
    
         // no longer needed
    public double slower(){
        dur = dur - 5;
        System.out.println(dur);
        return dur;        
    } // slow down
    
    public void tempStop() {
        try{
            Thread.sleep(750);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        } // end of catch        
    } // end of tempstop
    
    
    class Car extends Pane{
        private double w = 450;
        private double h = 450;
        // build tires
        Circle circle = new Circle(5);
        Circle circle2 = new Circle(5);
        Rectangle rect = new Rectangle(50,15,50,15);
        Rectangle roof = new Rectangle(20,10,20,10);
        
        public Car(){
        circle.setFill(Color.BLACK);
        circle.setCenterX(25);
        circle.setCenterY(200);        
        
        circle2.setFill(Color.BLACK);
        circle2.setCenterX(60);
        circle2.setCenterY(200);
        // build car        
        rect.setFill(Color.RED);
        rect.setStroke(Color.BLACK);
        rect.setX(18);
        rect.setY(180);
        //build roof        
        roof.setFill(Color.AQUA);
        roof.setStroke(Color.BLACK);
        roof.setX(32);
        roof.setY(170);
        
        getChildren().addAll(circle, circle2 ,rect, roof);
        } // end of constructor for car
        
    } // end of Car
    
} // end of class