package net.eduSample.sample.service.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import net.eduSample.common.service.dao.BaseDAO;


@Repository("SampleDAO")
public class SampleDAO {
	
	@Resource(name = "BaseDAO")
	private BaseDAO baseDAO;
	
	public String getForDatabaseTest(){
		return (String) baseDAO.selectObject("sampleMapper.selectTest", "");
	}
}