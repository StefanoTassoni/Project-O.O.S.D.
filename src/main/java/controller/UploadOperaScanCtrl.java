package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.exception.ServiceException;
import controller.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import model.Scansione;
import model.service.ScansioneService;

public class UploadOperaScanCtrl implements Initializable{
	
	@FXML Text operaTitle;
	@FXML Text operaAuthor;
	@FXML TextField pageN;
	@FXML Button saveScan;
	
	private final String IMAGEDIR = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "imagedir" + File.separator + "";
    
    public void initialize(URL location, ResourceBundle resources) 
    {
    		System.out.println("UploadOperaScanCtrl.cls - inizialize() - Opera: " + DigitalLibrary.currentOpera.toString());try 
	    {
    			operaTitle.setText(DigitalLibrary.currentOpera.getTitolo());
    			operaAuthor.setText(DigitalLibrary.currentOpera.getAutore());
	    } 
        catch (Exception e) 
        {
        		System.out.println("UploadOperaScanCtrl.cls - inizialize() - opera detail exception: " + e.getMessage());
    			e.printStackTrace();
    		}
    }
    
    @FXML
    public void uploadImageScan(MouseEvent event)
    {
    		System.out.println("UploadOperaScanCtrl.cls - uploadImageScan() - Opera: " + DigitalLibrary.currentOpera.toString());
		if(pageN.getText() != null && DigitalLibrary.currentOpera.getId() != null && Integer.valueOf(pageN.getText()) instanceof Integer) 
		{
			
	        File repo = new File (IMAGEDIR + DigitalLibrary.currentOpera.getId() + File.separator);
	        Path newImagePath = Paths.get(repo.toString() + File.separator + pageN.getText() + ".jpg"  );
	        System.out.println("UploadOperaScanCtrl.cls - uploadImageScan() - repo: " + repo );
	        try 
	        {
		        FileChooser fileChooser = new FileChooser();
		        fileChooser.setTitle("Open Resource File");
		       
		        File selectedImage = fileChooser.showOpenDialog(DigitalLibrary.stage);
		        if (selectedImage != null) 
		        {
		        		System.out.println("UploadOperaScanCtrl.cls - uploadImageScan() - selectedImage Path: " + selectedImage.toPath());
		        		System.out.println("UploadOperaScanCtrl.cls - uploadImageScan() - newImagePath absolutePath: " + newImagePath.toAbsolutePath());
		        		System.out.println("UploadOperaScanCtrl.cls - uploadImageScan() - newImagePath Path: " + newImagePath);
		        		
					Files.copy(selectedImage.toPath(), newImagePath , StandardCopyOption.REPLACE_EXISTING);
		        		
		        }	
	        } 
	        catch (IOException e) 
	        {
	        		System.out.println("UploadOperaScanCtrl.cls - uploadImageScan() - exception: " + e.getMessage());
				e.printStackTrace();
			}
	        
	        Preferences userPreferences = Preferences.userRoot();
			
			Date todayDate = new Date();
			todayDate = Calendar.getInstance().getTime();
			
			Scansione newScan = new Scansione();  
			newScan.setFormato("jpg");
			newScan.setDataPubblicazione(todayDate);
			newScan.setIdOpera(DigitalLibrary.currentOpera.getId());
			newScan.setIdUser(userPreferences.getInt("userId", 0));
			newScan.setPagina(pageN.getText());
			newScan.setPath(newImagePath.toString());
			
			ScansioneService scanService = ScansioneService.getInstance();
			try 
			{
				scanService.saveScan(newScan);
			} 
			catch (ServiceException e) 
			{
				System.out.println("UploadOperaScanCtrl.cls - uploadImageScan() - insert exception: " + e.getMessage());
				e.printStackTrace();
			}
	    		
	    		
	        GUIUtils guiUtils = GUIUtils.getInstance();
	        try 
	        {	
	        		guiUtils.closePopupWindow(saveScan.getScene());
			} 
	        catch (Exception e) {
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("UploadOperaScanCtrl.cls - uploadImageScan() - inserire numero di pagina");
		}
    }
}
 
