package com.estar.judgment.evaluation.web.law.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.cause.Cause;
import com.estar.judgment.cause.CauseReader;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.law.dto.AllJudgmentInfoDTO;
import com.estar.judgment.evaluation.web.law.dto.AllJudgmentPartyDTO;
import com.estar.judgment.evaluation.web.law.dto.M2JudgmentInfoDTO;

@Service
public class AllJudgmentInfoService extends BaseService{
	private static final Cause[] CAUSES = CauseReader.readFromXml();
	
	@Autowired
	private DBHibernateTemplate hp;
	
	@Autowired
	private M2JudgmentErrorService m2JudgmentErrorService;
	
	@Autowired
	private AllJudgmentErrorService allJudgmentErrorService;
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public Map getJudgmentInfoDTO(AllJudgmentInfoDTO dto,AllJudgmentPartyDTO pDto,int pageNo,int pageSize)throws Exception{
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		StringBuffer sql3 = new StringBuffer();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.AllJudgmentInfoDTO(t) from AllJudgmentInfo t " +
				"where 1=1  ");
		List para = new ArrayList();
		if(null != pDto ){
			if(!StringUtils.nullOrBlank(pDto.getName()) || !StringUtils.nullOrBlank(pDto.getUnit())){
				sql3.append("SELECT distinct j.id FROM AllJudgmentParty j " +
				"where 1=1  ");
				if(!StringUtils.nullOrBlank(pDto.getName())){
					sql3.append(" and j.position = '律师' and j.name like ? ");
					para.add("%"+pDto.getName()+"%");
				}
				if(!StringUtils.nullOrBlank(pDto.getUnit())){
					sql3.append(" and j.unit like ? ");
					para.add("%"+pDto.getUnit()+"%");
				}
				sql2.append(" and t.id in ( " + sql3.toString() + " ) ");
			}
		}
		
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
		
		if(!StringUtils.nullOrBlank(dto.getCauseId())){
			String causeNames = this.getCauseNameStrSqlConditionById(dto.getCauseId());
			sql2.append(" and t.cause in ("+ causeNames +") ");
		}
		
		if(!StringUtils.nullOrBlank(dto.getCourtroomAbbr())){
			sql2.append(" and t.courtroomAbbr like ?  ");
			para.add("%"+dto.getCourtroomAbbr()+"%");
		}
		
		if(!StringUtils.nullOrBlank(dto.getCounter_claim_flag())){
			sql2.append(" and t.counter_claim_flag = ?  ");
			para.add(dto.getCounter_claim_flag());
		}
		
		if(!StringUtils.nullOrBlank(dto.getTrial_procedure())){
			sql2.append(" and t.trial_procedure = ?  ");
			para.add(dto.getTrial_procedure());
		}
		
		if(!StringUtils.nullOrBlank(dto.getDismiss_flag())){
			sql2.append(" and t.dismiss_flag = ?  ");
			para.add(dto.getDismiss_flag());
		}
		
		if(!StringUtils.nullOrBlank(dto.getJudgmentDate())){
			String[] temp = dto.getJudgmentDate().split(", ");
			if(temp.length > 0){
				if(temp.length == 1){
					sql2.append(" and t.judgmentDate>= ? ");
					para.add(temp[0]);
				}else{
					sql2.append(" and t.judgmentDate>= ? and t.judgmentDate<= ? ");
					para.add(temp[0]);
					para.add(temp[1]);
				}
			}
		}
		
		sql2.append(" and t.caseNumber is not null ");
		
		
		Map map = hp.getList(sql.toString()+sql2.toString()+" order by t.caseNumberYear desc,t.caseNumber desc ",list2Map(para),pageNo,pageSize);
		Long judgmentDocNum = allJudgmentErrorService.getCountJudgment(sql2.toString(), para);
		Long judgmentDocErrorNum = allJudgmentErrorService.getCountJudgmentError(sql2.toString(), para);
		
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
			para.add("%"+dto.getCaseNumberYear()+"%");
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
	
	
	//根据案由ID获取案由字符串，做SQL查询条件
	private static String getCauseNameStrSqlConditionById(String causeId){
		StringBuilder causeNameStr = new StringBuilder();
		for(int i = 0 ; i< CAUSES.length ; i++){
			Cause cause = CAUSES[i];
			if(causeId.equals(cause.getId())){
				causeNameStr.append("'"+cause.getName()+"'"+",");
			}
		}
		return causeNameStr.deleteCharAt(causeNameStr.length()-1).toString();
	}

