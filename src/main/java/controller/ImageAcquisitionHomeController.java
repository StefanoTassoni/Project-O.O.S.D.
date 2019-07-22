package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import controller.exception.ServiceException;
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
import javafx.stage.FileChooser;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import model.Opera;
import model.Scansione;
import model.service.OperaService;
import model.service.ScansioneService;

 
public class ImageAcquisitionHomeController implements Initializable, ObservableList<Opera>{
    
    /***REGISTER***/
    @FXML TextField AllOperaFilter;
//    @FXML TextField operaYear;
//    @FXML TextField operaLanguage;
//    @FXML Button searchButton;
    //@FXML Text registerErrorText;
    
    @FXML private TableView<Opera> AllOperaView;
    @FXML private TableColumn<Opera, String> operaTitle;
    @FXML private TableColumn<Opera, String> operaAuthor;
    @FXML private TableColumn<Opera, String> operaCategory;
    
    
    /***Sidebar START***/
    
    
    public void initialize(URL location, ResourceBundle resources) 
    {
    		ObservableList<Opera> tableRow =  FXCollections.observableArrayList();
	    	try 
	    {
	    		//TODO if profile = user delete following tab
	    		System.out.println("ImageAcquisitionHomeController.cls - initialize()");
	    		
	    		Preferences userPreferences = Preferences.userRoot();
	    			
    			Boolean isFiltered = userPreferences.getBoolean("isFiltered", false);
    			OperaService opService = OperaService.getInstance();
    			List<Opera> operas = new ArrayList<Opera>();
    			
    			if(isFiltered == true) 
    			{
    				userPreferences.remove("isFiltered");
    				operas = DigitalLibrary.currentResearch;
    			}
    			else
    			{	
    				operas = opService.getAllOperas();
    			}
	    		
    			if (!operas.isEmpty()) 
	    		{
				for (Opera op: operas) 
				{
					tableRow.add(op);
				}	
			}
        
	    		operaTitle.setCellValueFactory(new PropertyValueFactory<Opera, String>("titolo"));
	    		operaAuthor.setCellValueFactory(new PropertyValueFactory<Opera, String>("autore"));
	    		operaCategory.setCellValueFactory(new PropertyValueFactory<Opera, String>("categoria"));
    			
    			AllOperaView.setItems(tableRow);
	    		
	    		
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
    }
    
    @FXML protected void filterOperas() throws Exception 
    {	
    		System.out.println("ImageAcquisitionHomeController.cls - filterOperas()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			Preferences userPreferences = Preferences.userRoot();
			userPreferences.putBoolean("isFiltered",true);
			String filter = (!(AllOperaFilter.getText().isEmpty()) ? AllOperaFilter.getText() : "");
			OperaService opService = OperaService.getInstance();
			DigitalLibrary.currentResearch = opService.getByTitle(filter);
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/ImageAcquisitionHome.fxml",600,500);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    
    @FXML
    public void showOpera(MouseEvent event)
    {
        if (event.getClickCount() == 2) //Checking double click
        {
            System.out.println("ImageAcquisitionHomeController.cls - showOpera() - Opera detail requested: " + AllOperaView.getSelectionModel().getSelectedItem().getTitolo());
            GUIUtils guiUtils = GUIUtils.getInstance();
            OperaService operaService = OperaService.getInstance();
            try 
            {
	            	DigitalLibrary.currentOpera = operaService.getOperaById(AllOperaView.getSelectionModel().getSelectedItem().getId());	
	            	guiUtils.popUpNewResizeSceneContent(DigitalLibrary.root,"view/OperaImageAcquisitionDetailView.fxml", 600, 500);
			} 
            catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    @FXML
    public void uploadNewOpera(MouseEvent event)
    {
    		System.out.println("ImageAcquisitionHomeController.cls - uploadNewOpera()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
    		try {
			guiUtils.popUpNewResizeSceneContent(DigitalLibrary.root,"view/UploadNewOpera.fxml", 369, 415);
		} catch (Exception e) {
			System.out.println("UploadOperaScanCtrl.cls - uploadImageScan() - insert exception: " + e.getMessage());
			e.printStackTrace();
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



	public Iterator<Opera> iterator() {
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



	public boolean add(Opera e) {
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



	public boolean addAll(Collection<? extends Opera> c) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean addAll(int index, Collection<? extends Opera> c) {
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



	public Opera get(int index) {
		// TODO Auto-generated method stub
		return null;
	}



	public Opera set(int index, Opera element) {
		// TODO Auto-generated method stub
		return null;
	}



	public void add(int index, Opera element) {
		// TODO Auto-generated method stub
		
	}



	public Opera remove(int index) {
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



	public ListIterator<Opera> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}



	public ListIterator<Opera> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Opera> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}



	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}



	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}



	public void addListener(ListChangeListener<? super Opera> listener) {
		// TODO Auto-generated method stub
		
	}



	public void removeListener(ListChangeListener<? super Opera> listener) {
		// TODO Auto-generated method stub
		
	}



	public boolean addAll(Opera... elements) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean setAll(Opera... elements) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean setAll(Collection<? extends Opera> col) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean removeAll(Opera... elements) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean retainAll(Opera... elements) {
		// TODO Auto-generated method stub
		return false;
	}



	public void remove(int from, int to) {
		// TODO Auto-generated method stub
		
	}
    
}