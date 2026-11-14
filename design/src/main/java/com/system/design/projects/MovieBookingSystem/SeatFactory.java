package com.system.design.projects.MovieBookingSystem;

public  class SeatFactory {
    public Seat createSeat(SeatType seatType){
        if(seatType.equals(SeatType.NORMAL)){
            return new NormalSeat();
        }
        return new NormalSeat();
    }
}
