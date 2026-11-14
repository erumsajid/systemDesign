package com.system.design.projects.MovieBookingSystem;

public interface BookingService {
    Booking createBooking(Booking booking,String paymentStrategy);
    Booking getBooking(int bookingId);
    boolean cancelBooking(int bookingId);
    Booking getUserBookings(String userId);
}
