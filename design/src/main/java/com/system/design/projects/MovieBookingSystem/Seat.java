package com.system.design.projects.MovieBookingSystem;

public abstract class Seat {
    String id;
    private int seatNo;
    private SeatStatus status;
    public abstract SeatType getSeatType();
    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }


}
