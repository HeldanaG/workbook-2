package com.pluralsight;

public class TestStatistics {
    public static void main(String[] args) {

        double [] testScores={78,65,94,82,36.8,75,64.5,65,99,64};

        // declaring variables
        double highScore=testScores[0];
        double lowScore=testScores[0];
        double totalScore=0;
        double average=0;
        double medianNum=0;

        // for loop to iterate through each value to do needed operation
        for (int i =0; i < testScores.length;i++){

            //accumulating the total of scores by adding each value
            totalScore +=testScores[i];

            // if statement to find the highest score
            if (highScore < testScores[i] ){
                highScore = testScores[i];
            }
            // if statement to find the lowest score
            if ( lowScore > testScores[i]){
                lowScore = testScores[i];
            }
        }
        // determining the average and median numbers of the scores
        average =totalScore/testScores.length;
        medianNum=(testScores[(testScores.length/2)-1] + testScores[testScores.length/2])/2;

        // outputting results
        System.out.println("Highest: " + highScore);
        System.out.println("Lowest: " + lowScore);
        System.out.println("Total: " + totalScore);
        System.out.println("Average: " + average);
        System.out.println("Median: " + medianNum);
        
    }
}
