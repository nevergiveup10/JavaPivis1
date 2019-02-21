package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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
			Button button1 = new Button("Внести в список");         
			TextField tfield1 = new TextField ("Введите текст");
			ComboBox<String> combobox1 = new ComboBox<String>();
			Separator sep1 = new Separator();
			
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("Ошибка!");
			alert1.setHeaderText("Такой элемент уже содержится.");
			alert1.setContentText("Введите другой текст!");
			
			Label label2 = new Label ("Виджет №2:");
			Button button2 = new Button("Кнопка 1!");           
			Button button3 = new Button("Кнопка 2!");           
			TextField tfield2 = new TextField ("Введите текст");
			Separator sep2 = new Separator();
			
			
			button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
			if (combobox1.getItems().contains(tfield1.getText())) {
				alert1.showAndWait();
			}
			else {
			combobox1.getItems().addAll(tfield1.getText());
			combobox1.setValue(tfield1.getText());
			}
			}
			});
			
			button2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
		        public void handle(ActionEvent event) {
					button3.setText(tfield2.getText());					
				}
			});
			
			button3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
		        public void handle(ActionEvent event) {
					String strBuffer = button2.getText(); 
					button2.setText(button3.getText());				
					button3.setText(strBuffer);	
				}
			});
				
			VBox pane1 = new VBox (10, label, tfield1, button1, combobox1, sep1);
			VBox pane2 = new VBox(10, label2, tfield2, button2, button3, sep2);
			VBox root = new VBox(10, pane1, pane2);
			Scene scene = new Scene(root,300,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Lab 1, Smolensky P.");
			primaryStage.show();

	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
