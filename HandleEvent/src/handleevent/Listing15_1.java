/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handleevent;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author jh0375800
 */
public class Listing15_1  extends Application{
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        
        Button btOK = new Button("OK");
        OKHandlerClass handleOK = new OKHandlerClass();
        btOK.setOnAction(handleOK);
        Button btCancel = new Button("Cancel");
        CancelHandlerClass handleCancel = new CancelHandlerClass();
        btCancel.setOnAction(handleCancel);
        
        pane.getChildren().addAll(btOK, btCancel);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("HandleEvent");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    } // end of start
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main
    
} // end of Listin15_1 class

class OKHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e){
        System.out.println("OK button was clicked");
    } // end of handle
} // end of OKHandlerClass

class CancelHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        System.out.println("Cancel button clicked");
    } // end of handle
} // end of CancelHandlerClass