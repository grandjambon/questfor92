package com.pj.quest.data;

import com.pj.quest.data.model.Season;
import com.pj.quest.data.model.Team;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.pj.quest.data.TeamTestUtils.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SeasonDataManagerTest {

    @Test
    public void testSeasonDataManager() {
        List<Team> teams = Stream.of(manCity, liverpool, everton, astonVilla, sheffUtd, stockportCounty).collect(Collectors.toList());

        SeasonDataManager seasonDataManager = new SeasonDataManager();
        Collection<Season> seasons = seasonDataManager.getSeasons(teams, Collections.EMPTY_LIST);
        assertThat(seasons.size(), is(4));
    }
}