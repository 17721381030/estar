package com.estar.judgment.evaluation.web.security.web.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.frame.util.TimestampTool;
import com.estar.judgment.evaluation.web.security.dto.AqOrgDTO;
import com.estar.judgment.evaluation.web.security.dto.AqOrgTreeDTO;
import com.estar.judgment.evaluation.web.security.entity.AqOrg;
import com.estar.judgment.evaluation.web.security.service.OrgService;

@Scope("prototype")  
public class OrgAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private OrgService orgService;
	private AqOrgDTO dto;
	private String status;
	private AqOrg aqOrg;
	public AqOrg getAqOrg() {
		return aqOrg;
	}

	public void setAqOrg(AqOrg aqOrg) {
		this.aqOrg = aqOrg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JSON(serialize=false)
	public AqOrgDTO getDto() {
		return dto;
	}

	public void setDto(AqOrgDTO dto) {
		this.dto = dto;
	}


	
	private List<AqOrg> orgList;
	
	public List<AqOrg> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<AqOrg> orgList) {
		this.orgList = orgList;
	}

	private List<AqOrgTreeDTO> orgtree;
	
	public List<AqOrgTreeDTO> getOrgtree() {
		return orgtree;
	}

	public void setOrgtree(List<AqOrgTreeDTO> orgtree) {
		this.orgtree = orgtree;
	}

	public String list() throws Exception {
		orgtree = orgService.loadOrgTree(dto.getOrgId());
		return "json";
	}


	public String remove() throws Exception {
		String id = request.getParameter("id");
		orgService.delAqOrg(id);
		status = "1";
		return "json";
	}
	
	public String edit() throws Exception {
		String id = request.getParameter("id");
		aqOrg = orgService.loadOrgById(id);
		return "json";
	}
	
	public String manage() throws Exception {
		return "org_manage";
	}
	
	public String modify() throws Exception {
		String fid = request.getParameter("fid");
		AqOrg o = copyVal2Entity();
		if(false == orgService.getIsHaveSameCodeOrName(o)){
			if(StringUtils.nullOrBlank(o.getOrgId())){
				o.setCreateby(this.getCurrentUserInfo().getUserName());
				o.setCreatedate(TimestampTool.crunttime());
				o.setUpdateby(this.getCurrentUserInfo().getUserName());
				o.setUpdatedate(TimestampTool.crunttime());
				o.setDelFlag("0");
				String id = orgService.addAqOrg(o, fid);
				o.setOrgId(id);
			}else{
				AqOrg oldObj = orgService.loadOrgById(o.getOrgId());
				o.setCreateby(oldObj.getCreateby());
				o.setCreatedate(oldObj.getCreatedate());
				o.setUpdateby(this.getCurrentUserInfo().getUserName());
				o.setUpdatedate(TimestampTool.crunttime());
				o.setDelFlag("0");
				BeanUtils.copyProperties(o, oldObj);
				orgService.updateAqOrg(oldObj);
			}
			aqOrg = o;
			status = "1";
		}else{
			status = "0";
		}
		return "json";
	}

	private AqOrg copyVal2Entity(){
		
		String id = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String fullName = request.getParameter("full_name");
		String orgLevel = request.getParameter("org_level");
		String phone = request.getParameter("phone");
		String fax = request.getParameter("fax");
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		String orgType = request.getParameter("org_type");
		AqOrg o = new AqOrg();
		o.setOrgId(id);
		o.setCode(code);
		o.setName(null == name?"":StringUtils.string2Utf_8(name));
		o.setFullName(null == fullName?"":StringUtils.string2Utf_8(fullName));
		o.setOrgLevel(orgLevel);
		o.setPhone(phone);
		o.setFax(fax);
		o.setAddress(null == address?"":StringUtils.string2Utf_8(address));
		o.setDescription(null == description?"":StringUtils.string2Utf_8(description));
		o.setOrgType(orgType);
		return o;
	}

	
}
