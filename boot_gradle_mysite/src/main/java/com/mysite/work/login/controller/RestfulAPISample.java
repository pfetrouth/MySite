package com.mysite.work.login.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.work.login.vo.LoginVO;
import com.mysite.work.login.vo.MemberVO;
import com.mysite.work.mapper.login.LogInMapper;

@RestController
public class RestfulAPISample {
	@Autowired
    private LogInMapper mapper;
	
	Logger logger = LoggerFactory.getLogger(RestfulAPISample.class);
	   
    @GetMapping(value="/rest") 
    public List<MemberVO> home() throws Exception{
        
        //List<MemberVO> list = mapper.selectMemberList();
    	LoginVO vo = new LoginVO();
    	List<MemberVO> list = mapper.doLoginList(vo);
        
        for(int i=0; i<list.size(); i++){
            System.out.println("name : " + list.get(i).getName());
            System.out.println("resno : " + list.get(i).getResno());
        }        
       
        ObjectMapper mapper = new ObjectMapper();
        
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        
        System.out.println("json : " + json);        
        
		
		logger.trace("trace -- Hello world.");
		logger.debug("debug -- Hello world.");
		logger.info("info -- Hello world.");
		logger.warn("warn -- Hello world.");
		logger.error("error -- Hello world.");
  
        return list;
    }
}
