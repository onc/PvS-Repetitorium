package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class HandlerExample02 extends Application{
	Button myButton;
	TextArea myTextArea;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("HandlerExample 02");
		BorderPane rootLayout = new BorderPane();
		
		myButton = new Button("Click me!");
		myButton.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Clicked");
				event.consume();
			}
		});

		myButton.setOnMouseReleased((MouseEvent event) -> {
			System.out.println("Released");
		});
		
		myButton.setOnMousePressed((MouseEvent event) -> {
			System.out.println("Pressed");
		});
		
		myButton.setOnMouseClicked((MouseEvent event) -> {
			System.out.println("Clicked");
		});
		myTextArea = new TextArea("Hello World!");
		
		rootLayout.setBottom(myButton);
		rootLayout.setCenter(myTextArea);
	
		primaryStage.setScene(new Scene(rootLayout, 300, 300));
		primaryStage.show();
		
	}
}