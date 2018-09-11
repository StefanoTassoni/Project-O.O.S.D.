package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import controller.exception.ServiceException;
import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.User;
import model.service.LoginService;
 
public class LoginController 
{
    @FXML TextField usernameField;
    @FXML TextField passwordField;
    @FXML Text errorText;
    @FXML Button signInButton;
    
    
    @FXML protected void handleLoginButton(ActionEvent event) throws Exception {
    	
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		usernameField.getText();
    		passwordField.getText();
    		
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
						DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/welcomePage.fxml");
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
    
    
}