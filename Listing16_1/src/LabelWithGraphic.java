/*
 * Name:        James Horotn
 * Date:        02/21/2019
 * Program:     label with graphic
 * Purpose:     format a GUI with a label
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author jh0375800
 */
public class LabelWithGraphic extends Application{
    /**
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage){
        ImageView us = new ImageView(new Image("Images/us.gif"));
        Label lbl = new Label("US\n50 States", us);
        lbl.setStyle("-fx-border-color: green; -fx-border-width: 2");
        lbl.setContentDisplay(ContentDisplay.BOTTOM);
        lbl.setTextFill(Color.RED);
        
        Label lb2 = new Label("Circle", new Circle (50, 50, 25));
        lb2.setContentDisplay(ContentDisplay.TOP);
        lb2.setTextFill(Color.ORANGE);
        
        Label lb3 = new Label("Rectangle", new Rectangle(10, 10, 50, 25));
        lb3.setContentDisplay(ContentDisplay.RIGHT);
        
        Label lb4 = new Label("Ellipse", new Ellipse(50, 50, 50, 25));
        lb4.setContentDisplay(ContentDisplay.LEFT);
        
        Ellipse ellipse = new Ellipse(50, 50, 50, 25);
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.WHITE);
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, new Label("JavaFX"));
        
        Label lb5 = new Label("A pane inside a label", stackPane);
        lb5.setContentDisplay(ContentDisplay.BOTTOM);
        
        HBox pane = new HBox(20);
        pane.getChildren().addAll(lbl,lb2,lb3,lb4,lb5);
        
        Scene scene = new Scene(pane, 450, 150);
        primaryStage.setTitle("LabelWithGraphic ");
        primaryStage.setScene(scene);
        primaryStage.show();       
        
    } // end of start
    /**
     * This method launches the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main
    
} // end of class LabelWithGraphic
