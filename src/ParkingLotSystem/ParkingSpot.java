package ParkingLotSystem;

public class ParkingSpot {
    int id;
    SpotType spotType;
    boolean occupied;
    Vehicle vehicle;

    public ParkingSpot(int id, SpotType spotType) {
        this.id = id;
        this.spotType = spotType;
        this.occupied = false;
        this.vehicle = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        if(spotType.name().equalsIgnoreCase(vehicle.vehicleType.name()) && !occupied){
            return true;
        }
        return false;
    }
    public void assignVehicle(Vehicle vehicle){
        occupied=true;
        this.vehicle=vehicle;
    }

    public void removeVehicle(Vehicle vehicle){
        occupied=false;
        this.vehicle=null;
    }
}
