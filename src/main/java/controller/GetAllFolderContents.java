package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Opera;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.shape.Polygon;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class GetAllFolderContents implements Initializable{

    private String path;
    private ArrayList<File> files;
    private String[] extens;

    @FXML private ImageView[] images = new ImageView[10];
    @FXML private TilePane imgBox = new TilePane();;
    @FXML private VBox vBox = new VBox();
    @FXML private ImageView imageView1= new ImageView	();
    @FXML private ImageView imageView2= new ImageView	();
    private List<Image> AllImages = new LinkedList();
    
    @FXML
    public Polygon right_arrow;
    public Polygon left_arrow;
    public Button edit_button;
    public ImageView home_button;
    public TextField search_box;
    public TextArea tag_box;
    public ChoiceBox language_box;
    public Label photo_title;
    public Label photo_number;
    public ImageView photo_box;
    public Image home_picture;

    public void goToEditPage (ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Edit.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void goToHomePage (){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));

            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public Image getPicture(){


        /*home_picture = new Image(String.valueOf(getClass().getResource("home.png")));
        */return home_picture;
    }


    public File getPhotoById(int id) {
        id--;
        return this.files.get(id);
    }

    public void initialize(URL location, ResourceBundle resources) 
    {
    		System.out.println("GetAllFolderContents.cls - initialize()" );
    		System.out.println("Working Directory = " + System.getProperty("user.dir"));
    		
    		files = new ArrayList<File>();
        String style_outter = "-fx-border-color: black;" + 
				"-fx-border-style: solid;" + 
				"-fx-border-width: 5;";
        imgBox.setHgap(5.0);
        imgBox.setVgap(2.0);
        imgBox.setStyle(style_outter);
       
        File repo = new File ("src/main/resources/imagedir/Divina Commedia");
        System.out.println("GetAllFolderContents.cls - photo() - repo: " + repo );
        if (repo.isDirectory()) 
        {
        		try 
        		{
	            File[] fileList = repo.listFiles();
	            
	            for (File f : fileList) 
	            {
	            		Image image = new Image(f.toURI().toString());
	            		AllImages.add(image);
	                System.out.println("GetAllFolderContents.cls - photo() - Image path: " + f);
		            Image imageTest = new Image(f.toURI().toString());
		            imageView1.setImage(imageTest);
	            }
	            
//	            images = new ImageView[AllImages.size()];
	            
	            for (int j = 0; j < AllImages.size(); j++) 
	            {
	                images[j] = new ImageView(AllImages.get(j));
	                images[j].setFitHeight(50);
	                images[j].setFitWidth(50);
	                images[j].setSmooth(true);
	                images[j].setPreserveRatio(true);
	                images[j].setStyle(style_outter);
	                images[j].setVisible(true);
	                System.out.println("image added");
	            }
            }
        		catch (Exception e) 
        		{
            		System.out.println("GetAllFolderContents.cls - photo() - e: " + e);
            		e.printStackTrace();
			}
            
        }
        else 
        {
        		System.out.println("GetAllFolderContents.cls - photo() - repo is not a folder ");
        }
        
    		System.out.println("GetAllFolderContents.cls - initialize() - imgBox all children: " + imgBox.getChildren());
    		System.out.println("GetAllFolderContents.cls - initialize() - imageview: " + images);
    }
    
}