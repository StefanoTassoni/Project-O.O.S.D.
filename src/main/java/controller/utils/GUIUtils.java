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
	
	
}
