package com.courseplanner.Course.Planner.Planner;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"/planner/planner"})
@CrossOrigin(origins = "http://localhost:4200")
public class PlannerController {
	 @Autowired
	  PlannerDAO plannerDAO;
	 
	  //get planner
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/fetchPlanner"})
	  public List<PlannerBean> fetchPlanner() throws SQLException {
	    return this.plannerDAO.fetchPlanner();
	  }
	//create planner
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createPlanner"})
	  public List<PlannerBean> createPlanner(@RequestBody PlannerBean plannerBean) throws SQLException {
	    return this.plannerDAO.createPlanner(plannerBean);
	  } 
	  
	  //update planner
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updatePlanner"})
	  public List<PlannerBean> updatePlanner(@RequestBody PlannerBean plannerBean) throws SQLException {
	    return this.plannerDAO.updatePlanner(plannerBean);
	  }
	  
	  
	  //delete planner
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deletePlanner"})
	  public List<PlannerBean> deletePlanner(@RequestBody PlannerBean plannerBean) throws SQLException {
	    return this.plannerDAO.deletePlanner(plannerBean);
	  }
}
