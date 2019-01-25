package db.dao;

import db.dto.ModuloDTO;
import controller.exception.ServiceException;

public class ModuloDAO extends BaseDAO<ModuloDTO>{
	
	private static ModuloDAO istance;
	
	private ModuloDAO() {
		TABLE_NAME = "MODULO";
		CLAZZ = ModuloDTO.class;
	}
	
	public static ModuloDAO getIstance() {
		if(istance == null) {
			istance = new ModuloDAO();
		}
		return istance;
	}
	
	public ModuloDTO getById(Integer id) throws ServiceException{
		ModuloDTO moduloDTO = new ModuloDTO();
		moduloDTO.setId(id);
		return find(moduloDTO);
	}
	
	public void remove(ModuloDTO modulo) throws ServiceException{
		delete(modulo);
	}
	
}
