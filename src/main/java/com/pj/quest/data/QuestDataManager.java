package com.pj.quest.data;

import com.pj.quest.data.model.Division;
import com.pj.quest.data.model.Team;
import com.pj.quest.data.model.Visit;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class QuestDataManager {

    private final Collection<Division> divisions = new TreeSet<>(Comparator.comparing(Division::getLevel));
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @PostConstruct
    void initialise() throws IOException {
        InputStream stream = QuestDataManager.class.getResourceAsStream("/teams.dat");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        Division d = null;
        Team t = null;

        String s;
        while ((s = reader.readLine()) != null) {

            String[] parts = s.trim().split("\\|");
            if (parts[0].equals("Division")){
                int level = Integer.parseInt(parts[1]);
                // do something with id
                String id = parts[2];
                String name = parts[3];
                d = new Division(level, name);
                divisions.add(d);
            }
            else if (parts[0].equals("Team")) {
                // do something with id
                String id = parts[1];
                String name = parts[2];
                t = new Team(name);
                d.addTeam(t);
            }
            else if (parts[0].equals("Data")) {
                // maybe change this so that we see "Y" or "N" rather than just assuming that if it's there, it's "Y"
                if (parts[1].equals("92Club=Y")) {
                    t.setVisited92Club();
                } else if (parts[1].equals("City=Y")) {
                    t.setVisitedWithCity();
                } else if (parts[1].equals("Visit")) {

                    if (parts.length < 4) {
                        throw new IllegalArgumentException(t.getName() + " has not got a well-formed Visit");
                    }

                    LocalDate date = LocalDate.parse(parts[2], formatter);
                    String fixture = parts[3];

                    Pattern pattern = Pattern.compile("([A-Za-z ]+) ([0-9]+)-([0-9]+) ([A-Za-z ]+)");
                    Matcher matcher = pattern.matcher(fixture);
                    Visit v;
                    if (matcher.matches()) {
                        String homeTeam = matcher.group(1);
                        int homeGoals = Integer.parseInt(matcher.group(2));
                        int awayGoals = Integer.parseInt(matcher.group(3));
                        String awayTeam = matcher.group(4);

                        v = new Visit(date, homeTeam, homeGoals, awayGoals, awayTeam);
                    } else {
                        throw new IllegalArgumentException(t.getName() + " has a malformed Visit match");
                    }

                    t.setVisit(v);

                } else {
                    throw new IllegalArgumentException(t.getName() + " has a malformed Data component");
                }
            }
        }

    }

    public Collection<Team> getVisits() {
        return divisions.stream().
                flatMap(division -> division.getTeams().stream()).
                filter(Team::getVisited92Club).
                sorted((Comparator.comparing(team -> team.getVisit().getDateAsDate()))).
                collect(Collectors.toList());
    }


    public Collection<Division> getDivisions() {
        return divisions;
    }

    public int getNinetyTwoClubTotal() {
        int total = 0;
        for (Division d : divisions) {
            total+=d.getNinetyTwoClubTotal();
        }
        return total;
    }
}
