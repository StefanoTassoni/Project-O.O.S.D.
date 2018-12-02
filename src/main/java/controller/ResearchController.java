package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.utils.GUIUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import com.gluonhq.charm.glisten.control.CardPane;

import model.Opera;
import model.service.OperaService;
 
public class ResearchController implements Initializable{
    
    /***REGISTER***/
    @FXML TextField operaName;
    @FXML TextField operaCategory;
    @FXML TextField operaAuthor;
    @FXML TextField operaYear;
    @FXML TextField operaLanguage;
    @FXML Button searchButton;
    //@FXML Text registerErrorText;
    
    @FXML CardPane CardPaneAdmin;
    @FXML CardPane CardPaneUser;
    
    
    public void initialize(URL location, ResourceBundle resources) 
    {
	    	try 
	    {
	    		//TODO if profile = user delete following tab
	    		System.out.println("ResearchController.cls - initialize()");
	    		CardPaneUser.setVisible(false);
	    		CardPaneAdmin.setVisible(true);
	    		
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
    }
    
    
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
				DigitalLibrary.currentResearch = operaService.getByTitle(operaName.getText());
				
				System.out.println("ResearchController.cls - searchOpera() - operas: " + DigitalLibrary.currentResearch.toString());
				
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