package de.uulm.pvs.rep.examples.guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FX_Uebung04 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	String[] solmisation = new String[] {"do", "re", "mi", "fa", "sol"};
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FX-Übung 04");
		HBox root = new HBox();
		addHBox(root, 0);

		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();	
	}
	
	private HBox addHBox(HBox parent, int depth) {
		if(depth >= solmisation.length) {
			return null;
		} else {
			HBox child = new HBox();
			child.getChildren().add(new Button(solmisation[depth]));
			parent.getChildren().add(child);
			return addHBox(child, depth+1);
		}
	}
}
