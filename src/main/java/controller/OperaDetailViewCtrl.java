package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.lang.ArrayUtils;

import controller.utils.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

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
	    	            		System.out.println("OperaDetailViewCtrl.cls - inizialize() - current file: " + f);
	    		            ImageView imageView;
	    	                imageView = createImageView(f);
	    	                imageGallery.getChildren().addAll(imageView);
    	                }
    	            		else 
    	                {
    	            			//setting the cover
    	            			System.out.println("OperaDetailViewCtrl.cls - inizialize() - current file: " + f);
    	            			final Image image = new Image(new FileInputStream(f), 50, 0, true, true);
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
        		System.out.println("GetAllFolderContents.cls - photo() - repo is not a folder ");
        }
    			
    }

    private ImageView createImageView(final File imageFile) {
        // DEFAULT_THUMBNAIL_WIDTH is a constant you need to define
        // The last two arguments are: preserveRatio, and use smooth (slower)
        // resizing

        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 50, 0, true, true);
            imageView = new ImageView(image);
            imageView.setFitWidth(50);
            
//            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//
//                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
//
//                        if(mouseEvent.getClickCount() == 2){
//                            try {
//                                BorderPane borderPane = new BorderPane();
//                                ImageView imageView = new ImageView();
//                                Image image = new Image(new FileInputStream(imageFile));
//                                imageView.setImage(image);
//                                imageView.setStyle("-fx-background-color: BLACK");
//                                imageView.setFitHeight(stage.getHeight() - 10);
//                                imageView.setPreserveRatio(true);
//                                imageView.setSmooth(true);
//                                imageView.setCache(true);
//                                borderPane.setCenter(imageView);
//                                borderPane.setStyle("-fx-background-color: BLACK");
//                                Stage newStage = new Stage();
//                                newStage.setWidth(stage.getWidth());
//                                newStage.setHeight(stage.getHeight());
//                                newStage.setTitle(imageFile.getName());
//                                Scene scene = new Scene(borderPane,Color.BLACK);
//                                newStage.setScene(scene);
//                                newStage.show();
//                            } catch (FileNotFoundException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//                    }
//                }
//            });
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return imageView;
    }
    
}
 
