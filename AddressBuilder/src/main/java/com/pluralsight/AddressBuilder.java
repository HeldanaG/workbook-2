package com.pluralsight;
import java.util.Scanner;
public class AddressBuilder {

    // declaring scanner as static so that we can use it in different methods
    static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {

        // ask user their name
        System.out.println("Please provide the following information");
        String fullName=askQuestion("Full name:");

        // creating billing/ shipping address string builder so that we can append user input directly
        StringBuilder billingAdress =new StringBuilder();
        StringBuilder shippingAdress = new StringBuilder();

        // appending user input directly to billing address string builder by following the format
        billingAdress.append(askQuestion("\nBilling Street:"));
        billingAdress.append("\n");
        billingAdress.append(askQuestion("Billing city:"));
        billingAdress.append(",");
        billingAdress.append(askQuestion("Billing State:"));
        billingAdress.append(" ");
        billingAdress.append(askQuestion("Billing Zip:"));

        // checking if billing address is the same with shipping address (inspired by David Lisk)
        System.out.print("\nIs your Billing Address the same with Shipping Address:");
        String answer = input.nextLine();

        // checking if billing address is same if it does print billing address for both shipping and billing if not ask for shipping address
        if (answer.equals("yes")){
            System.out.println("\nFull Name: "+ fullName);
            System.out.println("\nBilling Address:\n"+ billingAdress);
            System.out.println("\nShipping Address:\n"+ billingAdress);
        }else {

            // appending user input directly to shipping address string builder by following the format
            shippingAdress.append(askQuestion("\nShipping Street:"));
            shippingAdress.append("\n");
            shippingAdress.append(askQuestion("Shipping city:"));
            shippingAdress.append(",");
            shippingAdress.append(askQuestion("Shipping State:"));
            shippingAdress.append(" ");
            shippingAdress.append(askQuestion("Shipping Zip:"));

            // printing out final output
            System.out.println("\nFull Name: "+ fullName);
            System.out.println("\nBilling Address:\n"+ billingAdress);
            System.out.println("\nShipping Address:\n"+ shippingAdress);
        }
    }
    // method to ask questions (inspired by Eric/instructor)
    public static String askQuestion(String question){
        System.out.print(question);
        String answer =input.nextLine();
        return answer.trim();

    }
}
