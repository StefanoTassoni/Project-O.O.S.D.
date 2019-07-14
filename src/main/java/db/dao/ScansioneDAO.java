package db.dao;

import db.dto.ScansioneDTO;

//import java.util.List;

import controller.exception.ServiceException;

public class ScansioneDAO extends BaseDAO<ScansioneDTO> {
	
	private static ScansioneDAO instance;

	private ScansioneDAO() 
	{
		TABLE_NAME = "SCANSIONE";
		CLAZZ = ScansioneDTO.class;
	}

	public static ScansioneDAO getInstance() 
	{
		if (instance == null) {
			instance = new ScansioneDAO();
		}
		return instance;
	}

	public ScansioneDTO getById(Integer id) throws ServiceException 
	{
		ScansioneDTO operaDTO = new ScansioneDTO();
		operaDTO.setId(id);
		return find(operaDTO);
	}
	
	public void remove(ScansioneDTO opera) throws ServiceException 
	{
		delete(opera);
	}

}
