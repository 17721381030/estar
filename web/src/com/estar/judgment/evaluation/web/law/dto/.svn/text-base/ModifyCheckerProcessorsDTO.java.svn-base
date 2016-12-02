package com.estar.judgment.evaluation.web.law.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.estar.common.util.CollectionUtil;
import com.estar.judgment.content.JudgmentContent;
import com.estar.judgment.evaluation.judgmentprocessor.CheckerExceptionInfo;
import com.estar.judgment.evaluation.judgmentprocessor.JudgmentProcessorInfo;
import com.estar.judgment.util.message.MessageType;

public class ModifyCheckerProcessorsDTO {

	private static final long serialVersionUID = 1L;
	
	private static List<JudgmentProcessorInfo> commonProcessors = null;
	private static Map<JudgmentContent, List<JudgmentProcessorInfo>> primaryProcessors = null;
	private static Map<JudgmentContent, List<JudgmentProcessorInfo>> relativeProcessors = null;
	private static String COMMON_JUDGMENT_PROCESSOR_NAME = "其他";
	private String allIsvalidCount;
	private String allIsNotValidCount;
	private List<JudgmentProcessorsDTO> proList;
	private String proInfo;
	
	
	public void setInfo(JudgmentProcessorInfo[] infos) {
		Boolean stepFlag = getProcessorInfoOfTopContents(infos);
		List<JudgmentProcessorsDTO> proList = new ArrayList<JudgmentProcessorsDTO>();
		if(stepFlag){
			//法院名称
			JudgmentProcessorsDTO courtDto = getJudgmentProcessorsDTO(JudgmentContent.COURT);
			proList.add(courtDto);
			//文书名称
			JudgmentProcessorsDTO typeDto = getJudgmentProcessorsDTO(JudgmentContent.TYPE);
			proList.add(typeDto);
			//案号
			JudgmentProcessorsDTO caseNumberDto = getJudgmentProcessorsDTO(JudgmentContent.CASE_NUMBER);
			proList.add(caseNumberDto);
			//当事人
			JudgmentProcessorsDTO partyDto = getJudgmentProcessorsDTO(JudgmentContent.PARTY);
			proList.add(partyDto);
			//案由与审理经过
			JudgmentProcessorsDTO causeContentDto = getJudgmentProcessorsDTO(JudgmentContent.CAUSE_CONTENT);
			proList.add(causeContentDto);
			//诉请
			JudgmentProcessorsDTO appealDto = getJudgmentProcessorsDTO(JudgmentContent.APPEAL);
			proList.add(appealDto);
			//法律条文
			JudgmentProcessorsDTO lawArticleDto = getJudgmentProcessorsDTO(JudgmentContent.LAW_ARTICLE);
			proList.add(lawArticleDto);
			//判决
			JudgmentProcessorsDTO judgmentDto = getJudgmentProcessorsDTO(JudgmentContent.JUDGMENT_CONTENT);
			proList.add(judgmentDto);
			//诉讼权利义务告知
			JudgmentProcessorsDTO rightsObligationsDto = getJudgmentProcessorsDTO(JudgmentContent.RIGHTS_OBLIGATIONS);
			proList.add(rightsObligationsDto);
			//审判组织和落款日期
			JudgmentProcessorsDTO trialGroupDateDto = getJudgmentProcessorsDTO(JudgmentContent.TRIAL_GROUP_DATE);
			proList.add(trialGroupDateDto);
			//其他
			if(commonProcessors != null){
				JudgmentProcessorsDTO commonJudgmentProcessorsDTO = getCommonJudgmentProcessorsDTO(commonProcessors);
				proList.add(commonJudgmentProcessorsDTO);
			}
			this.proList = proList;
			this.allIsvalidCount = String.valueOf(getValidArray(proList)[0]);
			this.allIsNotValidCount = String.valueOf(getValidArray(proList)[1]);
			
		}
	}
	private static JudgmentProcessorsDTO getCommonJudgmentProcessorsDTO(List<JudgmentProcessorInfo> commonProcessors){
		String validCount = null;
		String notValidCount = null;
		if(commonProcessors != null){
			int numberOfCommonProcessors = CollectionUtil.getLength(commonProcessors);
			int[] commonCountArray = null;
			if(numberOfCommonProcessors > 0){
				commonCountArray = getIntArray(commonProcessors);
			}
			if(null == commonCountArray ){validCount = String.valueOf(0);notValidCount = String.valueOf(0);};
			if(null != commonCountArray ){validCount = String.valueOf(commonCountArray[0]+commonCountArray[1]);notValidCount = String.valueOf(commonCountArray[2]);};
		}
		return new JudgmentProcessorsDTO(COMMON_JUDGMENT_PROCESSOR_NAME,validCount,notValidCount,commonProcessors);
	}
	private static JudgmentProcessorsDTO getJudgmentProcessorsDTO(JudgmentContent content){
		List<JudgmentProcessorInfo> primaryList = primaryProcessors.get(content);
		List<JudgmentProcessorInfo> relativeList = relativeProcessors.get(content);
		List<JudgmentProcessorInfo> allList = new ArrayList<JudgmentProcessorInfo>();
		int numberOfPrimaryProcessors = CollectionUtil.getLength(primaryList);
		int numberOfRelativeProcessors = CollectionUtil.getLength(relativeList);
		int[] priMaryCountArray = null;
		int[] relativeCountArray = null;
		String validCount = null;
		String notValidCount = null;
		if(numberOfPrimaryProcessors + numberOfRelativeProcessors > 0 ){
			if(numberOfPrimaryProcessors > 0){
				priMaryCountArray = getIntArray(primaryList);
				allList.addAll(primaryList);
			}
			if(numberOfRelativeProcessors > 0){
				relativeCountArray = getIntArray(relativeList);
				allList.addAll(relativeList);
			}
		}
		if(null == priMaryCountArray && null == relativeCountArray ){validCount = String.valueOf(0);notValidCount = String.valueOf(0);};
		if(null != priMaryCountArray && null == relativeCountArray ){validCount = String.valueOf(priMaryCountArray[0]+priMaryCountArray[1]);notValidCount = String.valueOf(priMaryCountArray[2]);};
		if(null == priMaryCountArray && null != relativeCountArray ){validCount = String.valueOf(relativeCountArray[0]+relativeCountArray[1]);notValidCount = String.valueOf(relativeCountArray[2]);};
		if(null != priMaryCountArray && null != relativeCountArray ){validCount = String.valueOf(priMaryCountArray[0]+priMaryCountArray[1]+relativeCountArray[0]+relativeCountArray[1]);notValidCount = String.valueOf(priMaryCountArray[2]+relativeCountArray[2]);};		
		return new JudgmentProcessorsDTO(content.getName(),validCount,notValidCount,allList);
	}

