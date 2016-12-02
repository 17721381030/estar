package com.estar.judgment.evaluation.web.law.dto;

import java.math.BigDecimal;

public class ErrorYearRateDetailDto {
	
	private String courtName;
	private BigDecimal[]  errorRateArray;
	private String[]  yearArray;
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public BigDecimal[] getErrorRateArray() {
		return errorRateArray;
	}
	public void setErrorRateArray(BigDecimal[] errorRateArray) {
		this.errorRateArray = errorRateArray;
	}
	public String[] getYearArray() {
		return yearArray;
	}
	public void setYearArray(String[] yearArray) {
		this.yearArray = yearArray;
	}
	
	
	
	

}
