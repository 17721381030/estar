package com.estar.judgment.evaluation.web.law.dto;

import java.math.BigDecimal;

public class ErrorCasueRateDetailDto {
	
	private String causeName;
	
	private BigDecimal[] causeAndRateArray;

	public String getCauseName() {
		return causeName;
	}

	public void setCauseName(String causeName) {
		this.causeName = causeName;
	}

	public BigDecimal[] getCauseAndRateArray() {
		return causeAndRateArray;
	}

	public void setCauseAndRateArray(BigDecimal[] causeAndRateArray) {
		this.causeAndRateArray = causeAndRateArray;
	}
	
	

}
