package model.mapper;

import java.util.ArrayList;
import java.util.List;

import db.dto.OperaDTO;
import model.Opera;

public class OperaMapper {
	
	public static OperaDTO toDTO(Opera model) {
		OperaDTO dto = new OperaDTO();
		dto.setId(model.getId());
		dto.setTitolo(model.getTitolo());
		dto.setCategoria(model.getCategoria());
		dto.setAutore(model.getAutore());
		dto.setLingua(model.getLingua());
		dto.setDateCreazione(model.getDateCreazione());
		dto.setDataPublicazione(model.getDataPublicazione());
		return dto;
	}
	
	public static Opera toModel(OperaDTO dto) {
		Opera model = new Opera();
		model.setId(dto.getId());
		model.setTitolo(dto.getTitolo());
		model.setCategoria(dto.getCategoria());
		model.setAutore(dto.getAutore());
		model.setLingua(dto.getLingua());
		model.setDateCreazione(dto.getDateCreazione());
		model.setDataPublicazione(dto.getDataPublicazione());
		return model;
	}
	
	public static List<Opera> toModel(List<OperaDTO> dtoList) {
		List<Opera> modelList = new ArrayList<Opera>();
		for (OperaDTO dto : dtoList) {
			modelList.add(toModel(dto));
		}
		return modelList;
	}

}