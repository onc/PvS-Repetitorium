package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class MouseListenerClass extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Mouse Listener");
		GridPane rootLayout = new GridPane();
		
		TextArea welcome = new TextArea("Welcome!");
		Button listenerButton = new Button("Button");
		Button knopfButton = new Button("Knopf");
		
		listenerButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				welcome.setText("Mouse Pressed!");
			}
			
		});
		
		listenerButton.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				welcome.setText("Mouse Released!");
			}
			
		});
		
		listenerButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				welcome.setText("Mouse Clicked!");
			}
			
		});
		
		listenerButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				welcome.setText("Mouse Entered!");
			}
			
		});
		
		listenerButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				welcome.setText("Mouse Exited!");
			}
			
		});
		
		knopfButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				knopfButton.setText(event.getX() + ", " + event.getY());
			}
			
		});
		
		knopfButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				knopfButton.setText("Knopf");
			}
			
		});
		
		rootLayout.add(welcome, 1, 1);
		rootLayout.add(listenerButton, 1, 2);
		rootLayout.add(knopfButton, 1, 3);
		primaryStage.setScene(new Scene(rootLayout, 600, 600));
		primaryStage.show();
		
	}

}
