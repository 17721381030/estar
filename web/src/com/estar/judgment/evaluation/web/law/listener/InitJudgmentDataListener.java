package com.estar.judgment.evaluation.web.law.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.estar.judgment.evaluation.JudgmentProcessorFactory;
import com.estar.judgment.evaluation.judgmentprocessor.JudgmentProcessorManager;

public class InitJudgmentDataListener implements ServletContextListener {
	
	private static final JudgmentProcessorManager PROCESSOR_MANAGER = new JudgmentProcessorManager();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("监听开始...，读取Text范例文本,用来提高第一次访问的速度");
		String path = arg0.getServletContext().getRealPath("test_judgment.txt");
		
		//如果有写好的工具类 ， 可以替换读取文件部分的代码 start
		File file = new File(path);
		String str = "";
		try {
			FileInputStream fi = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fi.read(buffer))> 0){
				str += new String(buffer,0,len,"gbk");
			}
			//System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//如果有写好的工具类 ， 可以替换读取文件部分的代码 end
		JudgmentProcessorFactory.getJudgmentInfoProcessor(PROCESSOR_MANAGER).execute(str);
		System.out.println("监听结束...");
	}

}
