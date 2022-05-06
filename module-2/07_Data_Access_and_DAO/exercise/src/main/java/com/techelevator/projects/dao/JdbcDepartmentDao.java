package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	private final JdbcTemplate jdbcTemplate;
	public JdbcDepartmentDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

//	********************************************************************************************************************
//*******GET DEPARTMENT RETURNS NULL WHEN ID NOT FOUND & GET DEPARTMENT RETURNS CORRECT DEPARTMENT FOR ID***************

	@Override
	public Department getDepartment(Long departmentId) {
		Department department = null;
		String sqlGetDepartment = "SELECT department_id, name FROM department WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDepartment, departmentId);
		if (results.next()) {
			department = mapRowToDepartments(results);
		}
		return department;
	}

//	********************************************************************************************************************
//*************************GET ALL DEPARTMENTS RETURNS LIST OF ALL DEPARTMENTS******************************************

	@Override
	public List<Department> getAllDepartments() {
		ArrayList<Department> departments = new ArrayList<>();
		String sqlGetAllDepartments = "SELECT name, department_id FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);
		while(results.next()) {
			departments.add(mapRowToDepartments(results));
	}
		return departments;
	}

//**********************************************************************************************************************
//***************************UPDATED DEPARTMENT HAS EXPECTED NAME WHEN RETRIEVED****************************************

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sqlUpdateDepartment = "UPDATE department SET name = ? WHERE department_id = ?";
		jdbcTemplate.update(sqlUpdateDepartment, updatedDepartment.getName(), updatedDepartment.getId());
	}

//	********************************************************************************************************************
//***************************PRIVATE MAP_ROW_TO_DEPARTMENTS*************************************************************

	private Department mapRowToDepartments(SqlRowSet rowSet) {
		Department departments = new Department();
		departments.setName(rowSet.getString("name"));
		departments.setId(rowSet.getLong("department_id"));
		return departments;
	}
}
