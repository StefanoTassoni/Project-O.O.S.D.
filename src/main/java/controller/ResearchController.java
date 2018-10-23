package controller;

import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
 
public class ResearchController 
{
    
    /***REGISTER***/
    @FXML TextField operaName;
    @FXML TextField operaCategory;
    @FXML TextField operaAuthor;
    @FXML TextField operaYear;
    @FXML TextField operaLanguage;
    @FXML Button searchButton;
    //@FXML Text registerErrorText;
    
    
    @FXML protected void searchOpera(ActionEvent event) throws Exception 
    {	
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		
    		if(!operaName.getText().isEmpty() && !operaCategory.getText().isEmpty() &&
			!operaAuthor.getText().isEmpty() && !operaYear.getText().isEmpty() &&
			!operaLanguage.getText().isEmpty() ) 
		{
			try 
			{
				System.out.println("ResearchController.cls - searchOpera() - operaName: " + operaName.getText());
				System.out.println("ResearchController.cls - searchOpera() - operaCategory: " + operaCategory.getText());
				System.out.println("ResearchController.cls - searchOpera() - operaAuthor: " + operaAuthor.getText());
				System.out.println("ResearchController.cls - searchOpera() - operaLanguage: " + operaLanguage.getText());
				System.out.println("ResearchController.cls - searchOpera() - operaYear: " + operaYear.getText());
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("ResearchController.cls - searchOpera() - username or password empty");
		}
    
    }
    
    @FXML protected void gotoResearchHome() throws Exception 
    {	
    		System.out.println("ResearchController.cls - gotoResearchHome() - username or password empty");
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
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/LoginPage.fxml");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    @FXML protected void gotoModuleCompiling() throws Exception 
    {	
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