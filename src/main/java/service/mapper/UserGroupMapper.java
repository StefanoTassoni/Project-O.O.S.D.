package service.mapper;

import java.util.ArrayList;
import java.util.List;

import db.dao.dto.UserGroupDTO;
import service.model.UserGroup;

public class UserGroupMapper {
	
	public static UserGroupDTO toDTO(UserGroup model) {
		UserGroupDTO dto = new UserGroupDTO();
		dto.setFkUser(model.getFkUser());
		dto.setFkGroup(model.getFkGroup());
		return dto;
	}
	
	public static UserGroup toModel(UserGroupDTO dto) {
		UserGroup model = new UserGroup();
		model.setFkUser(dto.getFkUser());
		model.setFkGroup(dto.getFkGroup());
		return model;
	}
	
	public static List<UserGroup> toModel(List<UserGroupDTO> dtoList) {
		List<UserGroup> modelList = new ArrayList<UserGroup>();
		for (UserGroupDTO dto : dtoList) {
			modelList.add(toModel(dto));
		}
		return modelList;
	}

}