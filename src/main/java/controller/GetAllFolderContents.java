package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.control.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class GetAllFolderContents implements Initializable{


    @FXML private ListView<ImageView> ImageList = new ListView<ImageView>(); 
    @FXML private TilePane ImageTilePane = new TilePane(); 
       
    public void initialize(URL location, ResourceBundle resources) 
    {
    		System.out.println("GetAllFolderContents.cls - initialize()" );
    		System.out.println("Working Directory = " + System.getProperty("user.dir"));
    		
    		ImageTilePane.setPadding(new Insets(15, 15, 15, 15));
    		ImageTilePane.setHgap(15);
    		
    		
        File repo = new File ("src/main/resources/imagedir/Divina Commedia");
        System.out.println("GetAllFolderContents.cls - photo() - repo: " + repo );
        
        if (repo.isDirectory()) 
        {
        		try 
        		{
	            File[] fileList = repo.listFiles();
	            
	            
	            ObservableList<ImageView> items = FXCollections.observableArrayList();
	            ImageList.setItems(items);
	            
	            
	            for (File f : fileList) 
	            {
	            		/****ListView START**/
	            		Image image = new Image(f.toURI().toString());
	                System.out.println("GetAllFolderContents.cls - photo() - Image path: " + f);
		            ImageView item = new ImageView(image);
		            ImageList.getItems().add(item);
		            /****ListView END**/
		            
		            /****TilePane START**/
		            ImageView imageView;
	                imageView = createImageView(f);
		            ImageTilePane.getChildren().addAll(imageView);
		            /****TilePane END**/
	            }
	            
	           
            }
        		catch (Exception e) 
        		{
            		System.out.println("GetAllFolderContents.cls - photo() - e: " + e);
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