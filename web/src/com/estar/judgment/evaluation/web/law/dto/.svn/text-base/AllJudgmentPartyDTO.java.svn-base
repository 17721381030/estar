package com.estar.judgment.evaluation.web.law.dto;


import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseDTO;
import com.estar.judgment.evaluation.web.law.entity.AllJudgmentParty;
public class AllJudgmentPartyDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;
	private String id;
	private String partyFlag;
	private String legalStatus;
	private String personFlag;
	private String name;
	private String nationality;
	private String address;
	private String unit;
	private String position;
	private String countryContent;
	
	public AllJudgmentPartyDTO(AllJudgmentParty t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	public AllJudgmentPartyDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getPartyFlag() {
		return partyFlag;
	}


	public void setPartyFlag(String partyFlag) {
		this.partyFlag = partyFlag;
	}


	public String getLegalStatus() {
		return legalStatus;
	}


	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}


	public String getPersonFlag() {
		return personFlag;
	}


	public void setPersonFlag(String personFlag) {
		this.personFlag = personFlag;
	}


	public String getCountryContent() {
		return countryContent;
	}


	public void setCountryContent(String countryContent) {
		this.countryContent = countryContent;
	}


	
	
	
	
}