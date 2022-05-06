package com.techelevator.model;

public class Forum {

    private int forum_id;
    private int user_id;
    private String question;

    public Forum() { }

    public Forum(int forum_id, int users_id, String question) {
        this.forum_id = forum_id;
        this.user_id = users_id;
        this.question = question;
    }

//    Forum_Id

    public int getForum_id() {
        return forum_id;
    }

    public void setForum_id(int forum_id) {
        this.forum_id = forum_id;
    }


//    User_Id

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


//    Question


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

