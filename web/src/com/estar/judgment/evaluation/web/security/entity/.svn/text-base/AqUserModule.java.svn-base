package com.estar.judgment.evaluation.web.security.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "aq_user_module")
public class AqUserModule implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String dyId;
	private String userId;
	private String moduleId;
	public AqUserModule() {
	}

	

	@Id
	@GeneratedValue(generator = "pg")      
	@GenericGenerator(name = "pg", strategy = "uuid.hex")
	@Column(name = "DY_ID", unique = true, nullable = false)
	public String getDyId() {
		return dyId;
	}

	public void setDyId(String dyId) {
		this.dyId = dyId;
	}

	@Column(name = "USER_ID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "MODULE_ID")
	public String getModuleId() {
		return moduleId;
	}



	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	

}