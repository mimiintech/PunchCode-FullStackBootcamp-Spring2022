package com.techelevator.model;


/**
 * Puppy
 */
public class Puppy {
    private int id;
    private String name;
    private int weight;
    private String gender;
    private boolean paperTrained;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Puppy() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isPaperTrained() {
        return paperTrained;
    }

    public void setPaperTrained(boolean paperTrained) {
        this.paperTrained = paperTrained;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Puppy(String name, int weight, String gender, boolean paperTrained, String image) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
        this.paperTrained = paperTrained;
        this.image = image;
    }

    public Puppy(int id, String name, int weight, String gender, boolean paperTrained, String image) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.gender = gender;
        this.paperTrained = paperTrained;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Puppy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", paperTrained=" + paperTrained +
                ", image='" + image + '\'' +
                '}';
    }
}