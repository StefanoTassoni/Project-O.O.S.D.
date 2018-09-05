package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.sql.Connection;

import javafx.application.Application;
import javafx.stage.Stage;
import model.service.LoginService;
import model.User;

import javax.naming.NamingException;

import controller.exception.ServiceException;
import db.Database;
import view.GUI;

public class DigitalLibrary extends Application{


	
	public static void main(String [] args) throws ClassNotFoundException, NamingException, ServiceException {	
		
		try 
		{
			Database.connect();
			
//			LoginService log = LoginService.getInstance();
//			User u = new User();
//			u = log.login("federiange", "fede");
//			System.out.println(u);
			
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
		GUI gui = GUI.getInstance();
		gui.start(primaryStage);
	}
	
}
