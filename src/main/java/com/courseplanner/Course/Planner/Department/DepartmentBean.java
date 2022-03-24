package com.courseplanner.Course.Planner.Department;

import java.math.BigDecimal;

public class DepartmentBean {
	private BigDecimal departmentId;
	private String departmentName;
	private String departmentDesc;
	private BigDecimal departmentFacultyId;
	private String departmentFacultyName;
	public BigDecimal getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	public BigDecimal getDepartmentFacultyId() {
		return departmentFacultyId;
	}
	public void setDepartmentFacultyId(BigDecimal departmentFacultyId) {
		this.departmentFacultyId = departmentFacultyId;
	}
	public String getDepartmentFacultyName() {
		return departmentFacultyName;
	}
	public void setDepartmentFacultyName(String departmentFacultyName) {
		this.departmentFacultyName = departmentFacultyName;
	}
	
	
}
