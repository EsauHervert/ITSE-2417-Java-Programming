import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUIKittenPicEH extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create a Pane.
		Pane pane = new HBox(10);
		pane.setPadding(new Insets(5,5,5,5));
		Image image = new Image("C:/Users/EsauH/Desktop/kitten.bmp");
		
		pane.getChildren().add(new ImageView(image));
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Cute Kitten");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
