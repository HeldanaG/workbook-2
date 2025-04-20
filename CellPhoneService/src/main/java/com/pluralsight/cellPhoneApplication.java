package com.pluralsight;

import java.util.Scanner;



public class cellPhoneApplication {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        // initiating a class with myPhone variable
        cellPhone myPhone = new cellPhone();

        // set the cellPhone data directly from user input
        System.out.println("Phone no 1 information input");
        myPhone.setSerialNumber(Integer.parseInt(askQuestion("What is the serial number: ")));// since serialNumber is int, we parse it into integer when we receive input from user
        myPhone.setModel(askQuestion("What model is the phone: "));
        myPhone.setCarrier(askQuestion("Who is the carrier: "));
        myPhone.setPhoneNumber(askQuestion("hat is the phone number: "));
        myPhone.setOwner(askQuestion("Who is the owner of the phone: "));

        // second instance of cellphone object
        cellPhone myPhone2 = new cellPhone();

        // create our myphone 2 only with phone number and owner
        myPhone2.setPhoneNumber("852-555-5555");
        myPhone2.setOwner("Heldana");

        // Third instance of cellphone object
        cellPhone myPhone3 = new cellPhone (0, "", "", "", "");

        myPhone3.setSerialNumber(333);
        myPhone3.setModel("huwawi");
        myPhone3.setCarrier("Tele");
        myPhone3.setPhoneNumber("000-000-0000");
        myPhone3.setOwner("GuduCasa");



        // display the content of both cellphone ( able to access with get-method)
        System.out.println("\nPhone no 1 information output " );
        display(myPhone);

        System.out.println("\nPhone no 2 information output " );
        display(myPhone2);

        System.out.println("\nPhone no 3 information output " );
        display(myPhone3);

        // dialing from different object
        myPhone.dial(myPhone2.getPhoneNumber());
        myPhone2.dial(myPhone.getPhoneNumber());
        myPhone3.dial(myPhone.getPhoneNumber());






        }
    public static void display(cellPhone phone){
        System.out.println("Serial number: " + phone.getSerialNumber());
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
