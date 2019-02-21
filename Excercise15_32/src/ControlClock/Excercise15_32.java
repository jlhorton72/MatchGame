/*
 * Name:        James Horton
 * Date:        02/21/2019
 * Purpose:     Build and animate a clock
 * Program:     Excercise15_32 / ControlClock
 */
package ControlClock;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * this will create a clock and allow start and stop of the clock
 * @author jh0375800
 */
public class Excercise15_32 extends Application {

    public void start(Stage primaryStage) {
            // create hbox for buttons
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setAlignment(Pos.CENTER);   
        
            // create stop and start button
        Button btStart = new Button("Start");
        Button btStop = new Button("Stop");
        
            // add buttons to bhox
        hBox.getChildren().addAll(btStart, btStop);
        
            // create the instance of the clock
        ClockPane clock = new ClockPane();
        
            // create a pane for the clock and the buttons
        BorderPane pane = new BorderPane();
        
            // add hbox and clock to borderpane
        pane.setBottom(hBox);
        pane.setCenter(clock);
        
            // add animation to this clock so it runs
        EventHandler<ActionEvent> eventHandler = e -> {
          clock.setCurrentTime(); // Set a new clock time
        };  // this is right from book

        Timeline animation = new Timeline(
        new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Starts animation and right from book
        
            // add functionality to buttons to start/stop the clock
        btStart.setOnAction(e -> {
            animation.play();
        });
        
        btStop.setOnAction(e -> {
            animation.pause();
        });
        
            // set scene and display
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    } // end of start

    /**
     * this is the main to launch the args from start
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main
    
    /**
     * The below code is from Listing 14.21
     * It displays the clock with the current time
     */
    public class ClockPane extends Pane {

        private int hour;
        private int minute;
        private int second;

        /**
         * Construct a default clock with the current time
         */
        public ClockPane() {
            setCurrentTime();
        }

        /**
         * Construct a clock with specified hour, minute, and second
         */
        public ClockPane(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        /**
         * Return hour
         */
        public int getHour() {
            return hour;
        }

        /**
         * Set a new hour
         */
        public void setHour(int hour) {
            this.hour = hour;
            paintClock();
        }

        /**
         * Return minute
         */
        public int getMinute() {
            return minute;
        }

        /**
         * Set a new minute
         */
        public void setMinute(int minute) {
            this.minute = minute;
            paintClock();
        }

        /**
         * Return second
         */
        public int getSecond() {
            return second;
        }

        /**
         * Set a new second
         */
        public void setSecond(int second) {
            this.second = second;
            paintClock();
        }

        /* Set the current time for the clock */
        public void setCurrentTime() {
            // Construct a calendar for the current date and time
            Calendar calendar = new GregorianCalendar();

            // Set current hour, minute and second
            this.hour = calendar.get(Calendar.HOUR_OF_DAY);
            this.minute = calendar.get(Calendar.MINUTE);
            this.second = calendar.get(Calendar.SECOND);

            paintClock(); // Repaint the clock
        }

        /**
         * Paint the clock
         */
        private void paintClock() {
            // Initialize clock parameters
            double clockRadius
                    = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
            double centerX = getWidth() / 2;
            double centerY = getHeight() / 2;

            // Draw circle
            Circle circle = new Circle(centerX, centerY, clockRadius);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
            Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
            Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
            Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

            // Draw second hand
            double sLength = clockRadius * 0.8;
            double secondX = centerX + sLength
                    * Math.sin(second * (2 * Math.PI / 60));
            double secondY = centerY - sLength
                    * Math.cos(second * (2 * Math.PI / 60));
            Line sLine = new Line(centerX, centerY, secondX, secondY);
            sLine.setStroke(Color.RED);

            // Draw minute hand
            double mLength = clockRadius * 0.65;
            double xMinute = centerX + mLength
                    * Math.sin(minute * (2 * Math.PI / 60));
            double minuteY = centerY - mLength
                    * Math.cos(minute * (2 * Math.PI / 60));
            Line mLine = new Line(centerX, centerY, xMinute, minuteY);
            mLine.setStroke(Color.BLUE);

            // Draw hour hand
            double hLength = clockRadius * 0.5;
            double hourX = centerX + hLength
                    * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            double hourY = centerY - hLength
                    * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            Line hLine = new Line(centerX, centerY, hourX, hourY);
            hLine.setStroke(Color.GREEN);

            getChildren().clear(); // Clear the pane
            getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
        }

        @Override
        public void setWidth(double width) {
            super.setWidth(width);
            paintClock();
        }

        @Override
        public void setHeight(double height) {
            super.setHeight(height);
            paintClock();
        }
    }
     
} // end of class Excercise15_32
