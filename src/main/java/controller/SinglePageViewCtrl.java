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
import javafx.scene.web.HTMLEditor;
import model.Scansione;
import model.Trascrizione;
import model.service.ScansioneService;
import model.service.TrascrizioneService;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SinglePageViewCtrl implements Initializable{
	
	@FXML ImageView pageScan;
	@FXML HTMLEditor pageTranscription;
	@FXML Text scanId;
	@FXML Button saveButton;
	@FXML Button validateButton;
	@FXML Button assignmentButton;
    
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
    			
    			ScansioneService sService = ScansioneService.getInstance();
    			Scansione tempScan = sService.getScanByPath(scanId.getText());
    			
    			
    			TrascrizioneService tService = TrascrizioneService.getInstance();
    			Trascrizione tempTrascr = tService.getTranscriptionByScanId(tempScan.getId());
    			
    			String replacedHtmlString = tempTrascr.getTesto().replace("<apx>", "\"");
    			
    			pageTranscription.setHtmlText(replacedHtmlString);
    			
    			if(tempTrascr.getValidata() == 1) {
    				validateButton.setDisable(true);
    			}
    			
    	           
    		}
    		catch (Exception e) 
    		{
    			System.out.println("SinglePageViewCtrl.cls - inizialize() - exception: " + e.getMessage());
        		e.printStackTrace();
    		}
        
        System.out.println("SinglePageViewCtrl.cls - inizialize() - groupId: " + userPreferences.get("groupId", null));
		if(userPreferences.get("groupId",null) != null && userPreferences.get("groupId",null).equals("3")) 
		{
			pageTranscription.setDisable(true);
			validateButton.setVisible(false);
			saveButton.setVisible(false);
			assignmentButton.setVisible(false);
		}
		else if(userPreferences.get("groupId",null) != null && userPreferences.get("groupId",null).equals("2"))
		{
			pageTranscription.setDisable(false);
			validateButton.setVisible(false);
			saveButton.setVisible(true);
			assignmentButton.setVisible(false);
		}
    			
    }
    
    @FXML protected void saveTranscription(ActionEvent event) throws Exception 
    {
    		try 
    		{
    			GUIUtils guiUtils = GUIUtils.getInstance();
    	        System.out.println("SinglePageViewCtrl.cls - saveTranscription() - scanId: " + scanId.getText());
    	        System.out.println("SinglePageViewCtrl.cls - saveTranscription() - pageTranscription: " + pageTranscription.getHtmlText());
    	        ScansioneService scanService = ScansioneService.getInstance();
    	        Scansione scan = scanService.getScanByPath(scanId.getText());
    	        System.out.println("SinglePageViewCtrl.cls - saveTranscription() - pageTranscription: " + scan.toString());
    	        
    	        Trascrizione transcription = new Trascrizione();
    	        transcription.setIdScan(scan.getId());
    	        String replaceHTMLString = pageTranscription.getHtmlText().replace("\"","<apx>");;
    	        transcription.setTesto(replaceHTMLString);
    	        transcription.setValidata(0);
    	        TrascrizioneService tService = TrascrizioneService.getInstance();
    	        tService.saveTranscription(transcription);
    	        validateButton.setDisable(false);
    	        guiUtils.closePopupWindow(saveButton.getScene());	
    		}
    		catch (Exception e) 
    		{
    			System.out.println("SinglePageViewCtrl.cls - saveTranscription() - exception: " + e.getMessage());
        		e.printStackTrace();
		}
           
    }
    
    
    @FXML protected void validateTranscription(ActionEvent event) throws Exception 
    {
    		try 
    		{
    	        System.out.println("SinglePageViewCtrl.cls - validateTranscription() - scanId: " + scanId.getText());
    	        ScansioneService scanService = ScansioneService.getInstance();
    	        Scansione scan = scanService.getScanByPath(scanId.getText());
    	        System.out.println("SinglePageViewCtrl.cls - validateTranscription() - pageTranscription: " + scan.toString());
    	        
    	        Trascrizione transcription = new Trascrizione();
    	        transcription.setIdScan(scan.getId());
    	        String replaceHTMLString = pageTranscription.getHtmlText().replace("\"","<apx>");;
    	        transcription.setTesto(replaceHTMLString);
    	        transcription.setValidata(0);
    	        TrascrizioneService tService = TrascrizioneService.getInstance();
    	        tService.validateTranscription(transcription);
    	        validateButton.setDisable(true);	
    		}
    		catch (Exception e) 
    		{
    			System.out.println("SinglePageViewCtrl.cls - validateTranscription() - exception: " + e.getMessage());
        		e.printStackTrace();
		}
           
    }


    
}
 
