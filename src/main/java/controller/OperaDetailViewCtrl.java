package controller;

import java.net.URL;
import java.util.ResourceBundle;
import controller.utils.StringUtils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class OperaDetailViewCtrl implements Initializable{
	
	@FXML Text operaTitle;
	@FXML Text operaAuthor;
	@FXML Text operaCategory;
	@FXML Text operaLanguage;
	@FXML Text operaPublicationDate;
    
    public void initialize(URL location, ResourceBundle resources) 
    {
    		System.out.println("OperaDetailViewCtrl.cls - inizialize() - Opera: " + DigitalLibrary.currentOpera.toString());
    		try 
	    {
    			operaTitle.setText(DigitalLibrary.currentOpera.getTitolo());
    			operaAuthor.setText(DigitalLibrary.currentOpera.getAutore());
    			operaCategory.setText(DigitalLibrary.currentOpera.getCategoria());
    			operaLanguage.setText(DigitalLibrary.currentOpera.getLingua());
    			System.out.println("OperaDetailViewCtrl.cls - inizialize() - OperaPublicationDate: " + DigitalLibrary.currentOpera.getDataPublicazione());
    			operaPublicationDate.setText(StringUtils.stringToDate(DigitalLibrary.currentOpera.getDataPublicazione(), false));
			
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
    }

}
 
