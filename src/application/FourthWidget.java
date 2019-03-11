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

	public VBox pane4() {
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
		VBox box4 = new VBox(5, label, tField, button, chkBox1, chkBox2, chkBox3, sep);
		return box4;

	}
}
