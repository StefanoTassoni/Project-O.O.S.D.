package service;

import java.util.List;

import db.dao.TrascrizioneDAO;
import db.dao.dto.TrascrizioneDTO;
import service.mapper.TrascrizioneMapper;
import service.model.Trascrizione;
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
	
	public Trascrizione getTranscriptionByScanId(Integer scanId) throws ServiceException 
	{
		TrascrizioneDTO trasDTO = TrascrizioneDAO.getByScanId(scanId);
		return TrascrizioneMapper.toModel(trasDTO);
	}
	
	public List<Trascrizione> getAllTranscriptions() throws ServiceException 
	{
		List<TrascrizioneDTO> trasDTOList = TrascrizioneDAO.selectAll();
		return TrascrizioneMapper.toModel(trasDTOList);
	}
	
	public Boolean saveTranscription(Trascrizione tras) throws ServiceException {
		deleteTranscription(tras);
		TrascrizioneDTO trasDTO = TrascrizioneMapper.toDTO(tras); 
		TrascrizioneDAO.insert(trasDTO);
		return true;
	}
	
	public Boolean validateTranscription(Trascrizione tras) throws ServiceException {
		TrascrizioneDTO conditionDTO = new TrascrizioneDTO();
		conditionDTO.setIdScan(tras.getIdScan());
		TrascrizioneDTO changesDTO = new TrascrizioneDTO();
		changesDTO.setValidata(1);
		TrascrizioneDAO.update(changesDTO, conditionDTO);
		return true;
	}
	
	public Boolean deleteTranscription(Trascrizione tras) throws ServiceException {
		TrascrizioneDTO trasDTO = new TrascrizioneDTO();
		trasDTO.setIdScan(tras.getIdScan());
		TrascrizioneDAO.delete(trasDTO);
		return true;
	}
	
}
