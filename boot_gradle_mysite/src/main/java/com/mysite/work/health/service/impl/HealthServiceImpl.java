package com.mysite.work.health.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mysite.work.board.service.impl.BoardServiceImpl;
import com.mysite.work.health.dao.HealthCheckDAO;
import com.mysite.work.health.service.HealthService;
import com.mysite.work.health.vo.HealthCheckVO;

@Service
public class HealthServiceImpl implements HealthService {

	Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Inject
	private HealthCheckDAO healthCheckDAO;		
	
	@Override
	public HealthCheckVO getDatabaseHealth() throws Exception{
		// TODO Auto-generated method stub
		return healthCheckDAO.getDatabaseHealth();
	}

}
