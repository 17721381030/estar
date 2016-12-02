package com.estar.judgment.evaluation.web.law.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.common.util.HtmlUtil;
import com.estar.common.util.StringUtil;
import com.estar.judgment.evaluation.JudgmentInfo;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.frame.util.SpliterArticle;
import com.estar.judgment.evaluation.web.law.entity.AllJudgment;
import com.estar.judgment.evaluation.web.law.entity.AnalysisJudgmentErrorLog;
import com.estar.judgment.evaluation.web.law.entity.AnalysisJudgmentErrorLogId;
import com.estar.judgment.evaluation.web.law.entity.AnalysisJudgmentLog;
import com.estar.judgment.evaluation.web.law.entity.M2Judgment;
import com.estar.judgment.evaluation.web.law.entity.UserFeedBack;
import com.estar.judgment.util.exception.InvalidJudgmentReportException;


@Service
public class AnalysisArticleService extends BaseService{
	
	@Autowired
	private SpliterArticle spliterArticle;
	
	@Autowired
	private DBHibernateTemplate hp;
	
	@SuppressWarnings("unchecked")
	public JudgmentInfo AnalysisArticle(String article)throws Exception{
		JudgmentInfo info = null;
		try{
			info = (JudgmentInfo)spliterArticle.getTextProcessor().execute(article).getResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return info;
	}
	
	/**
	 *	TODO Liu  待删除
	 */
	@SuppressWarnings("unchecked")
	public M2Judgment getArticleById(String articleId)throws Exception{
		M2Judgment m2Judgment = null;
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select t from M2Judgment t where t.id = ? ");
		para.add(articleId);
		List list = hp.getList(sql.toString(),list2Map(para));
		if(null != list && list.size() > 0){
			m2Judgment = (M2Judgment)list.get(0);
		}
		return m2Judgment;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public AllJudgment getAllArticleById(String articleId)throws Exception{
		AllJudgment allJudgment = null;
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select t from AllJudgment t where t.id = ? ");
		para.add(articleId);
		List list = hp.getList(sql.toString(),list2Map(para));
		if(null != list && list.size() > 0){
			allJudgment = (AllJudgment)list.get(0);
		}
		return allJudgment;
	}
	
	public String clearHtmlTag(String articleContent) throws SQLException{
		String content = articleContent.replace("<br/>", "\n").replace("<p>", "").replace("</p>", "");
		String article = HtmlUtil.removeTagAndSurplusSpace(StringUtil.getNvl(content));
		return article.replace("\t", "");
	}
	
	
	@SuppressWarnings("unchecked")
	public void saveUserFeedBack(String articleContent,String errorMessage,String suggest)throws Exception{
		UserFeedBack userFeedBack = new UserFeedBack(articleContent,errorMessage,suggest);
		hp.save(userFeedBack);
	}
	
	@SuppressWarnings("unchecked")
	public AnalysisJudgmentLog saveJudgmentLog(JudgmentInfo info,String article){
		AnalysisJudgmentLog judgmentLog = null;
		String courtName = "";
		String casenumber = "";
		if(info.isValid()){
			if(!StringUtil.isEmpty(info.getCourt().getOriginalText())){
				courtName = info.getCourt().getOriginalText();	
			}
			if(!StringUtil.isEmpty(info.getCaseNumber().getOriginalText())){
				casenumber = info.getCaseNumber().getOriginalText();
			}
			judgmentLog = new AnalysisJudgmentLog(article,courtName,casenumber);
		}else{
			 judgmentLog = new AnalysisJudgmentLog(article,"文本格式错误","文本格式错误");
		}
		hp.save(judgmentLog);
		return judgmentLog;
	}
	
	@SuppressWarnings("unchecked")	
	public void saveJudgmentErrorLog(JudgmentInfo info,AnalysisJudgmentLog judgmentLog){
		if(info.isValid()){
			AnalysisJudgmentErrorLog[] errorsLog = createErrorsLogArray(judgmentLog.getId(),info.getExceptions());
			for(AnalysisJudgmentErrorLog log :errorsLog){
				hp.save(log);
			}	
		}
	}
	
	private AnalysisJudgmentErrorLog[]  createErrorsLogArray(Integer id,InvalidJudgmentReportException[] errors){
		AnalysisJudgmentErrorLog[] judmentErrorLogs = new AnalysisJudgmentErrorLog[errors.length];
		for(int i=0 ; i < errors.length ; i++){
			AnalysisJudgmentErrorLogId key = new AnalysisJudgmentErrorLogId(id,i+1);
			judmentErrorLogs[i] = new AnalysisJudgmentErrorLog(key,
					errors[i].getErrorContent().getTop().getName(),errors[i].getErrorContent().getName(),
					new Integer(errors[i].getId()),errors[i].getMessage(),errors[i].getStandardType().getId(),errors[i].getUserDefinedType().getId(),"N");
		}
		return judmentErrorLogs;
	}
	
}
