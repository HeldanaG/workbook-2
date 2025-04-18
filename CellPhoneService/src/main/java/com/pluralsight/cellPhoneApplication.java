package com.pluralsight;

import java.util.Scanner;

public class cellPhoneApplication {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        // initiating a class with myPhone variable
        cellPhone myPhone = new cellPhone();

        // set the cellPhone data directly from user input
        myPhone.setSerialNumber(Integer.parseInt(askQuestion("What is the serial number: ")));// since serialNumber is int, we parse it into integer when we receive input from user
        myPhone.setModel(askQuestion("What model is the phone: "));
        myPhone.setCarrier(askQuestion("Who is the carrier: "));
        myPhone.setPhoneNumber(askQuestion("hat is the phone number: "));
        myPhone.setOwner(askQuestion("Who is the owner of the phone: "));

        // use the getter to display this information
        System.out.println("\nSerial number: " + myPhone.getSerialNumber());
        System.out.println("Model: " + myPhone.getModel());
        System.out.println("Carrier: " + myPhone.getCarrier());
        System.out.println("Phone number: " + myPhone.getPhoneNumber());
        System.out.println("Owner: " + myPhone.getOwner());

    }
    // method to receive input from user
    public static String askQuestion(String question){
        System.out.print(question);
        String answer =input.nextLine();
        return answer.trim();
    }
}
