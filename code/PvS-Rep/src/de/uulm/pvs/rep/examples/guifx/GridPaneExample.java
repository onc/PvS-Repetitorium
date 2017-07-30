package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("GridPaneExample");
		GridPane rootLayout = new GridPane();
		
		Button button = new Button("I'm a Button!");
		TextArea textArea = new TextArea("I'm a TextArea!");
		TextField textField = new TextField("I'm a TextField!");

		rootLayout.add(button, 1, 5, 1, 1);
		rootLayout.add(textArea, 1, 1, 3, 2);
		rootLayout.add(textField, 3, 4, 2, 1);
		
		primaryStage.setScene(new Scene(rootLayout, 500, 400));
		primaryStage.show();
	}

}
