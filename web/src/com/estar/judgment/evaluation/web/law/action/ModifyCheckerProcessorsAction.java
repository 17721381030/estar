package com.estar.judgment.evaluation.web.law.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.estar.judgment.evaluation.judgmentprocessor.JudgmentProcessorInfo;
import com.estar.judgment.evaluation.judgmentprocessor.JudgmentProcessorManager;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.law.dto.DefineJudgmentProcessorExceptionDTO;
import com.estar.judgment.evaluation.web.law.dto.ModifyCheckerProcessorsDTO;
import com.estar.judgment.evaluation.web.law.entity.DefineJudgmentProcessorException;
import com.estar.judgment.evaluation.web.law.service.ModifyCheckerProcessorsService;
import com.estar.judgment.util.message.MessageType;

@Scope("prototype")  
public class ModifyCheckerProcessorsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ModifyCheckerProcessorsService modifyCheckerProcessorsService;
	
	private ModifyCheckerProcessorsDTO d = new ModifyCheckerProcessorsDTO();


	public ModifyCheckerProcessorsDTO getD() {
		return d;
	}

	public void setD(ModifyCheckerProcessorsDTO d) {
		this.d = d;
	}

	public String initPage() throws Exception {
		return "list";
	}
	
	public String userMenu()throws Exception {
		JudgmentProcessorInfo[] infos = JudgmentProcessorManager.getJudgmentCheckerInfos();
		d.setInfo(infos);
		return "json";
	}
	
	
	public String setPro()throws Exception {
		String[] strArray = modifyCheckerProcessorsService.getStrArray(d.getProInfo());
		if(null != strArray && strArray.length != 0){
			List<DefineJudgmentProcessorException> djpList =  modifyCheckerProcessorsService.getObjectList(strArray[0], strArray[1]);
			if(null != djpList && 0 !=  djpList.size() ){
				DefineJudgmentProcessorException djpeDto = djpList.get(0);
				if(!djpeDto.getType().equalsIgnoreCase(strArray[2])){
					if(MessageType.ERROR.name().equalsIgnoreCase(strArray[2])){
						djpeDto.setType(MessageType.ERROR.getId());
					}else if(MessageType.WARNING.name().equalsIgnoreCase(strArray[2])){
						djpeDto.setType(MessageType.WARNING.getId());
					}else if(MessageType.INFORMATION.name().equalsIgnoreCase(strArray[2])){
						djpeDto.setType(MessageType.INFORMATION.getId());
					}
					modifyCheckerProcessorsService.updatedpException(djpeDto);
				}
			}else{
				DefineJudgmentProcessorExceptionDTO dto = new DefineJudgmentProcessorExceptionDTO();
				dto.setJudgment_processor(strArray[0]);
				dto.setException(strArray[1]);
				if(MessageType.ERROR.name().equalsIgnoreCase(strArray[2]) ){
					dto.setType(MessageType.ERROR.getId());
				}else if(MessageType.WARNING.name().equalsIgnoreCase(strArray[2])){
					dto.setType(MessageType.WARNING.getId());
				}else if(MessageType.INFORMATION.name().equalsIgnoreCase(strArray[2])){
					dto.setType(MessageType.INFORMATION.getId());
				}
				modifyCheckerProcessorsService.savedpException(dto);
			}
			JudgmentProcessorManager.setUserDefinedExceptionType(strArray[0], strArray[1], strArray[2]);
		}
		return "json";
	}
	

}
