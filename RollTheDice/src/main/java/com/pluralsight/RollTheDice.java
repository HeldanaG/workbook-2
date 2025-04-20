package com.pluralsight;

public class RollTheDice {
    public static void main(String[] args) {

        // variable declaration
        int roll1;
        int roll2;
        int count2=0;
        int count4=0;
        int count6=0;
        int count7=0;
        int sumRolls=0;

        // intiating an object
        Dice dice =new Dice();

        // loop that iterate 100 times
        for (int i=0; i <100; i++){

            // calling dice method from Dice class two times
            roll1= dice.roll();
            roll2= dice.roll();

            sumRolls= roll1+roll2;

            // displaying output of roll with it's sum
            System.out.println("Roll "+ i +":  " + roll1 + " - "+ roll2 + " " + "  Sum: "+sumRolls);

            // using switch to increment counters
            switch (sumRolls){
                case 2: count2 ++;
                case 4: count4 ++;
                case 6: count6 ++;
                case 7: count7++;
                default: break;
            }
        }
        // displaying the result of counters
        System.out.println("\nSum of rolls that gave 2 is: "+count2);
        System.out.println("Sum of rolls that gave 4 is: "+count4);
        System.out.println("Sum of rolls that gave 6 is: "+count6);
        System.out.println("Sum of rolls that gave 7 is: "+count7);

    }
}
