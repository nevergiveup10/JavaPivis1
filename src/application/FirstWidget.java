package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;

public class FirstWidget {
	Label label = new Label("Виджет №1:");
	Button button = new Button("Внести в список");
	TextField tField = new TextField("Введите текст");
	ComboBox<String> comboBox = new ComboBox<String>();
	Separator sep = new Separator();
	Alert alert = new Alert(AlertType.WARNING);

	public VBox pane1() {
		alert.setTitle("Ошибка!");
		alert.setHeaderText("Такой элемент уже содержится.");
		alert.setContentText("Введите другой текст!");

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (comboBox.getItems().contains(tField.getText())) {
					alert.showAndWait();
				} else {
					comboBox.getItems().addAll(tField.getText());
					comboBox.setValue(tField.getText());
				}
			}
		});
		VBox box1 = new VBox(5, label, tField, button, comboBox, sep);
		return box1;
	}
}
