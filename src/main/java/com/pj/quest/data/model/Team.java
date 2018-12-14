package com.pj.quest.data.model;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class Team {

    private final String name;
    private boolean visited92Club = false;
    private boolean visitedWithCity = false;

    private boolean isFormerGround = false;

    private Visit visit;

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

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public int hashCode() {
        return Pojomatic.hashCode(this);
    }

    public boolean equals(Object other) {
        return Pojomatic.equals(this, other);
    }

    public String toString() {
        return Pojomatic.toString(this);
    }

    public boolean getIsFormerGround() {
        return isFormerGround;
    }

    public void setIsFormerGround(boolean formerGround) {
        isFormerGround = formerGround;
    }
}
