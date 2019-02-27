/*
 * Name:        James Horton
 * Date:        02/28/2019
 * Program:     Textfield Demo
 * Purpose:     Write a program that sets the horizontal-alignment 
 *              and column-size properties of a text field dynamically,
 *              as shown in Figure 16.38a
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jh0375800
 */
public class TextfieldDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        TextField tfText = new TextField();
        TextField tfColSize = new TextField();
        
        tfText.setAlignment(Pos.BOTTOM_RIGHT);
        tfColSize.setAlignment(Pos.BOTTOM_RIGHT);
        
        tfText.setPrefColumnCount(13);
        tfColSize.setPrefColumnCount(3);
        
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Label("Text Field"), tfText);
        
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");
        
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbRight.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        
        
        HBox hBoxBtn = new HBox(5);
        hBoxBtn.setAlignment(Pos.CENTER);
        hBoxBtn.getChildren().addAll(rbLeft, rbCenter, rbRight);
        
        HBox hBoxCol = new HBox(5);
        hBoxCol.getChildren().addAll(new Label("Column Size"), tfColSize);
        
        HBox hBoxBoth = new HBox(15);
        hBoxBoth.setAlignment(Pos.CENTER);
        hBoxBoth.getChildren().addAll(hBoxBtn, hBoxCol);
        
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox, hBoxBoth);
        
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("TextFieldDemo");
        primaryStage.setScene(scene);
        primaryStage.show();    
         
        tfColSize.setOnAction(e -> {
            tfText.setPrefColumnCount(
                Integer.parseInt(tfColSize.getText()));
        });
                
        rbLeft.setOnAction(e -> tfText.setAlignment(Pos.BASELINE_LEFT));
        rbCenter.setOnAction(e -> tfText.setAlignment(Pos.BASELINE_CENTER));
        rbRight.setOnAction(e -> tfText.setAlignment(Pos.BASELINE_RIGHT));
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main
    
} // end of class
