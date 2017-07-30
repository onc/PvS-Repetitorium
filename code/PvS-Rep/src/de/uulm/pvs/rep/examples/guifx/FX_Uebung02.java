package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FX_Uebung02 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FX-Übung 02");
		BorderPane root = new BorderPane();
		FlowPane flow = new FlowPane();
		
		Button cancel = new Button("Abbrechen");
		Button okay = new Button("OK");
		
		TextArea textArea = new TextArea();
		
		flow.getChildren().addAll(cancel, okay);
		root.setCenter(textArea);
		root.setBottom(flow);
	
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();	
	}
}
