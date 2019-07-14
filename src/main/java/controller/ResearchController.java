package controller;

import java.util.ArrayList;
import java.util.List;
import controller.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.service.OperaService;
 
public class ResearchController {
    
    /***REGISTER***/
    @FXML TextField operaName;
    @FXML TextField operaCategory;
    @FXML TextField operaAuthor;
    @FXML TextField operaYear;
    @FXML TextField operaLanguage;
    @FXML Button searchButton;
    
    
    @FXML protected void searchOpera(ActionEvent event) throws Exception 
    {	
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		OperaService operaService = OperaService.getInstance();
    		
    		if(!operaName.getText().isEmpty()) 
		{
			try 
			{
//				System.out.println("ResearchController.cls - searchOpera() - operaName: " + operaName.getText());
//				System.out.println("ResearchController.cls - searchOpera() - operaCategory: " + operaCategory.getText());
//				System.out.println("ResearchController.cls - searchOpera() - operaAuthor: " + operaAuthor.getText());
//				System.out.println("ResearchController.cls - searchOpera() - operaLanguage: " + operaLanguage.getText());
//				System.out.println("ResearchController.cls - searchOpera() - operaYear: " + operaYear.getText());
				
				if (operaCategory.getText().isEmpty() && operaAuthor.getText().isEmpty() 
						&& operaLanguage.getText().isEmpty() && operaYear.getText().isEmpty()) 
				{
					DigitalLibrary.currentResearch = operaService.getByTitle(operaName.getText());
				}
				else 
				{
					List<String> queryConditions = new ArrayList<String>();
				
					queryConditions.add(" TITOLO LIKE \"%" + operaName.getText() + "%\"  ");
					
					if (!operaCategory.getText().isEmpty()) queryConditions.add(" CATEGORIA LIKE \"%" + operaCategory.getText() + "%\"  ");
					
					if (!operaAuthor.getText().isEmpty()) queryConditions.add(" AUTORE LIKE \"%" + operaAuthor.getText() + "%\"  ");
					
					if (!operaLanguage.getText().isEmpty()) queryConditions.add(" LINGUA LIKE \"%" + operaLanguage.getText() + "%\"  ");
					
					if (!operaYear.getText().isEmpty())
					{ 
						String dataInizioAnno = operaYear.getText() + "-01-01";
						String dataFineAnno = operaYear.getText() + "-31-12";
						
						queryConditions.add(" (DATE_CREAZIONE >= \"" + dataInizioAnno + "\" AND DATE_CREAZIONE < \"" + dataFineAnno + "\"  ) ");
						System.out.println("ResearchController.cls - searchOpera() - last queryConditions: " + queryConditions.get(queryConditions.size() - 1));
					}
					
					DigitalLibrary.currentResearch = operaService.getByResearchField(queryConditions);
				}
				
				System.out.println("ResearchController.cls - searchOpera() - operas: " + DigitalLibrary.currentResearch.toString());
				
				DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/OperaListPage.fxml");
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("ResearchController.cls - searchOpera() - Insert opera title");
		}
    
    }
    
    
}