	//获取案由信息,并导出
	@SuppressWarnings("unchecked")
	public Map getAllJudgmentInfoDTOForExport(AllJudgmentInfoDTO dto,AllJudgmentPartyDTO pDto)throws Exception{
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		StringBuffer sql3 = new StringBuffer();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.AllJudgmentInfoDTO(t,e) " +
				"from AllJudgmentInfo t,AllJudgmentError e where 1=1 and t.id = e.id and (e.errorType = ? or e.errorType = ?)");
		List para = new ArrayList();
		para.add("E");
		para.add("W");
		if(!StringUtils.nullOrBlank(pDto.getName()) || !StringUtils.nullOrBlank(pDto.getUnit())){
			sql3.append("SELECT distinct j.id FROM AllJudgmentParty j " +
			"where 1=1  ");
			if(!StringUtils.nullOrBlank(pDto.getName())){
				sql3.append(" and j.position = '律师' and j.name like ? ");
				para.add("%"+pDto.getName()+"%");
			}
			if(!StringUtils.nullOrBlank(pDto.getUnit())){
				sql3.append(" and j.unit like ? ");
				para.add("%"+pDto.getUnit()+"%");
			}
			sql2.append(" and t.id in ( " + sql3.toString() + " ) ");
		}
		
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
		
		//获取案由类型
		if(!StringUtils.nullOrBlank(dto.getCauseId())){
			String causeNames = this.getCauseNameStrSqlConditionById(dto.getCauseId());
			sql2.append(" and t.cause in ("+ causeNames +") ");
		}
		
		if(!StringUtils.nullOrBlank(dto.getCourtroomAbbr())){
			sql2.append(" and t.courtroomAbbr like ?  ");
			para.add("%"+dto.getCourtroomAbbr()+"%");
		}
		
		if(!StringUtils.nullOrBlank(dto.getCounter_claim_flag())){
			sql2.append(" and t.counter_claim_flag = ?  ");
			para.add(dto.getCounter_claim_flag());
		}
		
		if(!StringUtils.nullOrBlank(dto.getTrial_procedure())){
			sql2.append(" and t.trial_procedure = ?  ");
			para.add(dto.getTrial_procedure());
		}
		
		if(!StringUtils.nullOrBlank(dto.getDismiss_flag())){
			sql2.append(" and t.dismiss_flag = ?  ");
			para.add(dto.getDismiss_flag());
		}
		
		if(null!=dto.getJudgmentDate()){
			String[] temp = dto.getJudgmentDate().split(", ");
			if(temp.length > 0){
				if(temp.length == 1){
					sql2.append(" and t.judgmentDate>= ? ");
					para.add(temp[0]);
				}else{
					sql2.append(" and t.judgmentDate>= ? and t.judgmentDate<= ? ");
					para.add(temp[0]);
					para.add(temp[1]);
				}
			}
		}
		
		List list = hp.getList(sql.toString()+sql2.toString(),list2Map(para));
		para.remove("E");
		para.remove("W");
		Long judgmentDocNum = allJudgmentErrorService.getCountAllJudgment(sql2.toString(), para);
		Long judgmentDocErrorNum = allJudgmentErrorService.getCountAllJudgmentError(sql2.toString(), para);
		Map map = new HashMap();
		map.put("list", list);
		map.put("judgmentDocNum", judgmentDocNum);
		map.put("judgmentDocErrorNum", judgmentDocErrorNum);
		return map;
	}
	
}
