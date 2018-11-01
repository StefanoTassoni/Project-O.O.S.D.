package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


public class EditUserPasswordCtrl {

	@FXML TextField newPass;
	@FXML TextField oldPass;
	@FXML TextField confirmPass;
	
	@FXML Button saveNewPassword;
	
	
	@FXML protected void saveNewPassword(ActionEvent event) throws Exception 
    {	
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		
    		if(!newPass.getText().isEmpty() && !oldPass.getText().isEmpty() &&
    				!confirmPass.getText().isEmpty()) 
		{
			try 
			{
				System.out.println("EditUserPasswordCtrl.cls - saveNewPassword() - newPass: " + newPass.getText());
				System.out.println("EditUserPasswordCtrl.cls - saveNewPassword() - oldPass: " + oldPass.getText());
				System.out.println("EditUserPasswordCtrl.cls - saveNewPassword() - confirmPass: " + confirmPass.getText());
			
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				gotoUserProfile();
			}
		}
		else 
		{
			System.out.println("EditUserProfileCtrl.cls - saveNewProfile() - username empty");
		}
    
    }
	
	
	
	@FXML protected void gotoResearchHome() throws Exception 
    {	
    		System.out.println("EditUserPasswordCtrl.cls - gotoResearchHome()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/Libraryhome.fxml");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    @FXML protected void gotoUserProfile() throws Exception 
    {	
    		System.out.println("EditUserPasswordCtrl.cls - gotoUserProfile()");	
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/UserProfilePage.fxml", 600, 500);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    
    @FXML protected void gotoModuleCompiling() throws Exception 
    {	
    		System.out.println("EditUserPasswordCtrl.cls - gotoUserProfile()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/temp.fxml");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
	
	
}