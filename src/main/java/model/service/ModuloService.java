package model.service;

import java.util.prefs.Preferences;
import db.dao.ModuloDAO;
import db.dto.ModuloDTO;
import model.mapper.ModuloMapper;
import model.Modulo;


import java.util.List;
import java.util.prefs.Preferences;

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
	
	/*public Modulo getByUsername(String modUsername) throws ServiceException{
		DA COMPLETARE!!!
	}*/
	
	public void insertModulo(String msg) throws ServiceException{
		Preferences userPreferences = Preferences.userRoot();
		ModuloDTO moduloDTO = new ModuloDTO();
		moduloDTO.setFkIdUser(Integer.valueOf(userPreferences.get("userId",null)));
		moduloDTO.setMessage(msg);
		moduloDAO.insert(moduloDTO);
	}
	
}
	

