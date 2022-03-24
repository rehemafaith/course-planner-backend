package com.courseplanner.Course.Planner.Planner;

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
public class PlannerDAO {

	PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource;
	  
	  //Get planner
	  public List<PlannerBean> fetchPlanner() throws SQLException {
		    String sqlQuery = "SELECT planner.planner_id, course.course_name,semester.semester_name, unit.unit_name, planner.planner_course_id, planner.planner_unit_id, planner_semester_id FROM planner JOIN semester ON planner.planner_semester_id = semester.semester_id JOIN unit on planner.planner_unit_id = unit.unit_id JOIN course ON planner.planner_course_id = course.course_id;";
		    List<PlannerBean> planner = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		        PlannerBean fetch = new PlannerBean();
		        fetch.setPlannerId(rs.getBigDecimal("planner_id"));
		        fetch.setPlannerCourseName(rs.getString("course_name"));
		        fetch.setPlannerSemesterName(rs.getString("semester_name"));
		        fetch.setPlannerUnitName(rs.getString("unit_name"));
		        fetch.setPlannerUnitId(rs.getBigDecimal("planner_unit_id"));
		        fetch.setPlannerCourseId(rs.getBigDecimal("planner_course_id"));
		        fetch.setPlannerSemesterId(rs.getBigDecimal("planner_semester_id"));
		        planner.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return planner; 
		    
		  }
	  
	  //getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "planner_id";
		    String table_name = "planner";
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
	  

	  //create planner
	  public List<PlannerBean> createPlanner(PlannerBean plannerBean) throws SQLException {
		    String sql = "INSERT INTO planner(planner_id, planner_course_id, planner_semester_id, planner_unit_id) VALUES ( "+ getNextPrimaryKey() +",'"+ plannerBean.getPlannerCourseId()+"','"+ plannerBean.getPlannerSemesterId()+"','"+ plannerBean.getPlannerUnitId()+"')";
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchPlanner();
		  }
		//update planner
	  public List<PlannerBean> updatePlanner(PlannerBean plannerBean) throws SQLException {
		    String sql = "update planner set planner_course_id='" + plannerBean.getPlannerCourseId() + "',planner_semester_id='" + plannerBean.getPlannerSemesterId()+  
		      "' , planner_unit_id='"+ plannerBean.getPlannerUnitId()+"' where planner_id=" + plannerBean.getPlannerId();
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
		    return fetchPlanner();
		  } 
	  //delete planner
	  public List<PlannerBean> deletePlanner(PlannerBean plannerBean) throws SQLException {
	    String sql = "DELETE FROM planner WHERE planner_id=" + plannerBean.getPlannerId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace(); 
	    } finally {
	      this.conn.close();
	    }  
	    return fetchPlanner();
	    
	  }
	  
}
