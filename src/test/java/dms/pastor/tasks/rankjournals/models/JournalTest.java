package dms.pastor.tasks.rankjournals.models;

import dms.pastor.tasks.rankjournals.interfaces.ScoreComparator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class JournalTest extends TestCase {

    private Journal journalTest;

    public JournalTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(JournalTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        journalTest = new Journal("name", 1.0, 2012);
    }

    public void testJournalDataTest() {
        assertThat(journalTest.getName()).isNotNull();
        assertThat(journalTest.getScore()).isNotNull();
        assertThat(journalTest.getYear()).isNotNull();
    }

    public void test2NotEqualsScoreComparator() {
        List<Journal> journalList = new ArrayList<>();
        Journal journalA = new Journal("FirstLowerScore", 1.1, 2013);
        Journal journalB = new Journal("SecondHigherScore", 2.2, 2013);
        journalList.add(journalA);
        journalList.add(journalB);
        journalList.sort(new ScoreComparator());
        assertThat(journalB.getName()).isEqualTo(journalList.get(0).getName());
    }

    public void test2EqualsScoreComparator() {
        List<Journal> journalList = new ArrayList<>();
        Journal journalA = new Journal("FirstEqualScore", 1.1, 2013);
        Journal journalB = new Journal("SecondEqualScore", 1.1, 2013);
        journalList.add(journalA);
        journalList.add(journalB);
        journalList.sort(new ScoreComparator());
        assertThat(journalA.getName()).isEqualTo(journalList.get(0).getName());
    }
}
