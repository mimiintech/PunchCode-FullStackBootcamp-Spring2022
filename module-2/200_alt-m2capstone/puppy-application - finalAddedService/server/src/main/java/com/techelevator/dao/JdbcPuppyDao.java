package com.techelevator.dao;


import com.techelevator.model.Puppy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPuppyDao implements PuppyDao{

    // property
    JdbcTemplate jdbcTemplate;

    public JdbcPuppyDao(JdbcTemplate jdbcTemplate){ // passing in the jdbctemplate, we are letting spring boot
        // inject the database connection for us.
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Puppy> getAllPuppies() {
        List<Puppy> puppyList = new ArrayList<>();
        String sql = "SELECT puppy_id, puppy_name, weight, sex, " +
                "breed, paper_trained, dog_fact FROM puppy";
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
        String sex = results.getString("sex");
        String breed = results.getString("breed");
        boolean paperTrained = results.getBoolean("paper_trained");
        String fact = results.getString("dog_fact");
        Puppy puppy = new Puppy();
        puppy.setPuppyName(name);
        puppy.setBreed(breed);
        puppy.setSex(sex);
        puppy.setWeight(weight);
        puppy.setPaperTrained(paperTrained);
        puppy.setPuppyId(id);
        puppy.setFact(fact);
        return puppy;
    }

    @Override
    public Puppy getPuppyById(int puppyId) {
        String sql = "SELECT puppy_id, puppy_name, weight, sex, " +
                "breed, paper_trained, dog_fact FROM puppy WHERE puppy_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, puppyId);
        Puppy puppy = null;

        if (results.next()){  //results.next sets the pointer to the front of the
            puppy = mapRowToPuppy(results);
        }
        return puppy;
    }

    @Override
    public Puppy savePuppy(Puppy puppy) {
        String sql = "INSERT INTO puppy (puppy_name, weight, sex, breed, paper_trained, dog_fact) " +
                "VALUES(?, ?, ?, ?, ?, ?) RETURNING puppy_id";
        int id = jdbcTemplate.queryForObject(sql, Integer.class, puppy.getPuppyName(),
                puppy.getWeight(), puppy.getSex(), puppy.getBreed(), puppy.isPaperTrained(),
                puppy.getFact());
        Puppy retrievedPuppy = getPuppyById(id);
        System.out.println(retrievedPuppy.getFact());
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
