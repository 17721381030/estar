package com.estar.judgment.evaluation.web.law.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.frame.dbutils.DBJdbcTemplate;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.frame.util.TimestampTool;
import com.estar.judgment.evaluation.web.law.dto.CaseAppealLawDTO;
import com.estar.judgment.evaluation.web.law.dto.CaseDTO;
import com.estar.judgment.evaluation.web.law.dto.CaseLawElementDTO;
import com.estar.judgment.evaluation.web.law.dto.CaseRelateLawDTO;
import com.estar.judgment.evaluation.web.law.dto.M2JudgmentInfoDTO;
import com.estar.judgment.evaluation.web.law.entity.CaseAppealLaw;
import com.estar.judgment.evaluation.web.law.entity.CaseLawElement;
import com.estar.judgment.evaluation.web.law.entity.CaseRelateLaw;
import com.estar.judgment.evaluation.web.security.dto.AqUserDTO;


@Service
public class CaseAppealLawService extends BaseService{
	@Autowired
	private DBHibernateTemplate hp;
	
	@Autowired
	private DBJdbcTemplate jp;
	
	@SuppressWarnings("unchecked")
	public List<CaseAppealLawDTO> getCaseAppealLawListByAppealKeyId(String lawArticle,String appealKeyId)throws Exception{
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.CaseAppealLawDTO(t) from CaseAppealLaw t " +
				"where t.delFlag = '0' and t.appealKeyId = ? ");
		para.add(appealKeyId);
		
