package controller;

import java.util.prefs.Preferences;

import controller.exception.ServiceException;
import controller.utils.GUIUtils;
import controller.utils.StringUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import service.model.User;
import service.LoginService;
import service.UserService;
 
public class LoginController 
{
	/***LOGIN***/
    @FXML TextField usernameField;
    @FXML TextField passwordField;
    @FXML Button signInButton;
    @FXML Text loginErrorText;
    
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
				System.out.println("LoginController.cls - handleLoginButton() - username: " + usernameField.getText());
				System.out.println("LoginController.cls - handleLoginButton() - password: " + passwordField.getText());
				LoginService logService = LoginService.getInstance();
				UserService userService = UserService.getInstance();
				
				try 
				{
					User u = new User();
					u = logService.login((String)usernameField.getText(),(String)passwordField.getText());
					
					if(u != null) 
					{
						Integer groupId = userService.getUserGroupId(String.valueOf(u.getId()));
						//Prefereces used to store session information
						Preferences userPreferences = Preferences.userRoot();
						userPreferences.putInt("userId",u.getId());
						userPreferences.put("username",u.getUsername());
						userPreferences.put("groupId", String.valueOf(groupId));
						System.out.println("LoginController.cls - handleLoginButton() - groupId: " + groupId);
						DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/Libraryhome.fxml");		
					}
					else 
					{
						loginErrorText.setText("Sorry, something went wrong...Retry!");
						loginErrorText.setVisible(true);
					}
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				
			}
			else 
			{
				System.out.println("LoginController.cls - handleLoginButton() - username or password empty");
			}
        
    }
    
    @FXML protected void handleRegistrationButton(ActionEvent event) throws Exception {
		
		if(!registerNameField.getText().isEmpty() && !registerSurnameField.getText().isEmpty() 
				&& !registerUsernameField.getText().isEmpty() && !registerPasswordField.getText().isEmpty() 
				&& !registerEmailField.getText().isEmpty()) 
		{
			System.out.println("LoginController.cls - handleRegistrationButton() - name: " + registerNameField.getText());
			System.out.println("LoginController.cls - handleRegistrationButton() - surname: " + registerSurnameField.getText());
			System.out.println("LoginController.cls - handleRegistrationButton() - username: " + registerUsernameField.getText());
			System.out.println("LoginController.cls - handleRegistrationButton() - Pass: " + registerPasswordField.getText());
			System.out.println("LoginController.cls - handleRegistrationButton() - email: " + registerEmailField.getText());
			LoginService logService = LoginService.getInstance();
			try {
				User u = new User();
				u.setName(registerNameField.getText());
				u.setSurname(registerSurnameField.getText());
				u.setUsername(registerUsernameField.getText());
				u.setMail(registerEmailField.getText());
				u.setAddress("");
				u.setPhone("");
				u.setPassword(StringUtils.crypt(registerPasswordField.getText()));
				Boolean isCreated = logService.register(u);
				if(isCreated) 
				{
					registerErrorText.setText("Grazie, ora effettua il login!");
					registerErrorText.visibleProperty().set(true);
				}
				else 
				{
					registerErrorText.setText("Attenzione, username esistente!");
					registerErrorText.visibleProperty().set(true);
				}
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
		}
		else 
		{
			System.out.println("LoginController.cls - handleRegistrationButton() - campi non compilati");
			registerErrorText.setText("Attenzione, compila tutti i campi per completare la registrazione!");
			registerErrorText.visibleProperty().set(true);
		}
    
    }
    
    
}