package com.estar.judgment.evaluation.web.security.web.action;


import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.frame.util.MD5;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.frame.util.TimestampTool;
import com.estar.judgment.evaluation.web.security.dto.AqUserDTO;
import com.estar.judgment.evaluation.web.security.dto.AqUserModuleDTO;
import com.estar.judgment.evaluation.web.security.entity.AqUser;
import com.estar.judgment.evaluation.web.security.service.OrgService;
import com.estar.judgment.evaluation.web.security.service.UserService;

@Scope("prototype")  
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	@Autowired
	private OrgService orgService;
	private AqUserDTO d = new AqUserDTO();
	private AqUserDTO s = new AqUserDTO();
	public AqUserDTO getD() {
		return d;
	}
	public void setD(AqUserDTO d) {
		this.d = d;
	}

	public AqUserDTO getS() {
		return s;
	}
	public void setS(AqUserDTO s) {
		this.s = s;
	}

	public String list() throws Exception {
		if(!StringUtils.nullOrBlank(s.getOrgId())){
			Map<String,Object> map = userService.getAqUserList(s, getPageNo(), getPageSize());
			this.setPageInfoFromDB(this.d, map);
		}
		this.s.setOrgList(orgService.loadOrgsById(this.getCurrentUserInfo().getOrgId()));
		return "list";
	}


	public String delete() throws Exception {
		String[] ids = new String[]{this.d.getUserId()};
		if(null != ids && ids.length > 0){
			userService.delAqUser(ids);
		}
		return "delete";
	}
	
	public String edit() throws Exception {
		AqUser o = userService.loadAqUser(this.d.getUserId());
		if(null != o){
			BeanUtils.copyProperties(o, d);
		}
		AqUserDTO currentUser = this.getCurrentUserInfo();
		this.d.setOrgList(orgService.loadOrgsById(currentUser.getOrgId()));
		return "detail";
	}
	
	public String load_user() throws Exception {
		AqUser o = userService.loadAqUser(this.getCurrentUserInfo().getUserId());
		if(null != o){
			BeanUtils.copyProperties(o, d);
		}
		return "user_info";
	}
	
	
	public String toPasswd() throws Exception {
		return "passwd";
	}
	
	public String changePasswd() throws Exception {
		AqUserDTO user = this.getCurrentUserInfo();
		AqUser o = userService.loadAqUser(user.getUserId());
		if(o.getPasswd().equals(MD5.encrypt(o.getUserCode() + d.getPasswd()))){
			o.setPasswd(MD5.encrypt(o.getUserCode() + d.getNewPasswd()));
			userService.updateAqUser(o);
			this.setMsg(this.getText("operate_info",new String[]{"修改成功!"}));
		}else{
			this.setMsg(this.getText("operate_info",new String[]{"当前密码不正确!"}));
		}
		return "passwd";
	}
	
	public String save() throws Exception {
		AqUser o = new AqUser();
		BeanUtils.copyProperties(d, o);
		AqUserDTO currentUser = this.getCurrentUserInfo();
		this.d.setOrgList(orgService.loadOrgsById(currentUser.getOrgId()));
		AqUser checkUser =userService.checkUserExists(o.getUserCode());
		if(StringUtils.nullOrBlank(o.getUserId())){
			if(null != checkUser){
				this.setMsg(getText("user_code_exists"));
				return "detail";
			}else{
				o.setDelFlag("0");
				o.setCreateby(this.getCurrentUserInfo().getUserName());
				o.setCreatedate(TimestampTool.crunttime());
				o.setUpdateby(this.getCurrentUserInfo().getUserName());
				o.setUpdatedate(TimestampTool.crunttime());
				o.setPasswd(d.getNewPasswd());
				String userId = userService.addAqUser(o);
				d.setUserId(userId);
			}
		}else{
			if(null != checkUser && !checkUser.getUserId().equals(o.getUserId())){
				this.setMsg(getText("user_code_exists"));
				return "detail";
			}else{
				AqUser oldObj = userService.loadAqUser(o.getUserId());
				o.setCreateby(oldObj.getCreateby());
				o.setCreatedate(oldObj.getCreatedate());
				o.setUpdateby(this.getCurrentUserInfo().getUserName());
				o.setUpdatedate(TimestampTool.crunttime());
				o.setDelFlag("0");
				if(StringUtils.nullOrBlank(d.getNewPasswd())){
					o.setPasswd(oldObj.getPasswd());
				}else{
					o.setPasswd(MD5.encrypt(o.getUserCode()+d.getNewPasswd()));
				}
				BeanUtils.copyProperties(o, oldObj);
				userService.updateAqUser(oldObj);
			}
		}
		
		this.setMsg(getText("operate_info",new String[]{"操作成功"}));
		return "detail";
	}




	
	private List<AqUserModuleDTO> userModulList;
	public List<AqUserModuleDTO> getUserModulList() {
		return userModulList;
	}

	public void setUserModulList(List<AqUserModuleDTO> userModulList) {
		this.userModulList = userModulList;
	}

	public String user_module() throws Exception {
		String id = request.getParameter("id");
		userModulList = userService.getUserModule(id);
		return "json";
	}
	private String addModulestatus;
	
	public String getAddModulestatus() {
		return addModulestatus;
	}

	public void setAddModulestatus(String addModulestatus) {
		this.addModulestatus = addModulestatus;
	}

	public String module_save() throws Exception {
		String[] ids = request.getParameterValues("ids");
		String userId = request.getParameter("userId");
		userService.addUserModule(userId, ids);
		addModulestatus = "1";
		return "json";
	}

}
