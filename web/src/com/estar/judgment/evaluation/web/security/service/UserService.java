package com.estar.judgment.evaluation.web.security.service;




import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.frame.util.CheckIP;
import com.estar.judgment.evaluation.web.frame.util.LVBean;
import com.estar.judgment.evaluation.web.frame.util.MD5;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.security.dto.AqUserDTO;
import com.estar.judgment.evaluation.web.security.dto.AqUserModuleDTO;
import com.estar.judgment.evaluation.web.security.entity.AqModule;
import com.estar.judgment.evaluation.web.security.entity.AqOrg;
import com.estar.judgment.evaluation.web.security.entity.AqUser;
import com.estar.judgment.evaluation.web.security.entity.AqUserModule;
import com.estar.judgment.evaluation.web.security.utils.Dict;

@Service
public class UserService extends BaseService{
	@Autowired
	private DBHibernateTemplate hp;
	@Autowired
	private ModuleService moduleService;;
	@Autowired
	private OrgService orgService;
	
	public String addAqUser(AqUser o)throws Exception{
		if(o != null){
			if(!StringUtils.nullOrBlank(o.getPasswd())){
				o.setPasswd(MD5.encrypt(o.getUserCode()+o.getPasswd()));
			}
			return (String)hp.save(o);
		}
		return null;
	}
	
