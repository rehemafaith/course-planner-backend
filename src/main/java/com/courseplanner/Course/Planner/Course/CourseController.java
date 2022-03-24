package com.courseplanner.Course.Planner.Course;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({"/planner/course"})
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	
	
	 @Autowired
	  CourseDAO courseDAO;
	 
	  //get course
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/fetchCourse"})
	  public List<CourseBean> fetchCourse() throws SQLException {
	    return this.courseDAO.fetchCourse();
	  }
	//create course
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createCourse"})
	  public List<CourseBean> createCourse(@RequestBody CourseBean courseBean) throws SQLException {
	    return this.courseDAO.createCourse(courseBean);
	  } 
	  
	  //update course
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateCourse"})
	  public List<CourseBean> updateCourse(@RequestBody CourseBean courseBean) throws SQLException {
	    return this.courseDAO.updateCourse(courseBean);
	  }
	  
	  
	  //delete course
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteCourse"})
	  public List<CourseBean> deleteCourse(@RequestBody CourseBean courseBean) throws SQLException {
	    return this.courseDAO.deleteCourse(courseBean);
	  }
}
