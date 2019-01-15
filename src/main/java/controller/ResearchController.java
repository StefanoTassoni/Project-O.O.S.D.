package controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    
    /***Sidebar START***/
    @FXML CardPane CardPaneAdmin;
    @FXML CardPane CardPaneUser;
    @FXML CardPane CardPaneTranscriptor;
    
    
    public void initialize(URL location, ResourceBundle resources) 
    {
	    	try 
	    {
	    		//TODO if profile = user delete following tab
	    		System.out.println("ResearchController.cls - initialize()");
	    		Preferences userPreferences = Preferences.userRoot();
	    		String groupId = userPreferences.get("groupId", null);
	    		System.out.println("ResearchController.cls - initialize() - groupId: " + groupId);
	    		if(groupId != null) 
	    		{
	    			if(groupId.equals("1")) 
	    			{
	    				CardPaneAdmin.setVisible(true);
		    			CardPaneUser.setVisible(false);
		    			CardPaneTranscriptor.setVisible(false);
	    			}
	    			else if(groupId.equals("2")) 
	    			{
	    				CardPaneUser.setVisible(true);
		    			CardPaneAdmin.setVisible(false);
		    			CardPaneTranscriptor.setVisible(false);
	    			}
	    			else if(groupId.equals("3")) 
	    			{
	    				CardPaneTranscriptor.setVisible(true);
	    				CardPaneUser.setVisible(false);
		    			CardPaneAdmin.setVisible(false);
	    			}
	    		}
	    		else 
	    		{
	    			System.out.println("ResearchController.cls - initialize() - no group related to this account!");
	    		}
	    		
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
				
				if (operaCategory.getText().isEmpty() && operaAuthor.getText().isEmpty() 
						&& operaLanguage.getText().isEmpty() && operaYear.getText().isEmpty()) 
				{
					DigitalLibrary.currentResearch = operaService.getByTitle(operaName.getText());
				}
				else 
				{
					List<String> queryConditions = new ArrayList<String>();
				
					queryConditions.add(" TITOLO LIKE \"%" + operaName.getText() + "%\"  ");
					
					if (!operaCategory.getText().isEmpty()) queryConditions.add(" CATEGORIA LIKE \"%" + operaCategory.getText() + "%\"  ");
					
					if (!operaAuthor.getText().isEmpty()) queryConditions.add(" AUTORE LIKE \"%" + operaAuthor.getText() + "%\"  ");
					
					if (!operaLanguage.getText().isEmpty()) queryConditions.add(" LINGUA LIKE \"%" + operaLanguage.getText() + "%\"  ");
					
					if (!operaYear.getText().isEmpty())
					{ 
						String dataCreazione = operaYear.getText();
						SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
						java.util.Date textFieldAsDate = null;

						try {
						    textFieldAsDate = sdf.parse(dataCreazione);
						} catch (ParseException pe) {
							System.out.println("ResearchController.cls - searchOpera() - parseError: " + pe);
						}
						queryConditions.add(" DATA_CREAZIONE = \"" + textFieldAsDate + "\"  ");
					}
					
					DigitalLibrary.currentResearch = operaService.getByResearchField(queryConditions);
				}
				
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
    /***Sidebar STOP***/
    
}