package model.service;

import controller.exception.ServiceException;
import model.User;

public class LoginService {
	
	UserService userService;
	
	private static LoginService instance;

	private LoginService() {
		userService = UserService.getInstance();	}
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}
	
	
	public User login(String user, String pass) throws ServiceException {
				
		if(userService.checkUserByUsername(user)) {
			
			User userModel = userService.getByUsername(user);

			if(userModel.getPassword().equals(pass)) {
				return userModel;
			}
			else {
			return null;
			}
		}
		else {
		return null;
		}
	}

}
