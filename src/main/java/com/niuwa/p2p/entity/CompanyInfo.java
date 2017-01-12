package com.niuwa.p2p.entity;

public class CompanyInfo {
	private String compName;
	private String employeeCnt;
	private String type;
	private String industry;

	
	public CompanyInfo() {
	}
	

	public CompanyInfo( String type,String compName, String employeeCnt,String industry) {
		this.compName = compName;
		this.employeeCnt = employeeCnt;
		this.type = type;
		this.industry = industry;
	}


	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getEmployeeCnt() {
		return employeeCnt;
	}

	public void setEmployeeCnt(String employeeCnt) {
		this.employeeCnt = employeeCnt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getIndustry() {
		return industry;
	}


	public void setIndustry(String industry) {
		this.industry = industry;
	}


	@Override
	public String toString() {
		return "CompanyInfo [compName=" + compName + ", employeeCnt="
				+ employeeCnt + ", type=" + type + ", industry=" + industry
				+ "]";
	}
	
	

}
