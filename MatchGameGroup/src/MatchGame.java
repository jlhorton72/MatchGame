/*
 * Deveolpers:  Jim Horton, Jay Allen, Michael Wilson
 * Date:        02/28/2019
 * Project:     Create a match game on a board similar to tic tac toe
 * Program:     MatchGame.java
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author jh0375800 &mw0415436@otc.edu & Jay
 */
public class MatchGame extends Application {
    
        // class level vars
    private static int NUM_OF_IMGS = 8;
    int mouseClicks = 0;
    int score = 0;
    int shots = 0;
    int shotCount = 0;
    boolean isAMatch = false;
    private static int IMGS_PER_ROW = 4;
    
    // vars for click events
    private img selected = null;
    private int click = 2;
    Text txt = new Text("");
    //txt.setFont(Font.font ("Arial", 20));
    
    private Pane createBoard() {
        
        VBox imgHolder = new VBox(5);
        imgHolder.setAlignment(Pos.CENTER);
        List<img> images = new ArrayList<>();
        int imgSelector = 0;
        
        for (int lcv = 0; lcv < NUM_OF_IMGS; lcv++){
            images.add(new img(imgSelector));
            images.add(new img(imgSelector));
            if (imgSelector == 8){
                imgSelector = 0;
            } // end of if for reset
            else {
                imgSelector++;
            } // end of else
        } // end of inner for  
        
            // shuffles the colors choosen
        Collections.shuffle(images);
            // sets up each row
        List<HBox> hbxList = new ArrayList<>();
        for (int lcv = 0; lcv < IMGS_PER_ROW; lcv++){
            hbxList.add(new HBox(5));
            hbxList.get(lcv).setAlignment(Pos.CENTER);
        } // end of for loop
        
        int displayCount = 0;
        for (int i = 0; i < hbxList.size(); i++){
            for (int j = 0; j < IMGS_PER_ROW; j++){
                hbxList.get(i).getChildren().add(images.get(displayCount));
                displayCount++;
            } // end of inner for loop
            imgHolder.getChildren().add(hbxList.get(i));
        } // end of loop
        
            // game logic here
        for (img sq : images){
            sq.setOnMouseClicked(e -> {
                if (sq.pics.getOpacity() == 0){
                    if (selected == null){
                        selected = sq;
                        selected.open();
                        mouseClicks++;
                    } //end of if null
                    else if (mouseClicks < 2){
                        sq.open();
                        mouseClicks++;
                        if (mouseClicks == 2){
                            sq.sameImage(selected);
                            if (!isAMatch){
                                shots++;
                                shotCount++;
                                if(shotCount == 3){
                                    score--;
                                    shotCount=0;
                                } // end of if shotcount
                                selected.close();
                                sq.close();
                            } // end of if isAMatch
                            else {
                                score++;
                                shots++;
                                shotCount = 0;
                            } // end of else
                        } // end of 
                        selected = null;
                        sq.Winner();
                    } // end of else if
                } // end of if
            });
        } // end of for loop of game logic
        
        
        return imgHolder;
    } // end of method createBoard
//    // Random numbers
//    Random rand = new Random();
//    // make the list of images
//    public ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
//
//    // method for loading images into an image view
//    public void loadImages() {
//        for (int lcv = 1; lcv <= 18; lcv++) {
//            ImageView imageView = new ImageView("images/image" + lcv + ".jpg");
//            imageViews.add(imageView);
//        } // end of for loop
//    } // end of load images
//
//    //creatiion of array, we will set images from this array
//    public ArrayList<Integer> imgSet = new ArrayList<Integer>();

//    // randomly choose 8 of 18 pics to load into the display
//    public void setImageList() {
//        for (int idx = 0; idx < 8; idx++) {
//            int ranImg = rand.nextInt(17);
//            ranImg++;
//            imgSet.add(ranImg);
//            imgSet.add(ranImg);
//        } // end of for loop
//    } // end of setImages

//    // this method will set the images from the setImageList method onto the pane
//    public int setImageOnScreen() {
//        int index = rand.nextInt(imgSet.size());
//        imgSet.remove(index);
//        return index;
//    } // end of setImageOnScreen
    // randomly choose on of those 8 to be the compare to main image
    // 
    // onclick event for each image compare to the main image

    // Creating a GUI here to place all of our methods and objects
    @Override
    public void start(Stage primaryStage) {
//        // creates a 4x4 grid pane
//        // GridPane pane = new GridPane();
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                pane.add(imageViews.get(setImageOnScreen()), i, j);
//            }
//            //pane.add(new ImageView(imageViews(setImageOnScreen()),[i][j]));// = new ImageView(), j, i);
//        } // end of outer for loop
//
//        // decrelation of stack pane and adding of gridpane to it
//        // should automatcially center with a stack pane
//        StackPane sPane = new StackPane();
//        sPane.getChildren().add(pane);

        // create our scene and place our stackPane into it
        BorderPane bPane = new BorderPane();       
        bPane.setCenter(createBoard());
        bPane.setBottom(txt);
        Scene scene = new Scene(bPane, 450, 450);
        primaryStage.setTitle("MatchGame");
        primaryStage.setScene(scene);
        primaryStage.show();

    } // end of start

    
    //create a new class for adding the images
    private class img extends StackPane {

        // create an array of images to choose from
        FadeTransition ft;

//        private ImageView[] imgs = new ImageView[]{ 
//            for (int lcv = 1; lcv <= 16; lcv++) {
//            ImageView imageView = new ImageView("images/image" + lcv + ".jpg");
//            imgs.add(imageView);
//        } // end of for loop
//        // ImageView.
//        };
            // useing color and rectangles for testing
        private Color[] color = new Color[]{
            Color.AQUA,
            Color.GREEN,
            Color.BLANCHEDALMOND,
            Color.YELLOW,
            Color.DARKCYAN,
            Color.CADETBLUE,
            Color.BLACK,
            Color.OLIVE
        }; // loads color array
        
            
         private Rectangle pics = new Rectangle( 50,50);  // draws grid?
        // Constructor for img class
        public img(int imgSelector) {
            this.setStyle("-fx-border-color: black;");
            pics.setFill(color[imgSelector]);
            setAlignment(Pos.CENTER);
            getChildren().add(pics);
            this.pics.setOpacity(0);
        } // end of img constructor

        private void close() {
            // this uses FadeTransition
            FadeTransition ft = new FadeTransition(Duration.seconds(1), this.pics);
            ft.setToValue(0);
            ft.play();
        } // end of hide

        private void open() {
            this.pics.setOpacity(1);
        } // end of show

        private void Winner() {
            int counter = 4 - score;  // score is  variable
            if (score == 4){
                txt.setFont(Font.font(30));
                txt.setText("You won the game!");
                // System.out.println("You won the game!");
            } // end of if
            
            
        } // end of Winner

        private void sameImage(img chosen) {
            //if statement with else
            if (this.pics.getFill().equals(selected.pics.getFill())) {
                //System.out.println("True");
                isAMatch = true;
                mouseClicks = 0;

            } else {
               // System.out.println("False");
                isAMatch = false;
                mouseClicks = 0;
            }
        } // end of sameImage

    }// end of img class

    // this method runs our program by launching args
    public static void main(String[] args) {
        launch(args);
    } // end of main

} // end of class