	private static int[] getIntArray(List<JudgmentProcessorInfo> processorInfoList){
		int[] countArray = new int[]{0,0,0};
		for(int i=0; i<processorInfoList.size(); i++){
			if(null != processorInfoList.get(i).getExceptionInfos() && processorInfoList.get(i).getExceptionInfos().length > 0){
				for(int n = 0;n < processorInfoList.get(i).getExceptionInfos().length; n++){
					CheckerExceptionInfo exceptionInfo = processorInfoList.get(i).getExceptionInfos()[n];
					if(exceptionInfo.isEnabled()){
						if(MessageType.ERROR == exceptionInfo.getUserDefinedMessageType()){
							countArray[0]++;
						}else if(MessageType.WARNING == exceptionInfo.getUserDefinedMessageType()){
							countArray[1]++;
						}else if(MessageType.INFORMATION == exceptionInfo.getUserDefinedMessageType()){
							countArray[2]++;
						}
					}
				}
			}
		}
		return countArray;
	}
	
	private static Boolean getProcessorInfoOfTopContents(JudgmentProcessorInfo[] processors) {
		Boolean stepFlag = true;
		if (commonProcessors == null) {
			commonProcessors = new ArrayList<JudgmentProcessorInfo>();
			primaryProcessors = new HashMap<JudgmentContent, List<JudgmentProcessorInfo>>();
			relativeProcessors = new HashMap<JudgmentContent, List<JudgmentProcessorInfo>>();
			for (JudgmentProcessorInfo processor : processors) {
				if(processor.isChecker()){
					if (processor.hasContent()) {
						addProcessorInfoToTopContents(primaryProcessors, processor.getPrimaryContent(), processor);
						if (processor.hasRelativeContent()) {
							for (JudgmentContent content : processor.getRelativeContents()) {
								addProcessorInfoToTopContents(relativeProcessors, content, processor);
							}
						}
					} else {
						commonProcessors.add(processor);
					}
				}
			}
		}
		return stepFlag;
	}
	
	private static void addProcessorInfoToTopContents(Map<JudgmentContent, List<JudgmentProcessorInfo>> contents, JudgmentContent content, JudgmentProcessorInfo processor) {
		if (content != null) {
			content = content.getTop();
		}
		if (contents.containsKey(content)) {
			contents.get(content).add(processor);
		} else {
			List<JudgmentProcessorInfo> processors = new ArrayList<JudgmentProcessorInfo>();
			processors.add(processor);
			contents.put(content, processors);
		}
	}
	
	private static int[] getValidArray(List<JudgmentProcessorsDTO> proList){
		int[] countArray = new int[]{0,0};
		for(int i =0 ;i <proList.size();i++){
			JudgmentProcessorsDTO processor = proList.get(i);
			if(null != processor.getIsValidCount()){
				countArray[0] = countArray[0]+Integer.valueOf(processor.getIsValidCount());
			}
			if(null != processor.getIsNotValidCount()){
				countArray[1] = countArray[1]+Integer.valueOf(processor.getIsNotValidCount());
			}
		}
		return countArray;
	}
	
	public String getAllIsvalidCount() {
		return allIsvalidCount;
	}
	
	public void setAllIsvalidCount(String allIsvalidCount) {
		this.allIsvalidCount = allIsvalidCount;
	}
	
	public String getAllIsNotValidCount() {
		return allIsNotValidCount;
	}
	
	public void setAllIsNotValidCount(String allIsNotValidCount) {
		this.allIsNotValidCount = allIsNotValidCount;
	}
	
	public List<JudgmentProcessorsDTO> getProList() {
		return proList;
	}
	
	public void setProList(List<JudgmentProcessorsDTO> proList) {
		this.proList = proList;
	}
	public String getProInfo() {
		return proInfo;
	}
	public void setProInfo(String proInfo) {
		this.proInfo = proInfo;
	}
	
	

}