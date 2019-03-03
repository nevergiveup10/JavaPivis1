package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class SecondWidget {
	Label label = new Label("Виджет №2:");
	Button button1 = new Button("Кнопка 1!");
	Button button2 = new Button("Кнопка 2!");
	TextField tField = new TextField("Введите текст");
	Separator sep = new Separator();
	Alert alert = new Alert(AlertType.WARNING);

	public VBox pane2() {
		alert.setTitle("Ошибка!");
		alert.setHeaderText("Такого элемента не существует.");
		alert.setContentText("Выберите другой элемент!");

		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				button2.setText(tField.getText());
			}
		});

		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String strBuffer = button1.getText();
				button1.setText(button2.getText());
				button2.setText(strBuffer);
			}
		});
		VBox box2 = new VBox(5, label, tField, button1, button2, sep);
		return box2;
	}

}
