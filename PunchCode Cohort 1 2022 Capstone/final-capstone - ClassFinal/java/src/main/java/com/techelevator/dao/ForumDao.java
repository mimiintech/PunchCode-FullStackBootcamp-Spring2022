package com.techelevator.dao;

import com.techelevator.model.Forum;
import java.util.List;

public interface ForumDao {



    List<Forum> getAllQuestions();

    Forum getQuestion(int id);

    void createQuestion(Forum questionToAdd);

    void deleteQuestion(int id, Forum questionToDelete);

    void updateQuestion(int id, Forum questionToUpdate);

}

