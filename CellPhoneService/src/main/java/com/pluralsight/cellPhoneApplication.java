package com.pluralsight;

import java.util.Scanner;



public class cellPhoneApplication {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        // initiating a class with myPhone variable
        cellPhone myPhone = new cellPhone();



        //myPhone.dial("855-555-2222");

        // set the cellPhone data directly from user input
        myPhone.setSerialNumber(Integer.parseInt(askQuestion("What is the serial number: ")));// since serialNumber is int, we parse it into integer when we receive input from user
        myPhone.setModel(askQuestion("What model is the phone: "));
        myPhone.setCarrier(askQuestion("Who is the carrier: "));
        myPhone.setPhoneNumber(askQuestion("hat is the phone number: "));
        myPhone.setOwner(askQuestion("Who is the owner of the phone: "));
/*
        // use the getter to display this information
        System.out.println("\nSerial number: " + myPhone.getSerialNumber());
        System.out.println("Model: " + myPhone.getModel());
        System.out.println("Carrier: " + myPhone.getCarrier());
        System.out.println("Phone number: " + myPhone.getPhoneNumber());
        System.out.println("Owner: " + myPhone.getOwner());
*/
        // second instance of cellphone object
        cellPhone myPhone2 = new cellPhone();

        // create our myphone 2 only with phone number and owner
        myPhone2.setPhoneNumber("852-555-5555");
        myPhone2.setOwner("Heldana");

        // display the content of both cellphone ( able to access with get-method)
        display(myPhone);
        display(myPhone2);


        myPhone.dial(myPhone2.getPhoneNumber());
        myPhone2.dial(myPhone.getPhoneNumber());


    }
    public static void display(cellPhone phone){
        System.out.println("\nSerial number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
    }
    // method to receive input from user
    public static String askQuestion(String question){
        System.out.print(question);
        String answer =input.nextLine();
        return answer.trim();
    }
}
