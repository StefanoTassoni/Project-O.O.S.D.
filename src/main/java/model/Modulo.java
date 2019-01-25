package model;

	public class Modulo {
		
		private Integer id;
		private String message;
		private Integer idUser;
		
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
		
		public Integer getIdUser() {
			return idUser;
		}
		public void setIdUser(Integer idUser) {
			this.idUser = idUser;
		}
		
		@Override
		public String toString() {
			return "Modulo [id=" + id + ", message=" + message + ", idUser=" + idUser +"]";	
		}
		
	}
