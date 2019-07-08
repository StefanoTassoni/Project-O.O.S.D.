package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.exception.ServiceException;
import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.User;
import model.service.UserService;


public class EditUserProfileCtrl implements Initializable{
	
	@FXML TextField newName;
	@FXML TextField newSurname;
	@FXML TextField newAddress;
	@FXML TextField newMail;
	@FXML TextField newPhone;
	@FXML TextField newUsername;
	@FXML Button saveProfile;
	
	
	public void initialize(URL location, ResourceBundle resources) 
	{
		System.out.println("EditUserProfileCtrl.cls - initialize()");
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
					System.out.println("EditUserProfileCtrl.cls - initialize() - user info: " + u.toString());
					newUsername.setText(u.getUsername());	
					newName.setText(u.getName());
					newSurname.setText(u.getSurname());
					newAddress.setText(u.getAddress());
					newMail.setText(u.getMail());
					newPhone.setText(u.getPhone());	
				}
			} 
			catch (ServiceException e) 
			{
			
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("EditUserProfileCtrl.cls - initialize() - errore cattura user");
		}
		
    }
	
	@FXML protected void saveNewProfile(ActionEvent event) throws Exception 
    {	
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		UserService uService = UserService.getInstance();
    		User updateUser = new User();
    		
		try 
		{
//			System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newName: " + newName.getText());
//			System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newSurname: " + newSurname.getText());
//			System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newAddress: " + newAddress.getText());
//			System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newMail: " + newMail.getText());
//			System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newPhone: " + newPhone.getText());
//			System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newUsername: " + newUsername.getText());
			
			if(!newName.getText().isEmpty()) updateUser.setName(newName.getText());
			if(!newSurname.getText().isEmpty()) updateUser.setSurname(newSurname.getText());
			if(!newAddress.getText().isEmpty()) updateUser.setAddress(newAddress.getText());
			if(!newMail.getText().isEmpty()) updateUser.setMail(newMail.getText());
			if(!newPhone.getText().isEmpty()) updateUser.setPhone(newPhone.getText());
			Boolean usernameChanged = false;
			if(!newUsername.getText().isEmpty())
			{
				updateUser.setUsername(newUsername.getText());
				usernameChanged = true;
			}
			
			Preferences session = Preferences.userRoot();
			String username = session.get("username", null);
			if(uService.updateUser(updateUser, username) && usernameChanged) 
			{
				session.remove("username");
				session.put("username", newUsername.getText());
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/UserProfilePage.fxml", 600, 500);
		}
		
    }
	
	
}
