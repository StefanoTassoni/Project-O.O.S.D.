package controller;

import javafx.beans.property.SimpleStringProperty;

public class ModuleJoin
{
	private final SimpleStringProperty username;
	private final SimpleStringProperty qualifica;
	private final SimpleStringProperty gruppo;
    	
    	public String getUsername() {
        return username.get();
    }
    public void setUsername(String uName) {
        username.set(uName);
    }
        
    public String getQualifica() {
        return qualifica.get();
    }
    public void setQualifica(String qual) {
    		qualifica.set(qual);
    }
    
    public String getGruppo() {
        return gruppo.get();
    }
    public void setEmail(String fName) {
        gruppo.set(fName);
    }
	
    	ModuleJoin(String uName, String qual, String group )
    	{
    		this.username = new SimpleStringProperty(uName);
    		this.qualifica = new SimpleStringProperty(qual);
    		this.gruppo = new SimpleStringProperty(group);
    	}
    	
    	public String toString(){
			return "ModuloJoin [username=" + username + ", qualifica=" + qualifica + ", gruppo=" + gruppo + "]";
    	}
	
}