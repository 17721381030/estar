package com.estar.judgment.evaluation.web.frame.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


@SuppressWarnings("serial")
public class FrameInterceptor extends AbstractInterceptor {
	private Logger logger = Logger.getLogger(FrameInterceptor.class);
	
	
	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() {
		super.init();
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		String url = invocation.getInvocationContext().getName();
		if(!checkUserExiest(url,invocation)){
			return "loginPage";
		}
		try{
			truePara(invocation);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		try {
			result = invocation.invoke();
		} catch (Exception exception) {
			exception.printStackTrace();
			this.logger.error(this.getExceptionInfo(exception));
			throw exception;
		}
		return result;
	}

	private String getExceptionInfo(Exception exception) {
		StringBuffer bExceptionInfo = new StringBuffer();
		bExceptionInfo.append(exception.toString());
		bExceptionInfo.append("\\t\\n\\r");
		StackTraceElement[] stackTraceElements = exception.getStackTrace();
		for (int i = 0; i < stackTraceElements.length; i++) {
			bExceptionInfo.append(stackTraceElements[i].toString());
			bExceptionInfo.append("\\t\\n\\r");
		}
		return bExceptionInfo.toString();
	}

	
	
	private boolean checkUserExiest(String url,ActionInvocation invocation){
		if("analysis_analysisDocArticle".equals(url)||"securityCode".equals(url)){
			return true;
		}
		
		Object user = invocation.getInvocationContext().getSession().get("evalUser");
		if(null == user){
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private void truePara(ActionInvocation invocation){
		Map map=invocation.getInvocationContext().getParameters();
		Set keys = map.keySet();
        Iterator iters = keys.iterator();
        while(iters.hasNext()){
        	Object key = iters.next();
        	Object value = map.get(key);
        	map.put(key, transfer((String[])value));
        }
	}
	
	private String[] transfer(String[] params){
		for(int i=0;i<params.length;i++){
			if(StringUtils.nullOrBlank(params[i]))continue;
			params[i]=params[i].replace((char)12288, ' ').trim();
		}
		return params;
	}
	
}