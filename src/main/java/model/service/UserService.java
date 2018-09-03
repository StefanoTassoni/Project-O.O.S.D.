package model.service;

import java.util.List;



import db.dao.UserDAO;
//import it.univaq.ingweb.courseweb.db.dao.UserGroupsDAO;
import db.dto.UserDTO;
//import it.univaq.ingweb.courseweb.db.dao.dto.UserGroupsDTO;
import controller.exception.enums.ErrorCode;
import controller.exception.ServiceException;
import model.mapper.UserMapper;
import model.User;

public class UserService{

		
	private UserDAO userDAO;
//	private UserGroupsDAO userGroupDAO;
	


	
	private static UserService instance;
	
	private UserService() {
		userDAO = UserDAO.getInstance();
//		userGroupDAO = UserGroupsDAO.getInstance();
//		teacherDAO = TeacherDAO.getInstance();
	}
	
	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	public List<User> getAllUsers() throws ServiceException{
		List<UserDTO> userDTOlist = userDAO.selectAll();
		return UserMapper.toModel(userDTOlist);
	}
	
	
	public User getUserById(Integer userId) throws ServiceException{
		
		UserDTO userDTO = userDAO.getById(userId);
		if (userDTO == null) {
			throw new ServiceException(ErrorCode.USER_NOT_FOUND);
		}
		return UserMapper.toModel(userDTO);
	}

	
	public User getByUsername(String username) throws ServiceException {
		
		UserDTO userDTO = userDAO.getByUsername(username);
		return UserMapper.toModel(userDTO);
	
	}

	
	public Boolean checkUserByUsername(String username) throws ServiceException{
		UserDTO userDTO = userDAO.getByUsername(username);
		Boolean existing = false;
		if(userDTO != null)
			existing = true;
		return existing;
	}
	
//	public void saveUser(User user, String group) throws ServiceException {
//		UserDTO userDTO = UserMapper.toDTO(user); 
//		userDAO.insert(userDTO);
//		UserGroupsDTO userGroupDTO = new UserGroupsDTO();
//		if(group.equals("teacher")) {
//			userGroupDTO.setFkIdGroups(1);
//		}
//		else{
//			userGroupDTO.setFkIdGroups(0);
//		}
//		userGroupDTO.setFkIdUser(getByUsername(user.getUsername()).getId());
//		userGroupDAO.insert(userGroupDTO);
//	}
//	
//	public void updateUser(User user, String username) throws ServiceException {
//		UserDTO userDTO = UserMapper.toDTO(user);
//		User condition = new User();
//		condition.setUsername(username);
//		UserDTO DTOCondition = UserMapper.toDTO(condition);
//		userDAO.update(userDTO, DTOCondition);
//	}
//	
//	public void deleteUser(String userId, String user) throws ServiceException {
//		UserDTO userDTO = new UserDTO();
//		userDTO.setId(Integer.valueOf(userId));
//		UserGroupsDTO uGroup = new UserGroupsDTO();
//		uGroup.setFkIdUser(Integer.valueOf(userId));
//		TeacherDTO teachDTO = new TeacherDTO();
//		teachDTO.setFkIdUser(Integer.valueOf(userId));
//		teacherDAO.delete(teachDTO);
//		userGroupDAO.delete(uGroup);
//		userDAO.delete(userDTO);
//
//	}
}
