package model.service;

import java.util.prefs.Preferences;
import db.dao.ModuloDAO;
import db.dto.ModuloDTO;
import db.dto.UserDTO;
import db.dto.UserGroupDTO;
import model.mapper.ModuloMapper;
import model.mapper.UserMapper;
import model.Modulo;
import model.User;

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
	
	/*public Modulo getModuleByUsername(String modUsername) throws ServiceException{
		DA COMPLETARE!!!
	}*/
	
	public void insertModulo(Modulo module) throws ServiceException{
		Preferences userPreferences = Preferences.userRoot();
		ModuloDTO moduloDTO = new ModuloDTO();
		moduloDTO.setFkIdUser(module.getFkIdUser());
		moduloDTO.setMessage(module.getMessage());
		moduloDTO.setQualifica(module.getQualifica());
		moduloDAO.insert(moduloDTO);
	}
	
}
	

