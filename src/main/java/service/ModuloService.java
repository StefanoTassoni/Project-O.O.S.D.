package service;

import db.dao.ModuloDAO;
import db.dao.dto.ModuloDTO;
import service.mapper.ModuloMapper;
import service.model.Modulo;

import java.util.ArrayList;
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
	
	public List<Modulo> getAllModule() throws ServiceException{
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
	
	public Modulo getModulesByUsername(String username) throws ServiceException{
		ArrayList<ModuloDTO> moduleDTO = (ArrayList<ModuloDTO>) moduloDAO.getByUsername(username);
		if(!ModuloMapper.toModel(moduleDTO).isEmpty())
			return ModuloMapper.toModel(moduleDTO).get(0);
		else {
			return null;
		}
	}
	
	public void insertModulo(Modulo module) throws ServiceException{
		ModuloDTO moduloDTO = new ModuloDTO();
		moduloDTO.setFkIdUser(module.getFkIdUser());
		moduloDTO.setMessage(module.getMessage());
		moduloDTO.setQualifica(module.getQualifica());
		moduloDAO.insert(moduloDTO);
	}
	
	public void deleteModulo(Integer userId) throws ServiceException{
		ModuloDTO moduloDTO = new ModuloDTO();
		moduloDTO.setFkIdUser(userId);
		moduloDAO.delete(moduloDTO);
	}
	
}
	

