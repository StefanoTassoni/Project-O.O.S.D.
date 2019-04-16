package controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import com.gluonhq.charm.glisten.control.CardPane;

import model.Modulo;
import model.service.ModuloService;
 
public class SeeModuleCtrl implements Initializable, ObservableList<Modulo>{
    
    /***REGISTER***/
    @FXML TextField textModuleFilter;
//    @FXML TextField moduleUsername;

    
    @FXML private TableView<Modulo> AllModuleView;
    @FXML private TableColumn<Modulo, String> username;
    
    
    /***Sidebar START***/
    @FXML CardPane CardPaneAdmin;
    @FXML CardPane CardPaneUser;
    @FXML CardPane CardPaneTranscriptor;
    
    
    public void initialize(URL location, ResourceBundle resources) {
    		ObservableList<Modulo> tableRow =  FXCollections.observableArrayList();
	    	try 
	    {
	    		System.out.println("SeeModule.cls - initialize()");
	    		Preferences userPreferences = Preferences.userRoot();
	    			
    			Boolean isFiltered = userPreferences.getBoolean("isFiltered", false);
    			ModuloService modService = ModuloService.getInstance();
    			List<Modulo> moduli = new ArrayList<Modulo>();
    			
    			if(isFiltered == true) 
    			{
    				userPreferences.remove("isFiltered");
    				moduli = DigitalLibrary.currentResearchModule;
    			}
    			else
    			{	
    				moduli = modService.getAllMolule();
    			}
	    		
    			if (!moduli.isEmpty()) 
	    		{
				for (Modulo op: moduli) 
				{
					tableRow.add(op);
				}	
			}
        
    			username.setCellValueFactory(new PropertyValueFactory<Modulo, String>("titolo"));
    			
    			AllModuleView.setItems(tableRow);
	    		
	    		
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
    }
    /*DA COMPLETARE LA FUNZIONE PER FILTRARE
     * 
    @FXML protected void filterModule() throws Exception 
    {	
    		System.out.println("SeeModule.cls - filterModule()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			Preferences userPreferences = Preferences.userRoot();
			userPreferences.putBoolean("isFiltered",true);
			String filter = (!(textModuleFilter.getText().isEmpty()) ? textModuleFilter.getText() : "");
			ModuloService modService = ModuloService.getInstance();
			DigitalLibrary.currentResearchModule = modService.getByUsername(filter);
			DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/SeeModule.fxml");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }*/


	public boolean add(Modulo arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	public void add(int index, Modulo element) {
		// TODO Auto-generated method stub
		
	}


	public boolean addAll(Collection<? extends Modulo> c) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean addAll(int index, Collection<? extends Modulo> c) {
		// TODO Auto-generated method stub
		return false;
	}


	public void clear() {
		// TODO Auto-generated method stub
		
	}


	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	public Modulo get(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	public Iterator<Modulo> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public ListIterator<Modulo> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	public ListIterator<Modulo> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	public Modulo remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	public Modulo set(int index, Modulo element) {
		// TODO Auto-generated method stub
		return null;
	}


	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<Modulo> subList(int fromIndex, int toIndex) {
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


	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}


	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}


	public boolean addAll(Modulo... arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	public void addListener(ListChangeListener<? super Modulo> arg0) {
		// TODO Auto-generated method stub
		
	}


	public void remove(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}


	public boolean removeAll(Modulo... elements) {
		// TODO Auto-generated method stub
		return false;
	}


	public void removeListener(ListChangeListener<? super Modulo> listener) {
		// TODO Auto-generated method stub
		
	}


	public boolean retainAll(Modulo... elements) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean setAll(Modulo... elements) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean setAll(Collection<? extends Modulo> col) {
		// TODO Auto-generated method stub
		return false;
	}
}    