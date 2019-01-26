package controller;

import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.User;
import model.Modulo;
import model.service.ModuloService;
import model.service.UserService;


public class CompilationModuleCtrl {

	@FXML TextField username;
	@FXML TextField mail;
	@FXML TextField message;
	@FXML Button sendModule;
	
	 @FXML protected void sendModule (ActionEvent event) throws Exception {
		 
		 GUIUtils guiUtils = GUIUtils.getInstance();
 		
 		if(!message.getText().isEmpty()) 
		{
 			try
			{
				System.out.println("EditUserProfileCtrl.cls - sendModule() - message: " + message.getText());
				ModuloService moduloService = ModuloService.getInstance();
				moduloService.insertModulo(message.getText());
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
	 
	 
	 @FXML protected void gotoResearchHome() throws Exception 
	    {	
	    		System.out.println("UserProfileCtrl.cls - gotoResearchHome()");
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
	    		System.out.println("UserProfileCtrl.cls - gotoUserProfile()");	
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
	    		System.out.println("UserProfileCtrl.cls - gotoUserProfile()");
	    		GUIUtils guiUtils = GUIUtils.getInstance();
			try 
			{
				DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/CompilationModule.fxml");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	    }
}
