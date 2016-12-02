package com.estar.judgment.evaluation.web.law.service;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.law.dto.LawDTO;
import com.estar.judgment.evaluation.web.law.entity.Law;
import com.estar.judgment.evaluation.web.law.entity.LawItem;


@Service
public class LawService extends BaseService{
	@Autowired
	private DBHibernateTemplate hp;
	
	
	@SuppressWarnings("unchecked")
	public void saveLaw(LawDTO dto)throws Exception{
		Law law = new Law();
		BeanUtils.copyProperties(law, dto);
		String id = (String)hp.save(law);
		
		if(null != dto.getLawItemList() && dto.getLawItemList().size() > 0){
			for(int i = 0;i < dto.getLawItemList().size(); i++){
				LawItem item = new LawItem();
				BeanUtils.copyProperties(item, dto.getLawItemList().get(i));
				item.setLawId(id);
				hp.save(item);
			}
		}
	}
	
	
	

}
