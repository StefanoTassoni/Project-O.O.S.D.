package model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import db.dao.OperaDAO;
import db.dto.OperaDTO;
import model.mapper.OperaMapper;
import model.Opera;

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
	
	
}
