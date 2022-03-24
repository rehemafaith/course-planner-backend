package com.courseplanner.Course.Planner.Semester;

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
public class SemesterDAO {

	PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource; 
	  
	//Fetch semesters
	  public List<SemesterBean> fetchSemester() throws SQLException {
		    String sqlQuery = "SELECT * FROM semester";
		    List<SemesterBean> semester = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		        SemesterBean fetch = new SemesterBean();
		        fetch.setSemesterId(rs.getBigDecimal("semester_id"));
		        fetch.setSemesterName(rs.getString("semester_name"));
		        fetch.setSemesterDesc(rs.getString("semester_desc"));
		        semester.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return semester; 
		    
		  }
	  
	  
	  //create new Semesters
	  public List<SemesterBean> createSemester(SemesterBean semesterBean) throws SQLException {
		    String sql = "INSERT INTO semester(semester_id, semester_name, semester_desc) VALUES ( "+ getNextPrimaryKey() +",'"+ semesterBean.getSemesterName() +"','"+ semesterBean.getSemesterDesc()+"')";
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchSemester();
		  }
	  
	  //getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "semester_id";
		    String table_name = "semester";
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
	  
	//update faculty
	  public List<SemesterBean> updateSemester(SemesterBean semesterBean) throws SQLException {
		    String sql = "update semester set semester_name='" + semesterBean.getSemesterName()  + "',semester_desc='" + semesterBean.getSemesterDesc()+ "' where semester_id=" + semesterBean.getSemesterId();
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
		    return fetchSemester();
		  } 
	  
	  //delete a semester
	  public List<SemesterBean> deleteSemester(SemesterBean semesterBean) throws SQLException {
	    String sql = "DELETE FROM semester WHERE semester_id=" + semesterBean.getSemesterId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      this.conn.close();
	    } 
	    return fetchSemester();
	    
	  }

}
