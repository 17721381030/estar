package com.estar.judgment.evaluation.web.law.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.law.dto.XajDTO;
import com.estar.judgment.evaluation.web.law.entity.Xaj;
import com.estar.judgment.evaluation.web.law.entity.XajLaw;


@Service
public class StatisticsService extends BaseService{
	
	@Autowired
	private DBHibernateTemplate hp;
	
	@SuppressWarnings("unchecked")
	public Map getXajDTOList(XajDTO dto,int pageNo,int pageSize)throws Exception{
		List para = new ArrayList();
		StringBuffer sql = new StringBuffer();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.XajDTO(t) from Xaj t where 1=1 ");
		sql.append(" and t.caseId not in (select distinct b.id from AppealAndResponse b where b.responseId=-3) ");
		if(!StringUtils.nullOrBlank(dto.getAppraisalsPerson())){
			sql.append(" and t.appraisalsPerson = ?");
			para.add(dto.getAppraisalsPerson());
		}

		return hp.getList(sql.toString(),list2Map(para),pageNo,pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public Map getXajLawDTOList(XajDTO dto,int pageNo,int pageSize)throws Exception{
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.XajLawDTO(t,j) from XajLaw t,M2JudgmentInfo j where 1=1 ");
		sql.append(" and t.caseId = j.id and t.caseNumber = j.caseNumber");
		if(!StringUtils.nullOrBlank(dto.getAppealType())){
			sql.append(" and t.standardErrors = ? ");
			para.add(dto.getAppealType());
		}
		if(!StringUtils.nullOrBlank(dto.getAppraisalsPerson())){
			sql.append(" and t.appraisalsPerson = ?");
			para.add(dto.getAppraisalsPerson());
		}
		sql.append(" order by j.caseNumberYear desc,j.caseNumber");
		
		return hp.getList(sql.toString(),list2Map(para),pageNo,pageSize);
	}
	
	
	public void updateXajDto(XajDTO dto)throws Exception{
		if(!StringUtils.nullOrBlank(dto.getId())){
			Xaj o = hp.get(Xaj.class, dto.getId());
		//	o.setAppraisalsPerson(dto.getAppraisalsPerson());
			o.setAppraisalsStatus(dto.getAppraisalsStatus());
			o.setAppraisalsCause(dto.getAppraisalsCause());
			o.setOperatePerson(dto.getOperatePerson());
			o.setOperateDate(dto.getOperateDate());
			hp.save(o);
		}
	}
	
	public void updateXajLawDto(XajDTO dto)throws Exception{
		if(!StringUtils.nullOrBlank(dto.getId())){
			XajLaw o = hp.get(XajLaw.class, dto.getId());
		//	o.setAppraisalsPerson(dto.getAppraisalsPerson());
			o.setAppraisalsStatus(dto.getAppraisalsStatus());
			o.setAppraisalsCause(dto.getAppraisalsCause());
			o.setOperatePerson(dto.getOperatePerson());
			o.setOperateDate(dto.getOperateDate());
			hp.save(o);
		}
	}
}
