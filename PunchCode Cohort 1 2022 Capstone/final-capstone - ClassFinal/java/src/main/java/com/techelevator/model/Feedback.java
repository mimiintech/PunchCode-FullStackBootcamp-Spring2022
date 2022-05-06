package com.techelevator.model;

public class Feedback {
    private int feedback_id;
    private int forum_id;
    private int user_id;
    private String answer;

    public Feedback() { }

    public Feedback(int feedback_id, int forum_id, int user_id, String answer) {
        this.feedback_id = feedback_id;
        this.forum_id = forum_id;
        this.user_id = user_id;
        this.answer = answer;
    }

//Feedback_Id

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }


// Forum_Id

    public int getForum_id() {
        return forum_id;
    }

    public void setForum_id(int forum_id) {
        this.forum_id = forum_id;
    }


//   Users_Id

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


//    Answer


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
