package Uberlld.model;

import java.time.LocalDateTime;

public class Booking {
    private final Rider rider;
    private final Cab cab;

    private final Location pickupLocation;

    private final Location dropLocation;

    private final LocalDateTime bookingTime;

    private LocalDateTime rideStartTime;

    private LocalDateTime rideEndTime;

    private double fare;

    private BookingStatus status;

    public Booking(Rider rider, Cab cab, Location pickupLocation, Location dropLocation, double fare) {
        this.rider = rider;
        this.cab = cab;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.bookingTime = LocalDateTime.now();
        this.fare = fare;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Rider getRider() {
        return rider;
    }

    public Cab getCab() {
        return cab;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public LocalDateTime getRideStartTime() {
        return rideStartTime;
    }

    public void setRideStartTime(LocalDateTime rideStartTime) {
        this.rideStartTime = rideStartTime;
    }

    public LocalDateTime getRideEndTime() {
        return rideEndTime;
    }

    public void setRideEndTime(LocalDateTime rideEndTime) {
        this.rideEndTime = rideEndTime;
    }

    public void summary(){
        System.out.println("Booking Summary");
        System.out.println("rider:"+ rider.getName());
        System.out.println("Driver:"+ cab.getDriverName());
        System.out.println("Pickup:"+ pickupLocation +"-> Drop:" + dropLocation );
        System.out.println("Vehicle:" + cab.getVehicleType());
        System.out.println("Fare:" + fare);
        System.out.println("Time:" + bookingTime);
    }
}
