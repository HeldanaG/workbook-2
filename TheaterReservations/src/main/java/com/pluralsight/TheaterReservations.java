package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {
        // Declaring variables for later to use
        String fullName="";
        String outPutName=" ";
        String dateShow="";
        int numTicket=0;
        LocalDate reserveDate=null;
        boolean appRunning=true;

        // Declaring scanner class to accept input from user
        Scanner input =new Scanner(System.in);

        // asking user full name and assigning to a variable called " fullName"

        System.out.print("Enter your full name: ");
        fullName=input.nextLine().trim();

        // asking user reservation date and validating if they provide correct date type
        while (appRunning) {
            try {
                // asking user the reserve date and assigning to a variable called " dateShow"
                System.out.print("Enter the date of the show you want to reserve (MM/DD/YYYY): ");
                dateShow = input.nextLine();

                // interpreting the date format and assigning the default format to a variable called " reserveDate"
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                reserveDate = LocalDate.parse(dateShow, formatter);

                // if user provide correct date type this will terminate the while loop
                appRunning=false;
            }catch (DateTimeParseException e){
                // output to user if they didn't provide correct date type and asking user try again
                System.out.println("Try Again! you didn't follow the provided date format");
            }
        }

        // asking how many tickets user need and assigning to variable called "numTicket"
        System.out.print("Enter how many tickets you want: ");
        numTicket=input.nextInt();

        // validation to ask user not to provide invalid input
        while (numTicket <=0){
            System.out.println("Try again!You have to buy at-least 1 ticket to make reservation");
            System.out.print("Enter how many tickets you want: ");
            numTicket=input.nextInt();
        }

        // determining the output based on how many tickets needed
        if (numTicket >1){
            System.out.println(numTicket + " Tickets reserved for "+ reserveDate + " under "+ name(fullName));
        }else {
            System.out.println(numTicket + " Ticket reserved for "+ reserveDate + " under "+ name(fullName));
        }
    }
    
    // method to split full name and rearrange name
    public static String  name(String fullName){
        String[] nameSeparator;
        String firstName=" ";
        String lastName=" ";

        nameSeparator=fullName.split(" ");
        firstName=nameSeparator[0];
        lastName=nameSeparator[1];

        return lastName + ", "+ firstName;
    }
}
