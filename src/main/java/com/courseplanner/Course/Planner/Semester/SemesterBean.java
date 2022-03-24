package com.courseplanner.Course.Planner.Semester;

import java.math.BigDecimal;

public class SemesterBean {

	private BigDecimal semesterId;
	private String semesterName;
	private String semesterDesc;
	
	public BigDecimal getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(BigDecimal semesterId) {
		this.semesterId = semesterId;
	}
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	public String getSemesterDesc() {
		return semesterDesc;
	}
	public void setSemesterDesc(String semesterDesc) {
		this.semesterDesc = semesterDesc;
	}
	
}
