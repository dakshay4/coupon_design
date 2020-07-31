package com.dakshay.request;


import java.util.Date;

/**
 * Created by Dakshay on 12/24/2018.
 */
public class FlightSearchRequest {
    private String bookingType;
    private String origin;
    private String destination;
    private Date fromDate;
    private Date toDate;
    private String classType;
    private String airlineCode;
    private Integer adultCount;
    private Integer childCount;
    private Integer infantCount;
    private Boolean residentofIndia;
    private Integer optional1;
    private Integer optional2;
    private Integer optional3;

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public Integer getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(Integer adultCount) {
        this.adultCount = adultCount;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Integer getInfantCount() {
        return infantCount;
    }

    public void setInfantCount(Integer infantCount) {
        this.infantCount = infantCount;
    }

    public Boolean getResidentofIndia() {
        return residentofIndia;
    }

    public void setResidentofIndia(Boolean residentofIndia) {
        this.residentofIndia = residentofIndia;
    }

    public Integer getOptional1() {
        return optional1;
    }

    public void setOptional1(Integer optional1) {
        this.optional1 = optional1;
    }

    public Integer getOptional2() {
        return optional2;
    }

    public void setOptional2(Integer optional2) {
        this.optional2 = optional2;
    }

    public Integer getOptional3() {
        return optional3;
    }

    public void setOptional3(Integer optional3) {
        this.optional3 = optional3;
    }
}
