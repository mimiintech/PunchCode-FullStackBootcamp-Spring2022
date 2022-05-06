package com.techelevator.model;

public class Puppy {

    private int puppyId;
    private String puppyName;
    private int weight;
    private String sex;
    private String breed;
    private boolean paperTrained;
    private String fact;

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getPuppyId() {
        return puppyId;
    }

    public void setPuppyId(int puppyId) {
        this.puppyId = puppyId;
    }

    public String getPuppyName() {
        return puppyName;
    }


    public void setPuppyName(String puppyName) {
        this.puppyName = puppyName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isPaperTrained() {
        return paperTrained;
    }

    public void setPaperTrained(boolean paperTrained) {
        this.paperTrained = paperTrained;
    }

    @Override
    public String toString() {
        return "Pupper Info: " +
                "puppyId=" + puppyId +
                ", puppyName='" + puppyName + '\'' +
                ", weight=" + weight +
                ", gender='" + sex + '\'' +
                ", breed='" + breed + '\'' +
                ", paperTrained=" + paperTrained;
    }
}
