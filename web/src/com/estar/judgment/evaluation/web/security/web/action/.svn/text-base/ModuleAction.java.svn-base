package com.estar.judgment.evaluation.web.security.web.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.frame.util.TimestampTool;
import com.estar.judgment.evaluation.web.security.dto.AqModuleDTO;
import com.estar.judgment.evaluation.web.security.dto.AqUserDTO;
import com.estar.judgment.evaluation.web.security.entity.AqModule;
import com.estar.judgment.evaluation.web.security.service.ModuleService;

@Scope("prototype")  
public class ModuleAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ModuleService moduleService;
	
	private AqModuleDTO d = new AqModuleDTO();
	private AqModuleDTO s = new AqModuleDTO();
	private List<AqModuleDTO> moduleList = new ArrayList<AqModuleDTO>();
	public AqModuleDTO getD() {
		return this.d;
	}

	public void setD(AqModuleDTO d) {
		this.d = d;
	}
	
	public AqModuleDTO getS() {
		return this.s;
	}

	public void setS(AqModuleDTO s) {
		this.s = s;
	}

	public List<AqModuleDTO> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<AqModuleDTO> moduleList) {
		this.moduleList = moduleList;
	}

	public String list() throws Exception {
		Map<String,Object> map = moduleService.getAqModuleList(s,getPageNo(),getPageSize());
		super.setPageInfoFromDB(this.d,map);
		return "list";
	}


	public String delete() throws Exception {
		String id = this.d.getModuleId();
		String[] ids = new String[]{id};
		if(null != ids && ids.length > 0){
			moduleService.delAqModule(ids);
		}
		return "delete";
	}
	
	public String edit() throws Exception {
		AqModule o = moduleService.getObjectAqModule(this.d.getModuleId());
		if(null != o){
			this.d = this.d ==null?new AqModuleDTO():this.d;
			BeanUtils.copyProperties(o, d);
		}
		return "detail";
	}
	
	public String save() throws Exception {
		AqModule o = new AqModule();
		BeanUtils.copyProperties(d, o);
		if(StringUtils.nullOrBlank(d.getModuleId())){
			o.setCreateby(this.getCurrentUserInfo().getUserName());
			o.setCreatedate(TimestampTool.crunttime());
			o.setUpdateby(this.getCurrentUserInfo().getUserName());
			o.setUpdatedate(TimestampTool.crunttime());
			o.setDelFlag("0");
			String moduleId = moduleService.addAqModule(o);
			d.setModuleId(moduleId);
		}else{
			AqModule old = moduleService.getObjectAqModule(d.getModuleId());
			d.setCreateby(old.getCreateby());
			d.setCreatedate(old.getCreatedate());
			d.setDelFlag("0");
			BeanUtils.copyProperties(d, old);
			old.setUpdateby(this.getCurrentUserInfo().getUserName());
			old.setUpdatedate(TimestampTool.crunttime());
			moduleService.updateAqModule(old);
		}
		setMsg(getText("add_success"));
		return "detail";
	}
	
	public String userMenu()throws Exception {
		AqUserDTO user = this.getCurrentUserInfo();
		moduleList = moduleService.getAqModuleByUserId(user.getUserId());
		return "json";
	}
}
