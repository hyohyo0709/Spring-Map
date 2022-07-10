package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.LibmapDTO;

public class LibmapDAOImp implements LibmapDAO{

	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public LibmapDAOImp() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<LibmapDTO> lib_list(HashMap<String, Object> map) {
		
		return sqlSession.selectList("lib.lib_list", map);
	}
	
	@Override
	public int lib_countAll(String data) {
		
		return sqlSession.selectOne("lib.lib_countAll", data);
	}
}
