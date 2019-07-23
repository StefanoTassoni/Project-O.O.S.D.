package service.mapper;

import java.util.ArrayList;

import java.util.List;

import db.dao.dto.ScansioneDTO;
import service.model.Scansione;

public class ScansioneMapper {
	
	public static ScansioneDTO toDTO(Scansione model) {
		ScansioneDTO dto = new ScansioneDTO();
		dto.setId(model.getId());
		dto.setPagina(model.getPagina());
		dto.setPath(model.getPath());
		dto.setDataPubblicazione(model.getDataPubblicazione());
		dto.setFormato(model.getFormato());
		dto.setIdOpera(model.getIdOpera());
		dto.setIdUser(model.getIdUser());
		return dto;
	}
	
	public static Scansione toModel(ScansioneDTO dto) {
		Scansione model = new Scansione();
		model.setId(dto.getId());
		model.setPagina(dto.getPagina());
		model.setPath(dto.getPath());
		model.setDataPubblicazione(dto.getDataPubblicazione());
		model.setFormato(dto.getFormato());
		model.setIdOpera(dto.getIdOpera());
		model.setIdUser(dto.getIdUser());
		return model;
	}
	
	public static List<Scansione> toModel(List<ScansioneDTO> dtoList) {
		List<Scansione> modelList = new ArrayList<Scansione>();
		for (ScansioneDTO dto : dtoList) {
			modelList.add(toModel(dto));
		}
		return modelList;
	}

}