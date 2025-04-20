package com.pluralsight;
import  java.util.*;

public class Dice {

    public int roll(){

        Random num = new Random();
         int randomNumber =num.nextInt(1,6);
         return randomNumber;

    }
}
