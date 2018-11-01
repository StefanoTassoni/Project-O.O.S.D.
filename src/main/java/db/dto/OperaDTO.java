package db.dto;

import java.util.Date;

public class OperaDTO extends BaseDTO{
	
	private Integer id;
	private String titolo;
	private String categoria;
	private String autore;
	private String lingua;
	private Date data_creazione;
	private Date data_publicazione;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getLingua() {
		return lingua;
	}
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	public Date getData_creazione() {
		return data_creazione;
	}
	public void setData_creazione(Date data_creazione) {
		this.data_creazione = data_creazione;
	}
	public Date getData_publicazione() {
		return data_publicazione;
	}
	public void setData_publicazione(Date data_publicazione) {
		this.data_publicazione = data_publicazione;
	}
	
	@Override
	public String toString() {
		return "Opera [id=" + id + ", titolo=" + titolo + ", categoria=" + categoria + ", autore=" + autore + ", lingua="
				+ lingua + ", data_creazione=" + data_creazione + ", data_publicazione=" + data_publicazione +"]";
	}
	
}