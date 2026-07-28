package Uberlld.strategyPattern;

import Uberlld.model.Location;
import Uberlld.model.VehicleType;

public class VehicleTypePricingStrategy implements  PricingStrategy{


    @Override
    public double calculateFare(Location from, Location to, VehicleType vehicleType) {
        double baseRatePerKm;

        switch (vehicleType){
            case BIKE -> baseRatePerKm = 2.0;
            case SUV -> baseRatePerKm = 10.0;
            case AUTO -> baseRatePerKm = 4.0;
            case SEDAN -> baseRatePerKm = 8.0;
            default -> baseRatePerKm = 1.0;
        }

        double distance = from.distanceTo(to);

        return baseRatePerKm*distance;
    }
}
