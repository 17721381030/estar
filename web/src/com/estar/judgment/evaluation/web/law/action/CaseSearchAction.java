package com.estar.judgment.evaluation.web.law.action;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.frame.util.TimestampTool;
import com.estar.judgment.evaluation.web.law.dto.CaseDTO;
import com.estar.judgment.evaluation.web.law.service.CaseAppealKeyService;
import com.estar.judgment.evaluation.web.law.service.CaseAppealLawService;
import com.estar.judgment.evaluation.web.law.service.CaseCauseService;
import com.estar.judgment.evaluation.web.security.dto.AqUserDTO;

@Scope("prototype")  
public class CaseSearchAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CaseAppealKeyService caseAppealKeyService;
	@Autowired
	private CaseAppealLawService caseAppealLawService;
	@Autowired
	private CaseCauseService caseCauseService;
	
	private CaseDTO d = new CaseDTO();
	public CaseDTO getD() {
		return d;
	}
	public void setD(CaseDTO d) {
		this.d = d;
	}

	public String initPage() throws Exception {
		return "search";
	}

	public String loadCaseCause() throws Exception {
		d.setCauseList(caseCauseService.getCaseCauseDTO());
		return "json";
	}

	public String loadCaseAppealKey() throws Exception {
		d.setAppealKeyList(caseAppealKeyService.getCaseAppealKeyDTOListByCauseId(d.getCauseId()));
		return "json";
	}
	
	public String loadCaseAppealLaw() throws Exception {
		d.setAppealLawList(caseAppealLawService.getCaseAppealLawListByAppealKeyId(d.getLawArticle(),d.getAppealKeyId()));
		return "json";
	}
	
	public String loadCaseAppealLawObject() throws Exception {
		d.setCaseAppealLaw(caseAppealLawService.getCaseAppealLaw(d.getId()));
		return "json";
	}

	public String loadCaseElementAndRelateLaw() throws Exception {
		d.setLawElementList(caseAppealLawService.getCaseLawElementListByappealLawId(d.getAppealLawId()));
		d.setCaseRelateLawList(caseAppealLawService.getCaseRelateLawDTOListByappealLawId(d.getAppealLawId()));
		return "json";
	}
	
	public String refreshAppealLawList() throws Exception {
		AqUserDTO aqUserDTO = this.getCurrentUserInfo();
		d.setOperatePerson(aqUserDTO.getUserCode());
		d.setOperateDate(TimestampTool.crunttime());
		caseAppealLawService.saveCaseAppealLaw(d);
		
		return "json";
	}
	
	public String addCaseElement() throws Exception {
		AqUserDTO user = this.getCurrentUserInfo();
		caseAppealLawService.saveCaseElement(d,user);
		return "json";
	}
	
	public String addRelateLaw() throws Exception {
		AqUserDTO user = this.getCurrentUserInfo();
		caseAppealLawService.saveRelateLaw(d,user);
		return "json";
	}
	
	public String delCaseElement() throws Exception {
		AqUserDTO user = this.getCurrentUserInfo();
		caseAppealLawService.deleteCaseElement(d,user);
		return "json";
	}
	
	public String delRelateLaw() throws Exception {
		AqUserDTO user = this.getCurrentUserInfo();
		caseAppealLawService.deleteRelateLaw(d,user);
		return "json";
	}
	
	public String caseByAppealKeyAndLawArticle()throws Exception{
		if(!StringUtils.nullOrBlank(d.getAppealKey()) && !StringUtils.nullOrBlank(d.getLawArticle())){
			String causeId = caseAppealLawService.getCauseId(d.getCauseName());
			Map map = caseAppealLawService.getCaseByAppealKeyAndLawArticle(d,causeId,getPageNo(),getPageSize());
			super.setPageInfoFromDB(this.d,map);
		}
		return "caseList";
	}
}
