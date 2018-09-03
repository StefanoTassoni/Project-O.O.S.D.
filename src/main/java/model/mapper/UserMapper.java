package model.mapper;

import java.util.ArrayList;
import java.util.List;

import db.dto.UserDTO;
import model.User;

public class UserMapper {
	
	public static UserDTO toDTO(User model) {
		UserDTO dto = new UserDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setSurname(model.getSurname());
		dto.setUsername(model.getUsername());
		dto.setPassword(model.getPassword());
		return dto;
	}
	
	public static User toModel(UserDTO dto) {
		User model = new User();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setSurname(dto.getSurname());
		model.setUsername(dto.getUsername());
		model.setPassword(dto.getPassword());
		return model;
	}
	
	public static List<User> toModel(List<UserDTO> dtoList) {
		List<User> modelList = new ArrayList<User>();
		for (UserDTO dto : dtoList) {
			modelList.add(toModel(dto));
		}
		return modelList;
	}

}