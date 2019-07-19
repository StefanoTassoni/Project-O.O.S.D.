package db.dto;

public class TrascrizioneDTO extends BaseDTO{
	
	private Integer id;
	private String testo;
	private Integer idscan;
	private Boolean validata;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public Integer getIdScan() {
		return idscan;
	}
	public void setIdScan(Integer idscan) {
		this.idscan = idscan;
	}
	public Boolean getValidata() {
		return validata;
	}
	public void setValidata(Boolean validata) {
		this.validata = validata;
	}
	
	
	@Override
	public String toString() {
		return "Trascrizione [id=" + id + ", testo=" + testo + ", idscan=" + idscan + ", validata=" + validata +  "]";
	}
	
	
}
