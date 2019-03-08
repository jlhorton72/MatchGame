
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

/*
 * Deveolpers:  Jim Horton, Jay Allen, Michael Wilson
 * Date:        02/28/2019
 * Project:     Create a match game on a board similar to tic tac toe
 * Program:     MatchGame.java
 */
/**
 *
 * @author jh0375800 &mw0415436@otc.edu & Jay
 */
public class MatchGame extends Application {

    // Random numbers
    Random rand = new Random();
    // make the list of images
    public ArrayList<ImageView> imageViews = new ArrayList<ImageView>();

    // method for loading images into an image view
    public void loadImages() {
        for (int lcv = 1; lcv <= 18; lcv++) {
            ImageView imageView = new ImageView("images/image" + lcv + ".jpg");
            imageViews.add(imageView);
        } // end of for loop
    } // end of load images

    //creatiion of array, we will set images from this array
    public ArrayList<Integer> imgSet = new ArrayList<Integer>();

    // randomly choose 8 of 18 pics to load into the display
    public void setImageList() {
        for (int idx = 0; idx < 8; idx++) {
            int ranImg = rand.nextInt(17);
            ranImg++;
            imgSet.add(ranImg);
            imgSet.add(ranImg);
        } // end of for loop

    } // end of setImages

    // this method will set the images from the setImageList method onto the pane
    public int setImageOnScreen() {
        int index = rand.nextInt(imgSet.size());
        imgSet.remove(index);
        return index;
    } // end of setImageOnScreen
    // randomly choose on of those 8 to be the compare to main image
    // 
    // onclick event for each image compare to the main image

    // Creating a GUI here to place all of our methods and objects
    @Override
    public void start(Stage primaryStage) {
        // creates a 4x4 grid pane
        GridPane pane = new GridPane();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                pane.add(imageViews.get(setImageOnScreen()), i, j);
            }
            //pane.add(new ImageView(imageViews(setImageOnScreen()),[i][j]));// = new ImageView(), j, i);
        } // end of outer for loop

        // decrelation of stack pane and adding of gridpane to it
        // should automatcially center with a stack pane
        StackPane sPane = new StackPane();
        sPane.getChildren().add(pane);

        // create our scene and place our stackPane into it
        Scene scene = new Scene(sPane, 450, 450);
        primaryStage.setTitle("MatchGame");
        primaryStage.setScene(scene);
        primaryStage.show();

    } // end of start

    //create a new class for adding the images
    private class img extends StackPane {
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
                txt.setText("You won the game!");
                setFont(Font.font(30));
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

        private void setFont(Font font) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }// end of img class

    // this method runs our program by launching args
    public static void main(String[] args) {
        launch(args);
    } // end of main

} // end of class
