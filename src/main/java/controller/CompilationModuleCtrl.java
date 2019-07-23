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
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import service.model.User;
import service.model.Modulo;
import service.ModuloService;
import service.UserService;


public class CompilationModuleCtrl  implements Initializable{

	@FXML Text userName;
	@FXML TextField qualification;
	@FXML TextField message;
	@FXML Button sendModule;
	
	
	public void initialize(URL location, ResourceBundle resources) 
	{
		UserService uService = UserService.getInstance();
		Preferences session = Preferences.userRoot();
		String username = session.get("username", null);
		try {
			User tempUser = uService.getByUsername(username);
			userName.setText(tempUser.getName() + ' ' + tempUser.getSurname());
			
		} catch (ServiceException e) {
			System.out.println("CompilationModuleCtrl.cls - initialize() - exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	 @FXML protected void sendModule (ActionEvent event) throws Exception {
		 
		 GUIUtils guiUtils = GUIUtils.getInstance();
 		
 		if(!message.getText().isEmpty()) 
		{
 			try
			{
				System.out.println("CompilationModuleCtrl.cls - sendModule() - message: " + message.getText());
				System.out.println("CompilationModuleCtrl.cls - sendModule() - qualifica: " + qualification.getText());
				ModuloService moduloService = ModuloService.getInstance();
				
				Preferences session = Preferences.userRoot();
				String username = session.get("username", null);
				
				User tempUser = new User();
				
				UserService uService = UserService.getInstance();
				tempUser = uService.getByUsername(username);
				
				Modulo tempModule = new Modulo();
				tempModule.setFkIdUser(tempUser.getId());
				tempModule.setMessage(message.getText());
				tempModule.setQualifica(qualification.getText());
				moduloService.insertModulo(tempModule);
				DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/Libraryhome.fxml");
			}			
 			
			catch (Exception e) 
			{
				e.printStackTrace();
			}	
				
		}
 		else
 		{
			System.out.println("CompilationModuleCtrl.cls - sendModule() - compilare tutti i campi");
		}
	 }
	 
}
