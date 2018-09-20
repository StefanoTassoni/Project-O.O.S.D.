package db.dto;

public class UserDTO extends BaseDTO{
	
	private Integer id;
	private String name;
	private String surname;
	private String username;
	private String password;
	private String nome_gruppo;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNomeGruppo() {
		return nome_gruppo;
	}
	public void setNomeGruppo(String nome_gruppo) {
		this.nome_gruppo = nome_gruppo;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", username=" + username + ", password="
				+ password + ", nome gruppo=" + nome_gruppo +"]";
	}
	
}