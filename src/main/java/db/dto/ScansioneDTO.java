package db.dto;

import java.util.Date;

public class ScansioneDTO extends BaseDTO{
	
	private Integer id;
	private String n_pagina;
	private Date data_pubblicazione;
	private String path;
	private String formato;
	private Integer idOpera;
	private Integer IdUser;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPagina() {
		return n_pagina;
	}
	public void setPagina(String n_pagina) {
		this.n_pagina = n_pagina;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getIdOpera() {
		return idOpera;
	}
	public void setIdOpera(Integer idOpera) {
		this.idOpera = idOpera;
	}
	public Integer getIdUser() {
		return IdUser;
	}
	public void setIdUser(Integer IdUser) {
		this.IdUser = IdUser;
	}
	public Date getDataPubblicazione() {
		return data_pubblicazione;
	}
	public void setDataPubblicazione(Date data_pubblicazione) {
		this.data_pubblicazione = data_pubblicazione;
	}
	
	
	@Override
	public String toString() {
		return "Opera [id=" + id + ", n_pagina=" + n_pagina + ", formato=" + formato + ", idOpera=" + idOpera + ", IdUser="
				+ IdUser + ", data_pubblicazione=" + data_pubblicazione + ", path=" + path + "]";
	}
	
}
