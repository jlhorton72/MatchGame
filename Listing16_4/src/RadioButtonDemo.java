/*
 * Name:        James Horton
 * Date:        02/26/2019
 * Program:     button demo
 * Purpose:     radio buttons demo
 */
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 *
 * @author jh0375800
 */
public class RadioButtonDemo extends lCheckBoxDemo{
    @Override
    protected BorderPane getPane(){
        BorderPane pane = super.getPane();
        
        VBox paneForRadioButtons = new VBox(20);
        paneForRadioButtons.setPadding(new Insets(5,5,5,5));
        paneForRadioButtons.setStyle
            ("-fx-border-width: 2px; -fx-border-color: green");
        
        // create the radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");
        paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);
        pane.setLeft(paneForRadioButtons);
        
        // create a toggle group - radio button group
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);
        
        
        // set up action events
        rbRed.setOnAction(e -> {
            if(rbRed.isSelected()){
                System.out.println("Action event for red");
                text.setFill(Color.RED);
            } // end of if
        }); // end of rbRed action event
        
        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected()){
                System.out.println("Action event for green");
                text.setFill(Color.GREEN);
            } // end of if
        }); // end of rbGreen action event
        
        rbBlue.setOnAction(e -> {
            if(rbBlue.isSelected()){
                System.out.println("Action event for blue");
                text.setFill(Color.BLUE);
            } // end of if
        }); // end of rbBlue action event 
        
        return pane;
    } // end of getPane
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main
    
} // end of class
