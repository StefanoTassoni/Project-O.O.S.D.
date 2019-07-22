package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import org.apache.commons.lang.ArrayUtils;

import controller.utils.GUIUtils;
import controller.utils.StringUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class OperaImageAcquisitionDetailViewCtrl implements Initializable{
	
	@FXML Text operaTitle;
	@FXML Text operaAuthor;
	@FXML Text operaCategory;
	@FXML Text operaLanguage;
	@FXML Text operaPublicationDate;
	@FXML ImageView operaCover;
	@FXML TilePane imageGallery;
	@FXML Button uploadImage;
	
	private final String IMAGEDIR = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "imagedir" + File.separator + "";
    
    public void initialize(URL location, ResourceBundle resources) 
    {
    		System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - inizialize() - Opera: " + DigitalLibrary.currentOpera.toString());
    		try 
	    {
    			operaTitle.setText(DigitalLibrary.currentOpera.getTitolo());
    			operaAuthor.setText(DigitalLibrary.currentOpera.getAutore());
    			operaCategory.setText(DigitalLibrary.currentOpera.getCategoria());
    			operaLanguage.setText(DigitalLibrary.currentOpera.getLingua());
    			operaPublicationDate.setText(StringUtils.stringToDate(DigitalLibrary.currentOpera.getDataPublicazione(), false));
	    } 
        catch (Exception e) 
        {
        		System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - inizialize() - opera detail exception: " + e.getMessage());
    			e.printStackTrace();
    		}
    			
		/****************
		 * image capture
		 *****************/
		//System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - inizialize() - Working Directory: " + System.getProperty("user.dir") );
    		
    		imageGallery.setPadding(new Insets(15, 15, 15, 15));
    		imageGallery.setHgap(15);
    		
    		
        File repo = new File (IMAGEDIR + DigitalLibrary.currentOpera.getId());
        System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - inizialize() - repo: " + repo );
        
        if (repo.isDirectory()) 
        {
        		try 
        		{
    	            File[] fileList = repo.listFiles();
    	               
    	             
    	            
    	            /**loading the available pages of the opera**/
    	            fileList = (File[]) ArrayUtils.removeElement(fileList, 0);
    	            System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - inizialize() - fileList: " + fileList.length);
    	            
    	            for (File f : fileList) 
    	            {   
    	            		if(!f.toString().contains("" + File.separator + "cover")) 
    	            		{
	    		            ImageView imageView;
	    	                imageView = createImageView(f);
	    	                imageView.setId(f.toString());
	    	                imageGallery.getChildren().addAll(imageView);
    	                }
    	            		else 
    	                {
    	            			/**setting the cover**/
    	            			final Image image = new Image(new FileInputStream(f));
    	            			operaCover.setImage(image);
    	                }
    	            }
    	            
    	           
        		}
        		catch (Exception e) 
        		{
        			System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - inizialize() - opera images exception: " + e.getMessage());
            		e.printStackTrace();
        		}
        		
        }/****Check isADirectory****/
        else 
        {
        		System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - photo() - repo is not a folder ");
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
    
//    @FXML
//    public void showOperaSinglePage(MouseEvent event)
//    {
//        if (event.getClickCount() == 2) //Checking double click
//        {
//        		//System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - showOperaSinglePage() - eventTarget: " + event.getTarget().toString());
//        		//System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - showOperaSinglePage() - eventTarget: " + event.toString());
//            
//        		Preferences userPreferences = Preferences.userRoot();
//        		String currentSelectedScan = ((ImageView) event.getTarget()).getId();
//        		userPreferences.put("currentSelectedScan", currentSelectedScan);
//        		
//        		System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - showOperaSinglePage() - scanPath: " + currentSelectedScan);
//        		
//            GUIUtils guiUtils = GUIUtils.getInstance();
//            try 
//            {	
//	        		guiUtils.popUpNewResizeSceneContent(DigitalLibrary.root,"view" + File.separator + "SinglePageView.fxml",600,500);
//			} 
//            catch (Exception e) {
//				e.printStackTrace();
//			}
//        }
//    }
    
    @FXML
    public void uploadImage(MouseEvent event)
    {
        
    		//System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - showOperaSinglePage() - eventTarget: " + event.getTarget().toString());
    		//System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - showOperaSinglePage() - eventTarget: " + event.toString());
    		
        GUIUtils guiUtils = GUIUtils.getInstance();
        try 
        {	
        		guiUtils.popUpNewResizeSceneContent(DigitalLibrary.root,"view" + File.separator + "UploadOperaScan.fxml", 400 , 300);
		} 
        catch (Exception e) {
        		System.out.println("OperaImageAcquisitionDetailViewCtrl.cls - inizialize() - uploadImage exception: " + e.getMessage());
			e.printStackTrace();
		}
    }
    
}
 
