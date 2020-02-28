package com.mysite.work.login.controller;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.work.login.vo.LoginVO;
import com.mysite.work.login.vo.MemberVO;
import com.mysite.work.mapper.login.LogInMapper;;
 
	@Controller
	@EnableAutoConfiguration
	public class LogInController {
		
		Logger logger = LoggerFactory.getLogger(RestfulAPISample.class);
	    
	    @Autowired
	    private LogInMapper mapper;
	    
	    @RequestMapping(value="/loginSample")
	    @ResponseBody
	    public String home() throws Exception{
	        
	    	LoginVO vo = new LoginVO();
	    	vo.setId("pfetrouth");
	    	vo.setPwd("123456789");
	    	MemberVO memberVo = mapper.doLogin(vo);
	        
	    	logger.debug("memberVo :"+memberVo);
	    	
	    	if(memberVo !=null) {
	    		
	    		return "loginSuccess";
	    		
	    	}else {
	    		
	    		return "loginFail";
	    	}
	      
	    }
	    
	    @RequestMapping(value="/user/loginPost")
	    @ResponseBody
	    public String loginDo(LoginVO vo, HttpSession session, Model model) throws Exception{
	        
	    	vo.setId("pfetrouth");
	    	vo.setPwd("123456789");
	    	MemberVO memberVo = mapper.doLogin(vo);
	        
	    	logger.debug("memberVo :"+memberVo);
	    	
	    	if(memberVo !=null) {
	    		
	    		session.setAttribute("memberInfo", memberVo);
	    		
	    		return "loginSuccess";
	    		
	    	}else {	    		
	    		
	    		
	    		return "loginFail";
	    	}


	    }
	    
	    @RequestMapping(value="/loginMain") 
	    public String loginMain() throws Exception{
	         	return "/user/login"; 

	    }
	 
	}
