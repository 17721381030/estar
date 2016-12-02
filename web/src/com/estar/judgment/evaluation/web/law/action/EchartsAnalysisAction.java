package com.estar.judgment.evaluation.web.law.action;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.estar.common.util.StringUtil;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.law.dto.EchartsDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorCasueRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorContentAndNumBycourtAndJudgeDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorContentAndNumDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorCourtRoomRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorCourtYearRateDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorJudgeNameRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorNumAndRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorRankRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorYearRateDetailDto;
import com.estar.judgment.evaluation.web.law.service.EchartsAnalysisService;

@Scope("prototype")  
public class EchartsAnalysisAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private EchartsDto d = new EchartsDto();
	
	@Autowired
	private EchartsAnalysisService echartsAnalysisService;

	public EchartsDto getD() {
		return d;
	}

	public void setD(EchartsDto d) {
		this.d = d;
	}

	public String initPage() throws Exception {
		return "list";
	}
	
	public String initEchartDetail()throws Exception {
		List<ErrorRateDetailDto> errorRateDetailDtoList = echartsAnalysisService.getEchartRateDetail();
		d.setErrorRateList(errorRateDetailDtoList);
		return "json";
	}             
	
	public String initEchartRankDetail()throws Exception {
		List<ErrorRankRateDetailDto> errorRankRateDetailDtoList = echartsAnalysisService.getEchartRankRateDetail();
		d.setErrorRankRateDetailDtoList(errorRankRateDetailDtoList);
		return "json";
	}       
	
	
	
	public String initEchartContentAndNumDetail()throws Exception {
		List<ErrorContentAndNumDetailDto> errorContentAndNumDetailDtoList =  echartsAnalysisService.getErrorContentAndNumDetail();
		d.setErrorContentAndNumList(errorContentAndNumDetailDtoList);
		return "json";
	}
	
	public String initEchartContentAndNumBycourtAndJudgeDetail()throws Exception {
		String court = d.getCourt();
		String courtRoom = d.getCourtRoom();
		String judge = d.getJudge();
		String showFlag = d.getShowFlag();
		if(StringUtil.isEmpty(court)){
			court = null;
		}else{
			court = URLDecoder.decode(court, "UTF-8");
		}
		if(StringUtil.isEmpty(courtRoom)){
			courtRoom = null;
		}else{
			courtRoom = URLDecoder.decode(courtRoom, "UTF-8");
		}
		if(StringUtil.isEmpty(judge)){
			judge = null;
		}else{
			judge = URLDecoder.decode(judge, "UTF-8");
		}
		if("0".equals(showFlag)){
			List<ErrorCourtRoomRateDetailDto> errorCourtRoomRateList = echartsAnalysisService.getErrorCourtRoomRateDetailDto(court);
			courtRoom = errorCourtRoomRateList.get(0).getCourtRoomArray()[0].split("/")[1];
			d.setCourtRoom(courtRoom);
		}
		if("1".equals(showFlag)){
			List<ErrorJudgeNameRateDetailDto> errorJudgeNameRateDetailDtoList = echartsAnalysisService.getErrorJudgeRateDetail(court,courtRoom);
			judge = errorJudgeNameRateDetailDtoList.get(0).getJudgeNameArray()[0].split("/")[2];
			d.setJudge(judge);
		}
		if("2".equals(showFlag)){
			List<ErrorCourtRoomRateDetailDto> errorCourtRoomRateList = echartsAnalysisService.getErrorCourtRoomRateDetailDto(court);
			courtRoom = errorCourtRoomRateList.get(0).getCourtRoomArray()[0].split("/")[1];
			d.setCourtRoom(courtRoom);
			List<ErrorJudgeNameRateDetailDto> errorJudgeNameRateDetailDtoList = echartsAnalysisService.getErrorJudgeRateDetail(court,courtRoom);
			judge = errorJudgeNameRateDetailDtoList.get(0).getJudgeNameArray()[0].split("/")[2];
			d.setJudge(judge);
		}
		List<ErrorContentAndNumBycourtAndJudgeDetailDto> errorContentAndNumBycjList =  echartsAnalysisService.getErrorContentAndNumBycourtAndjude(court,courtRoom,judge);
		d.setErrorContentAndNumBycjList(errorContentAndNumBycjList);
		return "json";
	}
	
	
	public String initEchartNumAndRateDetail()throws Exception {
		List<ErrorNumAndRateDetailDto> errorNumAndRateDetailDtoList =  echartsAnalysisService.getEchartNumberAndRateDetail();
		d.setErrorNumAndRateList(errorNumAndRateDetailDtoList);
		return "json";
	}
	
	public String initEchartCauseAndRateDetail()throws Exception {
		List<ErrorCasueRateDetailDto> errorCauseAndRateDetailDtoList =  echartsAnalysisService.getEchartCauseAndRateDetail();
		d.setErrorCauseAndRateList(errorCauseAndRateDetailDtoList);
		return "json";
	}
	
	public String initEchartYearRateDetail()throws Exception {
		List<ErrorYearRateDetailDto>  errorYearRateDetailDtoList =  echartsAnalysisService.getEchartYearRateDetail();
		d.setErrorYearRateList(errorYearRateDetailDtoList);
		return "json";
	}
	
	
	public String  initEchartCourtYearRateBycourtAndTrialProduce()throws Exception {
		List<ErrorCourtYearRateDto> errorRateDetailDtoList = echartsAnalysisService.getEchartCourtYearRateBycourtAndTrialProduce(URLDecoder.decode(d.getCourt(), "UTF-8"));
		d.setErrorCourtYearRateList(errorRateDetailDtoList);
		return "json";
	}
	
	
	public String  initEchartCourtRoomRateBycourt()throws Exception {
		List<ErrorCourtRoomRateDetailDto> errorCourtRoomRateList = echartsAnalysisService.getErrorCourtRoomRateDetailDto(URLDecoder.decode(d.getCourt(), "UTF-8"));
		d.setErrorCourtRoomRateDetailDtoList(errorCourtRoomRateList);
		return "json";
	}
	
	public String  initEchartJudgeNamRateBycourtAndRoom()throws Exception {
		String court = d.getCourt();
		String courtRoom = d.getCourtRoom();
		String showFlag = d.getShowFlag();
		if(StringUtil.isEmpty(court)){
			court = null;
		}else{
			court = URLDecoder.decode(court, "UTF-8");
		}
		if(StringUtil.isEmpty(courtRoom)){
			courtRoom = null;
		}else{
			courtRoom = URLDecoder.decode(courtRoom, "UTF-8");
		}
		if("3".equals(showFlag)){
			List<ErrorCourtRoomRateDetailDto> errorCourtRoomRateList = echartsAnalysisService.getErrorCourtRoomRateDetailDto(court);
			courtRoom = errorCourtRoomRateList.get(0).getCourtRoomArray()[0].split("/")[1];
			d.setCourtRoom(courtRoom);
		}
		List<ErrorJudgeNameRateDetailDto> errorJudgeNameRateDetailDtoList = echartsAnalysisService.getErrorJudgeRateDetail(court,courtRoom);
		d.setErrorJudgeNameRateDetailDtoList(errorJudgeNameRateDetailDtoList);
		return "json";
	}   
}
