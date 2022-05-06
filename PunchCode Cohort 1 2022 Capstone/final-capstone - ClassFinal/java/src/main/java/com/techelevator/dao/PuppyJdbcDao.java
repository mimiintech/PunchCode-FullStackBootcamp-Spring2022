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
        String sqlGetPuppies = "SELECT id, name, weight, sex, paper_trained, image FROM puppies";
        SqlRowSet result = template.queryForRowSet(sqlGetPuppies);
        List<Puppy> puppyList = new ArrayList<>();
        while (result.next()){
            Puppy puppy = mapResultToPuppy(result);
            puppyList.add(puppy);
        }
        return puppyList;
    }

    @Override
    public Puppy getPuppy(int id) {
        String sqlGetPuppy = "SELECT id, name, weight, sex, paper_trained, image FROM puppies WHERE id = ?";
        SqlRowSet result = template.queryForRowSet(sqlGetPuppy, id);
        if (result.next()) {
            return mapResultToPuppy(result);
        } else {
            throw new PuppyNotFoundException();
        }
    }





    private Puppy mapResultToPuppy(SqlRowSet result) {
        Puppy retrievedPuppy = new Puppy();
        retrievedPuppy.setId(result.getInt("id"));
        retrievedPuppy.setName(result.getString("name"));
        retrievedPuppy.setWeight(result.getInt("weight"));
        retrievedPuppy.setPaperTrained(result.getBoolean("paper_trained"));
        retrievedPuppy.setSex(result.getString("sex"));
        retrievedPuppy.setImage(result.getString("image"));
        return retrievedPuppy;
    }


    @Override
    public void savePuppy(Puppy puppyToSave) {
        String sqlSavePuppy = "INSERT INTO puppies (name, weight, sex, paper_trained, image) " +
                "VALUES (?, ?, ?, ?, ?)";
        template.update(sqlSavePuppy, puppyToSave.getName(), puppyToSave.getWeight(),
                puppyToSave.getSex(), puppyToSave.isPaperTrained(), puppyToSave.getImage());

    }

    @Override
    public void removePuppy(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void editPuppy(Puppy puppyToSave) {
        // TODO Auto-generated method stub

    }


}
