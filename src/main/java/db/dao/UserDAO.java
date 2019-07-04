package db.dao;

import db.dto.UserDTO;

import controller.exception.ServiceException;

public class UserDAO extends BaseDAO<UserDTO> {
	
	private static UserDAO instance;

	private UserDAO() {
		TABLE_NAME = "USER";
		CLAZZ = UserDTO.class;
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public UserDTO getById(Integer id) throws ServiceException {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		return find(userDTO);
	}
	
	public UserDTO getByUsername(String username) throws ServiceException {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(username);
		return find(userDTO);
	}

	public void remove(UserDTO user) throws ServiceException {
		delete(user);
	}
	
	
}