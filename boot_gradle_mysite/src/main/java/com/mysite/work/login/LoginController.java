package com.mysite.work.login;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysite.work.login.service.impl.LogInService;
import com.mysite.work.login.vo.LogInVO;
import com.mysite.work.user.vo.UserVO; 

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Inject
	private LogInService logInService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) throws Exception {
		model.addAttribute("logInVO", new LogInVO());
		return "login/login";
	}

	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		model.addAttribute("userVO", new UserVO());
		return "/login/signupForm";
	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("LogInVO") LogInVO logInVO, Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		UserVO userVO = logInService.getUserInfo(logInVO);
		logger.debug("userVO : {}",userVO);
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
