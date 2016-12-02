package com.estar.judgment.evaluation.web.law.dto;

import java.math.BigDecimal;

public class ErrorCourtYearRateDto {
	
	
	//private Integer[]  courtYearArray;
	private String[]  courtYearArray;
	
	private BigDecimal[]  gcourtErrorRateArray;
	
	private BigDecimal[]  scourtErrorRateArray;

	public String[] getCourtYearArray() {
		return courtYearArray;
	}

	public void setCourtYearArray(String[] courtYearArray) {
		this.courtYearArray = courtYearArray;
	}

	public BigDecimal[] getGcourtErrorRateArray() {
		return gcourtErrorRateArray;
	}

	public void setGcourtErrorRateArray(BigDecimal[] gcourtErrorRateArray) {
		this.gcourtErrorRateArray = gcourtErrorRateArray;
	}

	public BigDecimal[] getScourtErrorRateArray() {
		return scourtErrorRateArray;
	}

	public void setScourtErrorRateArray(BigDecimal[] scourtErrorRateArray) {
		this.scourtErrorRateArray = scourtErrorRateArray;
	}
	
	
	
	
	
}
