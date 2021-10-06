package dms.pastor.tasks.rankjournals.models;

import dms.pastor.tasks.rankjournals.interfaces.ScoreComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class JournalTest {

    private static final int YEAR_2012 = 2012;
    private static final int YEAR_2013 = 2013;
    private Journal journalTest;

    @BeforeEach
    protected void setUp() {
        journalTest = new Journal("name", 1.0, YEAR_2012);
    }

    @Test
    public void testJournalDataTest() {
        assertThat(journalTest.getName()).isNotNull();
        assertThat(journalTest.getScore()).isNotNull();
        assertThat(journalTest.getYear()).isNotNull();
    }

    @Test
    public void test2NotEqualsScoreComparator() {
        List<Journal> journalList = new ArrayList<>();
        Journal journalA = new Journal("FirstLowerScore", 1.1, YEAR_2013);
        Journal journalB = new Journal("SecondHigherScore", 2.2, YEAR_2013);
        journalList.add(journalA);
        journalList.add(journalB);
        journalList.sort(new ScoreComparator());
        assertThat(journalB.getName()).isEqualTo(journalList.get(0).getName());
    }

    @Test
    public void test2EqualsScoreComparator() {
        List<Journal> journalList = new ArrayList<>();
        Journal journalA = new Journal("FirstEqualScore", 1.1, YEAR_2013);
        Journal journalB = new Journal("SecondEqualScore", 1.1, YEAR_2013);
        journalList.add(journalA);
        journalList.add(journalB);
        journalList.sort(new ScoreComparator());
        assertThat(journalA.getName()).isEqualTo(journalList.get(0).getName());
    }
}
