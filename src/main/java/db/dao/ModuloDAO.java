package db.dao;

import db.dao.dto.ModuloDTO;
import java.util.List;

import controller.exception.ServiceException;

public class ModuloDAO extends BaseDAO<ModuloDTO>{
	
	private static ModuloDAO istance;
	
	private ModuloDAO() {
		TABLE_NAME = "MODULO";
		CLAZZ = ModuloDTO.class;
	}
	
	
	
//	private static final String SELECT_ALL_MODULE_WITH_USERNAME =
//			"SELECT DISTINCT u.name, u.username, m.fk_id_user, m.qualifica "
//			+ "FROM modulo m  "
//			+ "JOIN user u "
//			+ "ON u.id = m.fk_id_user "
//			+ "WHERE fk_id_user = {0}";
	
	private static final String SELECT_SINGLE_MODULE_WITH_USERNAME =
			"SELECT DISTINCT u.name, u.username, m.message,m.fk_id_user, m.qualifica "
			+ "FROM modulo m  "
			+ "JOIN user u "
			+ "ON u.id = m.fk_id_user "
			+ "WHERE u.username = \"{0}\"";
	
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
	
	public List<ModuloDTO> getByUsername(String username) throws ServiceException {
		return select(SELECT_SINGLE_MODULE_WITH_USERNAME, username);
	}
	
	public void removeModule(ModuloDTO modulo) throws ServiceException{
		delete(modulo);
	}
	
	public void insertModulo(ModuloDTO modulo) throws ServiceException {
		insert(modulo);
	}
	
}
