package model.service;

import java.util.List;

import db.dao.TrascrizioneDAO;
import db.dto.TrascrizioneDTO;
import model.mapper.TrascrizioneMapper;
import model.Trascrizione;
import controller.exception.ServiceException;


public class TrascrizioneService {
	
	private TrascrizioneDAO TrascrizioneDAO;
	
	private static TrascrizioneService instance;

	private TrascrizioneService() 
	{
		TrascrizioneDAO = TrascrizioneDAO.getInstance();	
	}
	
	public static TrascrizioneService getInstance() {
		if (instance == null) {
			instance = new TrascrizioneService();
		}
		return instance;
	}
	
	public Trascrizione getTranscriptionById(Integer id) throws ServiceException 
	{
		TrascrizioneDTO trasDTO = TrascrizioneDAO.getById(id);
		return TrascrizioneMapper.toModel(trasDTO);
	}
	
	public List<Trascrizione> getAllTranscriptions() throws ServiceException 
	{
		List<TrascrizioneDTO> trasDTOList = TrascrizioneDAO.selectAll();
		return TrascrizioneMapper.toModel(trasDTOList);
	}
	
	public Boolean saveTranscription(Trascrizione tras) throws ServiceException {
		TrascrizioneDTO trasDTO = TrascrizioneMapper.toDTO(tras); 
		TrascrizioneDAO.insert(trasDTO);
		return true;
	}
	
}
