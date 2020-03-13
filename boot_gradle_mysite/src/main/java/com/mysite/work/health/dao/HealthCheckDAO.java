package com.mysite.work.health.dao;

import com.mysite.work.health.vo.HealthCheckVO;

public interface HealthCheckDAO {

	public HealthCheckVO getDatabaseHealth() throws Exception;
}
