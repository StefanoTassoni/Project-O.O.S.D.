package controller;

import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class EditUserProfileCtrl {
	
	@FXML TextField newName;
	@FXML TextField newSurname;
	@FXML TextField newAddress;
	@FXML TextField newMail;
	@FXML TextField newPhone;
	@FXML TextField newUsername;
	@FXML Button saveProfile;
	
	@FXML protected void saveNewProfile(ActionEvent event) throws Exception 
    {	
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		
    		if(!newName.getText().isEmpty() && !newSurname.getText().isEmpty() &&
    				!newAddress.getText().isEmpty() && !newMail.getText().isEmpty() &&
    				!newPhone.getText().isEmpty() && !newUsername.getText().isEmpty()) 
		{
			try 
			{
				System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newName: " + newName.getText());
				System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newSurname: " + newSurname.getText());
				System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newAddress: " + newAddress.getText());
				System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newMail: " + newMail.getText());
				System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newPhone: " + newPhone.getText());
				System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - newUsername: " + newUsername.getText());
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
		else 
		{
			System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - username empty");
		}
    
    }
	
	
}
