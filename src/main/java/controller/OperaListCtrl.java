package controller;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import controller.utils.GUIUtils;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.model.Opera;
import service.OperaService;
 
public class OperaListCtrl implements Initializable, ObservableList<Opera>{
    
	//@FXML private TableView<Opera> tableView;
	@FXML private TableView<Opera> tableView;
    @FXML private TableColumn<Opera, String> operaTitle;
    @FXML private TableColumn<Opera, String> operaAuthor;
    @FXML private TableColumn<Opera, String> operaCategory;
    //@FXML Text registerErrorText;
    
    
    public void initialize(URL location, ResourceBundle resources) 
    {
    		//ObservableList<Opera> tableRow =  FXCollections.observableArrayList();
    		ObservableList<Opera> tableRow =  FXCollections.observableArrayList();
	    	try 
	    {
	    		//DigitalLibrary.currentResearch è uilizzato per mantenere e passare tra le pagine l'ultima ricerca effettuata
	    		List<Opera> operas = DigitalLibrary.currentResearch;
	    		
	    		if (!operas.isEmpty()) 
	    		{
				for (Opera op: operas) 
				{
					tableRow.add(op);
					//tableRow.add(new TableData("Beer","Brewery","Country"));
				}	
			}
        
	    		operaTitle.setCellValueFactory(new PropertyValueFactory<Opera, String>("titolo"));
    			operaAuthor.setCellValueFactory(new PropertyValueFactory<Opera, String>("autore"));
    			operaCategory.setCellValueFactory(new PropertyValueFactory<Opera, String>("categoria"));
    			
			tableView.setItems(tableRow);
			
			
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
            System.out.println("OperaListCtrl.cls - showOpera() - Opera detail requested: " + tableView.getSelectionModel().getSelectedItem().getTitolo());
            GUIUtils guiUtils = GUIUtils.getInstance();
            OperaService operaService = OperaService.getInstance();
            try 
            {
	            	DigitalLibrary.currentOpera = operaService.getOperaById(tableView.getSelectionModel().getSelectedItem().getId());	
	            	guiUtils.popUpNewSceneContent(DigitalLibrary.root,"view/OperaDetailView.fxml");
			} 
            catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    
    
    /*************************
     **** Auto generated Trash*
     *************************/
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