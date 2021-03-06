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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FifthWidget {
	Label label = new Label("������ �5:");
	TextField tField = new TextField("������� ����������");
	Button button1 = new Button("������� � Column1");
	Button button2 = new Button("��������� � Column2");
	Button button3 = new Button("��������� � Column1");
	TableView<StringData> table = new TableView<StringData>();
	TableColumn<StringData, String> firstColumn = new TableColumn<StringData, String>("Column1");
	TableColumn<StringData, String> secondColumn = new TableColumn<StringData, String>("Column2");

	ObservableList<StringData> data = FXCollections.observableArrayList();
	Separator sep = new Separator();

	public void colSetup() {

		firstColumn.setMinWidth(150);
		firstColumn.setCellValueFactory(new PropertyValueFactory<>("string1"));
		table.getColumns().add(firstColumn);

		secondColumn.setMinWidth(150);
		secondColumn.setCellValueFactory(new PropertyValueFactory<>("string2"));
		table.getColumns().add(secondColumn);
	}

	private void pane5() {

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

	}

	public VBox vBox5() {
		pane5();
		VBox box5 = new VBox(5, label, tField, button1, button2, button3, table, sep);
		return box5;
	}

	public HBox hBox5() {
		pane5();
		HBox box555 = new HBox(5, label, tField, button1, button2, button3, table, sep);
		return box555;
	}

	public StackPane stackPane5() {
		pane5();
		StackPane box5 = new StackPane(label, tField, button1, button2, button3, table, sep);
		return box5;
	}

	public AnchorPane anchorPane5() {
		pane5();
		AnchorPane box5 = new AnchorPane(label, tField, button1, button2, button3, table, sep);
		AnchorPane.setRightAnchor(label, 10.0);
		AnchorPane.setRightAnchor(tField, 20.0);
		AnchorPane.setRightAnchor(button1, 30.0);
		AnchorPane.setRightAnchor(button2, 40.0);
		AnchorPane.setRightAnchor(button3, 30.0);
		AnchorPane.setRightAnchor(table, 20.0);
		return box5;
	}

	public FlowPane flowPane5() {
		pane5();
		FlowPane box5 = new FlowPane(label, tField, button1, button2, button3, table, sep);
		return box5;
	}
}
