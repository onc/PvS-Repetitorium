package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FX_Uebung01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FX-Übung 01");
		BorderPane root = new BorderPane();
		GridPane grid = new GridPane();
				
		Label name = new Label("Name: ");
		name.setPrefSize(150, 75);
		
		TextField nameInput = new TextField();
		nameInput.setPrefSize(150, 75);
		
		Label pass = new Label("Password: ");
		pass.setPrefSize(150, 75);

		TextField passInput = new TextField();
		passInput.setPrefSize(150, 75);

		Button login = new Button("Login");
		login.setPrefSize(300, 50);
		
		grid.addColumn(1, name, pass);
		grid.addColumn(2, nameInput, passInput);
		
		root.setCenter(grid);
		root.setBottom(login);
		
		BorderPane.setAlignment(grid, Pos.CENTER);
		BorderPane.setAlignment(login, Pos.TOP_CENTER);
	
		primaryStage.setScene(new Scene(root, 300, 200));
		primaryStage.show();	
	}
}
