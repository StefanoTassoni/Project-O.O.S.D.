package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import model.service.UserService;

import javax.naming.NamingException;

import controller.exception.ServiceException;
import db.Database;

public class TestClass{


	
	public static void main(String [] args) throws SQLException, ClassNotFoundException, ServiceException
	{
		
		try {
			Database.connect();
			UserService uService = UserService.getInstance();
			System.out.println(uService.getAllUsers());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
