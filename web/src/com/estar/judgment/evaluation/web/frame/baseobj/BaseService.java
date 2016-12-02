package com.estar.judgment.evaluation.web.frame.baseobj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseService {
	@SuppressWarnings("unchecked")
	public Map list2Map(List<Object> list){
		Map map = new HashMap();
		if(null != list && list.size() > 0){
			for(int i = 0;i < list.size(); i++){
				map.put(""+i, list.get(i));
			}
		}
		return map;
	}
}
