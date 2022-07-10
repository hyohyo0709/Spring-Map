package service;

import java.util.HashMap;
import java.util.List;

import dao.LibmapDAO;
import dto.LibmapDTO;

public class LibmapServiceImp implements LibmapService{

	private LibmapDAO dao;
	
	public void setDao(LibmapDAO dao) {
		this.dao = dao;
	}
	
	public LibmapServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<LibmapDTO> f_listProcess(int pageNo, int pageSize, String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startpage", ((pageNo-1)*pageSize)+1);
		map.put("endpage", pageNo*pageSize);
		map.put("keyword",keyword );
		return dao.lib_list(map);
	}
	
	@Override
	public int f_countAllProcess(String data) {
		
		return dao.lib_countAll(data);
	}
}
