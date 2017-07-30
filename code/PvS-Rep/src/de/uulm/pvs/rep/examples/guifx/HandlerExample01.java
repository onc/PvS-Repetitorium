package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerExample01 extends Application implements EventHandler<ActionEvent>{
	Button myButton;
	TextArea myTextArea;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("HandlerExample 01");
		BorderPane rootLayout = new BorderPane();
		
		myButton = new Button("Click me!");
		myButton.setOnAction(this);
		myTextArea = new TextArea("Hello World!");
        
		
		rootLayout.setBottom(myButton);
		rootLayout.setCenter(myTextArea);
	
		primaryStage.setScene(new Scene(rootLayout, 300, 300));
		primaryStage.show();
		
		myButton.getOnAction().handle(new ActionEvent());
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(myTextArea.getText());
	}
}
