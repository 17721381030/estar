package com.estar.judgment.evaluation.web.law.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.law.dto.CaseAppealKeyDTO;


@Service
public class CaseAppealKeyService extends BaseService{
	@Autowired
	private DBHibernateTemplate hp;
	
	@SuppressWarnings("unchecked")
	public List<CaseAppealKeyDTO> getCaseAppealKeyDTOListByCauseId(String causeId)throws Exception{
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select new com.estar.judgment.evaluation.web.law.dto.CaseAppealKeyDTO(t) from CaseAppealKey t " +
				"where t.delFlag = '0' and t.causeId = ? order by t.appearCount desc ");
		para.add(causeId);
		return hp.getList(sql.toString(),list2Map(para));
	}
}
