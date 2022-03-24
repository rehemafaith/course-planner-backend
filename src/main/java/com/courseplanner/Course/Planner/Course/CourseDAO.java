package com.courseplanner.Course.Planner.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
public class CourseDAO {
	PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource;
	  
	  
	  //Get course
	  public List<CourseBean> fetchCourse() throws SQLException {
		    String sqlQuery = "SELECT * FROM course join department on department.department_id = course.course_department_id";
		    List<CourseBean> course = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		        CourseBean fetch = new CourseBean();
		        fetch.setCourseId(rs.getBigDecimal("course_id"));
		        fetch.setCourseName(rs.getString("course_name"));
		        fetch.setCourseDesc(rs.getString("course_desc"));
		        fetch.setCourseDepartmentId(rs.getBigDecimal("course_department_id"));
		        fetch.setCourseDepartmentName(rs.getString("department_name"));
		        course.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return course; 
		    
		  }
	  
	  //getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "course_id";
		    String table_name = "course";
		    String sql = "SELECT MAX(" + column_name + ") FROM " + table_name;
		    int primary = 0;
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		        primary = rs.getInt(1);
		        primary++;
		      } 
		    } catch (Exception e) { 
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return primary;
		  }
	  

	  //create course
	  public List<CourseBean> createCourse(CourseBean courseBean) throws SQLException {
		    String sql = "INSERT INTO course(course_id, course_name, course_desc, course_department_id) VALUES ( "+ getNextPrimaryKey() +",'"+ courseBean.getCourseName()+"','"+ courseBean.getCourseDesc()+"','"+ courseBean.getCourseDepartmentId()+"')";
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchCourse();
		  }
		//update course
	  public List<CourseBean> updateCourse(CourseBean courseBean) throws SQLException {
		    String sql = "update course set course_name='" + courseBean.getCourseName()  + "',course_desc='" + courseBean.getCourseDesc()+  
		      "' , course_department_id='"+ courseBean.getCourseDepartmentId()+"' where course_id=" + courseBean.getCourseId();
		    System.out.println(sql);
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchCourse();
		  } 
	  //delete course
	  public List<CourseBean> deleteCourse(CourseBean courseBean) throws SQLException {
	    String sql = "DELETE FROM course WHERE course_id=" + courseBean.getCourseId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace(); 
	    } finally {
	      this.conn.close();
	    } 
	    return fetchCourse();
	    
	  }
	  
}
