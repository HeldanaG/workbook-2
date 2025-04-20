package com.pluralsight;

public class cellPhone {

    // these are the properties/ variables that describe a cellPhone
    private int serialNumber;
    private String model;
    private String carrier;
    private String phoneNumber;
    private String owner;


    public cellPhone(int serialNum, String model, String carrier, String phoneNumber, String owner){
        this.serialNumber = serialNumber;
        this.model = model;
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.owner =owner;
    }
    //this is decided the values for the properties
    public cellPhone() {
        this.serialNumber = 0;
        this.model = "";
        this.carrier = "";
        this.phoneNumber = "";
        this.owner = "";
    }

    public void dial(String phoneNumber){
        System.out.println( this.getOwner() +"'s phone is calling " + phoneNumber);
    }
    public void dial(cellPhone phoneNumber){
        System.out.println( this.getOwner() +"'s phone is calling " + phoneNumber.getPhoneNumber());
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }




}
