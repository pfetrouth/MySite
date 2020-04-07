package com.mysite.work.login.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mysite.work.login.dao.LogInDAO;
import com.mysite.work.login.vo.LogInVO;
import com.mysite.work.user.service.impl.UserServiceImpl;
import com.mysite.work.user.vo.UserVO;

@Service
public class LogInServiceImpl implements LogInService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Inject
	private LogInDAO logInDAO;
	
	@Override
	public UserVO getUserInfo(LogInVO vo) throws Exception {
		// TODO Auto-generated method stub
		return logInDAO.getUserInfo(vo);
	}

}
