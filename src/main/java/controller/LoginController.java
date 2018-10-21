package controller;

import java.util.HashMap;
import java.util.Map;

import controller.exception.ServiceException;
import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import model.User;
import model.service.LoginService;
 
public class LoginController 
{
	/***LOGIN***/
    @FXML TextField usernameField;
    @FXML TextField passwordField;
    @FXML Button signInButton;
    @FXML Text errorText;
    
    /***REGISTER***/
    @FXML TextField registerNameField;
    @FXML TextField registerSurnameField;
    @FXML TextField registerUsernameField;
    @FXML TextField registerEmailField;
    @FXML TextField registerPasswordField;
    @FXML Button registerButton;
    @FXML Text registerErrorText;
    
    
    @FXML protected void handleLoginButton(ActionEvent event) throws Exception {
    	
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		
    		if(!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty() ) 
			{
				System.out.println("GUI.cls - start() - username: " + usernameField.getText());
				System.out.println("GUI.cls - start() - password: " + passwordField.getText());
				LoginService logService = LoginService.getInstance();
				try {
					User u = new User();
					u = logService.login((String)usernameField.getText(),(String)passwordField.getText());
					if(u != null) 
					{
						Map<String, Object> objectMap = new HashMap<String, Object>();
						objectMap.put("Username", u.getUsername());
						DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/Libraryhome.fxml");
						//loginWindow.setScene(sceneHandler("successLogin", objectMap));		
					}
					else 
					{
						errorText.setText("Sorry, something went wrong...Retry!");
						//loginWindow.setScene(sceneHandler("successLogin", null));	
					}
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				
			}
			else 
			{
				System.out.println("GUI.cls - start() - username or password empty");
			}
        
    }
    
    @FXML protected void handleRegistrationButton(ActionEvent event) throws Exception {
    	
		GUIUtils guiUtils = GUIUtils.getInstance();
		
		if(!registerNameField.getText().isEmpty() && !registerSurnameField.getText().isEmpty() 
				&& !registerUsernameField.getText().isEmpty() && !registerPasswordField.getText().isEmpty() 
				&& !registerEmailField.getText().isEmpty()) 
		{
			System.out.println("GUI.cls - start() - name: " + registerNameField.getText());
			System.out.println("GUI.cls - start() - surname: " + registerSurnameField.getText());
			System.out.println("GUI.cls - start() - username: " + registerUsernameField.getText());
			System.out.println("GUI.cls - start() - Pass: " + registerPasswordField.getText());
			System.out.println("GUI.cls - start() - email: " + registerEmailField.getText());
//			LoginService logService = LoginService.getInstance();
//			try {
//				User u = new User();
//				u = logService.login((String)usernameField.getText(),(String)passwordField.getText());
//				if(u != null) 
//				{
//					Map<String, Object> objectMap = new HashMap<String, Object>();
//					objectMap.put("Username", u.getUsername());
//					DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/welcomePage.fxml");
//					//loginWindow.setScene(sceneHandler("successLogin", objectMap));		
//				}
//				else 
//				{
//					errorText.setText("Sorry, something went wrong...Retry!");
//					//loginWindow.setScene(sceneHandler("successLogin", null));	
//				}
//			} catch (ServiceException e) {
//				e.printStackTrace();
//			}
			
		}
		else 
		{
			System.out.println("GUI.cls - start() - username already exist");
		}
    
}
    
    
}