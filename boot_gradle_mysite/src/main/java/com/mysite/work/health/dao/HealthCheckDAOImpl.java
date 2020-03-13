package com.mysite.work.health.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.mysite.work.health.vo.HealthCheckVO;

@Repository
public class HealthCheckDAOImpl implements HealthCheckDAO {
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public HealthCheckVO getDatabaseHealth() throws Exception{
		
		return sqlSession.selectOne("com.mysite.work.health.getDatabaseHealth");
	}
	

}
