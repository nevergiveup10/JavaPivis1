package application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaneChange {
	VBox root1 = new VBox();
	HBox root2 = new HBox();
	StackPane root3 = new StackPane();
	AnchorPane root4 = new AnchorPane();
	FlowPane root5 = new FlowPane();

	boolean changing = true;

	private void threadPause() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void checkStopKey(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.SHIFT) {
					changing = false;
				}
			}
		});
	}

	public void paneSwitcher(Stage primaryStage, FirstWidget firstWidget, SecondWidget secondWidget,
			ThirdWidget thirdWidget, FourthWidget fourthWidget, FifthWidget fifthWidget) {

		new Thread(() -> {

			threadPause();

			while (changing == true) {
				if (changing == false) {
					break;
				}

				Platform.runLater(() -> {
					HBox root = new HBox(3, firstWidget.hBox1(), secondWidget.hBox2(), thirdWidget.hBox3(),
							fourthWidget.hBox4(), fifthWidget.hBox5());
					Scene scene = new Scene(root, 900, 950);
					primaryStage.setScene(scene);
					checkStopKey(scene);

				});

				threadPause();

				if (changing == false) {
					break;
				}

				Platform.runLater(

						() -> {

							StackPane root = new StackPane(firstWidget.stackPane1(), secondWidget.stackPane2(),
									thirdWidget.stackPane3(), fourthWidget.stackPane4(), fifthWidget.stackPane5());
							Scene scene = new Scene(root, 900, 950);
							primaryStage.setScene(scene);
							checkStopKey(scene);
						});

				threadPause();

				if (changing == false) {
					break;
				}

				Platform.runLater(() -> {
					AnchorPane root = new AnchorPane(firstWidget.anchorPane1(), secondWidget.anchorPane2(),
							thirdWidget.anchorPane3(), fourthWidget.anchorPane4(), fifthWidget.anchorPane5());
					Scene scene = new Scene(root, 900, 950);
					primaryStage.setScene(scene);
					checkStopKey(scene);
				});

				threadPause();

				if (changing == false) {
					break;
				}

				Platform.runLater(() -> {
					FlowPane root = new FlowPane(firstWidget.flowPane1(), secondWidget.flowPane2(),
							thirdWidget.flowPane3(), fourthWidget.flowPane4(), fifthWidget.flowPane5());
					Scene scene = new Scene(root, 900, 950);
					primaryStage.setScene(scene);
					checkStopKey(scene);
				});

				threadPause();

				if (changing == false) {
					break;
				}

				Platform.runLater(() -> {
					VBox root = new VBox(3, firstWidget.vBox1(), secondWidget.vBox2(), thirdWidget.vBox3(),
							fourthWidget.vBox4(), fifthWidget.vBox5());
					Scene scene = new Scene(root, 900, 950);
					primaryStage.setScene(scene);
					checkStopKey(scene);
				});
				threadPause();
			}

		}).start();

	}

}