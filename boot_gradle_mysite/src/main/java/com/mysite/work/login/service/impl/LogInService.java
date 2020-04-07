package com.mysite.work.login.service.impl;

import com.mysite.work.login.vo.LogInVO;
import com.mysite.work.user.vo.UserVO;

public interface LogInService {

	public UserVO getUserInfo(LogInVO vo) throws Exception ;
}
