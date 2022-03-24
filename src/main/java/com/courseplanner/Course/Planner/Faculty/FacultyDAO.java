package com.courseplanner.Course.Planner.Faculty;

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
public class FacultyDAO {
	PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource; 
	  
	  //Fetch faculties
	  public List<FacultyBean> fetchFaculties() throws SQLException {
		    String sqlQuery = "SELECT * FROM faculty";
		    List<FacultyBean> faculties = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		        FacultyBean fetch = new FacultyBean();
		        fetch.setFacultyId(rs.getBigDecimal("faculty_id"));
		        fetch.setFacultyName(rs.getString("faculty_name"));
		        fetch.setFacultyDesc(rs.getString("faculty_desc"));
		        faculties.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return faculties; 
		    
		  }
	  
	  
	  //create new Faculties
	  public List<FacultyBean> createFaculty(FacultyBean facultyBean) throws SQLException {
		    String sql = "INSERT INTO faculty(faculty_id, faculty_name, faculty_desc) VALUES ( "+ getNextPrimaryKey() +",'"+ facultyBean.getFacultyName() +"','"+ facultyBean.getFacultyDesc()+"')";
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchFaculties();
		  }
	  
	  //getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "faculty_id";
		    String table_name = "faculty";
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
	  public List<FacultyBean> updateFaculty(FacultyBean facultyBean) throws SQLException {
		    String sql = "update faculty set faculty_name='" + facultyBean.getFacultyName()  + "',faculty_desc='" + facultyBean.getFacultyDesc()+ "' where faculty_id=" + facultyBean.getFacultyId();
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
		    return fetchFaculties();
		  } 
	  
	  //delete a faculty 
	  public List<FacultyBean> deleteFaculty(FacultyBean facultyBean) throws SQLException {
	    String sql = "DELETE FROM faculty WHERE faculty_id=" + facultyBean.getFacultyId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      this.conn.close();
	    } 
	    return fetchFaculties();
	    
	  }

}
