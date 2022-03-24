package com.courseplanner.Course.Planner.Course;

import java.math.BigDecimal;

public class CourseBean {
	private BigDecimal courseId;
	private String courseName;
	private String courseDesc;
	private BigDecimal courseDepartmentId;
	private String courseDepartmentName;
	public BigDecimal getCourseId() {
		return courseId;
	}
	public void setCourseId(BigDecimal courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public BigDecimal getCourseDepartmentId() {
		return courseDepartmentId;
	}
	public void setCourseDepartmentId(BigDecimal courseDepartmentId) {
		this.courseDepartmentId = courseDepartmentId;
	}
	public String getCourseDepartmentName() {
		return courseDepartmentName;
	}
	public void setCourseDepartmentName(String courseDepartmentName) {
		this.courseDepartmentName = courseDepartmentName;
	}
	
}
