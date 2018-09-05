package view;

import controller.exception.ServiceException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.service.*;
import model.service.LoginService;
import model.User;

public class GUI extends Application implements EventHandler<ActionEvent>{
	
	private static GUI instance;
	private String TITLE = "Digital Library";
	Button loginButton, clickButton2;
	Stage loginWindow;; 
	Scene loginScene, successLoginScene;
	
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
		
		Label loginLabel = new Label("Welcome to Digital Library");
		
		loginButton = new Button();
		loginButton.setText("Login");
		
		clickButton2 = new Button();
		
		TextField usernameField = new TextField();
		usernameField.setPromptText("username");
		TextField passField = new TextField();
		passField.setPromptText("password");
		
//		Scene loginScene = new Scene(layout, 300 , 250);
//		loginWindow.setScene(loginScene);
//		loginWindow.show();
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(loginLabel, usernameField, passField,loginButton);
		
		loginScene = new Scene(layout1, 200 , 200);
		
		loginWindow.setScene(loginScene);
		loginWindow.setTitle(TITLE);
		loginWindow.show();
		
		//Event handling
		loginButton.setOnAction(e -> 
		{
			if(!usernameField.getText().isEmpty() && !passField.getText().isEmpty() ) 
			{
				System.out.println("GUI.cls - start() - username: " + usernameField.getText());
				System.out.println("GUI.cls - start() - password: " + passField.getText());
				LoginService logService = LoginService.getInstance();
				try {
					User u = new User();
					u = logService.login((String)usernameField.getText(),(String)passField.getText());
					if(u != null) 
					{
						clickButton2.setText("Go back to login");
						
						Label successLoginLabel = new Label("Welcome ");
						
						StackPane layout = new StackPane();
						layout.getChildren().addAll(successLoginLabel);
						
						successLoginScene = new Scene(layout, 600 , 300);
						loginWindow.setScene(successLoginScene);		
					}
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}
				
			}
			else 
			{
				System.out.println("GUI.cls - start() - username or password empty");
			}
				
		});
		clickButton2.setOnAction(e -> loginWindow.setScene(loginScene));
	}



	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}


	
	
}
