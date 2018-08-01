package com.pj.quest.data;

import com.pj.quest.data.model.Division;
import com.pj.quest.data.model.Team;
import com.pj.quest.springboot.controller.QuestConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={QuestConfiguration.class})
public class QuestDataManagerIntegrationTest {

    @Autowired
    private QuestDataManager questDataManager;

    @Test
    public void testQuestDataManager() {
        assertNotNull(questDataManager);
    }

    @Test
    public void testNumberOfDivisions() {
        Collection<Division> divisions = questDataManager.getDivisions();
        assertEquals(4, divisions.size());
    }

    @Test
    public void testNumTeamsInDivision() {
        Collection<Division> divisions = questDataManager.getDivisions();
        Iterator<Division> iterator = divisions.iterator();

        assertTrue(iterator.hasNext());
        Division prem = iterator.next();
        assertEquals(1, prem.getLevel());
        assertEquals(20, prem.getTeams().size());

        assertTrue(iterator.hasNext());
        Division championship = iterator.next();
        assertEquals(2, championship.getLevel());
        assertEquals(24, championship.getTeams().size());

        assertTrue(iterator.hasNext());
        Division league1 = iterator.next();
        assertEquals(3, league1.getLevel());
        assertEquals(24, league1.getTeams().size());

        assertTrue(iterator.hasNext());
        Division league2 = iterator.next();
        assertEquals(4, league2.getLevel());
        assertEquals(24, league2.getTeams().size());
    }

    // throwaway test that should be converted to a unit test
    @Ignore
    @Test
    public void testGet92ClubCount() {
        assertEquals(66, questDataManager.getNinetyTwoClubTotal());
    }

    @Test
    public void testAllAttendedGroundsHaveGames() {
        Collection<Division> divisions = questDataManager.getDivisions();
        for (Division division : divisions) {
            for (Team team : division.getTeams()) {
                if (team.getVisited92Club()) {
                    assertNotNull(team.getName() + " has not got a visit associated with it", team.getVisit());
                }
            }
        }
    }

}