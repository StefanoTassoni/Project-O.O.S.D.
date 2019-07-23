package db.dao.dto;

import java.util.Date;

public class OperaDTO extends BaseDTO{
	
	private Integer id;
	private String titolo;
	private String categoria;
	private String autore;
	private String lingua;
	private Date dateCreazione;
	private Date dataPublicazione;

	
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
	public Date getDateCreazione() {
		return dateCreazione;
	}
	public void setDateCreazione(Date dateCreazione) {
		this.dateCreazione = dateCreazione;
	}
	public Date getDataPublicazione() {
		return dataPublicazione;
	}
	public void setDataPublicazione(Date dataPublicazione) {
		this.dataPublicazione = dataPublicazione;
	}
	
	@Override
	public String toString() {
		return "Opera [id=" + id + ", titolo=" + titolo + ", categoria=" + categoria + ", autore=" + autore + ", lingua="
				+ lingua + ", dateCreazione=" + dateCreazione + ", dataPublicazione=" + dataPublicazione +"]";
	}
	
}