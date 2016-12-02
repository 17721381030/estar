package com.estar.judgment.evaluation.web.security.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.security.dto.AqModuleDTO;
import com.estar.judgment.evaluation.web.security.dto.AqOperateDTO;
import com.estar.judgment.evaluation.web.security.entity.AqModule;
import com.estar.judgment.evaluation.web.security.entity.AqOperate;
import com.estar.judgment.evaluation.web.security.entity.AqUserModule;


@Service
public class ModuleService extends BaseService{
	@Autowired
	private DBHibernateTemplate hp;
	
	
	public String addAqOperate(AqOperate o)throws Exception{
		if(o != null){
			return (String)hp.save(o);
		}
		return null;
	}
	
	public void updateAqOperate(AqOperate o)throws Exception{
		if(o != null){
			hp.update(o);
		}
	}
	
	public void delAqOperate(String[] ids)throws Exception{
		if(ids != null && ids.length > 0){
			for(int i = 0; i < ids.length; i++){
				AqOperate o = hp.get(AqOperate.class, ids[i]);
				hp.delete(o);
			}
		}
	}
	
	public AqOperate getAqOperate(String id)throws Exception{
		if(id != null){
			return (AqOperate)hp.get(AqOperate.class, id);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<AqOperate> getAqOperateList(AqOperate o)throws Exception{
		if(o != null){
			StringBuffer sql = new StringBuffer();
			sql.append("select t from AqOperate t where t.delFlag = '0' ");
			Map<String,Object> mapps = new HashMap<String,Object>();
			if(!StringUtils.nullOrBlank(o.getModuleId())){
				sql.append(" and t.moduleId = ? ");
				mapps.put("0", o.getModuleId());
			}
			if(!StringUtils.nullOrBlank(o.getName())){
				sql.append(" and t.name like ? ");
				mapps.put("1", "%"+o.getName()+"%");
			}
			return hp.getList(sql.toString(), mapps);
		}
		return null;
	}
	
	
	public String addAqModule(AqModule o)throws Exception{
		if(o != null){
			return (String)hp.save(o);
		}
		return null;
	}
	
	public void updateAqModule(AqModule o)throws Exception{
		if(o != null){
			hp.update(o);
		}
	}
	
	public AqModule getObjectAqModule(String id)throws Exception{
		if(id != null){
			return (AqModule)hp.get(AqModule.class, id);
		}
		return null;
	}
	
	public void delAqModule(String[] ids)throws Exception{
		if(ids != null && ids.length > 0){
			for(int i = 0; i < ids.length; i++){
				AqModule o = hp.get(AqModule.class, ids[i]);
				hp.delete(o);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Object> getAqModuleList(AqModuleDTO o,int pageNo,int pageSize)throws Exception{
		StringBuffer sql = new StringBuffer();
		List<Object> para = new ArrayList<Object>();
		sql.append("select t from AqModule t where t.delFlag = '0' ");
		if(!StringUtils.nullOrBlank(o.getName())){
			sql.append(" and t.name like ? ");
			para.add("%"+o.getName()+"%");
		}
		return hp.getList(sql.toString(),list2Map(para),pageNo,pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public List getAqModuleList()throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select t from AqModule t where t.delFlag = '0' ");
		return hp.getList(sql.toString());
	}
	
	public String addAqUserModule(AqUserModule o)throws Exception{
		if(o != null){
			return (String)hp.save(o);
		}
		return null;
	}
	
	public void delAqUserModule(String[] ids)throws Exception{
		if(ids != null && ids.length > 0){
			for(int i = 0; i < ids.length; i++){
				AqUserModule o = hp.get(AqUserModule.class, ids[i]);
				hp.delete(o);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AqUserModule> getAqUserModuleList(AqUserModule o)throws Exception{
		if(o != null){
			StringBuffer sql = new StringBuffer();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("0", o.getUserId());
			sql.append("select t from AqUserModule t where t.userId = ? ");
			return hp.getList(sql.toString(),map);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private List<AqOperateDTO> getAqModuleOperateByModuleId(String moduleId)throws Exception{
		StringBuffer sql = new StringBuffer();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("0", moduleId);
		sql.append("select new com.estar.judgment.evaluation.web.security.dto.AqOperateDTO(t) from AqOperate t ");
		sql.append(" where t.moduleId = ? order by t.ord asc ");
		List list = hp.getList(sql.toString(),map);
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	private List<AqModuleDTO> getAqModuleMenuByUserId(String userId)throws Exception{
		StringBuffer sql = new StringBuffer();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("0", userId);
		sql.append("select new com.estar.judgment.evaluation.web.security.dto.AqModuleDTO(t1) from AqUserModule t, AqModule t1 ");
		sql.append(" where t.userId = ? and t.moduleId = t1.moduleId order by t1.ord asc ");
		List list = hp.getList(sql.toString(),map);
		return list;
	}
	

	public List<AqModuleDTO> getAqModuleByUserId(String userId)throws Exception{
		List<AqModuleDTO> menuList = getAqModuleMenuByUserId(userId);
		if(null != menuList && menuList.size() > 0){
			for(int i = 0; i < menuList.size(); i++){
				AqModuleDTO moduleDto = menuList.get(i);
				moduleDto.setOperateList(getAqModuleOperateByModuleId(moduleDto.getModuleId()));
			}
		}
		return menuList;
	}
}
