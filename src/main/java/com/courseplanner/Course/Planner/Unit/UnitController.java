package com.courseplanner.Course.Planner.Unit;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({"/planner/unit"})
@CrossOrigin(origins = "http://localhost:4200")
public class UnitController {

	 @Autowired
	  UnitDAO unitDAO;
	 
	  //get unit
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/fetchUnit"})
	  public List<UnitBean> fetchUnit() throws SQLException {
	    return this.unitDAO.fetchUnit();
	  }
	//create unit
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createUnit"})
	  public List<UnitBean> createUnit(@RequestBody UnitBean unitBean) throws SQLException {
	    return this.unitDAO.createUnit(unitBean);
	  } 
	  
	  //update unit
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateUnit"})
	  public List<UnitBean> updateUnit(@RequestBody UnitBean unitBean) throws SQLException {
	    return this.unitDAO.updateUnit(unitBean);
	  }
	  
	  
	  //delete unit
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteUnit"})
	  public List<UnitBean> deleteUnit(@RequestBody UnitBean unitBean) throws SQLException {
	    return this.unitDAO.deleteUnit(unitBean);
	  }
}
