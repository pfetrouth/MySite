package com.mysite.work.welcome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysite.work.menu.controller.MenuController;
import com.mysite.work.user.vo.UserVO;

@Controller 
public class WelcomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getWelcome( HttpServletRequest request) throws Exception {
	
		HttpSession session = request.getSession();
		UserVO userVO=(UserVO)session.getAttribute("memberInfo");
		String url ="";
		
		if(userVO==null) {
			url ="redirect:/login/login";
		}else {		
			session.setAttribute("memberInfo", userVO);			
			url ="redirect:/board/getBoardList";
		}
		
		return url;
	}

}
