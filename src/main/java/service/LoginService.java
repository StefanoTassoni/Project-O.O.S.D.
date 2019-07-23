package service;

import controller.exception.ServiceException;
import controller.utils.StringUtils;
import service.model.User;

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
				
		if(userService.checkUserByUsername(user)) 
		{	
			User userModel = userService.getByUsername(user);

			if(userModel.getPassword().equals(StringUtils.crypt(pass))) {
				return userModel;
			}
			else 
			{
				return null;
			}
		}
		else 
		{
			return null;
		}
	}
	
	
	public Boolean register(User newUser) throws ServiceException {
		
		if(!userService.checkUserByUsername(newUser.getUsername())) 
		{	
			System.out.println("LoginService.cls - register() - new User: " + newUser.toString());
			return userService.saveUser(newUser);
		}
		else 
		{
			System.out.println("LoginService.cls - register() - username esistente");
			return false;
		}
	}
	

}
