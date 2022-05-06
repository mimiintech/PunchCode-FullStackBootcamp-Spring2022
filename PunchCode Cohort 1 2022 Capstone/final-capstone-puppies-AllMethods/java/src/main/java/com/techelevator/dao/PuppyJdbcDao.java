package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.techelevator.exceptions.PuppyNotFoundException;
import com.techelevator.model.Puppy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * PuppyJdbcDao
 */
@Component
public class PuppyJdbcDao implements PuppyDao {

	private JdbcTemplate template;

	public PuppyJdbcDao(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Puppy> getPuppies() {
		List<Puppy> puppyList= new ArrayList<>();
		String sql = "select * from puppies";
		SqlRowSet results = template.queryForRowSet(sql);
		while(results.next()){
			puppyList.add(mapResultToPuppy(results));
		}

		return  puppyList;
	}

	@Override
	public Puppy getPuppy(int id) {
		String sqlGetPuppy = "SELECT * FROM puppies WHERE id=?";
		SqlRowSet result = template.queryForRowSet(sqlGetPuppy, id);
		if (result.next()) {
			return mapResultToPuppy(result);
		} else {
			throw new PuppyNotFoundException();
		}
	}





	private Puppy mapResultToPuppy(SqlRowSet result) {
		Puppy retrievedPuppy = null;
		int id = result.getInt("id");
		String name = result.getString("name");
		int weight = result.getInt("weight");
		String gender = result.getString("gender");
		boolean paper_trained = result.getBoolean("paper_trained");
		String image = result.getString("image");

		retrievedPuppy = new Puppy(id, name, weight, gender, paper_trained, image);
		return retrievedPuppy;
	}


	@Override
	public void savePuppy(Puppy puppyToSave) {
		String sql = "INSERT INTO puppies (name, weight, gender, paper_trained, image) "
		+ "values (?, ?, ?, ?, ?)";
		template.update(sql, puppyToSave.getName(), puppyToSave.getWeight(),
				puppyToSave.getGender(), puppyToSave.isPaperTrained(), puppyToSave.getImage());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePuppy(int id) {
		String sql = "delete from puppies where id = ?";
		template.update(sql, id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPuppy(Puppy puppyToSave, int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE puppies set weight = ?, paper_trained = ? where id = ?";
		template.update(sql, puppyToSave.getWeight(), puppyToSave.isPaperTrained(), id);

	}


}