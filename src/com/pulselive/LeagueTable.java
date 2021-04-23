package com.pulselive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class LeagueTable implements LeagueInterface{

    private final int numberOfClubs;

    private final ArrayList<LeagueTableEntry> league;
    private final Scanner scanner;
    private final ArrayList<Match> matches;

    public LeagueTable(int numberOfClubs) {

        this.numberOfClubs = numberOfClubs;
        league = new ArrayList<>();
        matches = new ArrayList<>();
        scanner = new Scanner(System.in);
        displayMenu();
    }


    public void displayMenu() {

        while(true) {
            System.out.println("***************************************** ");
            System.out.println("League App: ");
            System.out.println("***************************************** ");
            System.out.println("Create new team and add it to league (press 1)");
            System.out.println("Delete existing team from league (press 2)");
            System.out.println("Display Statistics for team (press 3)");
            System.out.println("Display the League Table (press 4)");
            System.out.println("Add a Played Match (press 5)");
            String line = scanner.nextLine();
            int command = 0;
            try {
                command = Integer.parseInt(line);
            } catch (Exception e) {
            }

            switch(command) {
                case 1 :
                    addTeam();
                    break;
                case 2 :
                    deleteTeam();
                    break;
                case 3 :
                    displayStatistics();
                    break;
                case 4 :
                    getTableEntries();
                    break;
                case 5:
                    addPlayedMatch();
                    break;
                default:
                    System.out.println("Wrong Command");
            }

        }
    }

    public void addTeam(){
        if(league.size() == numberOfClubs) {
            System.out.println("Can't add more clubs to league");
            return;
        }

        LeagueTableEntry club = new LeagueTableEntry();
        System.out.println("Insert Club Name: ");
        String line = scanner.nextLine();
        club.setTeamName(line);

        if(league.contains(club)){
            System.out.println("Given club already register in the league");
            return;
        }
        league.add(club);
    }

    public void deleteTeam() {
        System.out.println("Insert club name: ");
        String line = scanner.nextLine();
        for(LeagueTableEntry club : league) {
            if(club.getTeamName().equals(line)){
                league.remove(club);
                System.out.println("Club "+ club.getTeamName()+" removed");
                return;
            }
        }
        System.out.println("Given club already register in the league");
    }

    public void displayStatistics() {

        System.out.println("Insert club name: ");
        String line = scanner.nextLine();
        for (LeagueTableEntry club : league) {
            if(club.getTeamName().equals(line)){
                System.out.println("Club " + club.getTeamName()+ " matches played: " + club.getPlayed());
                System.out.println("Club " + club.getTeamName()+ " matches won: " + club.getWon());
                System.out.println("Club " + club.getTeamName()+ " matches lost: " + club.getLost());
                System.out.println("Club " + club.getTeamName()+ " matches draw: " + club.getDrawn());
                System.out.println("Club " + club.getTeamName()+ " scored goals For: " + club.getGoalsFor());
                System.out.println("Club " + club.getTeamName()+ " recieved goals Against: " + club.getGoalsAgainst());
                System.out.println("Club " + club.getTeamName()+ " points: " + club.getPoints());
                return;
            }
        }
        System.out.println("No such club in league");
    }

    public void getTableEntries() {

        Collections.sort(league, new CustomComparator());
        for(LeagueTableEntry club : league) {
            System.out.println("Club: " + club.getTeamName()+" Points: "+ club.getPoints()+" goal difference: "+ (club.getGoalsFor()-club.getGoalsAgainst()));
        }
    }

    public void addPlayedMatch(){
        System.out.println("Enter date (format mm-dd-yyyy): ");
        String line = scanner.nextLine();
        Date date;
        try {
            date = new SimpleDateFormat("MM-dd-yyyy").parse(line);
        } catch (ParseException ex) {
            System.out.println("You have to enter date in format mm-dd-yyyy");
            return;
        }
        System.out.println("Enter Home Team: ");
        line = scanner.nextLine();
        LeagueTableEntry home = null;
        for(LeagueTableEntry club : league){
            if(club.getTeamName().equals(line))
                home = club;
        }
        if (home == null) {
            System.out.println("No such club in league");
            return;
        }
        System.out.println("Enter Away Team: ");
        line = scanner.nextLine();
        LeagueTableEntry away = null;
        for(LeagueTableEntry club : league){
            if(club.getTeamName().equals(line))
                away = club;
        }
        if (away == null) {
            System.out.println("No such club in league");
            return;
        }

        System.out.println("Enter home team goals: ");
        line = scanner.nextLine();
        int homeGoals = -1;
        try {
            homeGoals = Integer.parseInt(line);
        } catch (Exception e) {
        }
        if (homeGoals == -1) {
            System.out.println("You have to enter number of goals");
            return;
        }

        System.out.println("Enter away team goals: ");
        line = scanner.nextLine();
        int awayGoals = -1;
        try {
            awayGoals = Integer.parseInt(line);
        } catch (Exception e) {
        }
        if (awayGoals == -1) {
            System.out.println("You have to enter number of goals");
            return;
        }


        Match match = new Match();
        match.setDate(date);
        match.setTeamA(home);
        match.setTeamB(away);
        match.setTeamAScore(awayGoals);
        match.setTeamBScore(homeGoals);
        matches.add(match);
        home.setGoalsFor(home.getGoalsFor()+homeGoals);
        away.setGoalsFor(away.getGoalsFor()+awayGoals);
        home.setGoalsAgainst(home.getGoalsAgainst()+awayGoals);
        away.setGoalsAgainst(away.getGoalsAgainst()+homeGoals);
        home.setPlayed(home.getPlayed()+1);
        away.setPlayed(away.getPlayed()+1);

        if (homeGoals > awayGoals) {
            home.setPoints(home.getPoints()+3);
            home.setWon(home.getWon()+1);
            away.setLost(away.getLost()+1);
        }

        else if (homeGoals < awayGoals) {
            away.setPoints(away.getPoints()+3);
            away.setWon(away.getWon()+1);
            home.setLost(home.getLost()+1);
        }
        else {
            home.setPoints(home.getPoints()+1);
            away.setPoints(away.getPoints()+1);
            home.setDrawn(home.getDrawn()+1);
            away.setDrawn(away.getDrawn()+1);
        }
    }
}
