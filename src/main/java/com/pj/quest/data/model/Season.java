package com.pj.quest.data.model;


import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

@AutoProperty
public class Season {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String name;

    private final Collection<Team> teams = new TreeSet<>(new TeamComparator());

    public Season(int startYear, String name) {
        this.startDate = LocalDate.of(startYear, Month.JULY, 1);
        this.endDate = LocalDate.of(startYear+1, Month.JUNE, 30);
        this.name = name;
    }

    public boolean acceptActive(Team team) {
        LocalDate date = team.getVisit().getDateAsDate();

        Comparator<LocalDate> comparator = Comparator.naturalOrder();

        if (comparator.compare(startDate, date) <= 0 && comparator.compare(endDate, date) >= 0) {
            teams.add(team);
            return true;
        }
        return false;
    }

    public boolean acceptFormer(Team team) {
        return false;
    }

    public Collection<Team> getTeams() {
        return new ArrayList<>(teams);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getName() {
        return name;
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

    private static final class TeamComparator implements Comparator<Team> {
        @Override
        public int compare(Team t1, Team t2) {
            LocalDate date1 = t1.getVisit().getDateAsDate();
            LocalDate date2 = t2.getVisit().getDateAsDate();

            int i = date1.compareTo(date2);
            if (i != 0)
                return i;

            return t1.getName().compareTo(t2.getName());
        }
    }
}
