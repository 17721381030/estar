package com.estar.judgment.evaluation.web.law.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.law.dto.M2JudgmentInfoDTO;

/**
 * 待废除，由JudgmentInfoService去取代
 * @author Administrator
 *
 */
@Service
public class M2JudgmentInfoService extends BaseService{
	@Autowired
	private DBHibernateTemplate hp;
	
	@Autowired
	private M2JudgmentErrorService m2JudgmentErrorService;
	
	@SuppressWarnings("unchecked")
	public Map getM2JudgmentInfoDTO(M2JudgmentInfoDTO dto,int pageNo,int pageSize)throws Exception{
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.M2JudgmentInfoDTO(t) from M2JudgmentInfo t " +
				"where 1=1  ");
		
		List para = new ArrayList();
		if(!StringUtils.nullOrBlank(dto.getCourt())){
			sql2.append(" and t.court like ?  ");
			para.add("%"+dto.getCourt()+"%");
		}
		
		if(null != dto.getCaseNumberYear()){
			sql2.append(" and t.caseNumberYear = ?  ");
			para.add(dto.getCaseNumberYear());
		}
		
		if(!StringUtils.nullOrBlank(dto.getTrialGroup())){
			sql2.append(" and t.trialGroup like ?  ");
			para.add("%"+dto.getTrialGroup()+"%");
		}
		
		if(!StringUtils.nullOrBlank(dto.getCaseNumber())){
			sql2.append(" and t.caseNumber like ?  ");
			para.add("%"+dto.getCaseNumber()+"%");
		}
		sql2.append(" and t.caseNumber is not null ");
		
		Map map = hp.getList(sql.toString()+sql2.toString()+" order by t.caseNumberYear desc,t.caseNumber desc ",list2Map(para),pageNo,pageSize);
		Long judgmentDocNum = m2JudgmentErrorService.getCountM2Judgment(sql2.toString(), para);
		Long judgmentDocErrorNum = m2JudgmentErrorService.getCountM2JudgmentError(sql2.toString(), para);
		
		map.put("judgmentDocNum", judgmentDocNum);
		map.put("judgmentDocErrorNum", judgmentDocErrorNum);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map getM2JudgmentInfoDTOForExport(M2JudgmentInfoDTO dto)throws Exception{
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.M2JudgmentInfoDTO(t,e) " +
				"from M2JudgmentInfo t,M2JudgmentError e where 1=1 and t.id = e.id and (e.errorType = ? or e.errorType = ?)");
		
		List para = new ArrayList();
		para.add("E");
		para.add("W");
		if(!StringUtils.nullOrBlank(dto.getCourt())){
			sql2.append(" and t.court like ?  ");
			para.add("%"+dto.getCourt()+"%");
		}
		
		if(null != dto.getCaseNumberYear()){
			sql2.append(" and t.caseNumberYear = ?  ");
			para.add(dto.getCaseNumberYear());
		}
		
		if(!StringUtils.nullOrBlank(dto.getTrialGroup())){
			sql2.append(" and t.trialGroup like ?  ");
			para.add("%"+dto.getTrialGroup()+"%");
		}
		
		if(!StringUtils.nullOrBlank(dto.getCaseNumber())){
			sql2.append(" and t.caseNumber like ?  ");
			para.add("%"+dto.getCaseNumber()+"%");
		}
		
		
		List list = hp.getList(sql.toString()+sql2.toString(),list2Map(para));
		para.remove("E");
		para.remove("W");
		Long judgmentDocNum = m2JudgmentErrorService.getCountM2Judgment(sql2.toString(), para);
		Long judgmentDocErrorNum = m2JudgmentErrorService.getCountM2JudgmentError(sql2.toString(), para);
		Map map = new HashMap();
		map.put("list", list);
		map.put("judgmentDocNum", judgmentDocNum);
		map.put("judgmentDocErrorNum", judgmentDocErrorNum);
		return map;
	}
	
}
