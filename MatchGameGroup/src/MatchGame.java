
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * Deveolpers:  Jim Horton, Jay Allen, Michael Wilson
 * Date:        02/28/2019
 * Project:     Create a match game on a board similar to tic tac toe
 * Program:     MatchGame.java
 */

/**
 *
 * @author jh0375800
 */
public class MatchGame extends Application{
        // indicates which players turn
    private String whoseTurn = "Player 1";
    
        // create the 4 by 4 grid
    private Cell[][] cell = new Cell[4][4];
    
        // create status label
    private Label lblStatus = new Label ("Player 1's turn");
    
        // make the list of images
    public void loadImages(){
    //private ImageView[] ImageViews = new ImageView;
        ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
        for ( int lcv = 1; lcv <= 18; lcv++ ){
            ImageView imageView = new ImageView("images/image" + lcv + ".jpg");
            imageViews.add(imageView);
        } // end of for loop
    } // end of load images
    
    // randomly choose 16 of 18 pics to load into the display
        // this should be a new arraylist??
        // this may be called arraylist imageDisplayNum
    
    // randomly choose on of those 16 to be the compare to main image
        // 
    // onclick event for each image compare to the main image
    
    
    @Override
    public void start(Stage primaryStage){
         GridPane pane = new GridPane(); 
    for (int i = 0; i < 4; i++){
      for (int j = 0; j < 4; j++)
        pane.add(cell[i][j] = new Cell(), j, i);
    } // end of outer for loop
    
    BorderPane bPane = new BorderPane();
    bPane.setCenter(pane);
    bPane.setBottom(lblStatus);
    
    Scene scene = new Scene(bPane, 450, 450);
    primaryStage.setTitle("MatchGame");
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
