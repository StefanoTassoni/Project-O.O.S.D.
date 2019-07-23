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
    	        guiUtils.closePopupWindow(validateButton.getScene());	
    		}
    		catch (Exception e) 
    		{
    			System.out.println("SinglePageViewCtrl.cls - saveTranscription() - exception: " + e.getMessage());
        		e.printStackTrace();
		}
           
    } 


    
}
 
