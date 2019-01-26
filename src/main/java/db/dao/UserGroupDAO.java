package db.dao;

import db.dto.UserGroupDTO;

import java.util.List;

import controller.exception.ServiceException;

public class UserGroupDAO extends BaseDAO<UserGroupDTO> {
	
	private static final String SELECT_USER_GROUP_BY_ID = 
			"SELECT DISTINCT ug.fk_user, ug.fk_group " + 
			"FROM user u " + 
			"JOIN usergroup ug ON u.id = ug.fk_user " + 
			"JOIN gruppo g ON g.id = ug.fk_group " +
			"WHERE u.id = {0} ";
	
	private static UserGroupDAO instance;

	private UserGroupDAO() {
		TABLE_NAME = "USERGROUP";
		CLAZZ = UserGroupDTO.class;
	}

	public static UserGroupDAO getInstance() {
		if (instance == null) {
			instance = new UserGroupDAO();
		}
		return instance;
	}
	
	public List<UserGroupDTO> selectUserGroup(String userId) throws ServiceException 
	{
		return select(SELECT_USER_GROUP_BY_ID, userId);
	}

}