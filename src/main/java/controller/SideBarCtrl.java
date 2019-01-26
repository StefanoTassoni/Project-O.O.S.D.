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

public class SideBarCtrl implements Initializable{

	@FXML CardPane CardPaneAdmin;
	@FXML CardPane CardPaneUser;
	@FXML CardPane CardPaneTranscriptor;
	
	
	public void initialize(URL location, ResourceBundle resources) 
    {
	    	try 
	    {
	    		//TODO if profile = user delete following tab
	    		System.out.println("SideBarCtrl.cls - initialize()");
	    		Preferences userPreferences = Preferences.userRoot();
	    		String groupId = userPreferences.get("groupId", null);
	    		System.out.println("SideBarCtrl.cls - initialize() - groupId: " + groupId);
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
	    			System.out.println("SideBarCtrl.cls - initialize() - no group related to this account!");
	    		}
	    		
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
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
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/CompilationModule.fxml", 600, 500);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    
    @FXML protected void gotoImageAcquisition() throws Exception 
    {	
    		System.out.println("ResearchController.cls - gotoImageAcquisition()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/ImageAcquisitionHome.fxml");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
}