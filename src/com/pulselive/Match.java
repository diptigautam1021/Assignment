package com.pulselive;

import java.util.Date;

public class Match {

    private LeagueTableEntry teamA;
    private LeagueTableEntry teamB;
    private int teamAScore;
    private int teamBScore;
    private Date date;


    public LeagueTableEntry getTeamA() {
        return teamA;
    }

    public LeagueTableEntry getTeamB() {
        return teamB;
    }

    public int getTeamAScore(){
        return teamAScore;
    }

    public int getTeamBScore(){
        return teamBScore;
    }

    public Date getDate() {
        return date;
    }

    public void setTeamA(LeagueTableEntry teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(LeagueTableEntry teamB) {
        this.teamB = teamB;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
