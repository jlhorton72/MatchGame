/*
 * Name:        James Horton
 * Date:        02/26/2019
 * Program:     button demo
 * Purpose:     demo check boxes
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
/**
 *
 * @author jh0375800
 */
public class lCheckBoxDemo extends ButtonDemo{
    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();      // run the method in the super class
        
        Font fontBoldItalic = Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 20);
        
        Font fontBold = Font.font("Times New Roman", 
                FontWeight.BOLD, FontPosture.REGULAR, 20);
        
        Font fontItalic = Font.font("Times New Roman", 
                FontWeight.NORMAL, FontPosture.ITALIC, 20);
        
        Font fontNormal = Font.font("Times New Roman", 
                FontWeight.NORMAL, FontPosture.REGULAR, 20);
        
        text.setFont(fontNormal);
        // create check boxes
        VBox paneForCheckBoxes = new VBox(20);
        paneForCheckBoxes.setPadding(new Insets(5,5,5,5));
        paneForCheckBoxes.setStyle("-fx-border-color: green");
        
        // set up check boxes
        CheckBox chkBold = new CheckBox("Bold");
        CheckBox chkItalic = new CheckBox("Italic");
        paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
        pane.setRight(paneForCheckBoxes);
        
        // event handlers for checkboxes
        EventHandler<ActionEvent> handler = e -> {
            if (chkBold.isSelected() && chkItalic.isSelected()){
                text.setFont(fontBoldItalic);
            } // end of if
            else if (chkBold.isSelected()){
                text.setFont(fontBold);
            } // end of else if
            else if (chkItalic.isSelected()){
                text.setFont(fontItalic);
            } // end of else if
            else {
                text.setFont(fontNormal);
            } // end of else
        }; // end of eventhandler
        
        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);        
        
        return pane;
    } // end of BorderPane GetPane
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main
    
} // end of class
