package model.service;

import db.dao.ModuloDAO;
import db.dto.ModuloDTO;
import model.mapper.ModuloMapper;
import model.Modulo;


import java.util.List;

import controller.exception.ServiceException;
import controller.exception.enums.ErrorCode;

public class ModuloService {
	
	private ModuloDAO moduloDAO;
	private static ModuloService instance;
	
	private ModuloService(){
		moduloDAO = ModuloDAO.getIstance();	
	}
	
	public static ModuloService getInstance() {
		if (instance == null) {
			instance = new ModuloService();
		}
		return instance;
	}
	
	public List<Modulo> getAllMolule() throws ServiceException{
		List<ModuloDTO> moduloDTOlist = moduloDAO.selectAll();
		return ModuloMapper.toModel(moduloDTOlist);
	}
	
	public Modulo getModuloById(Integer moduloId) throws ServiceException{
		ModuloDTO moduloDTO = moduloDAO.getById(moduloId);
		if(moduloDTO == null) {
			throw new ServiceException(ErrorCode.MODULO_NOT_FOUND);
		}
		return ModuloMapper.toModel(moduloDTO);
	}
	
	/*inserisce un nuovo modulo
	public void setModulo(String user, String message, Integer iduser ) {
		String query= "INSERT INTO `modulo`(`ID`, `message`, `IDuser`) VALUES (1 ,'eccolo', 2)";
		
		//ModuloDTO moduloDTO = moduloDAO.insert(query);
	}
	*/
	
}
	

