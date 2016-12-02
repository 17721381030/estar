package com.estar.judgment.evaluation.web.law.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.law.dto.AllJudgmentInfoDTO;
import com.estar.judgment.evaluation.web.law.dto.M2JudgmentInfoDTO;
import com.estar.judgment.evaluation.web.law.service.AllJudgmentInfoService;

@Scope("prototype")  
public class BatchEvaluateAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	//private M2JudgmentInfoService m2JudgmentInfoService;
	private AllJudgmentInfoService JudgmentInfoService;
	private Long judgmentDocNum;
	private Long judgmentDocErrorNum;
	private M2JudgmentInfoDTO d = new M2JudgmentInfoDTO();
	private M2JudgmentInfoDTO s = new M2JudgmentInfoDTO();
	private AllJudgmentInfoDTO a = new AllJudgmentInfoDTO();
	
	public String initPage() throws Exception {
		this.judgmentDocNum = (long)0;
		this.judgmentDocErrorNum = (long)0;
		return "list";
	}

	@SuppressWarnings("unchecked")
	public String search() throws Exception {
		System.out.println(a.getCourt());
		//List list = null;
		//System.out.println(s.getCourt());
		//Map<String,Object> map = m2JudgmentInfoService.getM2JudgmentInfoDTO(s,getPageNo(),getPageSize());
		Map<String,Object> map = JudgmentInfoService.getJudgmentInfoDTO(a,null,getPageNo(),getPageSize());
		super.setPageInfoFromDB(this.d,map);
		this.judgmentDocNum = (Long)map.get("judgmentDocNum");
		this.judgmentDocErrorNum = (Long)map.get("judgmentDocErrorNum");
		return "list";
	}
	

	public String edit() throws Exception {
		return "edit";
	}

	public M2JudgmentInfoDTO getD() {
		return d;
	}

	public void setD(M2JudgmentInfoDTO d) {
		this.d = d;
	}

	public M2JudgmentInfoDTO getS() {
		return s;
	}

	public void setS(M2JudgmentInfoDTO s) {
		this.s = s;
	}
	
	public AllJudgmentInfoDTO getA() {
		return a;
	}

	public void setA(AllJudgmentInfoDTO a) {
		this.a = a;
	}

	public Long getJudgmentDocNum() {
		return judgmentDocNum;
	}

	public void setJudgmentDocNum(Long judgmentDocNum) {
		this.judgmentDocNum = judgmentDocNum;
	}

	public Long getJudgmentDocErrorNum() {
		return judgmentDocErrorNum;
	}

	public void setJudgmentDocErrorNum(Long judgmentDocErrorNum) {
		this.judgmentDocErrorNum = judgmentDocErrorNum;
	}
}
