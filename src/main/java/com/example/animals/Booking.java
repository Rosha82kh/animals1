package com.example.animals;

public class Booking extends customers{
   private int bookingNo;
   private int custNo;
   private int animalNo;
   private int weekNo;
   private int cageNO;

    public Booking(int bookingNo, int custNo, int animalNo, int weekNo, int cageNO) {
        this.bookingNo = bookingNo;
        this.custNo = custNo;
        this.animalNo = animalNo;
        this.weekNo = weekNo;
        this.cageNO = cageNO;
    }
    public Booking() {
        this.bookingNo = bookingNo;
        this.custNo = custNo;
        this.animalNo = animalNo;
        this.weekNo = weekNo;
        this.cageNO = cageNO;
    }

    public Booking(String name, String address, String phone, int bookingNo, int custNo, int animalNo, int weekNo, int cageNO) {
        super(name, address, phone);
        this.bookingNo = bookingNo;
        this.custNo = custNo;
        this.animalNo = animalNo;
        this.weekNo = weekNo;
        this.cageNO = cageNO;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
    }

    public int getCustNo() {
        return custNo;
    }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }

    public int getAnimalNo() {
        return animalNo;
    }

    public void setAnimalNo(int animalNo) {
        this.animalNo = animalNo;
    }

    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    public int getCageNO() {
        return cageNO;
    }

    public void setCageNO(int cageNO) {
        this.cageNO = cageNO;
    }
}
