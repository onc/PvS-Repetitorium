package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class BorderPaneExample extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("BorderPaneExample");
		
		Button top = new Button("top");
		Button left = new Button("left");
		Button right = new Button("right");
		Button center = new Button("center");
		Button bottom = new Button("bottom");
		
		BorderPane.setAlignment(top, Pos.CENTER);
		BorderPane.setAlignment(left, Pos.CENTER);
		BorderPane.setAlignment(right, Pos.CENTER);
		BorderPane.setAlignment(center, Pos.CENTER);
		BorderPane.setAlignment(bottom, Pos.CENTER);
		
		BorderPane rootLayout = new BorderPane();
		
		rootLayout.setTop(top);
		rootLayout.setLeft(left);
		rootLayout.setRight(right);
		rootLayout.setCenter(center);
		rootLayout.setBottom(bottom);
		
		primaryStage.setScene(new Scene(rootLayout, 300, 300));
		primaryStage.show();
		
	}

}
