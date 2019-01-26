package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


public class UserProfileCtrl implements Initializable{
	
	@FXML Button editProfile;
	@FXML Button editPassword;
	
	@FXML Text firstName;
	@FXML Text surname;
	@FXML Text address;
	@FXML Text mail;
	@FXML Text phone;
	@FXML Text username;
	@FXML Circle avatar;
	

	public void initialize(URL location, ResourceBundle resources) 
	{
		System.out.println("UserProfileCtrl.cls - constructor()");
		firstName.setText("ciao");
		surname.setText("ciao");
		address.setText("ciao");
		mail.setText("ciao");
		phone.setText("ciao");
		username.setText("ciao");
//		Image image = new Image("../../resources/avatar.png");
//		ImagePattern imagePattern = new ImagePattern(image);
//		avatar.setFill(imagePattern);
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
