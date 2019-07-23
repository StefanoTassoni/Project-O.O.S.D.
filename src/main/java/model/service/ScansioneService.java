package model.service;

import java.util.List;

import db.dao.ScansioneDAO;
import db.dto.ScansioneDTO;
import model.mapper.ScansioneMapper;
import model.Scansione;
import controller.exception.ServiceException;

public class ScansioneService {
	
	private ScansioneDAO ScansioneDAO;
	
	private static ScansioneService instance;

	private ScansioneService() 
	{
		ScansioneDAO = ScansioneDAO.getInstance();	
	}
	
	public static ScansioneService getInstance() {
		if (instance == null) {
			instance = new ScansioneService();
		}
		return instance;
	}
	
	public Scansione getScansioneById(Integer id) throws ServiceException 
	{
		ScansioneDTO scanDTO = ScansioneDAO.getById(id);
		return ScansioneMapper.toModel(scanDTO);
	}
	
	public Scansione getScanByPath(String path ) throws ServiceException 
	{
		ScansioneDTO scanDTO = ScansioneDAO.getByPath(path);
		return ScansioneMapper.toModel(scanDTO);
	}
	
	public List<Scansione> getAllScans() throws ServiceException 
	{
		List<ScansioneDTO> scanDTOList = ScansioneDAO.selectAll();
		return ScansioneMapper.toModel(scanDTOList);
	}
	
	public Boolean saveScan(Scansione scan) throws ServiceException {
		ScansioneDTO scanDTO = ScansioneMapper.toDTO(scan); 
		ScansioneDAO.insert(scanDTO);
		return true;
	}
	
}
