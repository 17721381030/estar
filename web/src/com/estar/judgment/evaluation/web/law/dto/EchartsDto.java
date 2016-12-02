package com.estar.judgment.evaluation.web.law.dto;

import java.util.List;

public class EchartsDto {
	
	private List<ErrorRateDetailDto> errorRateList;
	
	private List<ErrorYearRateDetailDto> errorYearRateList;
	
	private List<ErrorNumAndRateDetailDto> errorNumAndRateList;
	
	private List<ErrorCasueRateDetailDto> errorCauseAndRateList;
	
	private List<ErrorContentAndNumDetailDto> errorContentAndNumList;
	
	private List<ErrorCourtYearRateDto> errorCourtYearRateList;
	
	private List<ErrorRankRateDetailDto> errorRankRateDetailDtoList;
	
	private List<ErrorCourtRoomRateDetailDto> errorCourtRoomRateDetailDtoList;
	
	private List<ErrorJudgeNameRateDetailDto> errorJudgeNameRateDetailDtoList;

	private List<ErrorContentAndNumBycourtAndJudgeDetailDto> errorContentAndNumBycjList;
	
	private String court;
	
	private String courtRoom;
	
	private String trial_procedure;
	
	private String judge;
	
	private String showFlag;


	public List<ErrorRateDetailDto> getErrorRateList() {
		return errorRateList;
	}

	public void setErrorRateList(List<ErrorRateDetailDto> errorRateList) {
		this.errorRateList = errorRateList;
	}

	public List<ErrorYearRateDetailDto> getErrorYearRateList() {
		return errorYearRateList;
	}

	public void setErrorYearRateList(List<ErrorYearRateDetailDto> errorYearRateList) {
		this.errorYearRateList = errorYearRateList;
	}

	public List<ErrorNumAndRateDetailDto> getErrorNumAndRateList() {
		return errorNumAndRateList;
	}

	public void setErrorNumAndRateList(
			List<ErrorNumAndRateDetailDto> errorNumAndRateList) {
		this.errorNumAndRateList = errorNumAndRateList;
	}

	public List<ErrorCasueRateDetailDto> getErrorCauseAndRateList() {
		return errorCauseAndRateList;
	}

	public void setErrorCauseAndRateList(
			List<ErrorCasueRateDetailDto> errorCauseAndRateList) {
		this.errorCauseAndRateList = errorCauseAndRateList;
	}

	public List<ErrorContentAndNumDetailDto> getErrorContentAndNumList() {
		return errorContentAndNumList;
	}

	public void setErrorContentAndNumList(
			List<ErrorContentAndNumDetailDto> errorContentAndNumList) {
		this.errorContentAndNumList = errorContentAndNumList;
	}
	
	public List<ErrorCourtYearRateDto> getErrorCourtYearRateList() {
		return errorCourtYearRateList;
	}

	public void setErrorCourtYearRateList(
			List<ErrorCourtYearRateDto> errorCourtYearRateList) {
		this.errorCourtYearRateList = errorCourtYearRateList;
	}
	
	public List<ErrorRankRateDetailDto> getErrorRankRateDetailDtoList() {
		return errorRankRateDetailDtoList;
	}

	public void setErrorRankRateDetailDtoList(
			List<ErrorRankRateDetailDto> errorRankRateDetailDtoList) {
		this.errorRankRateDetailDtoList = errorRankRateDetailDtoList;
	}

	public List<ErrorCourtRoomRateDetailDto> getErrorCourtRoomRateDetailDtoList() {
		return errorCourtRoomRateDetailDtoList;
	}

	public void setErrorCourtRoomRateDetailDtoList(
			List<ErrorCourtRoomRateDetailDto> errorCourtRoomRateDetailDtoList) {
		this.errorCourtRoomRateDetailDtoList = errorCourtRoomRateDetailDtoList;
	}
	
	public List<ErrorJudgeNameRateDetailDto> getErrorJudgeNameRateDetailDtoList() {
		return errorJudgeNameRateDetailDtoList;
	}

	public void setErrorJudgeNameRateDetailDtoList(
			List<ErrorJudgeNameRateDetailDto> errorJudgeNameRateDetailDtoList) {
		this.errorJudgeNameRateDetailDtoList = errorJudgeNameRateDetailDtoList;
	}
	
	public List<ErrorContentAndNumBycourtAndJudgeDetailDto> getErrorContentAndNumBycjList() {
		return errorContentAndNumBycjList;
	}

	public void setErrorContentAndNumBycjList(
			List<ErrorContentAndNumBycourtAndJudgeDetailDto> errorContentAndNumBycjList) {
		this.errorContentAndNumBycjList = errorContentAndNumBycjList;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}
	
	public String getCourtRoom() {
		return courtRoom;
	}

	public void setCourtRoom(String courtRoom) {
		this.courtRoom = courtRoom;
	}

	public String getTrial_procedure() {
		return trial_procedure;
	}

	public void setTrial_procedure(String trial_procedure) {
		this.trial_procedure = trial_procedure;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
}
