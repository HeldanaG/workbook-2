package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VehicleInventory {

    static Scanner input = new Scanner(System.in);
    static Vehicle[] vehicles = createdVehicles();

    public static void main(String[] args) {

        mainManu();

    }

    public static void mainManu() {

        boolean appRunning = true;
        while (appRunning) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ MAIN MENU~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("What do you want to do?\n" +
                    "1 - List all vehicles\n" +
                    "2 - Search by make/model\n" +
                    "3 - Search by price range\n" +
                    "4 - Search by color\n" +
                    "5 - Add a vehicle\n" +
                    "6 - Quit\n" +
                    "Enter your command:");

            try {
                int userChoice = input.nextInt();
                input.nextLine();

                switch (userChoice) {
                    case 1:
                        listAllVehicles();
                        break;
                    case 2:
                        findVehiclesByModel();
                        break;
                    case 3:
                        findVehiclesByPriceRange();
                        break;
                    case 4:
                        findVehicleByColor();
                        break;
                    case 5:
                        addVehicles();
                        break;
                    case 6:
                        appRunning = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.print("Please enter a number 1 - 6: ");
                        continue;

                }
                //return userChoice;
            } catch (InputMismatchException e) {
                System.out.print("Invalid Input! Please enter a number: ");
                input.nextLine();
                continue;
            }
        }
    }

    public static Vehicle[] createdVehicles() {

        return new Vehicle[]{

                new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500),
                new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000),
                new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700),
                new Vehicle(101124, "Honda Civic", "White", 70000, 7500),
                new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500),
                new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0),
                new Vehicle(0, "", "", 0, 0)

        };
    }

    public static void listAllVehicles() {

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LIST ALL VEHICLES ~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle ID: " + vehicle.getVehicleId() +
                    ", Make Model: " + vehicle.getMakeModel() +
                    ", Color: " + vehicle.getColor() +
                    ", Odometer Reading: " + vehicle.getOdometerReading() +
                    ", Price " + vehicle.getPrice());
        }
    }

    public static void findVehiclesByModel() {

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FIND VEHICLES BY MODEL ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        boolean appRunning = true;
        while (appRunning) {
            try {
                System.out.print("Enter the vehicle make: ");
                String vehicleMake = input.nextLine().trim();

                // Check if input is empty after trimming
                while (vehicleMake.isEmpty() || vehicleMake.matches("\\d+")) {
                    System.out.print("Invalid input. Please enter a valid vehicle make: ");
                    vehicleMake = input.nextLine().trim();
                }

                System.out.print("Enter the vehicle model: ");
                String vehicleModel = input.nextLine().trim();

                // Check if input is empty after trimming
                while (vehicleModel.isEmpty() || vehicleModel.matches("\\d+")) {
                    System.out.print("Invalid input. Please enter a valid vehicle model: ");
                    vehicleModel = input.nextLine().trim();
                }
                String addVehicleModel= vehicleMake + " " + vehicleModel;

                boolean found = false;

                // Loop through each vehicle
                for (int i = 0; i < vehicles.length; i++) {
                    if (addVehicleModel.equalsIgnoreCase(vehicles[i].getMakeModel())) {
                        System.out.println("Vehicle ID: " + vehicles[i].getVehicleId() +
                                ", Make Model: " + vehicles[i].getMakeModel() +
                                ", Color: " + vehicles[i].getColor() +
                                ", Odometer Reading: " + vehicles[i].getOdometerReading() +
                                ", Price " + vehicles[i].getPrice());
                        found = true;
                    }
                }
                    // ONLY after checking all cars, if no match found, show this message
                    if (!found) {
                        System.out.println("Sorry! Car Is Not In Inventory.");
                    }


                    System.out.print("Do you want to look for another car (y/n): ");
                        String lookAnotherCar = input.nextLine();

                        if (lookAnotherCar.equalsIgnoreCase("y")) {
                            continue;
                            // If user doesn't want to search again, stop the loop
                        } else if (lookAnotherCar.equalsIgnoreCase("n")) {
                            appRunning = false;
                        } else {
                            System.out.print("Invalid Input! Please Enter y or n: ");
                            lookAnotherCar = input.nextLine();

                            while(!(lookAnotherCar.equalsIgnoreCase("y") || lookAnotherCar.equalsIgnoreCase("n"))){
                                System.out.print("Invalid Input! Please Enter y or n: ");
                                lookAnotherCar = input.nextLine();

                                if (lookAnotherCar.equalsIgnoreCase("y")) {
                                    continue;
                                    // If user doesn't want to search again, stop the loop
                                } else {
                                    appRunning = false;
                                }
                            }
                        }


            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again.");
                input.nextLine();
                continue;
            }
        }
    }

    public static void findVehiclesByPriceRange() {

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FIND VEHICLES BY PRICE RANGE ~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Control variable to keep the program running until the user decides to exit
        boolean appRunning = true;

        // Start of the outer loop
        while (appRunning) {
            try {
                // Display vehicle price range options to the user
                System.out.println("Vehicle Price range Includes:\n" +
                        "1. $4,000 -  $7,999\n" +
                        "2. $8,000 - $9,999\n" +
                        "3. $10,000 - $11,999\n" +
                        "4. $12,000 - $14,999\n" +
                        "5. >= $15,000");

                // Prompt the user to select a price range
                System.out.print("Please Enter Your Choice: ");
                int priceRangeChoice = input.nextInt(); // Capture user's choice

                // Validate the user's input to make sure it's within 1 to 5
                while (priceRangeChoice < 1 || priceRangeChoice > 5) {
                    System.out.print("Incorrect Input! Please Choose from option 1 - 5 : ");
                    priceRangeChoice = input.nextInt();// Re-enter if invalid
                }


                // Variable to track whether any vehicles matched the selected price range
                boolean vehicleFound = false;

                // Loop through the vehicles array to check each vehicle's price
                for (int i = 0; i < vehicles.length; i++) {
                    double price = vehicles[i].getPrice(); // Get the current vehicle's price

                    // Check if the price falls into the selected price range
                    if ((priceRangeChoice == 1 && price >= 4000 && price <= 7999) ||
                            (priceRangeChoice == 2 && price >= 8000 && price <= 9999) ||
                            (priceRangeChoice == 3 && price >= 10000 && price <= 11999) ||
                            (priceRangeChoice == 4 && price >= 12000 && price <= 14999) ||
                            (priceRangeChoice == 5 && price >= 15000)) {

                        // Print vehicle details if it matches the selected range
                        System.out.println("Vehicle ID: " + vehicles[i].getVehicleId() +
                                ", Make Model: " + vehicles[i].getMakeModel() +
                                ", Color: " + vehicles[i].getColor() +
                                ", Odometer Reading: " + vehicles[i].getOdometerReading() +
                                ", Price $" + price);

                        vehicleFound = true; // Set flag to true when a match is found
                    }
                }

                // If no vehicle matched the selected price range, notify the user
                if (!vehicleFound) {
                    System.out.println("No vehicles found in this price range.");
                }

                input.nextLine();// Clear the input buffer
                // Ask the user if they want to search for another price range
                System.out.print("Do you want to search another price range? (y/n): ");
                String lookAnotherCar = input.nextLine(); // Capture response

                if (lookAnotherCar.equalsIgnoreCase("y")) {
                    continue;
                    // If user doesn't want to search again, stop the loop
                } else if (lookAnotherCar.equalsIgnoreCase("n")) {
                    appRunning = false;
                } else {
                    System.out.print("Invalid Input! Please Enter y or n: ");
                    lookAnotherCar = input.nextLine();
                    while(!(lookAnotherCar.equalsIgnoreCase("y") || lookAnotherCar.equalsIgnoreCase("n"))){
                        System.out.print("Invalid Input! Please Enter y or n: ");
                        lookAnotherCar = input.nextLine();

                        if (lookAnotherCar.equalsIgnoreCase("y")) {
                            continue;
                            // If user doesn't want to search again, stop the loop
                        } else {
                            appRunning = false;
                        }
                    }
                }

            } catch (Exception e) {
                // Handle invalid input errors (like letters instead of numbers)
                System.out.println("Invalid Input! Please Try Again.");
                input.nextLine(); // Clear the input buffer
            }
        }
    }

    public static void findVehicleByColor(){

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FIND VEHICLES BY COLOR ~~~~~~~~~~~~~~~~~~~~~~~~~~");

        boolean appRunning = true;
        while (appRunning) {
            try {
                System.out.print("Enter a vehicle color: ");
                String addVehicleColor = input.nextLine().trim();

                // Check if input is empty after trimming
                while (addVehicleColor.isEmpty() || addVehicleColor.matches("\\d+")) {
                    System.out.print("Invalid input. Please enter a valid vehicle Color: ");
                    addVehicleColor = input.nextLine().trim();
                }
                boolean found = false;
                // Loop through each vehicle
                for (int i = 0; i < vehicles.length; i++) {
                    if (addVehicleColor.equalsIgnoreCase(vehicles[i].getColor())) {
                        System.out.println("Vehicle ID: " + vehicles[i].getVehicleId() +
                                ", Make Model: " + vehicles[i].getMakeModel() +
                                ", Color: " + vehicles[i].getColor() +
                                ", Odometer Reading: " + vehicles[i].getOdometerReading() +
                                ", Price " + vehicles[i].getPrice());
                        found = true;
                    }
                }
                    // ONLY after checking all cars, if no match found, show this message
                    if (!found) {
                        System.out.println("Sorry! Car Is Not In Inventory.");
                    }
                    System.out.print("Do you want to look for another car (y/n): ");
                    String lookAnotherCar = input.nextLine();

                    if (lookAnotherCar.equalsIgnoreCase("y")) {
                        continue;
                        // If user doesn't want to search again, stop the loop
                    } else if (lookAnotherCar.equalsIgnoreCase("n")) {
                        appRunning = false;
                    } else {
                        System.out.print("Invalid Input! Please Enter y or n: ");
                        lookAnotherCar = input.nextLine();

                        while(!(lookAnotherCar.equalsIgnoreCase("y") || lookAnotherCar.equalsIgnoreCase("n"))){
                            System.out.print("Invalid Input! Please Enter y or n: ");
                            lookAnotherCar = input.nextLine();

                            if (lookAnotherCar.equalsIgnoreCase("y")) {
                                continue;
                                // If user doesn't want to search again, stop the loop
                            } else {
                                appRunning = false;
                            }
                        }
                    }
            }catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again.");
                input.nextLine();
                continue;
            }
        }
    }

    // Method to add a new vehicle to the inventory
    public static void addVehicles() {

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ADD VEHICLES ~~~~~~~~~~~~~~~~~~~~~~~~~~");

        boolean appRunning = true;  // Control variable for the loop
        while (appRunning) {
            try {
                System.out.println("Enter your vehicle information separately");

                boolean vehicleAdded = false;  // Flag to track if a vehicle was added

                // Loop through the vehicles array to find an empty slot
                for (int i = 0; i < vehicles.length; i++) {
                    // Check for an empty slot by verifying vehicleId is 0
                    if (vehicles[i].getVehicleId() == 0) {

                        // --- Vehicle ID input and validation ---
                        System.out.print("Enter your vehicle ID: ");
                        String inputVehicleId = input.nextLine().trim();
                        while (inputVehicleId.isEmpty() || !inputVehicleId.matches("\\d+") || inputVehicleId.length()<6) {
                            System.out.print("Invalid input. Please enter a valid 6 digit vehicle ID: ");
                            inputVehicleId = input.nextLine().trim();
                        }
                        long newVehicleId = Long.parseLong(inputVehicleId);

                        // --- Vehicle Make input and validation ---
                        System.out.print("Enter your vehicle Make: ");
                        String inputVehicleMake = input.nextLine().trim();
                        while (inputVehicleMake.isEmpty() || inputVehicleMake.matches("\\d+")) {
                            System.out.print("Invalid input. Please enter a valid vehicle Make: ");
                            inputVehicleMake = input.nextLine().trim();
                        }

                        // --- Vehicle Model input and validation ---
                        System.out.print("Enter your vehicle Model: ");
                        String inputVehicleModel = input.nextLine().trim();
                        while (inputVehicleModel.isEmpty() || inputVehicleModel.matches("\\d+")) {
                            System.out.print("Invalid input. Please enter a valid vehicle Model: ");
                            inputVehicleModel = input.nextLine().trim();
                        }

                        String newVehicleModel = capitalizeWords(inputVehicleMake) + " " + capitalizeWords(inputVehicleModel);  // Capitalize first letter of each word

                        // --- Vehicle Color input and validation ---
                        System.out.print("Enter your vehicle Color: ");
                        String inputVehicleColor = input.nextLine().trim();
                        while (inputVehicleColor.isEmpty() || inputVehicleColor.matches("\\d+")) {
                            System.out.print("Invalid input. Please enter a valid vehicle Color: ");
                            inputVehicleColor = input.nextLine().trim();
                        }
                        String newVehicleColor = capitalizeWords(inputVehicleColor);  // Capitalize first letter of each word

                        // --- Odometer Reading input and validation ---
                        System.out.print("Enter your vehicle Odometer Reading: ");
                        String inputVehicleOdometer = input.nextLine().trim();
                        while (inputVehicleOdometer.isEmpty() || !inputVehicleOdometer.matches("\\d+")) {
                            System.out.print("Invalid input. Please enter a valid Odometer Reading: ");
                            inputVehicleOdometer = input.nextLine().trim();
                        }
                        int newOdometer = Integer.parseInt(inputVehicleOdometer);

                        // --- Vehicle Price input and validation ---
                        System.out.print("Enter your vehicle Price: ");
                        String inputVehiclePrice = input.nextLine().trim();
                        while (inputVehiclePrice.isEmpty() || !inputVehiclePrice.matches("\\d+")) {
                            System.out.print("Invalid input. Please enter a valid vehicle Price: ");
                            inputVehiclePrice = input.nextLine().trim();
                        }
                        double newPrice = Double.parseDouble(inputVehiclePrice);

                        // --- Create new Vehicle object and store it in the array ---
                        vehicles[i] = new Vehicle(newVehicleId, newVehicleModel, newVehicleColor, newOdometer, newPrice);

                        vehicleAdded = true;  // Mark that a vehicle was successfully added
                        appRunning = false;   // Stop the outer while loop
                        break;  // Exit the for loop after adding one vehicle
                    }
                }

                // If no empty slots were found, inform the user that inventory is full
                if (!vehicleAdded) {
                    System.out.println("Sorry - Vehicle Inventory is full! Cannot add more vehicles.");
                    appRunning = false;
                }

            } catch (InputMismatchException e) {
                // Catch block for invalid numeric input — though we're already using regex validation
                System.out.println("Invalid Input! Please Try Again.");
                input.nextLine();  // Clear the input buffer
            }
        }

    }

    // chat gpt code- to make user input of vehicle model capitalized the beginning of the name
    public static String capitalizeWords(String input) {
        String[] words = input.trim().toLowerCase().split("\\s+");  // Split by spaces
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))  // Capitalize first char
                        .append(word.substring(1))                     // Append rest of word
                        .append(" ");                                   // Add space
            }
        }
        return capitalized.toString().trim();  // Remove extra space at end
    }

    // Method to remove the most recently added vehicle
    public static void removeLastVehicle() {
        // Start from the end of the array
        for (int i = vehicles.length - 1; i >= 0; i--) {
            if (vehicles[i].getVehicleId() != 0) {
                // Found the last added vehicle — reset its fields
                vehicles[i] = new Vehicle(0, "", "", 0, 0);
                System.out.println("Last entered vehicle has been removed.");
                return;  // Exit after removing one vehicle
            }
        }
        // If no vehicle was found
        System.out.println("No vehicles to remove.");
    }

}

