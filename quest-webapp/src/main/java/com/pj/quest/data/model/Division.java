package com.pj.quest.data.model;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

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
}
