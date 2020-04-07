package com.mysite.work.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysite.work.mapper.login.LogInMapper;
import com.mysite.work.user.vo.UserVO;;

@Controller
@RequestMapping(value = "/user")
public class LogInController {

	Logger logger = LoggerFactory.getLogger(RestfulAPISample.class);

	@Autowired
	private LogInMapper mapper;

	@RequestMapping(value = "/loginMain")
	public String loginMain() throws Exception {
		return "/user/loginDo";

	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loginForm(Model model) throws Exception {
		model.addAttribute("userVO", new UserVO());
		return "/login/login";
	}

	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		model.addAttribute("userVO", new UserVO());
		return "/login/signupForm";
	}

}
