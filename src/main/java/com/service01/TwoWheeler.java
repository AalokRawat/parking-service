package com.service01;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aalokr on 12/8/17.
 */
public class TwoWheeler implements Vehicle {

    private long inTime;
    private String number;
    private String type="TwoWheeler";

    public TwoWheeler(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public long getInTime() {
        return inTime;
    }

    @Override
    public void setInTime(long timestamp) {
        this.inTime = timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        return number.equalsIgnoreCase(((Vehicle)obj).getNumber());
    }

    @Override
    public String toString() {
        return "TwoWheeler{" +
                "inTime=" + new Date(inTime).toString() +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}
