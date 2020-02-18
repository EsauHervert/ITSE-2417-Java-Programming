//Esau Hervert
//ITSE 2417
//Project 4, Program 3
//References:
//http://java-buddy.blogspot.com/2015/07/validate-and-parse-javafx-textfield-to.html : Text to int.
// http://docs.oracle.com/javafx/2/charts/pie-chart.htm : PieChart

// Here are all the libraries that I will be using.
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIPieChartEH extends Application {
	
	Stage Window; // This is the window.
	Button But; // They will press the button to generate the Pie Chart.
	Scene scene;
	
	// Launches the Application.
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Window = primaryStage;
		Window.setTitle("Budget"); // Title of the window.
		
		// The inputs that the user will enter.
		TextField Housing = new TextField ("Housing");
		TextField Food = new TextField ("Food");
		TextField Transportation = new TextField ("Transportation");
		TextField Other = new TextField ("Other");
		
		But = new Button("Display Chart");
		But.setOnAction((ActionEvent event) -> {
			
	        Scene scene2 = new Scene(new Group(), 600, 400); // Where the Pie Chart will be.

	        // Turning the string data to integer data.
			int HousingValue = Integer.parseInt(Housing.getText());
			int FoodValue = Integer.parseInt(Food.getText());
			int TransportationValue = Integer.parseInt(Transportation.getText());
			int OtherValue = Integer.parseInt(Other.getText());

			
			//Create the Pie Chart.
	        ObservableList<PieChart.Data> pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("Housing", HousingValue),
	                new PieChart.Data("Food", FoodValue),
	                new PieChart.Data("Transportation", TransportationValue),
	                new PieChart.Data("Other", OtherValue));
	        final PieChart chart = new PieChart(pieChartData);
	        chart.setTitle("Budget");
	        
	        chart.setLegendSide(Side.RIGHT); // Displays the legend at the Right side of the chart.

	        // Display the Pie Chart.
	        ((Group) scene2.getRoot()).getChildren().add(chart); 
	        Window.setScene(scene2);
			Window.show();
		});
		
		// THe input window.
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(Housing, Food, Transportation, Other, But);
		
		// The initial window.
		scene = new Scene(layout, 300, 300);
		Window.setScene(scene);
		Window.show();
	}
}