		if(!StringUtils.nullOrBlank(lawArticle)){
			sql.append(" and t.relateLaw like ? ");
			para.add("%"+lawArticle+"%");
		}
		//sql.append(" order by t.relateValue desc  ");
		//sql.append(" order by t.quoteCount desc  ");
		return hp.getList(sql.toString(),list2Map(para));
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CaseLawElementDTO> getCaseLawElementListByappealLawId(String appealLawId)throws Exception{
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.CaseLawElementDTO(t) from CaseLawElement t " +
				"where t.delFlag = '0' and t.appealLawId = ? ");
		para.add(appealLawId);
		return hp.getList(sql.toString(),list2Map(para));
	}
	
	@SuppressWarnings("unchecked")
	public List<CaseRelateLawDTO> getCaseRelateLawDTOListByappealLawId(String appealLawId)throws Exception{
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.CaseRelateLawDTO(t) from CaseRelateLaw t " +
				"where t.delFlag = '0' and t.appealLawId = ? ");
		para.add(appealLawId);
		return hp.getList(sql.toString(),list2Map(para));
	}
	
	public void saveCaseAppealLaw(CaseDTO o)throws Exception{
		if(o != null && o.getAppealLawList().size() > 0){
			for(CaseAppealLawDTO obj : o.getAppealLawList()){
				CaseAppealLaw law = getCaseAppealLaw(obj.getId());
				law.setAffirmRelate(obj.getAffirmRelate());
				law.setLawRelateDegree(obj.getLawRelateDegree());
				law.setRemark(obj.getRemark());
				law.setIssue(obj.getIssue());
				law.setUpdateBy(o.getOperatePerson());
				law.setUpdateDate(o.getOperateDate());
				hp.update(law);
			}
		}
	}
	
	public CaseAppealLaw getCaseAppealLaw(String id)throws Exception{
		CaseAppealLaw obj = null;
		if(id != null){
			obj = hp.get(CaseAppealLaw.class, id);
		}
		return obj;
	}
	
	public CaseLawElement getCaseLawElement(String id)throws Exception{
		CaseLawElement obj = null;
		if(id != null){
			obj = hp.get(CaseLawElement.class, id);
		}
		return obj;
	}
	
	public CaseRelateLaw getCaseRelateLaw(String id)throws Exception{
		CaseRelateLaw obj = null;
		if(id != null){
			obj = hp.get(CaseRelateLaw.class, id);
		}
		return obj;
	}
	
	public void saveCaseElement(CaseDTO o,AqUserDTO user)throws Exception{
		if(StringUtils.nullOrBlank(o.getId())){
			CaseLawElement element = new CaseLawElement();
			element.setAppealLawId(o.getAppealLawId());
			element.setLawElement(o.getContent());
			element.setCreateBy(user.getUserName());
			element.setCreateDate(TimestampTool.crunttime());
			element.setDelFlag("0");
			element.setUpdateBy(user.getUserName());
			element.setUpdateDate(TimestampTool.crunttime());
			o.setId((String)hp.save(element));
		}else{
			CaseLawElement element = getCaseLawElement(o.getId());
			element.setLawElement(o.getContent());
			element.setDelFlag("0");
			element.setUpdateBy(user.getUserName());
			element.setUpdateDate(TimestampTool.crunttime());
			hp.save(element);
		}
	}
	
	public void saveRelateLaw(CaseDTO o,AqUserDTO user)throws Exception{
		if(StringUtils.nullOrBlank(o.getId())){
			CaseRelateLaw relateLaw = new CaseRelateLaw();
			relateLaw.setAppealLawId(o.getAppealLawId());
			relateLaw.setRelateLaw(o.getContent());
			relateLaw.setCreateBy(user.getUserName());
			relateLaw.setCreateDate(TimestampTool.crunttime());
			relateLaw.setDelFlag("0");
			relateLaw.setUpdateBy(user.getUserName());
			relateLaw.setUpdateDate(TimestampTool.crunttime());
			o.setId((String)hp.save(relateLaw));
		}else{
			CaseRelateLaw relateLaw = getCaseRelateLaw(o.getId());
			relateLaw.setRelateLaw(o.getContent());
			relateLaw.setDelFlag("0");
			relateLaw.setUpdateBy(user.getUserName());
			relateLaw.setUpdateDate(TimestampTool.crunttime());
			hp.save(relateLaw);
		}
	}
	
	public void deleteCaseElement(CaseDTO o,AqUserDTO user)throws Exception{
		CaseLawElement element = getCaseLawElement(o.getId());
		element.setDelFlag("1");
		element.setUpdateBy(user.getUserName());
		element.setUpdateDate(TimestampTool.crunttime());
		hp.save(element);
	}
	
	public void deleteRelateLaw(CaseDTO o,AqUserDTO user)throws Exception{
		CaseRelateLaw relateLaw = getCaseRelateLaw(o.getId());
		relateLaw.setDelFlag("1");
		relateLaw.setUpdateBy(user.getUserName());
		relateLaw.setUpdateDate(TimestampTool.crunttime());
		hp.save(relateLaw);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Map getCaseByAppealKeyAndLawArticle(CaseDTO dto,String causeId,int pageNo,int pageSize)throws Exception{
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append(" select distinct t3.id, t3.court,t3.case_number,t3.case_number_year from judgment_appeal t1,judgment_law_article t2,judgment_info t3  where t1.id = t2.id and t2.id = t3.id  ");
		sql.append(" and t1.appeal_type = ? and t2.law_article = ? ");
		sql.append(" and t3.cause_id = ? ");
		para.add(dto.getAppealKey());
		para.add(dto.getLawArticle());
		para.add(causeId);
		
		if(!StringUtils.nullOrBlank(dto.getCourt())){
			para.add("%"+dto.getCourt()+"%");
			sql.append(" and t3.court like ?");
		}
		
		if(!StringUtils.nullOrBlank(dto.getCaseNumber())){
			para.add("%"+dto.getCaseNumber()+"%");
			sql.append(" and t3.case_number like ? ");
		}
		
		Map map = jp.getList(sql.toString(),para.toArray(),pageNo,pageSize,new MapperDTO());
		return map;
	}
	
	public class MapperDTO implements RowMapper<Object>{

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			M2JudgmentInfoDTO dto = new M2JudgmentInfoDTO();
			dto.setId(rs.getString("id"));
			dto.setCaseNumber(rs.getString("case_number"));
			dto.setCourt(rs.getString("court"));
			dto.setCaseNumberYear(rs.getInt("case_number_year"));
			return dto;
		}
		
	}
	
	public String getCauseId(String cause){
		String causeId = "";
		if("离婚纠纷".equals(cause)){
			causeId = "divoc";
		}else if("民间借贷纠纷".equals(cause)){
			causeId = "ptelend";
		}else if("机动车交通事故责任纠纷".equals(cause)){
			causeId = "mototal";
		}else if("买卖合同纠纷".equals(cause)){
			causeId = "bizcont";
		}else if("物业服务合同纠纷".equals(cause)){
			causeId = "propservcont";
		}else if("劳动合同纠纷".equals(cause)){
			causeId = "labocont";
		}else if("金融借款合同纠纷".equals(cause)){
			causeId = "finloancont";
		}else if("信用卡纠纷".equals(cause)){
			causeId = "crcard";
		}else if("房屋租赁合同纠纷".equals(cause)){
			causeId = "hosliscont";
		}else if("房屋买卖合同纠纷".equals(cause)){
			causeId = "homebizcont";
		}else if("电信服务合同纠纷".equals(cause)){
			causeId = "teleservcont";
		}
		return causeId;
	}
}
