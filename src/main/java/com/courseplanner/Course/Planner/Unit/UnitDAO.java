package com.courseplanner.Course.Planner.Unit;

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
public class UnitDAO {

	PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource;
	  
	  
	  //Get planner
	  public List<UnitBean> fetchUnit() throws SQLException {
		    String sqlQuery = "SELECT * from unit JOIN course ON unit.unit_course_id = course.course_id JOIN department ON department.department_id = course.course_department_id";
		    List<UnitBean> unit = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		        UnitBean fetch = new UnitBean();
		        fetch.setUnitId(rs.getBigDecimal("unit_id"));
		        fetch.setUnitCode(rs.getString("unit_code"));
		        fetch.setUnitName(rs.getString("unit_name"));
		        fetch.setCourseName(rs.getString("course_name"));
		        fetch.setUnitRank(rs.getBigDecimal("unit_rank"));
		        fetch.setUnitCourseId(rs.getBigDecimal("unit_course_id"));
		        fetch.setUnitSpecialization(rs.getString("unit_specialization"));
		        unit.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return unit; 
		    
		  }
	  
	  //getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "unit_id";
		    String table_name = "unit";
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
	  

	  //create unit
	  public List<UnitBean> createUnit(UnitBean unitBean) throws SQLException {
		    String sql = "INSERT INTO unit(unit_id, unit_code, unit_name, unit_course_id, unit_rank, unit_specialization) VALUES ( "+ getNextPrimaryKey() +",'"+ unitBean.getUnitCode() +"','"+ unitBean.getUnitName() +"','"+ unitBean.getUnitCourseId() +"','"+ unitBean.getUnitRank() +"','"+ unitBean.getUnitSpecialization() +"')";
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchUnit();
		  }
		//update planner
	  public List<UnitBean> updateUnit(UnitBean unitBean) throws SQLException {
		    String sql = "update unit set unit_code='" + unitBean.getUnitCode() + "', unit_name='" + unitBean.getUnitName() +  
		      "' , unit_course_id='"+ unitBean.getUnitCourseId() +"' ,unit_rank='"+ unitBean.getUnitRank() +"', unit_specialization='"+ unitBean.getUnitSpecialization() +"' where unit_id=" + unitBean.getUnitId();
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
		    return fetchUnit();
		  } 
	  //delete unit
	  public List<UnitBean> deleteUnit(UnitBean unitBean) throws SQLException {
	    String sql = "DELETE FROM unit WHERE unit_id=" + unitBean.getUnitId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace(); 
	    } finally {
	      this.conn.close();
	    } 
	    return fetchUnit();
	    
	  }
}
