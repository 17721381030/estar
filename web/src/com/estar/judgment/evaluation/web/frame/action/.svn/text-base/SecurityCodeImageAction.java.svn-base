package com.estar.judgment.evaluation.web.frame.action;

import com.estar.judgment.evaluation.web.frame.security.SecurityCode;
import com.estar.judgment.evaluation.web.frame.security.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

@SuppressWarnings("serial")
public class SecurityCodeImageAction extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private ByteArrayInputStream imageStream;
    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

    public String execute() throws Exception {
        String securityCode = SecurityCode.getSecurityCode();
        imageStream = SecurityImage.getImageAsInputStream(securityCode);
        session.put("SESSION_SECURITY_CODE", securityCode);
        return SUCCESS;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}