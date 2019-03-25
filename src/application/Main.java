package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.event.EventHandler;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws InterruptedException { // throws InterruptedException {

		FirstWidget firstWidget = new FirstWidget();
		SecondWidget secondWidget = new SecondWidget();
		ThirdWidget thirdWidget = new ThirdWidget();
		FourthWidget fourthWidget = new FourthWidget();
		FifthWidget fifthWidget = new FifthWidget();
		PaneChange paneChange = new PaneChange();
		primaryStage.setTitle("Lab 1, Smolensky P.");

		VBox root = new VBox(3, firstWidget.vBox1(), secondWidget.vBox2(), thirdWidget.vBox3(), fourthWidget.vBox4(),
				fifthWidget.vBox5());
		Scene scene = new Scene(root, 900, 950);
		primaryStage.setScene(scene);
		primaryStage.show();

		fifthWidget.colSetup();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					paneChange.paneSwitcher(primaryStage, firstWidget, secondWidget, thirdWidget, fourthWidget,
							fifthWidget);
				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
