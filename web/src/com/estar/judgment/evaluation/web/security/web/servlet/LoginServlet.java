package com.estar.judgment.evaluation.web.security.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.security.dto.AqUserDTO;
import com.estar.judgment.evaluation.web.security.service.ModuleService;
import com.estar.judgment.evaluation.web.security.service.UserService;
import com.estar.judgment.evaluation.web.security.utils.Dict;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserService userService;
	private ModuleService moduleService;
	public LoginServlet() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u = request.getParameter("username");
        String p = request.getParameter("password");
        String c = request.getParameter("captcha");
        String ip = request.getRemoteAddr();
        String dispatcher = "";
        String securityCode = (String)request.getSession().getAttribute("SESSION_SECURITY_CODE");
        if(StringUtils.nullOrBlank(u)||StringUtils.nullOrBlank(p) || StringUtils.nullOrBlank(c)){
        	request.setAttribute("msg",Dict.LOGIN_STATUS_NAME.get(Dict.LOGIN_STATUS.NOT_NULL));
        	dispatcher = "login.jsp";
        }else if(!StringUtils.nullOrBlank(securityCode) && !securityCode.equals(c)){
        	request.setAttribute("msg",Dict.LOGIN_STATUS_NAME.get(Dict.LOGIN_STATUS.SECURITY_CODE));
        	dispatcher = "login.jsp";
        }else{
	        AqUserDTO aqUserDTO = null;
	        try {
	        	aqUserDTO = userService.userLogin(u, p, ip);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	        if(Dict.LOGIN_STATUS.SUCCESS.equals(aqUserDTO.getLoginStatus())){
	        	dispatcher = "ndex.jsp";
	        	request.getSession().setAttribute("evalUser", aqUserDTO);
	        	try {
					List menuList = moduleService.getAqModuleByUserId(aqUserDTO.getUserId());
					request.setAttribute("menuList", menuList);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }else{
	        	dispatcher = "login.jsp";
	        	request.setAttribute("msg",Dict.LOGIN_STATUS_NAME.get(aqUserDTO.getLoginStatus()));
	        }
        }
        request.getRequestDispatcher(dispatcher).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	
	public void init() throws ServletException {
		ServletContext servletContext = super.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		userService = (UserService) wac.getBean("userService");
		moduleService = (ModuleService) wac.getBean("moduleService");
	}

}
