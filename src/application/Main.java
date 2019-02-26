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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

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
			
			Label label3 = new Label ("Виджет №3:");
			TextField tfield3 = new TextField ("Введите имя объекта");
			Button button4 = new Button("Выбрать объект");
			RadioButton radBut1 = new RadioButton("1");
			RadioButton radBut2 = new RadioButton("2");
			RadioButton radBut3 = new RadioButton("3");
			ToggleGroup radButgroup = new ToggleGroup();
	        radBut1.setToggleGroup(radButgroup);
	        radBut2.setToggleGroup(radButgroup);
	        radBut3.setToggleGroup(radButgroup);
	        ArrayList<RadioButton> radButList = new ArrayList<RadioButton>();
	        radButList.add(radBut1);
	        radButList.add(radBut2);
	        radButList.add(radBut3);
			Separator sep3 = new Separator();
			
			Label label4 = new Label ("Виджет №4:");
			TextField tfield4 = new TextField ("Введите имя объекта");
			Button button5 = new Button("Выбрать объект");
			CheckBox chkBox1 = new CheckBox("1");
			CheckBox chkBox2 = new CheckBox("2");
			CheckBox chkBox3 = new CheckBox("3");
	        ArrayList<CheckBox> chkBoxList = new ArrayList<CheckBox>();
	        chkBoxList.add(chkBox1);
	        chkBoxList.add(chkBox2);
	        chkBoxList.add(chkBox3);
			Separator sep4 = new Separator();
			
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setTitle("Ошибка!");
			alert2.setHeaderText("Такого элемента не существует.");
			alert2.setContentText("Выберите другой элемент!");
			
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
			
			button4.setOnAction(new EventHandler<ActionEvent>() {
				@Override
		        public void handle(ActionEvent event) {
					RadioButton select1 =  radButList.stream()
		                    .filter(radioButton -> radioButton.getText().equals(tfield3.getText()))
		                    .findAny()
		                    .orElse(null);
		            if(select1!= null){
		            	radButgroup.selectToggle(select1);
		            } else {
		            	alert2.showAndWait();
		            }
			
				}
				});
			
			button5.setOnAction(new EventHandler<ActionEvent>() {
				@Override
		        public void handle(ActionEvent event) {
					CheckBox select2 =  chkBoxList.stream()
		                    .filter(checkBox -> checkBox.getText().equals(tfield4.getText()))
		                    .findAny()
		                    .orElse(null);
		            if(select2!= null){
		            	if(select2.isSelected()==false) {
		            		select2.fire();
		            		}
		            }	
		             else {
		            	alert2.showAndWait();
		            }
			
				}
				}); 
				
			VBox pane1 = new VBox (10, label, tfield1, button1, combobox1, sep1);
			VBox pane2 = new VBox(10, label2, tfield2, button2, button3, sep2);
			VBox pane3 = new VBox (10, label3, tfield3, button4, radBut1, radBut2, radBut3, sep3);
			VBox pane4 = new VBox (10, label4, tfield4, button5, chkBox1, chkBox2, chkBox3, sep4);
			VBox root = new VBox(10, pane1, pane2, pane3, pane4);
			Scene scene = new Scene(root,300,1000);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Lab 1, Smolensky P.");
			primaryStage.show();

	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
