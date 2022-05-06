package com.techelevator.dao;


import com.techelevator.model.Feedback;
import com.techelevator.model.Forum;

import java.util.List;


public interface FeedbackDao {

  void createAnswer(int forumId, int userId, Feedback answerToAdd);

    List<Feedback> getAllAnswers();

    Feedback getAnswer(int id);

    void updateAnswer(int id, Feedback answerToUpdate);

    void deleteAnswer(Feedback answerToDelete);

}

