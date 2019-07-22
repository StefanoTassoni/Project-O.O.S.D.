package controller;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.ZoneId;
//import java.util.Date;
import java.util.ResourceBundle;

import controller.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import model.Opera;
import model.service.OperaService;


public class UploadNewOperaCtrl  implements Initializable{
	
	@FXML TextField operaTitle;
	@FXML TextField operaAuthor;
	@FXML TextField operaCategory;
	@FXML TextField operaLanguage;
	@FXML DatePicker operaPublicationDate;
	@FXML DatePicker operaCreationDate;
	@FXML ImageView operaCover;
	@FXML TilePane imageGallery;
	@FXML Button uploadOpera;
	
	private final String IMAGEDIR = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "imagedir" + File.separator + "";
    
    public void initialize(URL location, ResourceBundle resources) 
    {
    		System.out.println("UploadNewOperaCtrl.cls - inizialize()");
    }
    
   
    @FXML
    public void uploadNewOpera(MouseEvent event)
    {
    		OperaService oService = OperaService.getInstance();
    		Opera newOpera = new Opera();
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		Boolean operaSaved = false;
	    	try 
	    {
    			if(operaTitle.getText() != null && operaAuthor.getText() != null && operaCategory.getText() != null 
    					&& operaLanguage.getText() != null && operaPublicationDate.getValue() != null && operaCreationDate.getValue() != null) 
    			{
    				newOpera.setTitolo(operaTitle.getText());
    				newOpera.setAutore(operaAuthor.getText());
    				newOpera.setCategoria(operaCategory.getText());
    				newOpera.setLingua(operaLanguage.getText());
    				System.out.println("UploadNewOperaCtrl.cls - inizialize() - operaPublicationDate: " + operaPublicationDate.getValue());
    				newOpera.setDataPublicazione(Date.from(operaPublicationDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    				newOpera.setDateCreazione(Date.from(operaCreationDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    				//java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    				
    				if(oService.saveOpera(newOpera)) {
    					guiUtils.closePopupWindow(uploadOpera.getScene());
    				}
    				
    			}
    			
    			
    			
	    } 
        catch (Exception e) 
        {
        		System.out.println("UploadNewOperaCtrl.cls - inizialize() - opera detail exception: " + e.getMessage());
    			e.printStackTrace();
    		}
    		
    		
        File repo = new File (IMAGEDIR);
        System.out.println("UploadNewOperaCtrl.cls - inizialize() - repo: " + repo );
        
        if (repo.isDirectory() && operaSaved) 
        {
        		try 
        		{
		        Opera tempOpera = oService.getByTitle(newOpera.getTitolo()).get(0);
		        boolean success = ( new File(String.valueOf(tempOpera.getId()))).mkdir();
		        
		        if (success) 
		        { 
		        		System.out.println("UploadNewOperaCtrl.cls - inizialize() - Directory: " + IMAGEDIR + String.valueOf(tempOpera.getId()) + " created");
		        }        
        		}
        		catch (Exception e) 
        		{
        			System.out.println("UploadNewOperaCtrl.cls - inizialize() - opera images exception: " + e.getMessage());
            		e.printStackTrace();
        		}
        		
        }
    }
}