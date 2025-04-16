package com.pluralsight;
import java.util.*;
public class FullNameApplication {
    public static void main(String[] args) {

        //declaring variable
        String first="";
        String last="";
        String middle="";
        String suffix="";
        String fullName="";

        // Scanner declaration to accept input from keyboard
        Scanner input = new Scanner(System.in);

        // asking user information separately and assigning to a variable accordingly
        System.out.println("Please enter your name.");

        System.out.print("First name: ");
        first=input.nextLine();

        System.out.print("Middle name: ");
        middle= input.nextLine();

        System.out.print("Last name: ");
        last=input.nextLine();

        System.out.print("Suffix: ");
        suffix=input.nextLine();

        // condition to determine what to output based on user input
        if (middle.isEmpty() && suffix.isEmpty()) {
            fullName = first + " " + last;
        } else if (middle.isEmpty()) {
            fullName = first + " " + last + ", " + suffix;
        } else if (suffix.isEmpty()) {
            fullName = first + " " + middle + " " + last;
        } else {
            fullName = first + " " + middle + " " + last + ", " + suffix;
        }
        // printing out final output
        System.out.println("\nFull name: " + fullName);


    }
}
