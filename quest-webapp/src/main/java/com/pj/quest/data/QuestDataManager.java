package com.pj.quest.data;

import com.pj.quest.data.model.Division;
import com.pj.quest.data.model.Team;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class QuestDataManager {

    private final Collection<Division> divisions = new TreeSet<>(Comparator.comparing(Division::getLevel));

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
                String name = parts[2];
                d = new Division(level, name);
                divisions.add(d);
            }
            else if (parts[0].equals("Team")) {
                String name = parts[1];
                t = new Team(name);
                d.addTeam(t);
            }
            else if (parts[0].equals("Data")) {
                // maybe change this so that we see "Y" or "N" rather than just assuming that if it's there, it's "Y"
                if (parts[1].equals("92Club=Y")) {
                    t.setVisited92Club();
                }
                else if (parts[1].equals("City=Y")) {
                    t.setVisitedWithCity();
                }
            }
        }

    }

    public Collection<Division> getDivisions() {
        return divisions;
    }

    public int get92ClubTotal() {
        int total = 0;
        for (Division d : divisions) {
            for (Team t : d.getTeams()) {
                if (t.getVisited92Club()) {
                    total++;
                }
            }
        }
        return total;
    }
}
