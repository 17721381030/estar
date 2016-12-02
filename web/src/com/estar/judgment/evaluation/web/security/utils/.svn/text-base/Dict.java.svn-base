package com.estar.judgment.evaluation.web.security.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.estar.judgment.evaluation.web.frame.util.LVBean;

public class Dict {
	   public static class LOGIN_STATUS {
	        public final static String SUCCESS = "1";
	        public final static String USER_NOT_EXISTS = "2";
	        public final static String PASSWD_ERROR = "3";
	        public final static String USER_FREEZE = "4";
	        public final static String IP_FROHIBIT = "5";
	        public final static String EFFECT = "6";
	        public final static String NO_ACCESS = "7";
	        public final static String NOT_NULL = "8";
	        public final static String SECURITY_CODE = "9";
	    }
	   public static Map<String,String> LOGIN_STATUS_NAME = new HashMap<String,String>();
	   static {
		   LOGIN_STATUS_NAME.put(LOGIN_STATUS.SUCCESS, "验证通过");
		   LOGIN_STATUS_NAME.put(LOGIN_STATUS.USER_NOT_EXISTS, "用户不存在");
		   LOGIN_STATUS_NAME.put(LOGIN_STATUS.PASSWD_ERROR, "密码错误");
		   LOGIN_STATUS_NAME.put(LOGIN_STATUS.USER_FREEZE, "用户被冻结");
		   LOGIN_STATUS_NAME.put(LOGIN_STATUS.IP_FROHIBIT, "所用IP禁止登入");
		   LOGIN_STATUS_NAME.put(LOGIN_STATUS.EFFECT, "用户过期");
		   LOGIN_STATUS_NAME.put(LOGIN_STATUS.NO_ACCESS, "无权访问系统");
		   LOGIN_STATUS_NAME.put(LOGIN_STATUS.NOT_NULL, "必填信息不能为空");
		   LOGIN_STATUS_NAME.put(LOGIN_STATUS.SECURITY_CODE, "验证码错误");
	   }
	   
	   public static List<LVBean> FROHIBIT_IP_LIST = new ArrayList<LVBean>();
}
