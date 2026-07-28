package Uberlld.strategyPattern;

import Uberlld.model.Location;
import Uberlld.model.VehicleType;

public interface PricingStrategy {

    double calculateFare(Location from, Location to, VehicleType vehicleType);
}
