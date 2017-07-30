package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class FX_Uebung03 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FX-Übung 03");
		BorderPane root = new BorderPane();
		TilePane top = new TilePane();
		FlowPane bottom = new FlowPane();
		
		Label c = new Label("Celsius");
		TextField celsius = new TextField();
		
		Label f = new Label("Fahrenheit");
		TextField fahrenheit = new TextField();
		
		Button button = new Button("Convert");
		button.prefWidthProperty().bind(root.widthProperty());
		button.prefHeightProperty().bind(root.heightProperty());
		
		top.getChildren().addAll(c, celsius);
		bottom.getChildren().addAll(f, fahrenheit);
		
		root.setCenter(button);
		root.setTop(top);
		root.setBottom(bottom);
	
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();	
	}
}
