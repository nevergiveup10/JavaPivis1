package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;

public class FirstWidget {
	Label label = new Label("Виджет №1:");
	Button button = new Button("Внести в список");
	TextField tField = new TextField("Введите текст");
	ComboBox<String> comboBox = new ComboBox<String>();
	Separator sep = new Separator();
	Alert alert = new Alert(AlertType.WARNING);

	private void pane1() {
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

	}

	public VBox vBox1() {
		pane1();
		VBox box1 = new VBox(5, label, tField, button, comboBox, sep);
		return box1;
	}

	public HBox hBox1() {
		pane1();
		HBox box111 = new HBox(5, label, tField, button, comboBox, sep);
		return box111;
	}

	public StackPane stackPane1() {
		pane1();
		StackPane box1 = new StackPane(label, tField, button, comboBox, sep);
		return box1;
	}

	public AnchorPane anchorPane1() {
		pane1();
		AnchorPane box1 = new AnchorPane(label, tField, button, comboBox, sep);
		AnchorPane.setRightAnchor(label, 10.0);
		AnchorPane.setRightAnchor(tField, 20.0);
		AnchorPane.setRightAnchor(button, 30.0);
		AnchorPane.setRightAnchor(comboBox, 40.0);
		return box1;
	}

	public FlowPane flowPane1() {
		pane1();
		FlowPane box1 = new FlowPane(label, tField, button, comboBox, sep);
		return box1;
	}
}
