package com.estar.judgment.evaluation.web.security.web.action;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.frame.util.TimestampTool;
import com.estar.judgment.evaluation.web.security.dto.AqOperateDTO;
import com.estar.judgment.evaluation.web.security.entity.AqOperate;
import com.estar.judgment.evaluation.web.security.service.ModuleService;

@Scope("prototype")  
public class OperateAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ModuleService moduleService;
	private AqOperateDTO d = new AqOperateDTO();
	private AqOperateDTO s = new AqOperateDTO();
	
	public AqOperateDTO getD() {
		return d;
	}

	public AqOperateDTO getS() {
		return s;
	}

	public void setD(AqOperateDTO d) {
		this.d = d;
	}

	public void setS(AqOperateDTO s) {
		this.s = s;
	}

	public String list() throws Exception {
		if(!StringUtils.nullOrBlank(s.getModuleId())){
			AqOperate o = new AqOperate();
			o.setModuleId(s.getModuleId());
			o.setName(s.getName());
			List<AqOperate> list = moduleService.getAqOperateList(o);
			setPageInfoFromDB(this.d,list);
		}
		this.s.setModuleList(moduleService.getAqModuleList());
		return "list";
	}


	public String delete() throws Exception {
		String[] ids = new String[]{this.d.getOperateId()};
		if(null != ids && ids.length > 0){
			moduleService.delAqOperate(ids);
		}
		return "delete";
	}
	
	public String edit() throws Exception {
		AqOperate o = moduleService.getAqOperate(this.d.getOperateId());
		if(null != o){
			BeanUtils.copyProperties(o,d);
		}
		this.d.setModuleList(moduleService.getAqModuleList());
		return "detail";
	}
	
	public String save() throws Exception {
		AqOperate o = new AqOperate();
		BeanUtils.copyProperties(d, o);
		if(StringUtils.nullOrBlank(o.getOperateId())){
			o.setCreateby(this.getCurrentUserInfo().getUserName());
			o.setCreatedate(TimestampTool.crunttime());
			o.setUpdateby(this.getCurrentUserInfo().getUserName());
			o.setUpdatedate(TimestampTool.crunttime());
			o.setDelFlag("0");
			String operateId = moduleService.addAqOperate(o);
			d.setOperateId(operateId);
		}else{
			AqOperate oldObj = moduleService.getAqOperate(o.getOperateId());
			o.setCreateby(oldObj.getCreateby());
			o.setCreatedate(oldObj.getCreatedate());
			o.setUpdateby(this.getCurrentUserInfo().getUserName());
			o.setUpdatedate(TimestampTool.crunttime());
			o.setDelFlag("0");
			BeanUtils.copyProperties(o, oldObj);
			moduleService.updateAqOperate(oldObj);
		}
		this.setMsg(getText("add_success"));
		this.d.setModuleList(moduleService.getAqModuleList());
		return "detail";
	}
	
}
