package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.service.*;

public class GUI extends Application implements EventHandler<ActionEvent>{
	
	private static GUI instance;
	private String TITLE = "Digital Library";
	Button clickButton;
	Stage loginWindow;; 
	Scene loginScene, redirectTestScene;
	
	public static GUI getInstance() 
	{
		if (instance == null) 
		{
			instance = new GUI();
		}
		return instance;
	}


	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		loginWindow = primaryStage;
		
		Label label1 = new Label("Welcome to Digital Library");
		
		clickButton = new Button();
		clickButton.setText("Go to scene 2");
		clickButton.setOnAction(e -> loginWindow.setScene(redirectTestScene));
		
//		Scene loginScene = new Scene(layout, 300 , 250);
//		loginWindow.setScene(loginScene);
//		loginWindow.show();
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, clickButton);
		
		loginScene = new Scene(layout1, 200 , 200);
		
		Button clickButton2 = new Button();
		clickButton2.setText("Go to scene 1 please");
		clickButton2.setOnAction(e -> loginWindow.setScene(loginScene));
		
		StackPane layout = new StackPane();
		layout.getChildren().add(clickButton2);
		
		redirectTestScene = new Scene(layout, 600 , 300);
		
		loginWindow.setScene(loginScene);
		loginWindow.setTitle(TITLE);
		loginWindow.show();
	}



	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}


	
	
}
