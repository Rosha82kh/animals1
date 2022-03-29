package com.example.animals;

public class Animals extends customers {
    private int animalNo;
    private String animalName;
    private String animalType;
    private String animalGender;
    private String animalComment;

    public Animals(int animalNo, String animalName, String animalType, String animalGender, String animalComment) {
        this.animalNo = animalNo;
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.animalComment = animalComment;
    }
    public Animals() {
        this.animalNo = animalNo;
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.animalComment = animalComment;
    }

    public Animals(String name, String address, String phone, int animalNo, String animalName, String animalType, String animalGender, String animalComment) {
        super(name, address, phone);
        this.animalNo = animalNo;
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.animalComment = animalComment;
    }

    public int getAnimalNo() {
        return animalNo;
    }

    public void setAnimalNo(int animalNo) {
        this.animalNo = animalNo;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalGender() {
        return animalGender;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public String getAnimalComment() {
        return animalComment;
    }

    public void setAnimalComment(String animalComment) {
        this.animalComment = animalComment;
    }
}
