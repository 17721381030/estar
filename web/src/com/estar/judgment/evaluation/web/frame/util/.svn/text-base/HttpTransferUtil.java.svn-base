package com.estar.judgment.evaluation.web.frame.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;


import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;




/**
 * HTTP数据发送工具
 * @author Adrian 2010.09.10
 */
public class HttpTransferUtil {
	
    /** io buffer size: 1024 * 8 */
	public static final int BUFFER_SIZE = 1024 * 8;
	
	/** content-type: XML */
	public static final String CONTENT_TYPE_XML = "text/xml;charset=UTF-8";
	
	/** content-type: HTML */
    public static final String CONTENT_TYPE_HTML = "text/html;charset=UTF-8";
    
    /** content-type: PLAIN */
    public static final String CONTENT_TYPE_PLAIN = "text/plain;charset=UTF-8";
    
    /** encoding: UTF-8 */
    public static final String ENCODING_UTF_8 = "UTF-8";
	
	private static Logger log = Logger.getLogger(HttpTransferUtil.class); 
	
	/**
	 * 通过java.net包中的类发送HTTP请求，并接收回复信息。
	 * @param strUrl url
	 * @param content 请求内容
	 * @param contentType content-type
	 * @return 回复信息
	 * @throws ServiceException
	 */
	public static String send(String strUrl, String content, String contentType) throws Exception {
	    String result = null;
	    InputStreamReader in = null; // 接收XML文件流
        BufferedReader bin = null; // 缓冲reader
	    try {
            URL url = new URL(strUrl);
            // 向某个特定协议对象返回表现http资源连接的引用
            URLConnection uc = url.openConnection();
            // 验证连接的类型，必须是HttpURLConnection的
            if (!(uc instanceof HttpURLConnection)) {
                String error = "[HttpTransferUtil-error] - java.net: wrong http connection type!\nURLConnection must be instance of HttpURLConnection!";
                log.error(error);
                throw new Exception(error);
            }
            
            HttpURLConnection hc = (HttpURLConnection) uc;
            // 把HTTP请求方法设置为POST（默认的是GET）
            hc.setRequestMethod("POST");
            // 表明程序必须把字符串内容输出到服务器程序资源
            hc.setDoOutput(true);
            // 表明不使用缓存
            hc.setUseCaches(false);
            // 连接超时时间
            hc.setConnectTimeout(5000);
            // 读取超时时间
            hc.setReadTimeout(5000);
            if (contentType != null) {
                // 设置content-type头部指示指定URL已编码数据的窗体MIME类型
                hc.setRequestProperty("content-type", contentType);
            }
            if (content != null) {
                // 将数据流发给客户端，默认GBK编码
                byte[] data = content.getBytes(ENCODING_UTF_8);
                // 设置content-length ！配置这个要注意字符集！
                //hc.setRequestProperty("content-length", "" + data.length);
                OutputStream output = hc.getOutputStream();
                // 发送数据
                output.write(data, 0, data.length);
                //OutputStream 的 flush 方法不执行任何操作，详见jdk-api。Adrian 2009.04.30
                //output.flush();
                output.close();
            } else {
                hc.getOutputStream().close();
            }
            
            // 用GBK编码接收流
            in = new InputStreamReader(hc.getInputStream(), ENCODING_UTF_8);
            bin = new BufferedReader(in);
            char[] b = new char[BUFFER_SIZE];
            int read = 0;
            StringBuffer s = new StringBuffer();
            while ((read = bin.read(b)) != -1) {
                s.append(b, 0, read);
            }
            result = s.toString();
            
            hc.disconnect();
        } catch (Exception e) {
            String error = "[HttpTransferUtil-error] - java.net: " + makeErrorInfo(strUrl, e);
            log.error(error);
            throw new Exception(error);
        } finally {
            try {
                if (bin != null) {
                    bin.close();
                    bin = null;
                }
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
	    return result;
	}
	
	/**
	 * 通过java.net包中的类发送HTTP请求XML，并接收回复信息。
	 * @param strUrl 请求地址
	 * @param content 发送内容
	 * @return 回复信息
	 * @throws ServiceException
	 */
	public static String sendXML(String strUrl, String content) throws Exception {
		String resultXml = send(strUrl, content, CONTENT_TYPE_XML);
		return resultXml;
	}
	
	/**
	 * 通过HttpClient类发送HTTP请求，并接收回复信息。
	 * @param strUrl url
	 * @param content 请求内容
	 * @param contentType content-type
	 * @param httpConfig HttpClient请求所需的具体参数：<br>
	 * <ul>
     * <li>1.proxyFlag-代理服务启用标志</li><li>2.proxyTimeout-代理服务超时时间</li>
     * <li>3.proxyUser-代理服务用户名</li><li>4.proxyPassword-代理服务密码</li>
     * <li>5.proxyHost-代理服务ip</li><li>6.proxyHostPort-代理服务端口</li>
	 * @return 回复信息
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public static String send(String strUrl, String content, String contentType, Map httpConfig) throws Exception {
	    String result = null;
        HttpClient httpClient = new HttpClient();
        // 判断是否需要代理 0-不需要代理; 1-需要代理
        String proxyFlag = (String) httpConfig.get("proxyFlag");
        if("1".equals(proxyFlag)) {
            // 定义代理的用户名密码
            UsernamePasswordCredentials credentials  = new 
                UsernamePasswordCredentials((String) httpConfig.get("proxyUser"),
                                            (String) httpConfig.get("proxyPassword"));
            // 定义代理IP和端口号
            HostConfiguration hostConfig = new HostConfiguration();
            hostConfig.setProxy((String) httpConfig.get("proxyHost"),
                                Integer.parseInt((String) httpConfig.get("proxyHostPort")));
            // 设置代理用户名密码
            httpClient.getState().setProxyCredentials(AuthScope.ANY, credentials);
            // 设置代理地址端口
            httpClient.setHostConfiguration(hostConfig);
        }
        // 连接超时时间 (毫秒)
        int timeout = Integer.parseInt((String) httpConfig.get("proxyTimeout"));
        // 设置HttpConnetionManager级别的超时时间
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
        // 创建post方法的实例
        PostMethod postMethod = new PostMethod(strUrl);
        // 设置HttpMethod级别的超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, Integer.valueOf(timeout));
        if (contentType != null) {
            // 指定请求内容的类型
            postMethod.setRequestHeader("content-type", contentType);
        } else {
        	// 默认字符集GBK
            postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, ENCODING_UTF_8);
        }
        if (content == null) {
            content = "";
        }
        /* 暂时不使用RetryHandler Adrian 2010.09.27
        // 使用系统提供的默认的恢复策略,连不上得试三次
        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler());
        */
        InputStreamReader in = null; // 接收XML文件流
        BufferedReader bin = null; // 缓冲reader
        try {
            // 注入发送的内容，默认GBK编码
            postMethod.setRequestEntity(new StringRequestEntity(content, null, ENCODING_UTF_8));
            // 执行postMethod，statusCode-请求状态代码
            int statusCode = httpClient.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK) {
                // 用GBK编码接收流
                in = new InputStreamReader(postMethod.getResponseBodyAsStream(), ENCODING_UTF_8);
                bin = new BufferedReader(in);
                char[] b = new char[BUFFER_SIZE];
                int read = 0;
                StringBuffer s = new StringBuffer();
                while ((read = bin.read(b)) != -1) {
                    s.append(b, 0, read);
                }
                result = s.toString();
            } 
            /* 一般HTTP-400或404错误都会被异常捕捉 Adrian 2009.04.30
            else if (statusCode == HttpStatus.SC_NOT_FOUND
                    || statusCode == HttpStatus.SC_BAD_REQUEST) { // 400和404错误
                log.error(strUrl + "请求地址错误！HttpStatus: " + statusCode);
                throw new ServiceException(strUrl + "请求地址错误！HttpStatus: " + statusCode);
            } 
            */
            // HTTP-500错误，一般为请求端处理数据时抛出异常。可能出现的原因多为数据错误或数据接收方解析发生错误。
            else if (statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) { 
                log.error("数据接收端处理有误，请核对！HttpStatus: " + statusCode);
                throw new Exception("数据接收端处理有误，请核对！HttpStatus: " + statusCode);
            }
        } catch (HttpException e) {
            // 发生致命的异常，可能是协议不对或者返回的内容有问题
            String error = makeErrorInfo(strUrl, e);
            log.error(error);
            throw new Exception(error);
        } catch (IOException e) {
            // 发生网络异常，可能出现的错误多为HTTP-400和404
            String error = makeErrorInfo(strUrl, e);
            log.error(error);
            throw new Exception(error);
        } finally {
            // 释放连接
            postMethod.releaseConnection();
            // 关闭连接
            httpClient.getHttpConnectionManager().closeIdleConnections(0);
            // 关闭流
            try {
                if (bin != null) {
                    bin.close();
                    bin = null;
                }
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        return result;
	}
	
	/**
	 * 通过HttpClient类发送HTTP请求XML，并接收回复信息。
	 * @param strUrl 请求地址
	 * @param content 发送内容
	 * @param httpConfig HttpClient请求所需的具体参数：<br>
     * <ul>
     * <li>1.proxyFlag-代理服务启用标志</li><li>2.proxyTimeout-代理服务超时时间</li>
     * <li>3.proxyUser-代理服务用户名</li><li>4.proxyPassword-代理服务密码</li>
     * <li>5.proxyHost-代理服务ip</li><li>6.proxyHostPort-代理服务端口</li>
	 * @return 回复信息
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public static String sendXML(String strUrl, String content, Map httpConfig) throws Exception {
		String resultXml = send(strUrl, content, CONTENT_TYPE_XML, httpConfig);
		return resultXml;
	}

	private static String makeErrorInfo(String strUrl, Exception e) {
		StringBuffer error = new StringBuffer();
		if (e instanceof IOException) {
			error.append("IOException-");
		} else if (e instanceof HttpException) {
			error.append("HttpException-");
		}
		error.append("数据发送时发生网络异常！请检查相关配置和交互数据！\n")
		.append("请求地址：").append(strUrl).append("\n")
		.append("casued by: ").append(e.getMessage());
		return error.toString();
	}

}
