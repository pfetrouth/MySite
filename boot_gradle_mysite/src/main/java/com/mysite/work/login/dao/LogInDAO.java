package com.mysite.work.login.dao;

import com.mysite.work.login.vo.LogInVO;
import com.mysite.work.user.vo.UserVO;

public interface LogInDAO {

	public UserVO getUserInfo(LogInVO vo) throws Exception;
}
