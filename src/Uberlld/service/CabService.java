package Uberlld.service;

import Uberlld.model.Cab;
import Uberlld.model.Location;
import Uberlld.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class CabService {
    private final List<Cab> cabs= new ArrayList<>();

    public void registerCab(String id, String driverName, Location location, VehicleType vehicleType){
        cabs.add(new Cab(id,driverName,vehicleType,location));
    }

    public Cab findNearestAvailable(Location riderLocation, VehicleType vehicleType){
        double minDistance = Double.MAX_VALUE;
        Cab nearestCab=null;
        for(Cab cab: cabs){
            if(cab.isAvailable() && cab.getVehicleType()==vehicleType){
               double distance =cab.getLocation().distanceTo(riderLocation);
                if(distance < minDistance){
                    nearestCab = cab;
                }
            }
        }
        return nearestCab;
    }
}
