package Uberlld.model;

public class Cab {
    private final String id;

    private final String driverName;

    private Location location;

    private boolean isAvailable;

    private final VehicleType vehicleType;

    public Cab(String id, String driverName, VehicleType vehicleType, Location location) {
        this.id = id;
        this.driverName = driverName;
        this.vehicleType = vehicleType;
        this.location = location;
        this.isAvailable = true;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void assignedToRider(){
        isAvailable = false;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
