package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class FifthWidget {
	Label label = new Label("Виджет №5:");
	TextField tField = new TextField("Введите информацию");
	Button button1 = new Button("Занисти в Column1");
	Button button2 = new Button("Перенести в Column2");
	Button button3 = new Button("Перенести в Column1");
	TableView<StringData> table = new TableView<StringData>();
	TableColumn<StringData, String> firstColumn = new TableColumn<StringData, String>("Column1");
	TableColumn<StringData, String> secondColumn = new TableColumn<StringData, String>("Column2");

	ObservableList<StringData> data = FXCollections.observableArrayList();
	Separator sep = new Separator();

	public VBox pane5() {

		firstColumn.setMinWidth(150);
		firstColumn.setCellValueFactory(new PropertyValueFactory<>("string1"));
		table.getColumns().add(firstColumn);

		secondColumn.setMinWidth(150);
		secondColumn.setCellValueFactory(new PropertyValueFactory<>("string2"));
		table.getColumns().add(secondColumn);

		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				data.add(new StringData(tField.getText(), ""));
				table.setItems(data);
			}
		});

		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int num = table.getFocusModel().getFocusedIndex();
				String stringBuffer = data.get(num).getString1();
				data.remove(num);
				data.add(num, new StringData("", stringBuffer));
				table.setItems(data);
			}
		});

		button3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int num = table.getFocusModel().getFocusedIndex();
				String stringBuffer = data.get(num).getString2();
				data.remove(num);
				data.add(num, new StringData(stringBuffer, ""));
				table.setItems(data);
			}
		});
		VBox box5 = new VBox(5, label, tField, button1, button2, button3, table, sep);
		return box5;
	}
}
