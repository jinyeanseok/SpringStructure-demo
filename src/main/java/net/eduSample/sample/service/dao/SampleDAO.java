package net.eduSample.sample.service.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import net.eduSample.common.service.dao.BaseDAO;
import net.eduSample.common.vo.UserVO;


@Repository("SampleDAO")
public class SampleDAO {
	
	@Resource(name = "BaseDAO")
	private BaseDAO baseDAO;
	
	public String getForDatabaseTest(){
		return (String) baseDAO.selectObject("sampleMapper.selectTest", "");
	}
	
	public void register(UserVO vo) throws Exception {
		baseDAO.insert("userMapper.register", vo);
	}
//	public void register(UserVO vo) throws Exception {
//		baseDAO.insert("userMapper.register");
//	}
	
	public UserVO login(UserVO vo) throws Exception {
		return (UserVO)baseDAO.selectObject("userMapper.login", vo);
	}
}