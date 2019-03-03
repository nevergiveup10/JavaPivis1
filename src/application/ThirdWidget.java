package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class ThirdWidget {
	Label label = new Label("Виджет №3:");
	TextField tField = new TextField("Введите имя объекта");
	Button button = new Button("Выбрать объект");
	RadioButton radBut1 = new RadioButton("1");
	RadioButton radBut2 = new RadioButton("2");
	RadioButton radBut3 = new RadioButton("3");
	ToggleGroup radButgroup = new ToggleGroup();
	ArrayList<RadioButton> radButList = new ArrayList<RadioButton>();
	Alert alert = new Alert(AlertType.WARNING);
	Separator sep3 = new Separator();

	public VBox pane3() {
		radBut1.setToggleGroup(radButgroup);
		radBut2.setToggleGroup(radButgroup);
		radBut3.setToggleGroup(radButgroup);

		radButList.add(radBut1);
		radButList.add(radBut2);
		radButList.add(radBut3);

		alert.setTitle("Ошибка!");
		alert.setHeaderText("Такого элемента не существует.");
		alert.setContentText("Выберите другой элемент!");

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				RadioButton select1 = radButList.stream()
						.filter(radioButton -> radioButton.getText().equals(tField.getText())).findAny().orElse(null);
				if (select1 != null) {
					radButgroup.selectToggle(select1);
				} else {
					alert.showAndWait();
				}

			}
		});
		VBox box3 = new VBox(5, label, tField, button, radBut1, radBut2, radBut3, sep3);
		return box3;
	}
}
