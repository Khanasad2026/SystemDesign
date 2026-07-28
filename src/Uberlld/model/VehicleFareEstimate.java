package Uberlld.model;

public class VehicleFareEstimate {
    private final VehicleType vehicleType;
    private final double estimatedPrice;

    public VehicleFareEstimate(VehicleType vehicleType, double estimatedPrice) {
        this.vehicleType = vehicleType;
        this.estimatedPrice = estimatedPrice;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getEstimatedPrice() {
        return estimatedPrice;
    }

    @Override
    public String toString(){
        return vehicleType + "  -$"+ estimatedPrice;
    }
}
