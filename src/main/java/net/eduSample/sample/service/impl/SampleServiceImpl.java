package net.eduSample.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.eduSample.sample.service.SampleService;
import net.eduSample.sample.service.dao.SampleDAO;


@Service("SampleService")
public class SampleServiceImpl implements SampleService {
	
	@Resource(name = "SampleDAO")
	private SampleDAO sampleDAO;
	
	public String getForDatabaseTest() throws Exception {
		
		return sampleDAO.getForDatabaseTest();
	}
	
}
