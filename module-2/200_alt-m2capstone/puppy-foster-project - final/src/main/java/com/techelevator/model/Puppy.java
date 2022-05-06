package com.techelevator.model;

public class Puppy {

    private int puppyId;
    private String puppyName;
    private int weight;
    private String gender;
    private String breed;
    private boolean paperTrained;

    public Puppy(int puppyId, String puppyName, int weight, String gender, String breed, boolean paperTrained) {
        this.puppyId = puppyId;
        this.puppyName = puppyName;
        this.weight = weight;
        this.gender = gender;
        this.breed = breed;
        this.paperTrained = paperTrained;
    }

    public Puppy(String puppyName, int weight, String gender, String breed, boolean paperTrained) {
        this.puppyName = puppyName;
        this.weight = weight;
        this.gender = gender;
        this.breed = breed;
        this.paperTrained = paperTrained;
    }

    public int getPuppyId() {
        return puppyId;
    }

    // setPuppyId because data source will generate this for us.

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", paperTrained=" + paperTrained;
    }
}
