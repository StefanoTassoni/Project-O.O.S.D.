package db.dao;

import db.dto.OperaDTO;

import java.util.List;

import controller.exception.ServiceException;

public class OperaDAO extends BaseDAO<OperaDTO> {
				
	private static final String SELECT_OPERA_BY_NAME = 
			"SELECT * FROM OPERA "
			+ "WHERE TITOLO LIKE \"%{0}%\"";
	
	private static final String SELECT_OPERA_BY_RESEARCHFIELD = 
			"SELECT * FROM OPERA "
			+ "WHERE {0}";
	
	
	private static OperaDAO instance;

	private OperaDAO() 
	{
		TABLE_NAME = "OPERA";
		CLAZZ = OperaDTO.class;
	}

	public static OperaDAO getInstance() 
	{
		if (instance == null) {
			instance = new OperaDAO();
		}
		return instance;
	}

	public OperaDTO getById(Integer id) throws ServiceException 
	{
		OperaDTO operaDTO = new OperaDTO();
		operaDTO.setId(id);
		return find(operaDTO);
	}
	
	public List<OperaDTO> getOperaByName(String title) throws ServiceException 
	{
		return select(SELECT_OPERA_BY_NAME, title);
	}
	
	public List<OperaDTO> getOperaByResearchField(String conditions) throws ServiceException 
	{
		return select(SELECT_OPERA_BY_RESEARCHFIELD, conditions);
	}

	public void remove(OperaDTO opera) throws ServiceException 
	{
		delete(opera);
	}
	
	
}
