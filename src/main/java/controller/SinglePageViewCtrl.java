package controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SinglePageViewCtrl implements Initializable{
	
	@FXML ImageView pageScan;
	@FXML TextArea pageTranscription;
    
    public void initialize(URL location, ResourceBundle resources) 
    {	
    		
        File repo = new File ("src/main/resources/imagedir/Divina Commedia");
        
        
        if (repo.isDirectory()) 
        {
        		try 
        		{
    	            File[] fileList = repo.listFiles();
    	            
    	            for (File f : fileList) 
    	            {   
    	            		if(f.toString().contains("/cover")) 
    	            		{
    	            			final Image image = new Image(new FileInputStream(f));//, 50, 0, true, true
    	            			pageScan.setImage(image);
    	                }
    	            }
    	            
    	           
        		}
        		catch (Exception e) 
        		{
        			System.out.println("SinglePageViewCtrl.cls - inizialize() - exception: " + e.getMessage());
            		e.printStackTrace();
        		}
        		
        }/****Check isADirectory****/
        else 
        {
        		System.out.println("SinglePageViewCtrl.cls - initialize() - repo is not a folder ");
        }
    			
    }

    
}
 
