package com.estar.judgment.evaluation.web.law.dto;

import java.math.BigDecimal;

public class ErrorJudgeNameRateDetailDto {
	
	private String[] judgeNameArray;
	
	private BigDecimal[] errorRateArray;

	public String[] getJudgeNameArray() {
		return judgeNameArray;
	}

	public void setJudgeNameArray(String[] judgeNameArray) {
		this.judgeNameArray = judgeNameArray;
	}

	public BigDecimal[] getErrorRateArray() {
		return errorRateArray;
	}

	public void setErrorRateArray(BigDecimal[] errorRateArray) {
		this.errorRateArray = errorRateArray;
	}
	
	

}
