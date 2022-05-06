package com.techelevator.model;

public class CatCards {

    private long catCardId;
    private String name;
    private String imgUrl;
    private String catFact;
    private String caption;

//    Getters
    public long getCatCardId() {
        return catCardId;
    }

    public String getName() {return name;}

    public String getImgUrl() {return imgUrl;}

    public String getCatFact() {return catFact;}

    public String getCaption() {
        return caption;
    }

//    Setters
    public void setCatCardId(int catCardId) {
        this.catCardId = catCardId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setCatFact(String catFact) {
        this.catFact = catFact;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}



