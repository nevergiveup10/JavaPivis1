package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//public class FirstWidget extends Application {
//}

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
			
			Label label = new Label ("Виджет №1:");
			Button button1 = new Button("Внести в список");           // кнопка
			TextField tfield1 = new TextField ("Введите текст");
			ComboBox combobox1 = new ComboBox();
			button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
			combobox1.getItems().addAll(tfield1.getText());
			combobox1.setValue(tfield1.getText());
	          button1.setText("You've clicked!");
			}
			});
			
			
	        FlowPane root = new FlowPane(10, 10, label, tfield1, button1, combobox1); // FlowPane располагает элементы в строку друг за другом
	        root.setOrientation(Orientation.VERTICAL);
	  //      Pane pane1 = new Pane();
			Scene scene = new Scene(root,2000,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Lab 1, Smolensky P.");
			primaryStage.show();

	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
