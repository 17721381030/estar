package com.estar.judgment.evaluation.web.law.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.frame.util.TimestampTool;
import com.estar.judgment.evaluation.web.law.dto.XajDTO;
import com.estar.judgment.evaluation.web.law.service.StatisticsService;
import com.estar.judgment.evaluation.web.security.dto.AqUserDTO;

@Scope("prototype")  
public class StatisticsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private StatisticsService statisticsService;

	private XajDTO d = new XajDTO();
	private XajDTO s = new XajDTO();
	
	
	public String initPage() throws Exception {
		s.setType("1");
		return "list";
	}

	@SuppressWarnings("unchecked")
	public String search() throws Exception {
		Map<String,Object> map = null;
		AqUserDTO user = this.getCurrentUserInfo();
		if(!"admin".equals(user.getUserCode())){
			s.setAppraisalsPerson(user.getUserCode());
		}
		if("1".equals(s.getType())){
			map = statisticsService.getXajDTOList(s,getPageNo(),getPageSize());
		}else{
			map = statisticsService.getXajLawDTOList(s,getPageNo(),getPageSize());
		}
		super.setPageInfoFromDB(this.d,map);
		return "list";
	}
	
	public String edit() throws Exception {
		return "edit";
	}

	public XajDTO getD() {
		return d;
	}

	public void setD(XajDTO d) {
		this.d = d;
	}

	public XajDTO getS() {
		return s;
	}

	public void setS(XajDTO s) {
		this.s = s;
	}

	
	public String refreshXajDto()throws Exception{
		AqUserDTO aqUserDTO = this.getCurrentUserInfo();
		System.out.print(d.getAppraisalsStatus());
		System.out.print(d.getAppraisalsCause());
		d.setOperatePerson(aqUserDTO.getUserCode());
		d.setOperateDate(TimestampTool.crunttime());
		if("x_aj".equals(d.getTableType())){
			statisticsService.updateXajDto(d);
		}else if("x_aj_law".equals(d.getTableType())){
			statisticsService.updateXajLawDto(d);
		}
		return "json";
	}
	
	
}
