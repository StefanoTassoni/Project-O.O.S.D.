package service;

import java.util.List;



import db.dao.UserDAO;
import db.dao.UserGroupDAO;
import db.dao.dto.UserGroupDTO;
import db.dao.dto.UserDTO;
import controller.exception.enums.ErrorCode;
import controller.exception.ServiceException;
import service.mapper.UserGroupMapper;
import service.mapper.UserMapper;
import service.model.User;
import service.model.UserGroup;

public class UserService{

		
	private UserDAO userDAO;
	private UserGroupDAO userGroupDAO;
	
	
	private static UserService instance;
	
	private UserService() {
		userDAO = UserDAO.getInstance();
		userGroupDAO = UserGroupDAO.getInstance();
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
	
	public Integer getUserGroupId(String userId) throws ServiceException 
	{
		List<UserGroupDTO> userGroupDTOList = userGroupDAO.selectUserGroup(userId);
		List<UserGroup> userGroups = UserGroupMapper.toModel(userGroupDTOList);
		return userGroups.get(0).getFkGroup();
	}
	
	
	public Boolean saveUser(User user) throws ServiceException {
		UserDTO userDTO = UserMapper.toDTO(user); 
		userDAO.insert(userDTO);
		UserGroupDTO userGroupDTO = new UserGroupDTO();
		userGroupDTO.setFkGroup(3);
		userGroupDTO.setFkUser(getByUsername(user.getUsername()).getId());
		userGroupDAO.insert(userGroupDTO);
		return true;
	}
	
	public Boolean updateUser(User user, String username) throws ServiceException {
		UserDTO userDTO = UserMapper.toDTO(user);
		User condition = new User();
		condition.setUsername(username);
		UserDTO DTOCondition = UserMapper.toDTO(condition);
		userDAO.update(userDTO, DTOCondition);
		return true;
	}
	
	
	public Boolean updateUserGroup(Integer userId) throws ServiceException {
		UserGroup condition = new UserGroup();
		condition.setFkUser(userId);
		UserGroupDTO deleteDTOCondition = UserGroupMapper.toDTO(condition);
		userGroupDAO.delete(deleteDTOCondition);
		condition.setFkGroup(2);
		UserGroupDTO DTOCondition = UserGroupMapper.toDTO(condition);
		userGroupDAO.insert(DTOCondition);
		return true;
	}
	
	
	
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
