package com.service01;

/**
 * Created by aalokr on 12/8/17.
 */
public class VehicleFactory {

    static Vehicle create(String number, String type){
        if(type.equalsIgnoreCase("TwoWheeler")){
            return new TwoWheeler(number);
        } else {
            return new FourWheeler(number);
        }
    }
}
