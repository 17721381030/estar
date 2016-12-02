package com.estar.judgment.evaluation.web.law.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.law.dto.AllJudgmentPartyDTO;


@Service
public class AllJudgmentPartyService extends BaseService{
	
	@Autowired
	private DBHibernateTemplate hp;
	
	@SuppressWarnings("unchecked")
	public List getIdAllJudgmentParty(AllJudgmentPartyDTO dto)throws Exception{
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql.append("SELECT distinct t.id FROM AllJudgmentParty t " +
				"where 1=1  ");
		
		List para = new ArrayList();
		if(!StringUtils.nullOrBlank(dto.getName())){
			sql2.append(" and t.position = '律师' and t.name like ? ");
			para.add("%"+dto.getName()+"%");
		}
		
		if(!StringUtils.nullOrBlank(dto.getUnit())){
			sql2.append(" and t.unit like ? ");
			para.add("%"+dto.getUnit()+"%");
		}
		
		List list;
		if(!StringUtils.nullOrBlank(dto.getName()) || !StringUtils.nullOrBlank(dto.getUnit())){
			list = hp.getList(sql.toString() + sql2.toString(), list2Map(para));
		}else{
			return null;
		}
		
		return list;
	}
	
}
