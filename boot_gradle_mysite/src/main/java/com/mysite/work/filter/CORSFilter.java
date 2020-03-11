package com.mysite.work.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysite.work.login.controller.RestfulAPISample;
import com.mysite.work.login.vo.MemberVO;

public class CORSFilter implements Filter {

	Logger logger = LoggerFactory.getLogger(RestfulAPISample.class);

	private List<String> whiteList;
	private List<String> resourceList;
	private boolean filterYn = false;

	public CORSFilter() {

		whiteList = new ArrayList<String>();
		// whiteList.add("/");
		whiteList.add("/loginMain");
		whiteList.add("/user/loginPost");
		whiteList.add("/board/getBoardList");
		whiteList.add("/health");

		resourceList = new ArrayList<String>();
		resourceList.add("/resources");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("init CORSFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		boolean isURIResouceFile = false;

		String uri = req.getRequestURI();
		logger.debug("uri :" + uri);

		if (filterYn) {

			if (!whiteList.contains(uri)) {

				for (String resouce : resourceList) {

					logger.debug("resouce :" + resouce);

					if (uri.startsWith(resouce)) {
						isURIResouceFile = true;
						break;
					}
				}
				logger.debug("isURIResouceFile :" + isURIResouceFile);
				if (!isURIResouceFile) {

					HttpServletRequest hsreq = (HttpServletRequest) request;
					HttpSession session = hsreq.getSession();
					MemberVO vo = (MemberVO) session.getAttribute("memberInfo");
					logger.debug("vo :" + vo);

					if (vo == null) {
						res.sendRedirect("loginMain");
						return;
					}
				}
			}

		}
		logger.info("##### filter - before #####");
		chain.doFilter(req, res);
		logger.info("##### filter - after #####");
	}

	@Override
	public void destroy() {
		logger.info("destroy CORSFilter");
	}

}
