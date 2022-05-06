package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date FROM project WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		if(results.next()){
			project = mapRowToProject(results);
		} return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> allProjects = new ArrayList<>();
		String sql = "SELECT * FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){

			allProjects.add(mapRowToProject(results));
		}
		return allProjects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "Insert Into project ( name, from_date, to_date)" +
				"VALUES (?,?,?) returning project_id;";
		long projectId = jdbcTemplate.queryForObject(sql,Long.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		newProject.setId(projectId);
		return newProject;

	}

	@Override
	public void deleteProject(Long projectId) {
		String sql = "DELETE from project_employee WHERE project_id = ?;" +
				"Delete from project where project_id = ?;";
		jdbcTemplate.update(sql,projectId,projectId);

	}

	public Project mapRowToProject(SqlRowSet rowSet){
		Project project = new Project();
		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString("name"));
		if(rowSet.getDate("from_date") != null ){
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if(rowSet.getDate("to_date") != null) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}
		return project;
	}
}


