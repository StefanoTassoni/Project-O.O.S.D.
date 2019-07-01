package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.lang.ArrayUtils;

import controller.utils.GUIUtils;
import controller.utils.StringUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import model.service.OperaService;

public class OperaDetailViewCtrl implements Initializable{
	
	@FXML Text operaTitle;
	@FXML Text operaAuthor;
	@FXML Text operaCategory;
	@FXML Text operaLanguage;
	@FXML Text operaPublicationDate;
	@FXML ImageView operaCover;
	@FXML TilePane imageGallery;
    
    public void initialize(URL location, ResourceBundle resources) 
    {
    		System.out.println("OperaDetailViewCtrl.cls - inizialize() - Opera: " + DigitalLibrary.currentOpera.toString());
    		try 
	    {
    			operaTitle.setText(DigitalLibrary.currentOpera.getTitolo());
    			operaAuthor.setText(DigitalLibrary.currentOpera.getAutore());
    			operaCategory.setText(DigitalLibrary.currentOpera.getCategoria());
    			operaLanguage.setText(DigitalLibrary.currentOpera.getLingua());
    			//System.out.println("OperaDetailViewCtrl.cls - inizialize() - OperaPublicationDate: " + DigitalLibrary.currentOpera.getDataPublicazione());
    			operaPublicationDate.setText(StringUtils.stringToDate(DigitalLibrary.currentOpera.getDataPublicazione(), false));
	    } 
        catch (Exception e) 
        {
        		System.out.println("OperaDetailViewCtrl.cls - inizialize() - opera detail exception: " + e.getMessage());
    			e.printStackTrace();
    		}
    			
		/****************
		 * image capture
		 *****************/
		System.out.println("OperaDetailViewCtrl.cls - inizialize() Working Directory = " + System.getProperty("user.dir") );
    		
    		imageGallery.setPadding(new Insets(15, 15, 15, 15));
    		imageGallery.setHgap(15);
    		
    		
        File repo = new File ("src/main/resources/imagedir/Divina Commedia");
        System.out.println("OperaDetailViewCtrl.cls - inizialize() - repo: " + repo );
        
        if (repo.isDirectory()) 
        {
        		try 
        		{
    	            File[] fileList = repo.listFiles();
    	               
    	             
    	            //	Image coverImage = new Image(fileList[0].toURI().toString());
    	            	//System.out.println("OperaDetailViewCtrl.cls - inizialize() - coverImage repo: " + fileList[0].toURI().toString());
    	            //operaCover = new ImageView(coverImage);
    	            
    	            //setting the available pages of the opera
    	            fileList = (File[]) ArrayUtils.removeElement(fileList, 0);
    	            System.out.println("OperaDetailViewCtrl.cls - inizialize() - fileList: " + fileList.length);
    	            
    	            for (File f : fileList) 
    	            {   
    	            		if(!f.toString().contains("/cover")) 
    	            		{
	    	            		//System.out.println("OperaDetailViewCtrl.cls - inizialize() - current file: " + f);
	    		            ImageView imageView;
	    	                imageView = createImageView(f);
	    	                imageGallery.getChildren().addAll(imageView);
    	                }
    	            		else 
    	                {
    	            			//setting the cover
    	            			//System.out.println("OperaDetailViewCtrl.cls - inizialize() - current file: " + f);
    	            			final Image image = new Image(new FileInputStream(f));//new FileInputStream(f), 50, 0, true, true
    	            			operaCover.setImage(image);
    	            			//operaCover.setFitWidth(50);
    	                }
    	            }
    	            
    	           
        		}
        		catch (Exception e) 
        		{
        			System.out.println("OperaDetailViewCtrl.cls - inizialize() - opera images exception: " + e.getMessage());
            		e.printStackTrace();
        		}
        		
        }/****Check isADirectory****/
        else 
        {
        		System.out.println("OperaDetailViewCtrl.cls - photo() - repo is not a folder ");
        }
    			
    }

    private ImageView createImageView(final File imageFile) {

        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 50, 0, true, true);
            imageView = new ImageView(image);
            imageView.setFitWidth(50);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return imageView;
    }
    
    @FXML
    public void showOperaSinglePage(MouseEvent event)
    {
        if (event.getClickCount() == 2) //Checking double click
        {
        		System.out.println("OperaDetailViewCtrl.cls - showOperaSinglePage() - selected Image: " + imageGallery.getChildren());
        		System.out.println("OperaDetailViewCtrl.cls - showOperaSinglePage() - eventSource: " + event.getSource());
            //System.out.println("OperaListCtrl.cls - showOpera() - Opera detail requested: " + tableView.getSelectionModel().getSelectedItem().getTitolo());
            GUIUtils guiUtils = GUIUtils.getInstance();
            try 
            {
            //			String url = image instanceof LocatedImage ? ((LocatedImage) image).getURL() : null;
	        //    	DigitalLibrary.currentOpera = operaService.getOperaById(tableView.getSelectionModel().getSelectedItem().getId());	
	        		guiUtils.popUpNewResizeSceneContent(DigitalLibrary.root,"view/SinglePageView.fxml",600,500);
			} 
            catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
}
 
