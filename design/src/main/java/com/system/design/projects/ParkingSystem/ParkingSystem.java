package com.system.design.projects.ParkingSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ParkingSystem {
    private final List<ParkingSlot> parkingSlotList;
    private final HashMap<Integer,BookingSlot> bookingSlots;
    ParkingSystem parkingSystem;
    private ParkingSystem(List<ParkingSlot> parkingSlotList, HashMap<Integer,BookingSlot> bookingSlots){
        this.parkingSlotList = parkingSlotList;
        this.bookingSlots = bookingSlots;
    }
    synchronized ParkingSystem getParkingSystemInstance(List<ParkingSlot> parkingSlotList){
        if(parkingSystem==null){
            return parkingSystem = new ParkingSystem(parkingSlotList,new HashMap<>());
        }
        return parkingSystem;

    }
    private Optional<ParkingSlot> findParkingSlot(VEHICLETYPE parkingtype){
        return parkingSlotList.stream().filter(parkingSlot -> {return parkingSlot.getType().equals(parkingtype) && parkingSlot.isVacant();}).findFirst();
    }
    BookingSlot bookParkingSlot(BookingSlot bookingSlot){
        Optional<ParkingSlot> parkingSlot = findParkingSlot(bookingSlot.vehicle.getVehicleType());
        if(parkingSlot.isPresent()){
            parkingSlot.get().setVehicleId(bookingSlot.vehicle.getVehicleNo());
            bookingSlot.paymentStatus = PaymentStatus.PENDING;
            bookingSlot.status = STATUS.PARKED;
            bookingSlot.parkingSlot = parkingSlot.get();
            addBooking(bookingSlot);
        }
        return null;
    }
    public void exitParking(int bookingNo,PaymentStrategy paymentStrategy){
        BookingSlot bookingSlot = bookingSlots.get(bookingNo);
        bookingSlot.parkingSlot.setVehicleId(0);
        double charge  = getParkingFees(bookingSlot.vehicle.getVehicleType()).getParkingAmountPerMinute();
        paymentStrategy.initiatePayment(charge);
        bookingSlot.status = STATUS.EXIT;
        bookingSlot.paymentStatus = PaymentStatus.COMPLETED;
    }

    public ParkingFeeStrategy getParkingFees(VEHICLETYPE parkingtype){
        return ParkingFeeFactory.getFeeStrategy(parkingtype);
    }
    public void addBooking(BookingSlot bookingSlot){
        bookingSlots.put(bookingSlot.bookingNo,bookingSlot);
    }

}
