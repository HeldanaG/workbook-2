package com.pluralsight;

import java.util.Scanner;

public class HighScoreWins {
    public static void main(String[] args) {

        String gameInfo=" ";
        String [] teamsAndScore;
        String [] teamsDivide;
        String [] scoreDivide;
        String scores;
        String teams=" ";
        String team1=" ";
        String team2=" ";
        int team1Score=0;
        int team2Score=0;

        Scanner input = new Scanner(System.in);

        // asking user for game information
        System.out.print("Enter team name and score (Team1:Team2|Team1Score:Team2Score): ");
        gameInfo=input.nextLine().trim();

        // separating game and score by |
        teamsAndScore =gameInfo.split("\\|");

        // separating teams from teamsAndScore since the teams name is on [0]
        teams=teamsAndScore[0];
        teamsDivide=teams.split(":");
        team1=teamsDivide[0];
        team2=teamsDivide[1];

        // separating score from teamsAndScore since the score is on [1]
        scores=teamsAndScore[1];
        scoreDivide=scores.split(":");
        team1Score=Integer.parseInt(scoreDivide[0]);
        team2Score=Integer.parseInt(scoreDivide[1]);

        // printing results
        if (team1Score > team2Score){
            System.out.println("Winner:"+ team1);
        }else {
            System.out.println("Winner:"+ team2);
        }

    }
}
