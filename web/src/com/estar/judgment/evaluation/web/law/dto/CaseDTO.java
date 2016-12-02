package com.estar.judgment.evaluation.web.law.dto;


import java.util.Date;
import java.util.List;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.law.entity.CaseAppealLaw;


public class CaseDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String causeId;
	private String causeName;
	private String appealKeyId;
	private String appealLawId;
	private String id;
	private String content;
	private List<CaseCauseDTO> causeList;
	private List<CaseAppealKeyDTO> appealKeyList;
	private List<CaseAppealLawDTO> appealLawList;
	private List<CaseLawElementDTO> lawElementList;
	private List<CaseRelateLawDTO> caseRelateLawList;
	private List<M2JudgmentInfoDTO> m2JudgmentInfoDTOList;
	private CaseAppealLaw caseAppealLaw;
	private String lawArticle;
	private String lawArticleId;
	private String appealKey;
	private String court;
	private String caseNumber;
	
	private String operatePerson;
	private Date operateDate;
	
	public CaseDTO() {
	}

	public String getCauseId() {
		return causeId;
	}

	public void setCauseId(String causeId) {
		this.causeId = causeId;
	}
	
	public String getCauseName() {
		return causeName;
	}

	public void setCauseName(String causeName) {
		this.causeName = causeName;
	}

	public String getAppealKeyId() {
		return appealKeyId;
	}

	public void setAppealKeyId(String appealKeyId) {
		this.appealKeyId = appealKeyId;
	}

	public String getAppealLawId() {
		return appealLawId;
	}

	public void setAppealLawId(String appealLawId) {
		this.appealLawId = appealLawId;
	}

	public List<CaseCauseDTO> getCauseList() {
		return causeList;
	}

	public void setCauseList(List<CaseCauseDTO> causeList) {
		this.causeList = causeList;
	}

	public List<CaseAppealKeyDTO> getAppealKeyList() {
		return appealKeyList;
	}

	public void setAppealKeyList(List<CaseAppealKeyDTO> appealKeyList) {
		this.appealKeyList = appealKeyList;
	}

	public List<CaseAppealLawDTO> getAppealLawList() {
		return appealLawList;
	}

	public void setAppealLawList(List<CaseAppealLawDTO> appealLawList) {
		this.appealLawList = appealLawList;
	}

	public List<CaseLawElementDTO> getLawElementList() {
		return lawElementList;
	}

	public void setLawElementList(List<CaseLawElementDTO> lawElementList) {
		this.lawElementList = lawElementList;
	}

	public List<CaseRelateLawDTO> getCaseRelateLawList() {
		return caseRelateLawList;
	}

	public void setCaseRelateLawList(List<CaseRelateLawDTO> caseRelateLawList) {
		this.caseRelateLawList = caseRelateLawList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CaseAppealLaw getCaseAppealLaw() {
		return caseAppealLaw;
	}

	public void setCaseAppealLaw(CaseAppealLaw caseAppealLaw) {
		this.caseAppealLaw = caseAppealLaw;
	}

	public List<M2JudgmentInfoDTO> getM2JudgmentInfoDTOList() {
		return m2JudgmentInfoDTOList;
	}

	public void setM2JudgmentInfoDTOList(List<M2JudgmentInfoDTO> judgmentInfoDTOList) {
		m2JudgmentInfoDTOList = judgmentInfoDTOList;
	}

	public String getLawArticle() {
		return lawArticle;
	}

	public void setLawArticle(String lawArticle) {
		this.lawArticle = lawArticle;
	}

	public String getLawArticleId() {
		return lawArticleId;
	}

	public void setLawArticleId(String lawArticleId) {
		this.lawArticleId = lawArticleId;
	}

	public String getAppealKey() {
		return appealKey;
	}

	public void setAppealKey(String appealKey) {
		this.appealKey = appealKey;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getOperatePerson() {
		return operatePerson;
	}

	public void setOperatePerson(String operatePerson) {
		this.operatePerson = operatePerson;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
	
}