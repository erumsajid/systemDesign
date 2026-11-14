package com.system.design.projects.MovieBookingSystem;

public class MovieBooking implements BookingService{
    NotificationService notificationService;
    PaymentService paymentService;
    @Override
    public Booking createBooking(Booking booking, String paymentStrategy) {
        return null;
    }

    @Override
    public Booking getBooking(int bookingId) {
        return null;
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        return false;
    }

    @Override
    public Booking getUserBookings(String userId) {
        return null;
    }
}
