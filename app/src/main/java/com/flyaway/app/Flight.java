package com.flyaway.app;

/**
 * Created by Yvonne on 10/15/2017.
 */

public class Flight {

    private String flightNumber;
    private String startTime;
    private String endTime;
    private String desLoc;
    private String departLoc;
    private String price;
    private String flightCompany;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDesLoc() {
        return desLoc;
    }

    public void setDesLoc(String desLoc) {
        this.desLoc = desLoc;
    }

    public String getDepartLoc() {
        return departLoc;
    }

    public void setDepartLoc(String departLoc) {
        this.departLoc = departLoc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }
}
