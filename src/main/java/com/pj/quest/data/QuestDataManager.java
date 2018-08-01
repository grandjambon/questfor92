package com.pj.quest.data;

import com.pj.quest.data.model.Division;
import com.pj.quest.data.model.Team;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

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

    public int getNinetyTwoClubTotal() {
        int total = 0;
        for (Division d : divisions) {
            total+=d.getNinetyTwoClubTotal();
        }
        return total;
    }
}
