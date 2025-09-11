package com.company;

interface Ride{
    Double calculateFare(int distance);
    String getVehicleType();
}

interface Driver{
    void acceptRide();
    void endRide();
}

class BikeRide implements Ride{
    @Override
    public Double calculateFare(int distance) {
        return distance * 10.0;
    }

    @Override
    public String getVehicleType(){
        return "Bike";
    }
}

class CarRide implements Ride{
    @Override
    public Double calculateFare(int distance){
        return distance * 20.0;
    }

    @Override
    public String getVehicleType(){
        return "Car";
    }
}

class LuxuryRide implements Ride{
    @Override
    public Double calculateFare(int distance){
        return distance * 30.0;
    }

    @Override
    public String getVehicleType(){
        return "Luxury";
    }
}

class BikeDriver implements Driver{
    @Override
    public void acceptRide(){
        System.out.println("Bike ride is accepted.");
    }

    @Override
    public void endRide(){
        System.out.println("Bike ride is ended.");
    }
}

class CarDriver implements Driver{
    @Override
    public void acceptRide(){
        System.out.println("Car ride is accepted.");
    }

    @Override
    public void endRide(){
        System.out.println("Car ride is ended.");
    }
}

class LuxuryDriver implements Driver{
    @Override
    public void acceptRide(){
        System.out.println("Luxury ride is accepted.");
    }

    @Override
    public void endRide(){
        System.out.println("Luxury ride is ended.");
    }
}

class Trip implements Ride, Driver{
    private Ride ride;
    private Driver driver;
    private int distance;

    public Trip(Ride ride, Driver driver, int distance){
        this.ride = ride;
        this.driver = driver;
        this.distance = distance;
    }

    public Double calculateFare(int distance){
        return ride.calculateFare(distance);
    }

    @Override
    public String getVehicleType(){
        return ride.getVehicleType();
    }

    @Override
    public void acceptRide(){
        driver.acceptRide();
    }

    @Override
    public void endRide() {
        driver.endRide();
    }

    public void startTrip(){
        System.out.println("Starting a " + getVehicleType() + " ride for distance: " + distance + " km.");
        acceptRide();

        System.out.println("Total Fare: ₹" + calculateFare(distance));
        endRide();
        System.out.println();
    }
}
public class RideHailing {
    public static void main(String[] args) {
        Trip bikeTrip = new Trip(new BikeRide(), new BikeDriver(), 15);
        bikeTrip.startTrip();

        Trip carTrip = new Trip(new CarRide(), new CarDriver(), 15);
        carTrip.startTrip();

        Trip luxuryTrip = new Trip(new LuxuryRide(), new LuxuryDriver(), 15);
        luxuryTrip.startTrip();
    }
}

