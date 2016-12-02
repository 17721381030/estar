package com.estar.judgment.evaluation.web.law.dto;

import java.math.BigDecimal;

public class ErrorCourtRoomRateDetailDto {
	
	private String[] courtRoomArray;
	
	private BigDecimal[] errorRateArray;

	public String[] getCourtRoomArray() {
		return courtRoomArray;
	}

	public void setCourtRoomArray(String[] courtRoomArray) {
		this.courtRoomArray = courtRoomArray;
	}

	public BigDecimal[] getErrorRateArray() {
		return errorRateArray;
	}

	public void setErrorRateArray(BigDecimal[] errorRateArray) {
		this.errorRateArray = errorRateArray;
	}
	
	

}
