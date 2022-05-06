package com.techelevator.dao;

import javax.sql.DataSource;

import com.techelevator.exceptions.ForumNotFoundException;
import com.techelevator.model.Forum;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcForumDao implements ForumDao {
    private final JdbcTemplate template;

    public JdbcForumDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

/// Create Method
//CHECK
    @Override
    public void createQuestion(Forum questionToAdd) {

        String sql = "INSERT INTO forum (user_id, question)" +
                "VALUES (?, ?)";
        template.update(sql, questionToAdd.getQuestion(), questionToAdd.getForum_id(), questionToAdd.getUser_id());
    }


    //Read Method

//    CHECK
//    For All

    @Override
    public List<Forum> getAllQuestions() {

        ArrayList<Forum> forums = new ArrayList<>();

        String sql = "SELECT * FROM forum";

        SqlRowSet results = template.queryForRowSet(sql);
        while (results.next()) {
            forums.add(mapRowToForum(results));
        }
        return forums;
    }


//    CHECK
// For One

    @Override
    public Forum getQuestion(int id) {

        Forum question;
        String sql = "SELECT question FROM forum WHERE forum_id = ?";
        SqlRowSet result = template.queryForRowSet(sql, id);
        if (result.next()) {
            question = mapRowToForum(result);
        } else {
            throw new ForumNotFoundException();
        }
        return question;
    }


//    CHECK
// Update Method


    @Override
    public  void updateQuestion(int id, Forum questionToUpdate) {

        String sql = "UPDATE forum SET question = ? WHERE user_id = ?";

        template.update(sql, questionToUpdate.getQuestion(), questionToUpdate.getUser_id(), questionToUpdate.getForum_id());

    }


//    Delete Method

//    CHECK
    @Override
    public  void deleteQuestion(int id, Forum questionToDelete) {

        String sql = "DELETE FROM forum WHERE forum_id = ?";

        template.update(sql, questionToDelete.getQuestion(), questionToDelete.getForum_id(), questionToDelete.getUser_id());
    }


//CHECK
    private Forum mapRowToForum(SqlRowSet result) {

        Forum retrievedForum = new Forum();

        retrievedForum.setForum_id(result.getInt("forum_id"));
        retrievedForum.setUser_id(result.getInt("user_id"));
        retrievedForum.setQuestion(result.getString("question"));

        return retrievedForum;
    }


}


