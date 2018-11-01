package controller;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import controller.exception.ServiceException;
import controller.utils.GUIUtils;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Opera;
import model.service.OperaService;
 
public class OperaListCtrl implements Initializable, ObservableList<Opera>{
    
	@FXML private TableView<Opera> tableView;
    @FXML private TableColumn<Opera, String> operaTitle;
    @FXML private TableColumn<Opera, String> operaAuthor;
    @FXML private TableColumn<Opera, String> operaCategory;
    //@FXML Text registerErrorText;
    
    
    public void initialize(URL location, ResourceBundle resources) 
    {
    		ObservableList<Opera> tableRow =  FXCollections.observableArrayList();
	    	try 
	    {
	    		OperaService operaService = OperaService.getInstance();
	    		List<Opera> operas = operaService.getAllOperas();
	    		
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
    			
			tableView.setItems(tableRow);
		} 
        catch (ServiceException e) 
        {
			e.printStackTrace();
		}
    }
    
    @FXML protected void gotoResearchHome() throws Exception 
    {	
    		System.out.println("OperaListCtrl.cls - gotoResearchHome()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/Libraryhome.fxml");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    @FXML protected void gotoUserProfile() throws Exception 
    {
    		System.out.println("OperaListCtrl.cls - gotoUserProfile()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceResizeSceneContent(DigitalLibrary.root, "view/UserProfilePage.fxml", 600, 500);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    @FXML protected void gotoModuleCompiling() throws Exception 
    {	
    		System.out.println("OperaListCtrl.cls - gotoModuleCompiling()");
    		GUIUtils guiUtils = GUIUtils.getInstance();
		try 
		{
			DigitalLibrary.root = guiUtils.replaceSceneContent(DigitalLibrary.root, "view/temp.fxml");
		} 
		catch (Exception e) 
		{
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