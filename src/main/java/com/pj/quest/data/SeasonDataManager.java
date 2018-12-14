package com.pj.quest.data;

import com.pj.quest.data.model.Season;
import com.pj.quest.data.model.Team;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class SeasonDataManager {

    public Collection<Season> getSeasons(Collection<Team> visits, Collection<Team> formerGrounds) {
        Map<String, Season> seasons = new HashMap<>();

        for (Team team : visits) {
            LocalDate date = team.getVisit().getDateAsDate();
            String seasonString = getSeasonString(date);
            Season season = seasons.computeIfAbsent(seasonString, s -> new Season(getStartYear(date), seasonString));
            season.acceptActive(team);
        }

        for (Team team : formerGrounds) {
            LocalDate date = team.getVisit().getDateAsDate();
            String seasonString = getSeasonString(date);
            Season season = seasons.computeIfAbsent(seasonString, s -> new Season(getStartYear(date), seasonString));
            season.acceptActive(team);
        }

        return seasons.values().stream().sorted(comparing(Season::getStartDate)).collect(toList());
    }

    private String getSeasonString(LocalDate date) {
        int year = date.getYear();
        int month = date.getMonthValue();

        int startYear = year;
        int endYear = year;

        if (month >=7) {
            endYear++;
        } else {
            startYear--;
        }

        return startYear+"-"+endYear;
    }

    private int getStartYear(LocalDate date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        int startYear = year;
        if (month < 7) {
            startYear--;
        }
        return startYear;
    }
}
