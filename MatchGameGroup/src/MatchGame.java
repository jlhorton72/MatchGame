
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
// import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.image.Image;

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
    //private Cell[][] cell = new Cell[4][4];
    
        // create status label
    private Label lblStatus = new Label ("Player 1's turn");
    
        // Random numbers
    Random rand = new Random();
        // make the list of images
    public ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
    public void loadImages(){           
        for ( int lcv = 1; lcv <= 18; lcv++ ){
            ImageView imageView = new ImageView("images/image" + lcv + ".jpg");
            imageViews.add(imageView);
        } // end of for loop
    } // end of load images
    
    public ArrayList<Integer> imgSet = new ArrayList<Integer>();
    // randomly choose 8 of 18 pics to load into the display
    public void setImageList(){
        for (int idx = 0; idx < 8; idx++){
            int ranImg = rand.nextInt(17);
            ranImg ++;
            imgSet.add(ranImg);
            imgSet.add(ranImg);
        } // end of for loop
        
        
    } // end of setImages
  
    public int setImageOnScreen(){
        int index = rand.nextInt(imgSet.size());
        imgSet.remove(index);
        return index;        
    } // end of setImageOnScreen
    // randomly choose on of those 8 to be the compare to main image
        // 
    // onclick event for each image compare to the main image
    
    
    @Override
    public void start(Stage primaryStage){
         GridPane pane = new GridPane(); 
    for (int i = 0; i < 4; i++){
      for (int j = 0; j < 4; j++)
        pane.add(imageViews.get(setImageOnScreen()), i, j);
        //pane.add(new ImageView(imageViews(setImageOnScreen()),[i][j]));// = new ImageView(), j, i);
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
