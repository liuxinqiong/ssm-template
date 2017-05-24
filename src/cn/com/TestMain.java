package cn.com;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.entity.Test;

public class TestMain {
	
	public static void main(String[] args) {
		SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			SqlSessionFactory sqlFactory = sqlBuilder.build(reader);
			System.out.println(sqlFactory);
			SqlSession session = sqlFactory.openSession();
			List<Test> ts=session.selectList("getAllTestData");
			for (Test t : ts) {
				System.out.println(t.getName());
			}
		
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}	
