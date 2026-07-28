package Uberlld.service;

import Uberlld.model.*;
import Uberlld.strategyPattern.PricingStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private final CabService cabService;
    //private final RiderService riderService;
    private final PricingStrategy pricingStrategy;

    public BookingService(CabService cabService,  PricingStrategy pricingStrategy) {
        this.cabService = cabService;
        //this.riderService = riderService;
        this.pricingStrategy = pricingStrategy;
    }

    public List<VehicleFareEstimate> showAvailableVehicleType(Location from, Location to){
        List<VehicleFareEstimate> estimates = new ArrayList<>();
        for(VehicleType type: VehicleType.values()){
            double fare = pricingStrategy.calculateFare(from, to, type);
            double roundedFare = BigDecimal.valueOf(fare).setScale(2, RoundingMode.HALF_UP).doubleValue();
            estimates.add(new VehicleFareEstimate(type,roundedFare));
        }
        return estimates;
    }

    public Booking bookCab(Rider rider, VehicleType vehicleType, Location dropLocation){
        Cab cab = cabService.findNearestAvailable(rider.getCurrentLocation(),vehicleType);
        if(cab == null) throw new RuntimeException("No available cab for the" + vehicleType);
        cab.assignedToRider();
        double fare = pricingStrategy.calculateFare(rider.getCurrentLocation(),dropLocation,cab.getVehicleType());
        Booking booking = new Booking(rider, cab, rider.getCurrentLocation(), dropLocation,fare);
        booking.setStatus(BookingStatus.CREATED);
        return booking;
    }

    public void startRide(Booking booking){
        booking.setStatus(BookingStatus.STARTED);
        booking.setRideStartTime(LocalDateTime.now());
        System.out.println("Ride Started");

    }

    public void endRide(Booking booking){
        booking.setStatus(BookingStatus.ENDED);
        booking.setRideEndTime(LocalDateTime.now());

        //Final Fare
        double finalFare = pricingStrategy.calculateFare(booking.getPickupLocation(), booking.getDropLocation(), booking.getCab().getVehicleType());
        System.out.println("Ride Ended");

    }

}
