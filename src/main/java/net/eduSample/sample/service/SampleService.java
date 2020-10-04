package net.eduSample.sample.service;

import net.eduSample.common.vo.UserVO;

public interface SampleService {
	
	public String getForDatabaseTest() throws Exception;
	
	public void register(UserVO vo) throws Exception;
	
	public UserVO login(UserVO vo) throws Exception;
	
}
