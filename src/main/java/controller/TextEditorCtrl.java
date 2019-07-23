package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import controller.exception.ServiceException;
import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import service.model.User;
import service.LoginService;

public class TextEditorCtrl {

	@FXML Button textEditorBTN;
	
	@FXML protected void handleEditorButton(ActionEvent event) throws Exception {
    	
		GUIUtils guiUtils = GUIUtils.getInstance();
		
		DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/AdminPage.fxml");		
				
    
	}
	
	
}
