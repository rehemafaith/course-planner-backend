package com.courseplanner.Course.Planner.Unit;

import java.math.BigDecimal;

public class UnitBean {
	private BigDecimal unitId;
	private String unitCode;
	private String unitName;
	private String courseName;
	private BigDecimal unitRank;
	private BigDecimal unitCourseId;
	private String unitSpecialization;
	public BigDecimal getUnitId() {
		return unitId;
	}
	public void setUnitId(BigDecimal unitId) {
		this.unitId = unitId;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public BigDecimal getUnitCourseId() {
		return unitCourseId;
	}
	public void setUnitCourseId(BigDecimal unitCourseId) {
		this.unitCourseId = unitCourseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public BigDecimal getUnitRank() {
		return unitRank;
	}
	public void setUnitRank(BigDecimal unitRank) {
		this.unitRank = unitRank;
	}
	public String getUnitSpecialization() {
		return unitSpecialization;
	}
	public void setUnitSpecialization(String unitSpecialization) {
		this.unitSpecialization = unitSpecialization;
	}
	
	
}
