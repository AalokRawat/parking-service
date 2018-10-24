package com.service01;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aalokr on 12/8/17.
 */

@RestController
public class ParkingService {
    Park park = new Park();

    @RequestMapping(value = "/parkService/in", method = RequestMethod.POST)
    String doParking(@RequestBody Form form){
        Vehicle vehicle = VehicleFactory.create(form.getNumber(), form.getType());
        return park.in(vehicle);
    }

    @RequestMapping("/parkService/out")
    long doExit(@RequestBody Form form){
        Vehicle vehicle = VehicleFactory.create(form.getNumber(), form.getType());
        return park.exit(vehicle);
    }
}
