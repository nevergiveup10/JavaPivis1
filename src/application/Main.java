package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.application.Application;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		FirstWidget firstWidget = new FirstWidget();
		SecondWidget secondWidget = new SecondWidget();
		ThirdWidget thirdWidget = new ThirdWidget();
		FourthWidget fourthWidget = new FourthWidget();
		FifthWidget fifthWidget = new FifthWidget();

		VBox root = new VBox(3, firstWidget.pane1(), secondWidget.pane2(), thirdWidget.pane3(), fourthWidget.pane4(),
				fifthWidget.pane5());
		Scene scene = new Scene(root, 300, 950);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lab 1, Smolensky P.");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
