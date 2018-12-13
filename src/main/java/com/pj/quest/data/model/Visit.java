package com.pj.quest.data.model;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AutoProperty
public class Visit {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate date;
    private final String homeTeam;
    private final int homeGoals;
    private final int awayGoals;
    private final String awayTeam;

    public Visit(LocalDate date, String homeTeam, int homeGoals, int awayGoals, String awayTeam) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.awayTeam = awayTeam;
    }

    public String getDate() {
        return date.format(formatter);
    }

    public LocalDate getDateAsDate() {
        return date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public String getAwayTeam() {
        return awayTeam;
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
}