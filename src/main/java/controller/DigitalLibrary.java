package controller;

import java.sql.SQLException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.naming.NamingException;

import controller.exception.ServiceException;
import db.Database;


public class DigitalLibrary extends Application{

	public static Stage stage;
	public static Parent root;
	private static String TITLE = "Digital Library";
	public static Integer xDim = 600;
	public static Integer yDim = 400;
	
	public static void main(String [] args) throws ClassNotFoundException, NamingException, ServiceException {	
		
		try 
		{
			Database.connect();
			launch(args);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		stage = primaryStage;
		root = FXMLLoader.load(getClass().getClassLoader().getResource("view/LoginPage.fxml"));
        Scene scene = new Scene(root, xDim, yDim);
        stage = new Stage();
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
		
//		GUI gui = GUI.getInstance();
//		gui.start(primaryStage);
	}
	
}
