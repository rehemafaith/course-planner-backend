package com.courseplanner.Course.Planner.Faculty;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/planner/faculty"})
@CrossOrigin(origins = "http://localhost:4200")
public class FacultyController {
	 @Autowired
	  FacultyDAO facultyDAO;
	 
	 //get department 
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/fetchFaculty"})
	  public List<FacultyBean> fetchFaculty() throws SQLException {
	    return this.facultyDAO.fetchFaculties();
	  }
	//create faculty
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createFaculty"})
	  public List<FacultyBean> createFaculty(@RequestBody FacultyBean facultyBean) throws SQLException {
	    return this.facultyDAO.createFaculty(facultyBean);
	  } 
	  
	//update faculty
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateFaculty"})
	  public List<FacultyBean> updateFaculty(@RequestBody FacultyBean facultyBean) throws SQLException {
	    return this.facultyDAO.updateFaculty(facultyBean);
	  }
	  
	  //delete faculty
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteFaculty"})
	  public List<FacultyBean> deleteFaculty(@RequestBody FacultyBean facultyBean) throws SQLException {
	    return this.facultyDAO.deleteFaculty(facultyBean);
	  }
	
}
