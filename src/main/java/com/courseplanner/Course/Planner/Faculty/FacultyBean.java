package com.courseplanner.Course.Planner.Faculty;

import java.math.BigDecimal;

public class FacultyBean {
	private BigDecimal facultyId;
	private String facultyName;
	private String facultyDesc;
	public BigDecimal getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(BigDecimal facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getFacultyDesc() {
		return facultyDesc;
	}
	public void setFacultyDesc(String facultyDesc) {
		this.facultyDesc = facultyDesc;
	}
}
