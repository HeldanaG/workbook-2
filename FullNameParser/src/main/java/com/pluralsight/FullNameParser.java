package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {

        //declaring variable
        String first="";
        String last="";
        String middle="";
        String noMiddle="(none)";
        String name="";
        String [] fullName;
        boolean appRunning=true;

        // Scanner declaration to accept input from keyboard
        Scanner input = new Scanner(System.in);

        // to ask again if user didn't provide enough information
        while (appRunning) {
            // asking for full name and assigning to variable called "name"
            System.out.print("Please enter your name: ");
            name = input.nextLine().trim();

            // split the full name on space and assigning to an array variable called " fullname"
            fullName = name.split(" ");

            // assigning splitted name from the array to a string variable based on the index
            if (fullName.length == 3) {
                first = fullName[0];
                middle = fullName[1];
                last = fullName[2];

                // printing out the assigned variable
                System.out.println("First name: " + first);
                System.out.println("Middle name: " + middle);
                System.out.println("Last name: " + last);

                // to break the loop if user provide enough information
                appRunning=false;
            } else if (fullName.length == 2) {
                first = fullName[0];
                last = fullName[1];

                System.out.println("First name: " + first);
                System.out.println("Middle name: " + noMiddle);
                System.out.println("Last name: " + last);

                // to break the loop if user provide enough information
                appRunning=false;
            } else {
                System.out.println("Your input is not correct. please try again!");
            }


        }
    }
}
