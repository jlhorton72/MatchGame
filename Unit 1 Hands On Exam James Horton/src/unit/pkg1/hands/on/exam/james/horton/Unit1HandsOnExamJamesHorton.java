/*
 * Name:        James Horton
 * Date:        02/12/2019
 * Assignment:  Unit 1 Hand On Exam  -- HangMan
 */
package unit.pkg1.hands.on.exam.james.horton;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
/**
 *
 * @author Redindianfred
 */
public class Unit1HandsOnExamJamesHorton extends Application {
    public void start(Stage primaryStage){
            // Create the arc for the base of hangman
        Arc arc = new Arc(200, 450, 125, 40, 0, 180);
        arc.setFill(Color.GREEN);
        arc.setType(ArcType.OPEN);
        arc.setStroke(Color.BLUE);
        
            // Create the riser line 
        Line line = new Line(200,410,200,050);
        line.setStrokeWidth(2.5);
        line.setStroke(Color.BLUE);
        
            // Create the cross arm from which to hang
        Line cross = new Line(200,050,325,050);
        cross.setStrokeWidth(2.5);
        cross.setStroke(Color.BLUE);
        
            // Create the rope from which to hang
        Line drop = new Line(325,050,325,100);
        drop.setStrokeWidth(2.5);
        drop.setStroke(Color.BLUE);
        
            // Create the head
        Circle circle = new Circle();
        circle.setRadius(30);
        circle.setCenterX(325);
        circle.setCenterY(130);
        circle.setStroke(Color.PURPLE);
        circle.setFill(Color.WHITESMOKE);
        
            // Creates the body
        Line body = new Line(325,160,325,260);
        body.setStrokeWidth(2.5);
        body.setStroke(Color.PURPLE);
        
            // Creates the left leg
        Line lLeg = new Line(325,260,290,350);
        lLeg.setStrokeWidth(2.5);
        lLeg.setStroke(Color.PURPLE);
        
            // Creates the right leg
        Line rLeg = new Line(325,260,360,350);
        rLeg.setStrokeWidth(2.5);
        rLeg.setStroke(Color.PURPLE);
        
                // Creates the left arm
        Line lArm = new Line(325,180,290,250);
        lArm.setStrokeWidth(2.5);
        lArm.setStroke(Color.PURPLE);
        
            // Creates the right arm
        Line rArm = new Line(325,180,360,250);
        rArm.setStrokeWidth(2.5);
        rArm.setStroke(Color.PURPLE);
        
            // Adds all shapes to the pane
        Group group = new Group();
        group.getChildren().addAll(arc, line, cross, drop, circle,
                body, lLeg, rLeg, rArm, lArm);
              
                // Sets and displays scene and stage
        Scene scene = new Scene(new Pane(group), 500, 500);
        primaryStage.setTitle("HangMan");
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
