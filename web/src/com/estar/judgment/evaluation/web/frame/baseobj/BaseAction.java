package com.estar.judgment.evaluation.web.frame.baseobj;


import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.security.dto.AqUserDTO;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements RequestAware,
		SessionAware, ServletRequestAware, ServletResponseAware,
		ServletContextAware {
	public HttpServletRequest request;// request请求对象
	public HttpSession session;// request请求对象
	public ServletContext servletContext;// servlet容器对象
	public HttpServletResponse response;// response相应对象
	@SuppressWarnings("unchecked")
	public Map sessionMap;
	/** 当前 reqeust */
	@SuppressWarnings("unchecked")
	public Map requestMap;
	@SuppressWarnings("unused")
	public AqUserDTO getCurrentUserInfo() throws Exception {
		AqUserDTO user = null;
		try {
			if (session.getAttribute("evalUser") == null) {
				throw new Exception("会话超时，请重新登陆！");
			} else {
				user = (AqUserDTO) session.getAttribute("evalUser");
			}
		} catch (Exception ex) {
		}

		return user;
	}

	
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
		this.session = request.getSession();
	}

	public void setServletResponse(HttpServletResponse res) {
		this.response = res;
	}

	public void setServletContext(ServletContext ser) {
		this.servletContext = ser;
	}

	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;

	}
	private int pageSize = 15;
	private int pageNo = 1;
	
	private int recTotal = 0;
	private int pageTotal = 0;
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRecTotal() {
		return recTotal;
	}

	public void setRecTotal(int recTotal) {
		this.recTotal = recTotal;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	
	@SuppressWarnings("unchecked")
	public void setPageInfoFromDB(BaseDTO dto,Map map){
		List list= (List)map.get("List");
		this.setRecTotal((Integer)map.get("RecTotal"));
		this.setPageTotal((Integer)map.get("PageTotal"));
		dto.setList(list);
		dto.setListResult((null == list || list.size() == 0)?1:2);
	}
	
	@SuppressWarnings("unchecked")
	public void setPageInfoFromDB(BaseDTO dto,List list){
		dto.setList(list);
		dto.setListResult((null == list || list.size() == 0)?1:2);
	}
	
	
	public void setMsg(String msg){
		request.setAttribute("msg", msg);
	}

	
	private String view = "0";
	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public boolean init(){
		String i = request.getParameter("init");
		if(StringUtils.nullOrBlank(i)){
			return false;
		}
		return true;
	}

	public Short getVersionNo() {
		Object obj = session.getAttribute("versionNo");
		if(null != obj ){
			return (Short)obj;
		}
		return null;
	}

	public void setVersionNo(Short versionNo) {
		session.setAttribute("versionNo", versionNo);
	}

	public String getRecId() {
		Object obj = session.getAttribute("recId");
		if(null != obj ){
			return (String)obj;
		}
		return null;
	}

	public void setRecId(String recId) {
		session.setAttribute("recId", recId);
	}
	
	
}
