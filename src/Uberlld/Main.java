package Uberlld;

import Uberlld.model.*;
import Uberlld.service.BookingService;
import Uberlld.service.CabService;
import Uberlld.service.RiderService;
import Uberlld.strategyPattern.PricingStrategy;
import Uberlld.strategyPattern.VehicleTypePricingStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args){
        RiderService riderService = new RiderService();
        CabService cabService = new CabService();
        PricingStrategy strategy = new VehicleTypePricingStrategy();

        BookingService bookingService = new BookingService(cabService, strategy);

        Rider rider = riderService.registerRider("r1","Lava");
        Location pickup = new Location(10,10);
        rider.setCurrentLocation(pickup);

        Location destinationLocation = new Location(20,20);

        cabService.registerCab("c1","One",new Location(11,11), VehicleType.AUTO);
        cabService.registerCab("c2","Two",new Location(11,14), VehicleType.AUTO);
        cabService.registerCab("c3","Three",new Location(13,16), VehicleType.BIKE);
        cabService.registerCab("c4","four",new Location(12,17), VehicleType.SUV);
        cabService.registerCab("c5","Five",new Location(15,18), VehicleType.SEDAN);

        System.out.println("Fare Estimation");
        List<VehicleFareEstimate>  estimates = bookingService.showAvailableVehicleType(pickup, destinationLocation);
        for(VehicleFareEstimate e: estimates){
            System.out.println("-" + e);
        }

        VehicleType selectedVehicleType = VehicleType.SEDAN;

        Booking booking;
        try{
            booking = bookingService.bookCab(rider, selectedVehicleType, destinationLocation);
        }catch(RuntimeException e){
            System.out.println("Booking Failed "+ e.getMessage() );
            return;
        }
        bookingService.startRide(booking);
        System.out.println("Ride is in progress");

        for(int i=1;i<=5;i++){
            System.out.println("After Direction Move Left" + i + "Meters");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Reached destination Ending Ride");

        bookingService.endRide(booking);

        System.out.println("Final Summary");

        booking.summary();


    }
}
