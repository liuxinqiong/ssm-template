package cn.com.service;

import java.util.List;

import cn.com.dao.TestDaoInf;
import cn.com.entity.Test;

public class TestService {
	
	private TestDaoInf testDao;
	
	
	public TestDaoInf getTestDao() {
		return testDao;
	}


	public void setTestDao(TestDaoInf testDao) {
		this.testDao = testDao;
	}


	public List<Test> getAllTestData(){
		return testDao.getAllTestData();
	}
}