	public void updateAqUser(AqUser o)throws Exception{
		if(o != null){
			
			AqUser obj = hp.get(AqUser.class, o.getUserId());
			
			hp.update(obj);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void delAqUser(String[] ids)throws Exception{
		if(ids != null && ids.length > 0){
			for(int i = 0; i < ids.length; i++){
				AqUser o = hp.get(AqUser.class, ids[i]);
				o.setDelFlag("1");
				hp.update(o);
			}
		}
	}
	
	public AqUser loadAqUser(String id)throws Exception{
		if(null != id){
			return (AqUser)hp.get(AqUser.class, id);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Object> getAqUserList(AqUserDTO o,int iPageNo,final int iPageSize )throws Exception{
		if(o != null){
			StringBuffer sql = new StringBuffer();
			List para = new ArrayList();
			sql.append("select new com.estar.judgment.evaluation.web.security.dto.AqUserDTO(t,o) from AqUser t,AqOrg o where t.orgId = o.id and t.delFlag = '0' ");
			if( !StringUtils.nullOrBlank(o.getUserCode())){
				sql.append(" and t.userCode like ?  ");
				para.add("%"+o.getUserCode()+"%");
			}
			if(!StringUtils.nullOrBlank(o.getUserName())){
				sql.append(" and t.userName like ?  ");
				para.add("%"+o.getUserName()+"%");
			}
			if(!StringUtils.nullOrBlank(o.getOrgId())){
				if(null != o.getSearchChildren() && "true".equals(o.getSearchChildren())){
					sql.append(" and t.orgId like ?  ");
					para.add(o.getOrgId()+"%");
				}else{
					sql.append(" and t.orgId = ?  ");
					para.add(o.getOrgId());
				}
			}
			return hp.getList(sql.toString(), list2Map(para),iPageNo,iPageSize);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public AqUser checkUserExists(String userCode)throws Exception{
		Map<String,String> mapps = new HashMap<String,String>();
		StringBuffer sql = new StringBuffer();
		int i = 0;
		sql.append("select t from AqUser t where t.delFlag = '0' and t.userCode = ?");
		mapps.put(""+(i++),userCode);
		List<AqUser> list = hp.getList(sql.toString(), mapps);
		if(null != list && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public AqUserDTO userLogin(String userCode,String passwd,String ip)throws Exception{
		AqUserDTO dto = new AqUserDTO();
		Map<String,String> mapps = new HashMap<String,String>();
		StringBuffer sql = new StringBuffer();
		int i = 0;
		sql.append("select t from AqUser t where t.delFlag = '0' and t.userCode = ?");
		mapps.put(""+(i++),userCode);
		List<AqUser> list = hp.getList(sql.toString(), mapps);
		if(null == list || list.size() == 0){
			dto.setLoginStatus(Dict.LOGIN_STATUS.USER_NOT_EXISTS);
			return dto;
		}
		AqUser user = list.get(0);
		if(!MD5.encrypt(userCode+passwd).equals(user.getPasswd())){
			dto.setLoginStatus(Dict.LOGIN_STATUS.PASSWD_ERROR);
			return dto;
		}
		
		if("0".equals(user.getIsValid())){
			dto.setLoginStatus(Dict.LOGIN_STATUS.USER_FREEZE);
			return dto;
		}
		
		if("1".equals(user.getEffect())){
			Date nowDate = new Date();
			if(nowDate.getTime() > user.getEffectB().getTime() && nowDate.getTime() < user.getEffectE().getTime()){
			}else{
				dto.setLoginStatus(Dict.LOGIN_STATUS.EFFECT);
				return dto;
			}
		}
		
		if(!StringUtils.nullOrBlank(ip) && Dict.FROHIBIT_IP_LIST.size() > 0){
			for(int j = 0;j < Dict.FROHIBIT_IP_LIST.size(); j++){
				LVBean lv = Dict.FROHIBIT_IP_LIST.get(j);
				if(CheckIP.ipBiJiao(ip,lv.getLabel(),lv.getValue())){
					dto.setLoginStatus(Dict.LOGIN_STATUS.IP_FROHIBIT);
					return dto;
				}
			}
		}
		
		AqUserModule module = new AqUserModule();
		module.setUserId(user.getUserId());
		List<AqUserModule> aqUserModuleList = moduleService.getAqUserModuleList(module);
		if(null == aqUserModuleList || aqUserModuleList.size() == 0){
			dto.setLoginStatus(Dict.LOGIN_STATUS.NO_ACCESS);
			return dto;
		}else{
			StringBuffer strModule = new StringBuffer();
			for(int k = 0;k < aqUserModuleList.size(); k++){
				AqUserModule aqUserModule = aqUserModuleList.get(k);
				strModule.append(aqUserModule.getModuleId()).append("-");
			}
		}
		
		BeanUtils.copyProperties(user, dto);
		setOrgInfo(user.getOrgId(),dto);
		dto.setLoginStatus(Dict.LOGIN_STATUS.SUCCESS);
		
		return dto;
	}
	private void setOrgInfo(String orgId,AqUserDTO dto) throws Exception {
		AqOrg org1 = orgService.loadOrgById(orgId);
		dto.setOrgId(org1.getOrgId());
		dto.setOrgCode(org1.getCode());
		dto.setOrgName(org1.getName());
		AqOrg org2 = null;
		if(!"1".equals(orgId)){
			org2 = orgService.loadParentOrgById(orgId);
			dto.setOrgPId(org2.getOrgId());
			dto.setOrgPCode(org2.getCode());
			dto.setOrgPName(org2.getName());
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<AqUserModuleDTO> getUserModule(String userId)throws Exception{
		List<AqUserModuleDTO> returnList = null;
		List aqModuleList = moduleService.getAqModuleList();
		AqUserModule o = new AqUserModule();
		o.setUserId(userId);
		List<AqUserModule> userModuleList = moduleService.getAqUserModuleList(o);
		
		if(null != aqModuleList && aqModuleList.size() > 0){
			returnList = new ArrayList<AqUserModuleDTO>();
			for(int i = 0; i < aqModuleList.size(); i++){
				AqModule m = (AqModule)aqModuleList.get(i);
				AqUserModuleDTO aqUserModuleDTO = new AqUserModuleDTO();
				aqUserModuleDTO.setModuleId(m.getModuleId());
				aqUserModuleDTO.setModuleName(m.getName());
				aqUserModuleDTO.setStatus("0");
				if(null != userModuleList && userModuleList.size() > 0){
					for(int j = 0; j< userModuleList.size(); j++){
						AqUserModule um = userModuleList.get(j);
						if(um.getModuleId().equals(m.getModuleId())){
							aqUserModuleDTO.setStatus("1");	
							break;
						}
					}
				}
				returnList.add(aqUserModuleDTO);
			}
		}
		
		return returnList;
	}

	
	@SuppressWarnings("unchecked")
	public boolean addUserModule(String userId,String[] moduleIds)throws Exception{
		Map<String,Object> mapps = new HashMap<String,Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select t from AqUserModule t where t.userId = ?");
		mapps.put("0",userId);
		List oldList = hp.getList(sql.toString(), mapps);
		if(null != oldList && oldList.size() > 0){
			for(int i = 0;i < oldList.size(); i++){
				AqUserModule old = (AqUserModule)oldList.get(i);
				hp.delete(old);
			}
		}
		if(null != moduleIds && moduleIds.length > 0 ){
			for(int j = 0; j < moduleIds.length; j++){
				AqUserModule m = new AqUserModule();
				m.setModuleId(moduleIds[j]);
				m.setUserId(userId);
				hp.save(m);
			}
		}
		return true;
	}
}
