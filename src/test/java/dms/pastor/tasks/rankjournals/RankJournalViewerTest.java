package dms.pastor.tasks.rankjournals;

import dms.pastor.tasks.rankjournals.models.Journal;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.tasks.rankjournals.JournalType.REVIEW;
import static dms.pastor.tasks.rankjournals.RankJournalViewer.*;
import static dms.pastor.tasks.rankjournals.models.Journal.createReview;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RankJournalViewerTest extends TestCase {

    private ArrayList<Journal> journals;

    public RankJournalViewerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(RankJournalViewerTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        journals = new ArrayList<>();
        Journal journal = new Journal("Journal A", 5.6, 2010);
        journals.add(journal);
        journal = new Journal("Journal B", 2.4, 2010);
        journals.add(journal);
        journal = new Journal("Journal C", 3.1, 2010);
        journals.add(journal);
        journal = createReview("Journal A", 2.2, 2009);
        journals.add(journal);
        journal = new Journal("Journal B", 6.2, 2009);
        journals.add(journal);
        journal = createReview("Journal C", 6.2, 2009);
        journals.add(journal);
        journal = createReview("Journal A", 5.6, 2008);
        journals.add(journal);
        journal = new Journal("Journal B", 2.4, 2008);
        journals.add(journal);
        journal = new Journal("Journal C", 3.1, 2008);
        journals.add(journal);
    }

    public void testJournals() {
        assertThat(journals).isNotNull();
    }

    public void testDisplayJournals() {
        String answer = "Rank	Journal	Score	Year\n1	Journal A	5.6	2010\n2	Journal B	2.4	2010\n3	Journal C	3.1	2010\n4	Journal A	2.2	2009\n5	Journal B	6.2	2009\n6	Journal C	6.2	2009\n7	Journal A	5.6	2008\n8	Journal B	2.4	2008\n9	Journal C	3.1	2008\n";
        assertThat(getJournalListAsString(journals)).isEqualTo(answer);
    }

    public void testSortJournalsByScoreForYear2010() {
        System.out.println("Scenario 1");
        String answer = "Rank	Journal	Score\n1	Journal A	5.6\n2	Journal C	3.1\n3	Journal B	2.4\n";
        assertThat(displaySortJournalsByScoreForYear(2010, journals)).isEqualTo(answer);
    }

    public void testSortJournalsByScoreThenNameForYear2009() {
        System.out.println("Scenario 2");
        String answer = "Rank	Journal	Score\n1	Journal B	6.2\n2	Journal C	6.2\n3	Journal A	2.2\n";
        assertThat(displaySortJournalsByScoreForYear(2009, journals)).isEqualTo(answer);
    }

    public void testSortJournalsWithExcludedFilterForYear2008() {
        System.out.println("Scenario 3");
        String answer = "Rank	Journal	Score\n1	Journal C	3.1\n2	Journal B	2.4\n";
        assertThat(displaySortJournalsWithExclusionFilter(2008, journals, getReview())).isEqualTo(answer);
    }

    public void testSortJournalsWithExcludedFilterForYear2009() {
        String answer = "Rank	Journal	Score\n1	Journal B	6.2\n";
        assertThat(displaySortJournalsWithExclusionFilter(2009, journals, getReview())).isEqualTo(answer);
    }

    private List<JournalType> getReview() {
        return new ArrayList<>(Collections.singletonList(REVIEW));
    }
}