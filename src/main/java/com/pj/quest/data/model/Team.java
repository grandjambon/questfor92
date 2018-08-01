package com.pj.quest.data.model;

public class Team {

    private final String name;
    private boolean visited92Club = false;
    private boolean visitedWithCity = false;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVisited92Club(){
        this.visited92Club = true;
    }

    public boolean getVisited92Club() {
        return visited92Club;
    }

    public void setVisitedWithCity(){
        this.visitedWithCity = true;
    }

    public boolean getVisitedWithCity() {
        return visitedWithCity;
    }
}
