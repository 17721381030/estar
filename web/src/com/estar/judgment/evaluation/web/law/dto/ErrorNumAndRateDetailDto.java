package com.estar.judgment.evaluation.web.law.dto;

import java.math.BigDecimal;

public class ErrorNumAndRateDetailDto {
	
	private String courtName;
	
	private BigDecimal[] numAndRateArray;

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public BigDecimal[] getNumAndRateArray() {
		return numAndRateArray;
	}

	public void setNumAndRateArray(BigDecimal[] numAndRateArray) {
		this.numAndRateArray = numAndRateArray;
	}
	
	

}
