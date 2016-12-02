package com.estar.judgment.evaluation.web.law.dto;

import java.math.BigInteger;

public class ErrorContentAndNumDetailDto {
	
	private String [] errorContentArray;
	
	private BigInteger[] numberArray;

	public String[] getErrorContentArray() {
		return errorContentArray;
	}

	public void setErrorContentArray(String[] errorContentArray) {
		this.errorContentArray = errorContentArray;
	}

	public BigInteger[] getNumberArray() {
		return numberArray;
	}

	public void setNumberArray(BigInteger[] numberArray) {
		this.numberArray = numberArray;
	}
	
	
	

}
