package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.utils.GUIUtils;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import service.model.Modulo;
import service.model.User;
import service.ModuloService;
import service.UserService;
 
public class SeeModuleCtrl implements Initializable, ObservableList<ModuleJoin>{
    


	@FXML TextField textModuleFilter;
//    @FXML TextField moduleUsername;

    
    @FXML private TableView<ModuleJoin> AllModuleView;
    @FXML private TableColumn<ModuleJoin, String> usernameColumn;
    @FXML private TableColumn<ModuleJoin, String> qualificationColumn;
    @FXML private TableColumn<ModuleJoin, String> groupColumn;
    
    
    
    
    public void initialize(URL location, ResourceBundle resources) {
    		ObservableList<ModuleJoin> tableRow =  FXCollections.observableArrayList();
	    	try 
	    {
	    		System.out.println("SeeModule.cls - initialize()");
	    		Preferences userPreferences = Preferences.userRoot();
	    		UserService uService = UserService.getInstance();
	    			
    			Boolean isFiltered = userPreferences.getBoolean("isModuleFiltered", false);
    			ModuloService modService = ModuloService.getInstance();
    			List<Modulo> moduli = new ArrayList<Modulo>();
    			User tempUser = new User();
    			ModuleJoin join = null;
    			if(isFiltered == true) 
    			{
    				userPreferences.remove("isModuleFiltered");
    				moduli = DigitalLibrary.currentResearchModule;
    			}
    			else
    			{	
    				moduli = modService.getAllModule();
    			}
    			System.out.println("SeeModuleCtrl.cls - initialize() - moduli: " + moduli.toString());
    			System.out.println("SeeModuleCtrl.cls - initialize() - moduli size: " + moduli.size());
    			if (!moduli.isEmpty() && moduli != null) 
	    		{
				for (Modulo singleModule: moduli) 
				{
					tempUser = uService.getUserById(singleModule.getFkIdUser());
					join = new ModuleJoin(tempUser.getUsername(), singleModule.getQualifica(),"Lettore");
					
					tableRow.add(join);
				}	
			}
        
    			
    			
    			usernameColumn.setCellValueFactory(
    					new PropertyValueFactory<ModuleJoin, String>("username")
    					);
    			
    			
    			qualificationColumn.setCellValueFactory(
    					new PropertyValueFactory<ModuleJoin, String>("qualifica")
    					);
    			
    			groupColumn.setCellValueFactory(
    					new PropertyValueFactory<ModuleJoin, String>("gruppo")
    					);
    			
    			AllModuleView.setItems(tableRow);    		
	    		
		} 
        catch (Exception e) 
        {
        		System.out.println("SeeModuleCtrl.cls - initialize() - exception: " + e.getMessage());
			e.printStackTrace();
		}
    }
    
    
    
    @FXML protected void filterModule() throws Exception 
    {	
    		System.out.println("SeeModule.cls - filterModule()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			Preferences userPreferences = Preferences.userRoot();
			userPreferences.putBoolean("isModuleFiltered",true);
			String filter = (!(textModuleFilter.getText().isEmpty()) ? textModuleFilter.getText() : "");
			ModuloService modService = ModuloService.getInstance();
			if (modService.getModulesByUsername(filter) != null) {
				DigitalLibrary.currentResearchModule.add( modService.getModulesByUsername(filter));
			}
			else{
				DigitalLibrary.currentResearchModule.clear();	
			}
			
			DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/SeeModule.fxml");
		} 
		catch (Exception e) 
		{
			System.out.println("SeeModuleCtrl.cls - initialize() - exception: " + e.getMessage());
			e.printStackTrace();
		}
    }


    @FXML
    public void showModule(MouseEvent event)
    {
    		if (event.getClickCount() == 2) //Checking double click
        {
	        System.out.println("SeeModuleCtrl.cls - showModule() - user clicked detail: " + AllModuleView.getSelectionModel().getSelectedItem());
	        GUIUtils guiUtils = GUIUtils.getInstance();
	        try 
	        {
		        	Preferences userPreferences = Preferences.userRoot();
		        	userPreferences.put("currentSelectedModuleUsername", AllModuleView.getSelectionModel().getSelectedItem().getUsername());	
	            	guiUtils.popUpNewResizeSceneContent(DigitalLibrary.root,"view/SingleModuleView.fxml",400,400);
			} 
	        catch (Exception e) {
				e.printStackTrace();
			}
        }
        
    }
    
    
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}



	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}



	public Iterator<controller.ModuleJoin> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}



	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}



	public boolean add(controller.ModuleJoin e) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean addAll(Collection<? extends controller.ModuleJoin> c) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean addAll(int index, Collection<? extends controller.ModuleJoin> c) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}



	public void clear() {
		// TODO Auto-generated method stub
		
	}



	public controller.ModuleJoin get(int index) {
		// TODO Auto-generated method stub
		return null;
	}



	public controller.ModuleJoin set(int index, controller.ModuleJoin element) {
		// TODO Auto-generated method stub
		return null;
	}



	public void add(int index, controller.ModuleJoin element) {
		// TODO Auto-generated method stub
		
	}



	public controller.ModuleJoin remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}



	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}



	public ListIterator<controller.ModuleJoin> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}



	public ListIterator<controller.ModuleJoin> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}



	public List<controller.ModuleJoin> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}



	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}



	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}



	public void addListener(ListChangeListener<? super controller.ModuleJoin> listener) {
		// TODO Auto-generated method stub
		
	}



	public void removeListener(ListChangeListener<? super controller.ModuleJoin> listener) {
		// TODO Auto-generated method stub
		
	}



	public boolean addAll(controller.ModuleJoin... elements) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean setAll(controller.ModuleJoin... elements) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean setAll(Collection<? extends controller.ModuleJoin> col) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean removeAll(controller.ModuleJoin... elements) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean retainAll(controller.ModuleJoin... elements) {
		// TODO Auto-generated method stub
		return false;
	}



	public void remove(int from, int to) {
		// TODO Auto-generated method stub
		
	}
    
	
}    