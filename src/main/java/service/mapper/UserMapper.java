package service.mapper;

import java.util.ArrayList;
import java.util.List;

import db.dao.dto.UserDTO;
import service.model.User;

public class UserMapper {
	
	public static UserDTO toDTO(User model) {
		UserDTO dto = new UserDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setSurname(model.getSurname());
		dto.setUsername(model.getUsername());
		dto.setMail(model.getMail());
		dto.setPhone(model.getPhone());
		dto.setAddress(model.getAddress());
		dto.setPassword(model.getPassword());
		dto.setNomeGruppo(model.getNomeGruppo());
		return dto;
	}
	
	public static User toModel(UserDTO dto) {
		User model = new User();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setSurname(dto.getSurname());
		model.setUsername(dto.getUsername());
		model.setMail(dto.getMail());
		model.setPhone(dto.getPhone());
		model.setAddress(dto.getAddress());
		model.setPassword(dto.getPassword());
		model.setNomeGruppo(dto.getNomeGruppo());
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