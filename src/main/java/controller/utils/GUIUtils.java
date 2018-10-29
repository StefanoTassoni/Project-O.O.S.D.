package controller.utils;

import controller.DigitalLibrary;
import controller.exception.ServiceException;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIUtils{
	
	
	private static GUIUtils instance;
//	private static GUIEventHandler eventHandler;
	
	
	public static GUIUtils getInstance() 
	{
//		eventHandler = GUIEventHandler.getInstance();
		
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
	
	
}
