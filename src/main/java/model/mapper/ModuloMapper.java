package model.mapper;

import java.util.ArrayList;
import java.util.List;
import db.dto.ModuloDTO;
import model.Modulo;


public class ModuloMapper {
	
	public static ModuloDTO toDTO(Modulo model) {
		ModuloDTO dto = new ModuloDTO();
		dto.setId(model.getId());
		dto.setMessage(model.getMessage() );
		dto.setIdUser(model.getIdUser());
		return dto;
	}
	
	public static Modulo toModel(ModuloDTO dto) {
		Modulo model = new Modulo();
		model.setId(dto.getId());
		model.setMessage(dto.getMessage());
		model.setIdUser(dto.getIdUser());
		return model;
	}
	
	public static List<Modulo> toModel(List<ModuloDTO> dtoList) {
		List<Modulo> modelList = new ArrayList<Modulo>();
		for (ModuloDTO dto : dtoList) {
			modelList.add(toModel(dto));
		}
		return modelList;
	}
}
