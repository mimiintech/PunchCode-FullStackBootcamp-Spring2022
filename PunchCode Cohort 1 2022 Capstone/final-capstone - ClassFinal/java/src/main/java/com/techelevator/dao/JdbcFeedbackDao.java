package com.techelevator.dao;


import javax.sql.DataSource;
import com.techelevator.exceptions.FeedbackNotFoundException;
import com.techelevator.model.Feedback;
import com.techelevator.model.Forum;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.SqlCall;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcFeedbackDao implements FeedbackDao {
    private final JdbcTemplate template;

    public JdbcFeedbackDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

//  CHECK
    @Override
    public void createAnswer(int forumId, int userId, Feedback answerToAdd) {

        String sql = "INSERT INTO feedback (forum_id, user_id, answer)" +
                "VALUES (?, ?, ?)";
        template.update(sql, answerToAdd.getAnswer(), answerToAdd.getUser_id(), answerToAdd.getFeedback_id(), answerToAdd.getForum_id());
    }


//        CHECK
@Override
    public List<Feedback> getAllAnswers() {

        ArrayList<Feedback> answers = new ArrayList<>();

        String sql = "SELECT * FROM feedback";

        SqlRowSet results = template.queryForRowSet(sql);
        while (results.next()) {
        answers.add(mapRowToFeedback(results));
        }
        return answers;
        }



//CHECK
@Override
public Feedback getAnswer(int id) {

        Feedback answer;
        String sql = "SELECT answer FROM feedback WHERE forum_id = ?";
        SqlRowSet result = template.queryForRowSet(sql, id);
        if (result.next()) {
            answer = mapRowToFeedback(result);
        } else {
        throw new FeedbackNotFoundException();
        }
        return answer;
        }


//CHECK
@Override
    public void updateAnswer(int id, Feedback answerToUpdate) {

        String sql = "UPDATE feedback SET answer = ? WHERE user_id = ?";

        template.update(sql,answerToUpdate.getAnswer(), answerToUpdate.getUser_id(), answerToUpdate.getFeedback_id(), answerToUpdate.getForum_id());

        }


//        CHECK
    @Override
    public void deleteAnswer(Feedback answerToDelete) {

        String sql = "DELETE FROM feedback WHERE forum_id = ?";

        template.update(sql, answerToDelete.getAnswer(), answerToDelete.getForum_id(), answerToDelete.getFeedback_id(), answerToDelete.getUser_id());
        }

//        CHECK
    private Feedback mapRowToFeedback(SqlRowSet result) {

        Feedback retrievedFeedback = new Feedback();

        retrievedFeedback.setFeedback_id(result.getInt("feedback_id"));
        retrievedFeedback.setForum_id(result.getInt("forum_id"));
        retrievedFeedback.setUser_id(result.getInt("user_id"));
        retrievedFeedback.setAnswer(result.getString("answer"));

        return retrievedFeedback;
        }


}
