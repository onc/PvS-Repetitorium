package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneExample extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FlowPaneExample");
		FlowPane rootLayout = new FlowPane();
		
		Button button = new Button("I'm a Button!");
		TextArea textArea = new TextArea("I'm a TextArea!");
		TextField textField = new TextField("I'm a TextField!");
		RadioButton radioButton = new RadioButton("I'm a RadioButton!");

		rootLayout.getChildren().addAll(button, textArea, textField, radioButton);
		primaryStage.setScene(new Scene(rootLayout, 400, 400));
		primaryStage.show();
		
	}

}
