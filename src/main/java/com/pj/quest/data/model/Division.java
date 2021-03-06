package com.pj.quest.data.model;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

@AutoProperty
public class Division {

    private final int level;
    private final String name;

    private final Collection<Team> teams = new TreeSet<>(Comparator.comparing(Team::getName));

    public Division(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Collection<Team> getTeams() {
        return teams;
    }

    public int getNinetyTwoClubTotal() {
        return (int)teams.stream().filter(Team::getVisited92Club).count();
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
