package ParkingLotSystem;

public class Driver {
    public static void main() {
        ParkingLot parkingLot= new ParkingLot();
        Level level=new Level(1);

        level.addSpot(new ParkingSpot(101,SpotType.BIKE));
        level.addSpot(new ParkingSpot(102,SpotType.TRUCK));
        level.addSpot(new ParkingSpot(103,SpotType.CAR));
        level.addSpot(new ParkingSpot(104,SpotType.BIKE));

        parkingLot.addLevel(level);

        //create vehicles
        Vehicle Bike= new Bike("UP65BG5862");
        Vehicle Car= new Car("UP65BG5867");
        Vehicle Truck= new Truck("UP65BG5866");
        Vehicle Bike1= new Bike("UP65BG5962");

        //park vehicle
        System.out.println("=========Parking Vehicle======");
        Ticket t1=parkingLot.parkVehicle(Bike);
        System.out.println("Bike parked: Ticket ID "+t1.getId()+" "+t1.getParkingSpot().getId());
    }
}
