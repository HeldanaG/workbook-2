package com.pluralsight;

public class ForLoop  {
    public static void main(String[] args) throws InterruptedException{


        // displaying countdown using for loop
        for (int i =10; i >0;i--){
            System.out.println(i);
            // sleep time to delay an output by 1000 milli second
            Thread.sleep(1000);

        }
        System.out.println("Launch");

    }
}
