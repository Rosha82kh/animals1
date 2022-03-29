package com.example.animals;

public class Week extends Booking {
  private int  weekNo;
  private int  yearNo;


    public Week(int bookingNo, int custNo, int animalNo, int weekNo, int cageNO, int weekNo1, int yearNo) {
        super(bookingNo, custNo, animalNo, weekNo, cageNO);
        this.weekNo = weekNo1;
        this.yearNo = yearNo;
    }

    public Week(int weekNo, int yearNo) {
        this.weekNo = weekNo;
        this.yearNo = yearNo;
    }
    public Week() {
        this.weekNo = weekNo;
        this.yearNo = yearNo;
    }

    public Week(String name, String address, String phone, int bookingNo, int custNo, int animalNo, int weekNo, int cageNO, int weekNo1, int yearNo) {
        super(name, address, phone, bookingNo, custNo, animalNo, weekNo, cageNO);
        this.weekNo = weekNo1;
        this.yearNo = yearNo;
    }

    @Override
    public int getWeekNo() {
        return weekNo;
    }

    @Override
    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    public int getYearNo() {
        return yearNo;
    }

    public void setYearNo(int yearNo) {
        this.yearNo = yearNo;
    }
}

