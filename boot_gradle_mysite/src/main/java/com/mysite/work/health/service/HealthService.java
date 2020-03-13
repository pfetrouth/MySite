package com.mysite.work.health.service;

import com.mysite.work.health.vo.HealthCheckVO;

public interface HealthService {
	
	public HealthCheckVO getDatabaseHealth() throws Exception;

}
