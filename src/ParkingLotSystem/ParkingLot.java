package ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Level> levels= new ArrayList<>();

    public void addLevel(Level level){
        levels.add(level);
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle){
        ParkingSpot availableSpot=null;
        for(Level level:levels){
            availableSpot=level.getAvailableSpot(vehicle);
            if(availableSpot!=null) break;
        }
        if(availableSpot==null){
            throw new RuntimeException("Parking is full");
        }
        return availableSpot;
    }

    public void unparkVehicle(Ticket ticket){
        ParkingSpot parkingSpot=ticket.getParkingSpot();
        parkingSpot.removeVehicle(ticket.vehicle);
    }

    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot availableSpot= findParkingSpot(vehicle);
        availableSpot.assignVehicle(vehicle);
        return new Ticket(vehicle,availableSpot);
    }
}
