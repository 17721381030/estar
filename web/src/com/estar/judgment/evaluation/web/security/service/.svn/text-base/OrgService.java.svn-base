package com.estar.judgment.evaluation.web.security.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.frame.dbutils.DBJdbcTemplate;
import com.estar.judgment.evaluation.web.security.dto.AqOrgTreeDTO;
import com.estar.judgment.evaluation.web.security.entity.AqOrg;


@Service
public class OrgService extends BaseService{
	@Autowired
	private DBHibernateTemplate hp;
	@Autowired
	private DBJdbcTemplate jp;
	public String addAqOrg(AqOrg o,String forgId)throws Exception{
		String orgId = "";
		if(o != null){
			AqOrg aqOrg = loadOrgById(forgId);
			orgId = createOrgId(forgId);
			o.setOrgId(orgId);
			o.setOrgType(aqOrg.getOrgType());
			o.setDelFlag("0");
			hp.save(o);
		}
		return orgId;
	}
	
	public void updateAqOrg(AqOrg o)throws Exception{
		if(o != null){
			hp.update(o);
		}
	}
	
	public void delAqOrg(String id)throws Exception{
		AqOrg aqOrg = loadOrgById(id);
		if(null != aqOrg){
			aqOrg.setDelFlag("1");
			hp.save(aqOrg);
		}
	}
	
	@SuppressWarnings("unchecked")
	public String createOrgId(String forgId) throws Exception {
		String returnCode = "";
		StringBuffer sql = new StringBuffer();
		Map<String,String> mapps = new HashMap<String,String>();
		int i = 0;
		sql.append("select max(t.orgId) from AqOrg t where t.orgId like ? and length(t.orgId) = ")
		.append(forgId.length()+3).append(" order by t.orgId desc ");
		
		mapps.put(""+(i++),forgId+"%");
		List<String> list = hp.getList(sql.toString(), mapps);
		Object obj = list.get(0);
		if(null == obj){
			returnCode = forgId + "001";
		}else{
			String strOrg = (String)obj;
			strOrg = strOrg.substring(strOrg.length()-3, strOrg.length());
			strOrg = (Integer.valueOf(strOrg)+1+1000)+"";
			strOrg = strOrg.substring(1,4);
			returnCode = forgId +""+ strOrg;
		}
		return returnCode;
	}
	
	public AqOrg loadOrgById(String orgId) throws Exception {
		AqOrg o = hp.get(AqOrg.class, orgId);
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public AqOrg loadOrgByCode(String orgCode) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String,String> mapps = new HashMap<String,String>();
		int i = 0;
		sql.append("select t from AqOrg t where t.delFlag = '0' and t.code = ?  ");
		mapps.put(""+(i++),orgCode);
		List<AqOrg> list = hp.getList(sql.toString(), mapps);
		if(null != list && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<AqOrg> loadOrgsById(String orgId) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String,String> mapps = new HashMap<String,String>();
		int i = 0;
		sql.append("select new com.estar.judgment.evaluation.web.security.dto.AqOrgTreeDTO(t) from AqOrg t where t.delFlag = '0' and t.orgId like ?  order by t.orgId");
		mapps.put(""+(i++),orgId+"%");
		List<AqOrg> list = hp.getList(sql.toString(), mapps);
		return list;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<AqOrgTreeDTO> loadOrgTree(String orgId) throws Exception {
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select new com.estar.judgment.evaluation.web.security.dto.AqOrgTreeDTO(t.orgId,t.name) from AqOrg t where t.orgId like ? and t.delFlag = '0' ");
		para.add(orgId+"%");
		List<AqOrgTreeDTO> list = hp.getList(sql.toString(),list2Map(para));
		return list;
	}
	
	public List<AqOrg> loadOrgsByFCode(String orgCode) throws Exception {
		AqOrg pAqOrg= loadOrgByCode(orgCode);
		return loadOrgsById(pAqOrg.getOrgId());
	}
	
	@SuppressWarnings("unchecked")
	public AqOrg loadParentOrgById(String orgId) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String,String> mapps = new HashMap<String,String>();
		int i = 0;
		sql.append("select t from AqOrg t where t.delFlag = '0' and t.orgId = ?  ");
		mapps.put(""+(i++),orgId.substring(0,orgId.length()-3));
		List<AqOrg> list = hp.getList(sql.toString(), mapps);
		if(null != list && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	public AqOrg loadParentOrgByCode(String orgCode) throws Exception {
		AqOrg pAqOrg= loadOrgByCode(orgCode);
		return loadParentOrgById(pAqOrg.getOrgId());
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean getIsHaveSameCodeOrName(AqOrg obj) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) as countNum from aq_org where del_flag='0' and  (code=? or name = ?) ");
		List listArgs = new ArrayList();
		listArgs.add(obj.getCode().trim());
		listArgs.add(obj.getName().trim());
		// 更新
		if (obj.getOrgId() != null && !obj.getOrgId().trim().equals("")) {
			sql.append(" and  org_id!=?");
			listArgs.add(obj.getOrgId().trim());
		}
		Map map = jp.queryForMap(sql.toString(), listArgs.toArray());
		if (Integer.parseInt(map.get("countNum").toString()) == 0)
			return false;
		return true;
	}
	
}
