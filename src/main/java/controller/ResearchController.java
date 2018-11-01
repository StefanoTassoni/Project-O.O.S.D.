package controller;

import java.util.List;

import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Opera;
import model.service.OperaService;
 
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
    		OperaService operaService = OperaService.getInstance();
    		
    		if(!operaName.getText().isEmpty()) 
		{
			try 
			{
				System.out.println("ResearchController.cls - searchOpera() - operaName: " + operaName.getText());
				System.out.println("ResearchController.cls - searchOpera() - operaCategory: " + operaCategory.getText());
				System.out.println("ResearchController.cls - searchOpera() - operaAuthor: " + operaAuthor.getText());
				System.out.println("ResearchController.cls - searchOpera() - operaLanguage: " + operaLanguage.getText());
				System.out.println("ResearchController.cls - searchOpera() - operaYear: " + operaYear.getText());
				List<Opera> operas = operaService.getByTitle(operaName.getText());
				
				System.out.println("ResearchController.cls - searchOpera() - operas: " + operas.toString());
				
				DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/OperaListPage.fxml");
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("ResearchController.cls - searchOpera() - Insert opera title");
		}
    
    }
    
    @FXML protected void gotoResearchHome() throws Exception 
    {	
    		System.out.println("ResearchController.cls - gotoResearchHome()");
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
    		System.out.println("ResearchController.cls - gotoUserProfile()");
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
    		System.out.println("ResearchController.cls - gotoModuleCompiling()");
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