package com.courseplanner.Course.Planner.Semester;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"/planner/semester"})
@CrossOrigin(origins = "http://localhost:4200")
public class SemesterController {
	
	@Autowired
	  SemesterDAO semesterDAO;
	 
	 //get semester
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/fetchSemester"})
	  public List<SemesterBean> fetchSemester() throws SQLException {
	    return this.semesterDAO.fetchSemester();
	  }
	//create semester
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createSemester"})
	  public List<SemesterBean> createSemester(@RequestBody SemesterBean semesterBean) throws SQLException {
	    return this.semesterDAO.createSemester(semesterBean);
	  } 
	  
	//update semester
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateSemester"})
	  public List<SemesterBean> updateSemester(@RequestBody SemesterBean semesterBean) throws SQLException {
	    return this.semesterDAO.updateSemester(semesterBean);
	  }
	  
	  //delete semester
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteSemester"})
	  public List<SemesterBean> deleteSemester(@RequestBody SemesterBean semesterBean) throws SQLException {
	    return this.semesterDAO.deleteSemester(semesterBean);
	  }
	
}
