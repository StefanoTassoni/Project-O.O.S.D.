package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.gluonhq.charm.glisten.control.CardPane;


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
	    				CardPaneTranscriptor.setVisible(true);
		    			CardPaneAdmin.setVisible(false);
		    			CardPaneUser.setVisible(false);
	    			}
	    			else if(groupId.equals("3")) 
	    			{
	    				CardPaneUser.setVisible(true);
	    				CardPaneTranscriptor.setVisible(false);
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
    		System.out.println("SideBarCtrl.cls - gotoResearchHome()");
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
    		System.out.println("SideBarCtrl.cls - gotoUserProfile()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view" + File.separator + "UserProfilePage.fxml", 600, 500);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    
    @FXML protected void gotoModuleCompiling() throws Exception 
    {	
    		System.out.println("SideBarCtrl.cls - gotoModuleCompiling()");
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
    

    @FXML protected void gotoSeeModule() throws Exception 
    {
    		System.out.println("ResearchController.cls - gotoSeeModule()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/SeeModule.fxml");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }
		

    @FXML protected void temp() throws Exception 
    {	

    		System.out.println("SideBarCtrl.cls - temp()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/Temp.fxml", 600, 500);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    @FXML protected void gotoImageAcquisition() throws Exception 
    {	
    		System.out.println("SideBarCtrl.cls - gotoImageAcquisition()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/ImageAcquisitionHome.fxml", 600, 500);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
}
