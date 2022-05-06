package com.techelevator.dao;

import com.techelevator.model.Puppy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPuppyDao implements PuppyDao{

    // property
    JdbcTemplate jdbcTemplate;

    public JdbcPuppyDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Puppy> getAllPuppies() {
        List<Puppy> puppyList = new ArrayList<>();
        String sql = "SELECT puppy_id, puppy_name, weight, gender, " +
                "breed, paper_trained FROM puppy";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){
            Puppy puppy = mapRowToPuppy(results);
            puppyList.add(puppy);
        }
        return puppyList;
    }

    // helper method
    private Puppy mapRowToPuppy(SqlRowSet results){
        int id = results.getInt("puppy_id");
        String name = results.getString("puppy_name");
        int weight = results.getInt("weight");
        String gender = results.getString("gender");
        String breed = results.getString("breed");
        boolean paperTrained = results.getBoolean("paper_trained");
        Puppy puppy = new Puppy(id, name, weight, gender, breed, paperTrained);
        return puppy;
    }

    @Override
    public Puppy getPuppyById(int puppyId) {
        String sql = "SELECT puppy_id, puppy_name, weight, gender, " +
                "breed, paper_trained FROM puppy WHERE puppy_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, puppyId);
        Puppy puppy = null;

        if (results.next()){  //results.next sets the pointer to the front of the
            puppy = mapRowToPuppy(results);
        }
        return puppy;
    }

    @Override
    public Puppy savePuppy(Puppy puppy) {
        String sql = "INSERT INTO puppy (puppy_name, weight, gender, breed, paper_trained) " +
                "VALUES(?, ?, ?, ?, ?) RETURNING puppy_id";

        int id = jdbcTemplate.queryForObject(sql, Integer.class, puppy.getPuppyName(),
                puppy.getWeight(), puppy.getGender(), puppy.getBreed(), puppy.isPaperTrained());

        Puppy retrievedPuppy = getPuppyById(id);
        return retrievedPuppy;
    }

    @Override
    public Puppy updatePuppy(Puppy puppy) {

        return null;
    }

    @Override
    public void removePuppy(int puppyId) {

    }
}
