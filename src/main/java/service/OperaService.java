package service;

import java.util.List;

import db.dao.OperaDAO;
import db.dao.dto.OperaDTO;
import service.mapper.OperaMapper;
import service.model.Opera;
import controller.exception.ServiceException;

public class OperaService {
	
	private OperaDAO OperaDAO;
	
	private static OperaService instance;

	private OperaService() 
	{
		OperaDAO = OperaDAO.getInstance();	
	}
	
	public static OperaService getInstance() {
		if (instance == null) {
			instance = new OperaService();
		}
		return instance;
	}
	
	public Opera getOperaById(Integer id) throws ServiceException 
	{
		OperaDTO operaDTO = OperaDAO.getById(id);
		//System.out.println("OperaService.cls - getOperaById() - operaDto: " + operaDTO.toString() );
		return OperaMapper.toModel(operaDTO);
	}
	
	public List<Opera> getAllOperas() throws ServiceException 
	{
		List<OperaDTO> operaDTOList = OperaDAO.selectAll();
		return OperaMapper.toModel(operaDTOList);
	}
	
	public List<Opera> getByTitle(String title) throws ServiceException 
	{
		List<OperaDTO> operaDTOList = OperaDAO.getOperaByName(title);
		return OperaMapper.toModel(operaDTOList);
	}
	
	public List<Opera> getByResearchField(List<String> researchField) throws ServiceException 
	{
		String queryString = "";
		for(String field : researchField) 
		{
			queryString += field + " AND ";
		}
		queryString = queryString.substring(0, queryString.length() - 4);
		List<OperaDTO> operaDTOList = OperaDAO.getOperaByResearchField(queryString);
		return OperaMapper.toModel(operaDTOList);
	}
	
	public Boolean saveOpera(Opera opera) throws ServiceException {
		OperaDTO operaDTO = OperaMapper.toDTO(opera); 
		OperaDAO.insert(operaDTO);
		return true;
	}
	
}
