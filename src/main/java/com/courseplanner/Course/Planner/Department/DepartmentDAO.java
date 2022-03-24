package com.courseplanner.Course.Planner.Department;

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
public class DepartmentDAO {

	PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource;
	  
	  //Get department
	  public List<DepartmentBean> fetchDepartment() throws SQLException {
		    String sqlQuery = "SELECT * FROM department JOIN faculty on department.department_faculty_id = faculty.faculty_id;";
		    List<DepartmentBean> department = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		        DepartmentBean fetch = new DepartmentBean();
		        fetch.setDepartmentId(rs.getBigDecimal("department_id"));
		        fetch.setDepartmentName(rs.getString("department_name"));
		        fetch.setDepartmentDesc(rs.getString("department_desc"));
		        fetch.setDepartmentFacultyId(rs.getBigDecimal("department_faculty_id"));
		        fetch.setDepartmentName(rs.getString("faculty_name"));
		        department.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return department; 
		    
		  }
	  
	//getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "department_id";
		    String table_name = "department";
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
	  
	  
	  //create department
	  public List<DepartmentBean> createDepartment(DepartmentBean departmentBean) throws SQLException {
		    String sql = "INSERT INTO department(department_id, department_name, department_desc, department_faculty_id) VALUES ( "+ getNextPrimaryKey() +",'"+ departmentBean.getDepartmentName()+"','"+ departmentBean.getDepartmentDesc()+"','"+departmentBean.getDepartmentFacultyId()+"')";
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchDepartment();
		  }
	  
	  
	//update department
	  public List<DepartmentBean> updateDepartment(DepartmentBean departmentBean) throws SQLException {
		    String sql = "update department set department_name='" + departmentBean.getDepartmentName()  + "',department_desc='" + departmentBean.getDepartmentDesc()+  
		      "' , department_faculty_id='"+departmentBean.getDepartmentFacultyId()+"' where department_id=" + departmentBean.getDepartmentId();
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
		    return fetchDepartment();
		  } 
	  //delete department
	  public List<DepartmentBean> deleteDepartment(DepartmentBean departmentBean) throws SQLException {
	    String sql = "DELETE FROM department WHERE department_id=" + departmentBean.getDepartmentId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      this.conn.close();
	    } 
	    return fetchDepartment();
	    
	  }
}
