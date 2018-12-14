package com.pj.quest.data;

import com.pj.quest.data.model.Team;
import com.pj.quest.data.model.Visit;

import java.time.LocalDate;

public class TeamTestUtils {

    public final static Team manCity;
    public final static Team sheffUtd;
    public final static Team liverpool;
    public final static Team stockportCounty;
    public final static Team astonVilla;
    public final static Team everton;

    static {
        manCity = new Team("Manchester City");
        manCity.setVisit(new Visit(LocalDate.of(1987, 4, 15), "Man City", 1, 1, "Spurs"));

        sheffUtd = new Team("Sheffield United");
        sheffUtd.setVisit(new Visit(LocalDate.of(1992, 2, 4), "Sheff Utd", 4, 2, "Man City"));

        astonVilla = new Team("Aston Villa");
        astonVilla.setVisit(new Visit(LocalDate.of(1991, 12, 1), "Aston Villa", 3, 1, "Man City"));

        everton = new Team("Everton");
        everton.setVisit(new Visit(LocalDate.of(1992, 4, 13), "Everton", 1, 2, "Man City"));

        liverpool = new Team("Liverpool");
        liverpool.setVisit(new Visit(LocalDate.of(1982, 10, 3), "Liverpool", 0, 0, "Man Utd"));

        stockportCounty = new Team("Stockport County");
        stockportCounty.setVisit(new Visit(LocalDate.of(1989, 9, 30), "Stockport", 0, 0, "QPR"));
    }

}
