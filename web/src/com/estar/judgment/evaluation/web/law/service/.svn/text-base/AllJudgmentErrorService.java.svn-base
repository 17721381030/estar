package com.estar.judgment.evaluation.web.law.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;


@Service
public class AllJudgmentErrorService extends BaseService{
	
	@Autowired
	private DBHibernateTemplate hp;
	
	@SuppressWarnings("unchecked")
	public Long getCountJudgment(String sql,List paras)throws Exception{
		sql += " and (t1.errorType = ? or t1.errorType = ?)";
		paras.add("E");
		paras.add("W");
		Long rectotal = (long)0;
		String sqlBase = "select count(distinct t1.id) from AllJudgmentError t1,AllJudgmentInfo t where t1.id = t.id ";
		List list = hp.getList(sqlBase+ sql,list2Map(paras));
		if(null != list && list.size() > 0){
			rectotal = (Long)list.get(0);
		}
		return rectotal;
	}
	
	
	@SuppressWarnings("unchecked")
	public Long getCountJudgmentError(String sql,List paras)throws Exception{
		sql += " and (t1.errorType = ? or t1.errorType = ?)";
		Long rectotal = (long)0;
		String sqlBase = "select count(t1.id) from AllJudgmentError t1,AllJudgmentInfo t where t1.id = t.id ";
		List list = hp.getList(sqlBase+ sql,list2Map(paras));
		if(null != list && list.size() > 0){
			rectotal = (Long)list.get(0);
		}
		return rectotal;
	}

	//获取瑕疵判决书总数
	@SuppressWarnings("unchecked")
	public Long getCountAllJudgment(String sql,List paras)throws Exception{
		sql += " and (t1.errorType = ? or t1.errorType = ?)";
		paras.add("E");
		paras.add("W");
		Long rectotal = (long)0;
		String sqlBase = "select count(distinct t1.id) from AllJudgmentError t1,AllJudgmentInfo t where t1.id = t.id ";
		List list = hp.getList(sqlBase+ sql,list2Map(paras));
		if(null != list && list.size() > 0){
			rectotal = (Long)list.get(0);
		}
		return rectotal;
	}

	//获取瑕疵总数
	@SuppressWarnings("unchecked")
	public Long getCountAllJudgmentError(String sql,List paras)throws Exception{
		sql += " and (t1.errorType = ? or t1.errorType = ?)";
		Long rectotal = (long)0;
		String sqlBase = "select count(t1.id) from AllJudgmentError t1,AllJudgmentInfo t where t1.id = t.id ";
		List list = hp.getList(sqlBase+ sql,list2Map(paras));
		if(null != list && list.size() > 0){
			rectotal = (Long)list.get(0);
		}
		return rectotal;
	}
}
