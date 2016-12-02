package com.estar.judgment.evaluation.web.law.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "judgment_party")
public class AllJudgmentParty implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String partyFlag;
	private String legalStatus;
	private String personFlag;
	private String name;
	private String nationality;
	private String address;
	private String unit;
	private String position;
	private String countryContent;
	
	public AllJudgmentParty() {
	}

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "assigned")
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "PARTY_FLAG")
	public String getPartyFlag() {
		return partyFlag;
	}

	public void setPartyFlag(String partyFlag) {
		this.partyFlag = partyFlag;
	}

	@Column(name = "LEGAL_STATUS")
	public String getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}

	@Column(name = "PERSON_FLAG")
	public String getPersonFlag() {
		return personFlag;
	}

	public void setPersonFlag(String personFlag) {
		this.personFlag = personFlag;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		
	@Column(name = "NATIONALITY")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "UNIT")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Column(name = "POSITION")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Column(name = "COUNTRY_CONTENT")
	public String getCountryContent(){
		return countryContent;
	}
	
	public void setCountryContent(String countryContent){
		this.countryContent = countryContent;
	}

	
}