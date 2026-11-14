package com.system.design.projects.MovieBookingSystem;

public class NormalSeat extends Seat{

    @Override
    public SeatType getSeatType() {
        return SeatType.NORMAL;
    }
}
