package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


import controller.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Modulo;
import model.User;
import model.service.ModuloService;
import model.service.UserService;

public class SingleModuleViewCtrl implements Initializable{
	
	@FXML TextArea moduleMessage;
	@FXML Text moduleQualification;
	@FXML Text nameSurname;
	@FXML Text hiddenUserId;
	@FXML Button approveModule;
	
    
    public void initialize(URL location, ResourceBundle resources) 
    {
    		Preferences userPreferences = Preferences.userRoot();
    		String username = userPreferences.get("currentSelectedModuleUsername", null);
    		Modulo modulo;
    		System.out.println("SingleModuleViewCtrl.cls - inizialize() - username: " + username);
    		try 
	    {
    			ModuloService moduleService = ModuloService.getInstance();
    			modulo = moduleService.getModulesByUsername(username);
    			System.out.println("SingleModuleViewCtrl.cls - inizialize() - modulo: " + modulo.toString());
    			moduleMessage.setText(modulo.getMessage());
    			
    			moduleQualification.setText(modulo.getQualifica());
    			moduleQualification.setDisable(false);
    			
    			UserService uService = UserService.getInstance();
    			User tempUser = uService.getByUsername(username);
    			nameSurname.setText(tempUser.getName() + " " + tempUser.getSurname());
    			
    			hiddenUserId.setText(String.valueOf(modulo.getFkIdUser()));
    			hiddenUserId.setVisible(false);
    			
	    }
        catch (Exception e) 
        {
        		System.out.println("SingleModuleViewCtrl.cls - inizialize() - cattura modulo exception: " + e.getMessage());
    			e.printStackTrace();
    		}
    }
    
    @FXML
    public void approveModule(MouseEvent event)
    {
    		System.out.println("SingleModuleViewCtrl.cls - approveModule() - Approvazione Modulo: " );
    		
    		UserService uService = UserService.getInstance();
    		try 
    		{
			uService.updateUserGroup(Integer.valueOf(hiddenUserId.getText()));
		}
    		catch (Exception e) 
    		{
			System.out.println("SingleModuleViewCtrl.cls - approveModule() - update userGroup exception: " + e.getMessage());
			e.printStackTrace();
		}
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		guiUtils.closePopupWindow(approveModule.getScene());
    }
}
 
