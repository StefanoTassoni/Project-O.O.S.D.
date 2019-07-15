package controller;

import java.util.prefs.Preferences;

import controller.utils.GUIUtils;
import controller.utils.StringUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import model.User;
import model.service.UserService;



public class EditUserPasswordCtrl{

	@FXML PasswordField newPass;
	@FXML PasswordField oldPass;
	@FXML PasswordField confirmPass;
	
	@FXML Button saveNewPassword;
	
	
	@FXML protected void saveNewPassword(ActionEvent event) throws Exception 
    {	
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		UserService uService = UserService.getInstance();
    		
    		
    		if(!newPass.getText().isEmpty() && !oldPass.getText().isEmpty() && !confirmPass.getText().isEmpty()) 
		{
			System.out.println("EditUserPasswordCtrl.cls - saveNewPassword() - newPass: " + newPass.getText());
			System.out.println("EditUserPasswordCtrl.cls - saveNewPassword() - oldPass: " + oldPass.getText());
			System.out.println("EditUserPasswordCtrl.cls - saveNewPassword() - confirmPass: " + confirmPass.getText());
			
    			if(confirmPass.getText().equals(newPass.getText())) 
    			{
    				try 
    				{
    					Preferences session = Preferences.userRoot();
    					String username = session.get("username", null);
    					User tempUser = uService.getByUsername(username);
    					if(tempUser.getPassword().equals(StringUtils.crypt(oldPass.getText()))) 
    					{
	    					User u = new User();
	    					u.setPassword(StringUtils.crypt(newPass.getText()));
	    					uService.updateUser(u, username);
	    					System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - pass aggiornata");
    					}
    					else 
    					{
    						System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - OLD pass is different");
    					}
    				} 
    				catch (Exception e) 
    				{
    					e.printStackTrace();
    				}
    			}
    			else 
    			{
    				System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - NEW pass are different");
    			}
			
		}
		else 
		{
			System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - username empty");
		}
    		DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/UserProfilePage.fxml", 600, 500);
    
    }
	
	
}