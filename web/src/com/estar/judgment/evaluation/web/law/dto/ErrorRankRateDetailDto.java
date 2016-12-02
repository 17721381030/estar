package com.estar.judgment.evaluation.web.law.dto;

import java.math.BigDecimal;

public class ErrorRankRateDetailDto {

	private String[] courtArray;
	
	private BigDecimal[] errorRateArray;

	
	public String[] getCourtArray() {
		return courtArray;
	}

	public void setCourtArray(String[] courtArray) {
		this.courtArray = courtArray;
	}

	public BigDecimal[] getErrorRateArray() {
		return errorRateArray;
	}

	public void setErrorRateArray(BigDecimal[] errorRateArray) {
		this.errorRateArray = errorRateArray;
	}
	
	
}
