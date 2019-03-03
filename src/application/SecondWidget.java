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
	Label label = new Label("������ �2:");
	Button button1 = new Button("������ 1!");
	Button button2 = new Button("������ 2!");
	TextField tField = new TextField("������� �����");
	Separator sep = new Separator();
	Alert alert = new Alert(AlertType.WARNING);

	public VBox pane2() {
		alert.setTitle("������!");
		alert.setHeaderText("������ �������� �� ����������.");
		alert.setContentText("�������� ������ �������!");

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
