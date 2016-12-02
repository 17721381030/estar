package com.estar.judgment.evaluation.web.law.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.law.dto.DefineJudgmentProcessorExceptionDTO;
import com.estar.judgment.evaluation.web.law.entity.DefineJudgmentProcessorException;


@Service
public class ModifyCheckerProcessorsService extends BaseService{
	@Autowired
	private  DBHibernateTemplate hp;
	
	
	@SuppressWarnings("unchecked")
	public List<DefineJudgmentProcessorException> getObjectList(String prossorId, String exceptionId)throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select t from DefineJudgmentProcessorException t where t.judgment_processor = '"+prossorId+"' and t.exception = '"+exceptionId+"' ");
		return hp.find(sql.toString());
	}
	
	@SuppressWarnings("unchecked")
	public void deletedpExceptionList()throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select t from DefineJudgmentProcessorException t");
		List<DefineJudgmentProcessorException>  oldlist = this.hp.getList(sql.toString());
		if(null != oldlist && oldlist.size() != 0){
			hp.deleteAll(oldlist);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void savedpExceptionDTOList(List<DefineJudgmentProcessorExceptionDTO> list)throws Exception{
		if(null != list &&list.size()> 0){
			for(int i = 0 ;i<list.size();i++){
				DefineJudgmentProcessorException dpe =new DefineJudgmentProcessorException(list.get(i));
				hp.save(dpe);
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void savedpException(DefineJudgmentProcessorExceptionDTO dto)throws Exception{
		DefineJudgmentProcessorException dpe =new DefineJudgmentProcessorException(dto);
		hp.save(dpe);
	}
	
	@SuppressWarnings("unchecked")
	public void updatedpException(DefineJudgmentProcessorException dto)throws Exception{
		hp.update(dto);
	}
	
	public String[] getStrArray(String info){
		String[] strArray = info.split(",");
		return strArray;
	}
	

	
}
