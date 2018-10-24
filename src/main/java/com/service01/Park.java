package com.service01;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aalokr on 12/10/17.
 */
public class Park {

    static ArrayList<Vehicle> twoWheelerParking = new ArrayList<>();
    static ArrayList<Vehicle> fourWheelerParking = new ArrayList<>();

    public synchronized String in(Vehicle vehicle){
        if(alreadyExist(vehicle)){
            return "Error: The vehicle with number " + vehicle.getNumber() + " already parked. call the cops";
        }

        if(checkAvalability(vehicle)){
            add(vehicle);
            vehicle.setInTime(System.currentTimeMillis());
            return vehicle.toString();
        }

        return "Sorry parking is full.";
    }

    public synchronized long exit(Vehicle vehicle){
        Vehicle originalVehicle = get(vehicle);
        long duration = System.currentTimeMillis()-originalVehicle.getInTime();
        remove(vehicle);
        return charges(vehicle, duration);
    }

    private boolean checkAvalability(Vehicle vehicle){
        if(vehicle.getType().equalsIgnoreCase("TwoWheeler")){
            return twoWheelerParking.size()<Capacity.TWO_WHEELER_CAPACITY;
        } else{
            return fourWheelerParking.size()<Capacity.FOUR_WHEELER_CAPACITY;
        }
    }

    private void add(Vehicle vehicle){
        if(vehicle.getType().equalsIgnoreCase("TwoWheeler")){
            twoWheelerParking.add(vehicle);
        } else {
            fourWheelerParking.add(vehicle);
        }
    }

    private void remove(Vehicle vehicle){
        if(vehicle.getType().equalsIgnoreCase("TwoWheeler")){
            twoWheelerParking.remove(vehicle);
        } else {
            fourWheelerParking.remove(vehicle);
        }
    }

    private Vehicle get (Vehicle vehicle){
        if(vehicle.getType().equalsIgnoreCase("TwoWheeler")) {
            int i = twoWheelerParking.indexOf(vehicle);
            return twoWheelerParking.get(i);
        } else {
            int i = fourWheelerParking.indexOf(vehicle);
            return fourWheelerParking.get(i);
        }
    }

    private long charges(Vehicle vehicle, long duration){
        long hours = duration/3600000;
        long minutes = duration / 60000 % 60;
        if(vehicle.getType().equalsIgnoreCase("TwoWheeler")) {
            return hours * Charges.TWO_WHEELER_CHARGES_PER_HOUR + ((minutes * Charges.TWO_WHEELER_CHARGES_PER_HOUR) / 60);
        } else {
            return hours*Charges.FOUR_WHEELER_CHARGES_PER_HOUR+((minutes*Charges.FOUR_WHEELER_CHARGES_PER_HOUR)/60);
        }
    }

    private boolean alreadyExist(Vehicle vehicle){
        return twoWheelerParking.contains(vehicle) || fourWheelerParking.contains(vehicle);
    }
}
