package com.example.animals;

public class Cage {
    private int cageNo;
    private String cageType;

    public Cage(int cageNo, String cageType) {
        this.cageNo = cageNo;
        this.cageType = cageType;
    }
    public Cage() {
        this.cageNo = cageNo;
        this.cageType = cageType;
    }
    public int getCageNo() {
        return cageNo;
    }

    public void setCageNo(int cageNo) {
        this.cageNo = cageNo;
    }

    public String getCageType() {
        return cageType;
    }

    public void setCageType(String cageType) {
        this.cageType = cageType;
    }
}
