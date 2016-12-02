package com.estar.judgment.evaluation.web.law.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.law.dto.CaseCauseDTO;


@Service
public class CaseCauseService extends BaseService{
	@Autowired
	private DBHibernateTemplate hp;
	
	
	@SuppressWarnings("unchecked")
	public List<CaseCauseDTO> getCaseCauseDTO()throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.CaseCauseDTO(t) from CaseCause t where t.delFlag = '0' ");
		return hp.getList(sql.toString());
	}
	
	

	
}
