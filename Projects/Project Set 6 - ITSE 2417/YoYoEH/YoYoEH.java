// Esau Hervert
// ITSE 2417
// Project 6 - Program 3
// Options: None
// References: https://stackoverflow.com/questions/20022889/how-to-make-the-ball-bounce-off-the-walls-in-javafx - More complicated case than I simpliefied.

// Libraries that I need.
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class YoYoEH extends Application {

    public static Circle circle; // The YoYo. 
    public static Line line; // String of the YoYo.
    public static Pane canvas; // Where the object will be.

    @Override
    public void start(final Stage primaryStage) {

    	//Create the pane and define it's size.
        canvas = new Pane();
        final Scene scene = new Scene(canvas, 600, 600);

        primaryStage.setTitle("Yo Yo"); // Title.
        primaryStage.setScene(scene);
        primaryStage.show();

        // Shapes that I will be using.
        circle = new Circle(50, Color.BLACK);
        line = new Line(100, 0, 100, 100);
        
        circle.relocate(100, 100); // Center the YoYo.

        // Add the shape to the canvas.
        canvas.getChildren().addAll(circle);
        canvas.getChildren().addAll(line);

        // This loop will perform the movement of the YoYo.
        // The time for each step is given as 100 miliseconds.
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {

        	
            double deltaY = 10; // Will change the movement of the objects by 10.
            int i = 0; // Counter for the change in the line.
            int value = 50; // Correction of the line.
            @Override
            public void handle(final ActionEvent t) {
                circle.setLayoutY(circle.getLayoutY() + deltaY); // Redraw the circle.

                // Bounds of our YoYo.
                final Bounds bounds = canvas.getBoundsInLocal();
                final boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
                final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius() + 50); // To keep the YoYo from hitting the top.
                
                //Line going down.
                if (deltaY > 0)
                {
                	i++;
                    line.setEndY((bounds.getMinY() + value + circle.getRadius() + 50) + i*deltaY);
                }
                // Line going up.
                else if (deltaY < 0)
                {
                	i++;
                    line.setEndY((bounds.getMaxY() - circle.getRadius()) + (i)*deltaY);
                    value = 0;
                }
                
                // Once the YoYo hits its bounds, its movement will be opposite to that of before.
                if (atBottomBorder || atTopBorder) {
                    deltaY *= -1;
                    i = 0;
                }

            }
        }));

        loop.setCycleCount(Timeline.INDEFINITE); // Goes on forever.
        loop.play(); // Play the loop.
    }

    // Run the Application.
    public static void main(final String[] args) {
        launch(args);
    }
}