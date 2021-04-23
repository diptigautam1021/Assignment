package com.pulselive;

public class LeagueTableEntry {

    private String teamName;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int points;



    public String getTeamName() {
        return teamName;
    }

    public int getWon(){
        return won;
    }

    public int getDrawn() {
        return drawn;
    }

    public int getLost(){
        return lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public int getPlayed() {
        return played;
    }

    public void setTeamName(String s) {
        this.teamName = s;
    }

    public void setWon(int i) {
        won=i;
    }

    public void setDrawn(int i){
        drawn = i;
    }

    public void setLost(int i) {
        lost=i;
    }

    public void setGoalsFor(int i){
        goalsFor = i;
    }

    public void setGoalsAgainst(int i){
        goalsAgainst = i;
    }

    public void setPoints(int i){
        points = i;
    }

    public void setPlayed(int i){
        played = i;
    }

    @Override
    public boolean equals(Object o) {
        return this.teamName.equals(((LeagueTableEntry)o).teamName);
    }
}
