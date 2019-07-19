package model.mapper;

import java.util.ArrayList;

import java.util.List;

import db.dto.TrascrizioneDTO;
import model.Trascrizione;

public class TrascrizioneMapper {
	
	public static TrascrizioneDTO toDTO(Trascrizione model) {
		TrascrizioneDTO dto = new TrascrizioneDTO();
		dto.setId(model.getId());
		dto.setTesto(model.getTesto());
		dto.setValidata(model.getValidata());
		dto.setIdScan(model.getIdScan());
		return dto;
	}
	
	public static Trascrizione toModel(TrascrizioneDTO dto) {
		Trascrizione model = new Trascrizione();
		model.setId(dto.getId());
		model.setTesto(dto.getTesto());
		model.setValidata(dto.getValidata());
		model.setIdScan(dto.getIdScan());
		return model;
	}
	
	public static List<Trascrizione> toModel(List<TrascrizioneDTO> dtoList) {
		List<Trascrizione> modelList = new ArrayList<Trascrizione>();
		for (TrascrizioneDTO dto : dtoList) {
			modelList.add(toModel(dto));
		}
		return modelList;
	}

}