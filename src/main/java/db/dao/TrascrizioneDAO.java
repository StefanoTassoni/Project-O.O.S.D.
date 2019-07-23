package db.dao;
import db.dto.TrascrizioneDTO;
import controller.exception.ServiceException;

public class TrascrizioneDAO extends BaseDAO<TrascrizioneDTO> {
	
	private static TrascrizioneDAO instance;

	private TrascrizioneDAO() 
	{
		TABLE_NAME = "TRASCRIZIONE";
		CLAZZ = TrascrizioneDTO.class;
	}

	public static TrascrizioneDAO getInstance() 
	{
		if (instance == null) {
			instance = new TrascrizioneDAO();
		}
		return instance;
	}

	public TrascrizioneDTO getById(Integer id) throws ServiceException 
	{
		TrascrizioneDTO transcriptionDTO = new TrascrizioneDTO();
		transcriptionDTO.setId(id);
		return find(transcriptionDTO);
	}
	
	public TrascrizioneDTO getByScanId(Integer scanId) throws ServiceException 
	{
		TrascrizioneDTO transcriptionDTO = new TrascrizioneDTO();
		transcriptionDTO.setIdScan(scanId);
		return find(transcriptionDTO);
	}
	
	public void remove(TrascrizioneDTO transcription) throws ServiceException 
	{
		delete(transcription);
	}

}
