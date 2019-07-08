package db.dto;

public class ModuloDTO extends BaseDTO {
	
	private Integer id;
	private String message;
	private String qualifica;
	private Integer fk_id_user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getQualifica() {
		return qualifica;
	}
	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}
	
	public Integer getFkIdUser() {
		return fk_id_user;
	}
	public void setFkIdUser(Integer idUser) {
		this.fk_id_user = idUser;
	}
	
	@Override
	public String toString() {
		return "Modulo [id=" + id + ", message=" + message + ", idUser=" + fk_id_user + ", qualifica=" + qualifica + "]";	
	}

}
