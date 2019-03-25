package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FourthWidget {
	Label label = new Label("Виджет №4:");
	TextField tField = new TextField("Введите имя объекта");
	Button button = new Button("Выбрать объект");
	CheckBox chkBox1 = new CheckBox("1");
	CheckBox chkBox2 = new CheckBox("2");
	CheckBox chkBox3 = new CheckBox("3");
	ArrayList<CheckBox> chkBoxList = new ArrayList<CheckBox>();
	Alert alert = new Alert(AlertType.WARNING);
	Separator sep = new Separator();

	private void pane4() {
		chkBoxList.add(chkBox1);
		chkBoxList.add(chkBox2);
		chkBoxList.add(chkBox3);
		alert.setTitle("Ошибка!");
		alert.setHeaderText("Такого элемента не существует.");
		alert.setContentText("Выберите другой элемент!");

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CheckBox select2 = chkBoxList.stream().filter(checkBox -> checkBox.getText().equals(tField.getText()))
						.findAny().orElse(null);
				if (select2 != null) {

					select2.fire();

				} else {
					alert.showAndWait();
				}

			}
		});

	}

	public VBox vBox4() {
		pane4();
		VBox box4 = new VBox(5, label, tField, button, chkBox1, chkBox2, chkBox3, sep);
		return box4;
	}

	public HBox hBox4() {
		pane4();
		HBox box444 = new HBox(5, label, tField, button, chkBox1, chkBox2, chkBox3, sep);
		return box444;
	}

	public StackPane stackPane4() {
		pane4();
		StackPane box4 = new StackPane(label, tField, button, chkBox1, chkBox2, chkBox3, sep);
		return box4;
	}

	public AnchorPane anchorPane4() {
		pane4();
		AnchorPane box4 = new AnchorPane(label, tField, button, chkBox1, chkBox2, chkBox3, sep);
		AnchorPane.setRightAnchor(label, 10.0);
		AnchorPane.setRightAnchor(tField, 20.0);
		AnchorPane.setRightAnchor(button, 30.0);
		AnchorPane.setRightAnchor(chkBox1, 40.0);
		AnchorPane.setRightAnchor(chkBox2, 30.0);
		AnchorPane.setRightAnchor(chkBox3, 20.0);
		return box4;
	}

	public FlowPane flowPane4() {
		pane4();
		FlowPane box4 = new FlowPane(label, tField, button, chkBox1, chkBox2, chkBox3, sep);
		return box4;
	}
}
