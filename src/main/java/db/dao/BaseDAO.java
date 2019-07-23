package db.dao;
import db.dao.dto.BaseDTO;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import db.Database;
import controller.exception.enums.ErrorCode;
import controller.exception.ServiceException;

public abstract class BaseDAO<T extends BaseDTO> {
	
	private static final String SELECT_ALL = "SELECT * FROM {0}";

	protected String TABLE_NAME;
	protected Class<T> CLAZZ;

	public void insert(List<T> dtoList) throws ServiceException {
		try {
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			for (T dto: dtoList) {
				mapList.add(dto.toMap());
			}
			Database.insert(TABLE_NAME, mapList);

		} catch (SQLException e) {
			throw new ServiceException(ErrorCode.RETRIEVE_DATA_FROM_DB, e);
		}
	}

	public void insert(T dto) throws ServiceException {

		List<T> dtoList = new ArrayList<T>();
		dtoList.add(dto);
		this.insert(dtoList);

	}

	public void delete(T dto) throws ServiceException {
		try {
			Database.delete(TABLE_NAME, dto.toMap());
		} catch (SQLException e) {
			throw new ServiceException(ErrorCode.RETRIEVE_DATA_FROM_DB, e);
		}
	}

	public Long count(T dto) throws ServiceException {
		try {
			return Database.count(TABLE_NAME, dto.toMap());
		} catch (SQLException e) {
			throw new ServiceException(ErrorCode.RETRIEVE_DATA_FROM_DB, e);
		}
	}

	public void update(T dto, T condition) throws ServiceException {
		try {
			Database.update(TABLE_NAME, dto.toMap(), condition.toMap());
		} catch (SQLException e) {
			throw new ServiceException(ErrorCode.RETRIEVE_DATA_FROM_DB, e);
		}
	}


	public List<T> select(String queryPattern, Object ... arguments) throws ServiceException {
		try {
			String query = MessageFormat.format(queryPattern, arguments);
			List<Map<String, Object>> resultList = Database.select(query);
			return mapToDTO(resultList);
		} catch (SQLException e) {
			throw new ServiceException(ErrorCode.RETRIEVE_DATA_FROM_DB, e);
		}

	}

	public List<T> selectAll() throws ServiceException {
		return select(SELECT_ALL, TABLE_NAME);
	}

	public List<T> select(T dto) throws ServiceException {
		return select(dto, null);
	}

	public List<T> select(T dto, String orderBy) throws ServiceException {
		try {
			List<Map<String, Object>> resultList = Database.select(TABLE_NAME, dto.toMap(), orderBy);
			return mapToDTO(resultList);
		} catch (SQLException e) {
			throw new ServiceException(ErrorCode.RETRIEVE_DATA_FROM_DB, e);
		}
	}

	/**
	 * Retrieved first element from a select query
	 * @param dto
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 */
	public T find(T dto) throws ServiceException {
		List<T> dtoList = this.select(dto);
		if (dtoList.isEmpty()) {
			return null;
		}
		return dtoList.get(0);
	}

	public T find(String queryPattern, Object ... arguments) throws ServiceException {
		List<T> dtoList = this.select(queryPattern, arguments);
		if (dtoList.isEmpty()) {
			return null;
		}
		return dtoList.get(0);
	}

	public T insertAndRecover(T dto) throws ServiceException {
		this.insert(dto);
		return this.find(dto);
	}

	private List<T> mapToDTO(List<Map<String, Object>> resultList) throws ServiceException {

		try {
			List<T> dtoList = new ArrayList<T>();
			for (Map<String, Object> mapRow: resultList) {
				T returnDto = CLAZZ.newInstance();
				returnDto.fillFromMap(mapRow);
				dtoList.add(returnDto);
			}
			return dtoList;
		} catch (ReflectiveOperationException e) {
			throw new ServiceException(ErrorCode.RETRIEVE_DATA_FROM_DB, e);
		}
	}

}

