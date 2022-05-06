package com.techelevator.projects.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class JdbcEmployeeDao implements EmployeeDao {
	private final JdbcTemplate jdbcTemplate;
	public JdbcEmployeeDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			employees.add(mapRowToEmployees(results));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> employees = new ArrayList<>();

		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee " +
				"WHERE first_name ILIKE ? AND last_name ILIKE ?";

		firstNameSearch = "%" + firstNameSearch + "%";
		lastNameSearch = "%" + lastNameSearch + "%";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstNameSearch, lastNameSearch);

		while(results.next()) {
			employees.add(mapRowToEmployees(results));
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee " +
				"JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"WHERE project_employee.project_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,projectId);
		while(results.next()) {
			employees.add(mapRowToEmployees(results));
		}
		return employees;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "Insert Into project_employee (project_id, employee_id)" + "VALUES (?,?)";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> employeeNoProjects = new ArrayList<>();
		String sql = "SELECT * FROM employee " +
		"left join project_employee on project_employee.employee_id = employee.employee_id " +
		"WHERE project_employee.project_id is null;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			employeeNoProjects.add(mapRowToEmployees(results));
		}
		return employeeNoProjects;
	}

	private Employee mapRowToEmployees(SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setId(rowSet.getLong("employee_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());

		if(Long.valueOf(rowSet.getLong("department_id")) != null){
			employee.setDepartmentId(rowSet.getLong("department_id"));
		}
		return employee;
	}
}

