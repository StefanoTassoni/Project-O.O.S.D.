package controller.utils;

import controller.DigitalLibrary;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIUtils{
	
	
	private static GUIUtils instance;
	
	
	public static GUIUtils getInstance() 
	{
		
		if (instance == null) 
		{
			instance = new GUIUtils();
		}
		return instance;
	}

	public Parent replaceSceneContent(Parent root, String fxml) throws Exception {
		root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
        Scene scene = new Scene(root, DigitalLibrary.xDim, DigitalLibrary.yDim);
        DigitalLibrary.stage.setScene(scene);
		return root;
    }
	
	public Parent replaceResizeSceneContent(Parent root, String fxml, Integer xdim , Integer ydim) throws Exception {
		root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
		DigitalLibrary.stage.setResizable(true);
        Scene scene = new Scene(root, xdim, ydim);
        DigitalLibrary.stage.setScene(scene);
        DigitalLibrary.stage.setResizable(false);
		return root;
    }
	
	public void popUpNewSceneContent(Parent root, String fxml) throws Exception {
		try 
		{
			final Stage dialog = new Stage();
	        dialog.initOwner(DigitalLibrary.stage);
	        root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
	        dialog.setResizable(true);
	        Scene dialogScene = new Scene(root, 600, 400);
	        dialog.setScene(dialogScene);
	        dialog.show();
        } 
		catch (Exception e) 
		{
			System.out.println("GUIUtils.cls - popUpNewSceneContent() - exception" );
			e.printStackTrace();
		}
    }
	
	
	public void popUpNewResizeSceneContent(Parent root, String fxml, Integer xdim , Integer ydim) throws Exception {
		try 
		{
			final Stage dialog = new Stage();
	        dialog.initOwner(DigitalLibrary.stage);
	        root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
	        dialog.setResizable(true);
	        Scene dialogScene = new Scene(root, xdim, ydim);
	        dialog.setScene(dialogScene);
	        dialog.show();
        } 
		catch (Exception e) 
		{
			System.out.println("GUIUtils.cls - popUpNewSceneContent() - exception" );
			e.printStackTrace();
		}
    }
	
}
