package net.eduSample.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.eduSample.common.vo.UserVO;
import net.eduSample.sample.service.SampleService;
import net.eduSample.sample.service.dao.SampleDAO;


@Service("SampleService")
public class SampleServiceImpl implements SampleService {
	
	@Resource(name = "SampleDAO")
	private SampleDAO sampleDAO;
	
	public String getForDatabaseTest() throws Exception {
		
		return sampleDAO.getForDatabaseTest();
	}
	
	@Override
	public void register(UserVO vo) throws Exception {
		sampleDAO.register(vo);
	}
	
	@Override
	public UserVO login(UserVO vo) throws Exception {
		return sampleDAO.login(vo);
	}
}
