package com.estar.judgment.evaluation.web.law.dto;

import java.math.BigDecimal;

public class ErrorRateDetailDto {
	
	private String courtName;
	private BigDecimal  errorRate;
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public BigDecimal getErrorRate() {
		return errorRate;
	}
	public void setErrorRate(BigDecimal errorRate) {
		this.errorRate = errorRate;
	}
	
	
	

}
