package com.mysite.work.login.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mysite.work.login.vo.LogInVO;
import com.mysite.work.user.vo.UserVO;

@Repository
public class LogInDAOImpl implements LogInDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public UserVO getUserInfo(LogInVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.mysite.work.mapper.login.LogInMapper.getLogin",vo);
	}

}
