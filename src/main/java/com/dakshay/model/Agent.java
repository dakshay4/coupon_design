package com.dakshay.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dakshay on 9/22/2018.
 */
@Entity
@Table(name = "travel_agent")
public class Agent {
    //Personal
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column
    private String agentUserName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="mobile_no")
    private Long mobileNo;
    @Column(name="res_address_line1")
    private String resAddressLine1;
    @Column(name="res_address_line2")
    private String resAddressLine2;
    @Column(name="phone_no")
    private Long phoneNo;
    @Column(name="email")
    private String email;
    @Column(name="res_city")
    private String resCity;
    @Column(name="res_state")
    private String resState;
    @Column(name="res_country")
    private String resCountry;
    @Column(name="res_pin_code")
    private Integer resPinCode;

    //Business
    @Column(name="agency_name")
    private String agencyName;
    @Column(name = "pan")
    private String pan;
    @Column(name="agency_address_line1")
    private String agencyAddressLine1;
    @Column(name="agency_address_line2")
    private String agencyAddressLine2;
    @Column(name="agency_city")
    private String agencyCity;
    @Column(name="agency_state")
    private String agencyState;
    @Column(name="agency_country")
    private String agencyCountry;
    @Column(name="agency_pin_code")
    private Integer agencyPinCode;
    @Column(name="agency_phone_no")
    private Long agencyPhoneNo;
    @Column(name="business_type")
    private String businessType;        //enum
    @Column(name="is_iata_registered")
    private String isIataRegistered;
    @Column(name="years")
    private Integer years;

    //GST
    @Column(name="gst_classification")
    private String gstClassification;   //enum
    @Column(name="agency_gst")
    private String agencyGst;
    @Column(name="agency_state_code")
    private String agencyStateCode;
    @Column(name="contact_person_name")
    private String contactPersonName;
    @Column(name="contact_person_contact")
    private String contactPersonMobile;
    @Column(name="contact_person_email")
    private String contactPersonEmail;@Column(name = "status")
    private String status;
    @Column(name = "registration_date")
    private Date registrationDate;

    public Agent() {
    }

    public Agent(Long id, String agentUserName, String firstName, String lastName, Long mobileNo, String resAddressLine1, String resAddressLine2, Long phoneNo, String email, String resCity, String resState, String resCountry, Integer resPinCode, String agencyName, String pan, String agencyAddressLine1, String agencyAddressLine2, String agencyCity, String agencyState, String agencyCountry, Integer agencyPinCode, Long phoneNo1, String businessType, String isIataRegistered, Integer years, String gstClassification, String agencyGst, String agencyStateCode, String contactPersonName, String contactPersonMobile, String contactPersonEmail, String status, Date registrationDate) {
        this.id = id;
        this.agentUserName = agentUserName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.resAddressLine1 = resAddressLine1;
        this.resAddressLine2 = resAddressLine2;
        this.phoneNo = phoneNo;
        this.email = email;
        this.resCity = resCity;
        this.resState = resState;
        this.resCountry = resCountry;
        this.resPinCode = resPinCode;
        this.agencyName = agencyName;
        this.pan = pan;
        this.agencyAddressLine1 = agencyAddressLine1;
        this.agencyAddressLine2 = agencyAddressLine2;
        this.agencyCity = agencyCity;
        this.agencyState = agencyState;
        this.agencyCountry = agencyCountry;
        this.agencyPinCode = agencyPinCode;
        this.phoneNo = phoneNo1;
        this.businessType = businessType;
        this.isIataRegistered = isIataRegistered;
        this.years = years;
        this.gstClassification = gstClassification;
        this.agencyGst = agencyGst;
        this.agencyStateCode = agencyStateCode;
        this.contactPersonName = contactPersonName;
        this.contactPersonMobile = contactPersonMobile;
        this.contactPersonEmail = contactPersonEmail;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentUserName() {
        return agentUserName;
    }

    public void setAgentUserName(String agentUserName) {
        this.agentUserName = agentUserName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getResAddressLine1() {
        return resAddressLine1;
    }

    public void setResAddressLine1(String resAddressLine1) {
        this.resAddressLine1 = resAddressLine1;
    }

    public String getResAddressLine2() {
        return resAddressLine2;
    }

    public void setResAddressLine2(String resAddressLine2) {
        this.resAddressLine2 = resAddressLine2;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResCity() {
        return resCity;
    }

    public void setResCity(String resCity) {
        this.resCity = resCity;
    }

    public String getResState() {
        return resState;
    }

    public void setResState(String resState) {
        this.resState = resState;
    }

    public String getResCountry() {
        return resCountry;
    }

    public void setResCountry(String resCountry) {
        this.resCountry = resCountry;
    }

    public Integer getResPinCode() {
        return resPinCode;
    }

    public void setResPinCode(Integer resPinCode) {
        this.resPinCode = resPinCode;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAgencyAddressLine1() {
        return agencyAddressLine1;
    }

    public void setAgencyAddressLine1(String agencyAddressLine1) {
        this.agencyAddressLine1 = agencyAddressLine1;
    }

    public String getAgencyAddressLine2() {
        return agencyAddressLine2;
    }

    public void setAgencyAddressLine2(String agencyAddressLine2) {
        this.agencyAddressLine2 = agencyAddressLine2;
    }

    public String getAgencyCity() {
        return agencyCity;
    }

    public void setAgencyCity(String agencyCity) {
        this.agencyCity = agencyCity;
    }

    public String getAgencyState() {
        return agencyState;
    }

    public void setAgencyState(String agencyState) {
        this.agencyState = agencyState;
    }

    public String getAgencyCountry() {
        return agencyCountry;
    }

    public void setAgencyCountry(String agencyCountry) {
        this.agencyCountry = agencyCountry;
    }

    public Integer getAgencyPinCode() {
        return agencyPinCode;
    }

    public void setAgencyPinCode(Integer agencyPinCode) {
        this.agencyPinCode = agencyPinCode;
    }

    public Long getAgencyPhoneNo() {
        return agencyPhoneNo;
    }

    public void setAgencyPhoneNo(Long agencyPhoneNo) {
        this.agencyPhoneNo = agencyPhoneNo;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getIsIataRegistered() {
        return isIataRegistered;
    }

    public void setIsIataRegistered(String isIataRegistered) {
        this.isIataRegistered = isIataRegistered;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public String getGstClassification() {
        return gstClassification;
    }

    public void setGstClassification(String gstClassification) {
        this.gstClassification = gstClassification;
    }

    public String getAgencyGst() {
        return agencyGst;
    }

    public void setAgencyGst(String agencyGst) {
        this.agencyGst = agencyGst;
    }

    public String getAgencyStateCode() {
        return agencyStateCode;
    }

    public void setAgencyStateCode(String agencyStateCode) {
        this.agencyStateCode = agencyStateCode;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonMobile() {
        return contactPersonMobile;
    }

    public void setContactPersonMobile(String contactPersonMobile) {
        this.contactPersonMobile = contactPersonMobile;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
