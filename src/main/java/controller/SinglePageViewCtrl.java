package controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SinglePageViewCtrl implements Initializable{
	
	@FXML ImageView pageScan;
	@FXML TextArea pageTranscription;
	@FXML Text scanId;
	@FXML Button saveButton;
    
    public void initialize(URL location, ResourceBundle resources) 
    {	
    		Preferences userPreferences = Preferences.userRoot();
    		System.out.println("SinglePageViewCtrl.cls - inizialize() - currentSelectedScan: " + userPreferences.get("currentSelectedScan", null));
        
        try 
        {
    			File file = new File (userPreferences.get("currentSelectedScan", null));
    			final Image image = new Image(new FileInputStream(file));//, 50, 0, true, true
    			pageScan.setImage(image);
    			
    			scanId.setText(userPreferences.get("currentSelectedScan", null));
    	           
    		}
    		catch (Exception e) 
    		{
    			System.out.println("SinglePageViewCtrl.cls - inizialize() - exception: " + e.getMessage());
        		e.printStackTrace();
    		}

    			
    }
    
    @FXML protected void saveTranscription(ActionEvent event) throws Exception 
    {
    		try 
    		{
    			GUIUtils guiUtils = GUIUtils.getInstance();
    	        //System.out.println("SinglePageViewCtrl.cls - saveTranscription() - scanId: " + scanId.getText());
    	        //System.out.println("SinglePageViewCtrl.cls - saveTranscription() - pageTranscription: " + pageTranscription.getText());
    	        guiUtils.closePopupWindow(saveButton.getScene());	
    		}
    		catch (Exception e) 
    		{
    			System.out.println("SinglePageViewCtrl.cls - saveTranscription() - exception: " + e.getMessage());
        		e.printStackTrace();
		}
           
    } 


    
}
 
