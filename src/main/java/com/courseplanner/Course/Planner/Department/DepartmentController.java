package com.courseplanner.Course.Planner.Department;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({"/planner/department"})
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

	 @Autowired
	  DepartmentDAO departmentDAO;
	 
	  //get department 
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/fetchDepartment"})
	  public List<DepartmentBean> fetchDepartment() throws SQLException {
	    return this.departmentDAO.fetchDepartment();
	  }
	//create department
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createDepartment"})
	  public List<DepartmentBean> createDepartment(@RequestBody DepartmentBean departmentBean) throws SQLException {
	    return this.departmentDAO.createDepartment(departmentBean);
	  } 
	  
	  //update department
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateDepartment"})
	  public List<DepartmentBean> updateDepartment(@RequestBody DepartmentBean departmentBean) throws SQLException {
	    return this.departmentDAO.updateDepartment(departmentBean);
	  }
	  
	  
	  //delete department
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteDepartment"})
	  public List<DepartmentBean> deleteDepartment(@RequestBody DepartmentBean departmentBean) throws SQLException {
	    return this.departmentDAO.deleteDepartment(departmentBean);
	  }
}
