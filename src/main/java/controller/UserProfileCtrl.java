package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.exception.ServiceException;
import controller.utils.GUIUtils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import service.model.User;
import service.UserService;


public class UserProfileCtrl implements Initializable{
	
	@FXML Button editProfile;
	@FXML Button editPassword;
	
	@FXML Text firstNameField;
	@FXML Text surnameField;
	@FXML Text addressField;
	@FXML Text mailField;
	@FXML Text phoneField;
	@FXML Text usernameField;
	@FXML Circle avatar;
	

	public void initialize(URL location, ResourceBundle resources) 
	{
		System.out.println("UserProfileCtrl.cls - initialize()");
		Preferences session = Preferences.userRoot();
		String username = session.get("username", null);
		if( !username.equals(null)) 
		{
			UserService userService = UserService.getInstance();
			try 
			{
				User u = userService.getByUsername(username);
			
				if (u != null) 
				{
					System.out.println("UserProfileCtrl.cls - initialize() - user info: " + u.toString());
					usernameField.setText(u.getUsername());	
					firstNameField.setText(u.getName());
					surnameField.setText(u.getSurname());
					addressField.setText(u.getAddress());
					mailField.setText(u.getMail());
					phoneField.setText(u.getPhone());	
				}
			} 
			catch (ServiceException e) 
			{
			
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("UserProfileCtrl.cls - initialize() - errore cattura user");
		}
		
    }


	
	@FXML protected void gotoEditProfile() throws Exception 
    {	
    		System.out.println("UserProfileCtrl.cls - gotoEditProfile()");
    		Preferences session = Preferences.userRoot();
    		System.out.println("UserProfileCtrl.cls - gotoResearchHome() - sessionUsernname: " + session.get("username", null));
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/EditUserProfilePage.fxml", 600, 500);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
	
	@FXML protected void gotoEditPassword() throws Exception 
    {	
    		System.out.println("UserProfileCtrl.cls - gotoEditPassword()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/EditUserPassword.fxml", 600, 500);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
	
	
}
