package dms.pastor.tasks.rankjournals;

import dms.pastor.tasks.rankjournals.models.Journal;
import dms.pastor.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tasks.rankjournals.JournalType.REVIEW;
import static dms.pastor.tasks.rankjournals.RankJournalViewer.*;
import static dms.pastor.tasks.rankjournals.models.Journal.createReview;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RankJournalViewerTest{

    private static final int YEAR_2010 = 2010;
    private static final int YEAR_2009 = 2009;
    private static final int YEAR_2008 = 2008;
    private static final String JOURNAL_A = "Journal A";
    private static final String JOURNAL_B = "Journal B";
    private static final String JOURNAL_C = "Journal C";
    private ArrayList<Journal> journals;

    @BeforeEach
    protected void setUp() throws Exception {
        journals = new ArrayList<>();
        Journal journal = new Journal(JOURNAL_A, 5.6, YEAR_2010);
        journals.add(journal);
        journal = new Journal(JOURNAL_B, 2.4, YEAR_2010);
        journals.add(journal);
        journal = new Journal(JOURNAL_C, 3.1, YEAR_2010);
        journals.add(journal);
        journal = createReview(JOURNAL_A, 2.2, YEAR_2009);
        journals.add(journal);
        journal = new Journal(JOURNAL_B, 6.2, YEAR_2009);
        journals.add(journal);
        journal = createReview(JOURNAL_C, 6.2, YEAR_2009);
        journals.add(journal);
        journal = createReview(JOURNAL_A, 5.6, YEAR_2008);
        journals.add(journal);
        journal = new Journal(JOURNAL_B, 2.4, YEAR_2008);
        journals.add(journal);
        journal = new Journal(JOURNAL_C, 3.1, YEAR_2008);
        journals.add(journal);
    }

    @Test
    public void testJournals() {
        assertThat(journals).isNotNull();
    }

    @Test
    public void testDisplayJournals() {
        String answer = StringUtils.replaceWithSystemNewLine("Rank	Journal	Score	Year\n1	Journal A	5.6	2010\n2	Journal B	2.4	2010\n3	Journal C	3.1	2010\n4	Journal A	2.2	2009\n5	Journal B	6.2	2009\n6	Journal C	6.2	2009\n7	Journal A	5.6	2008\n8	Journal B	2.4	2008\n9	Journal C	3.1	2008\n");
        final var journalListAsString = StringUtils.replaceWithSystemNewLine(getJournalListAsString(journals));
        assertThat(journalListAsString).isEqualTo(answer);
    }

    @Test
    public void testSortJournalsByScoreForYear2010() {
        System.out.println("Scenario 1");
        String answer = "Rank	Journal	Score\n1	Journal A	5.6\n2	Journal C	3.1\n3	Journal B	2.4\n";
        assertThat(displaySortJournalsByScoreForYear(YEAR_2010, journals)).isEqualTo(answer);
    }

    @Test
    public void testSortJournalsByScoreThenNameForYear2009() {
        System.out.println("Scenario 2");
        String answer = "Rank	Journal	Score\n1	Journal B	6.2\n2	Journal C	6.2\n3	Journal A	2.2\n";
        assertThat(displaySortJournalsByScoreForYear(YEAR_2009, journals)).isEqualTo(answer);
    }

    @Test
    public void testSortJournalsWithExcludedFilterForYear2008() {
        System.out.println("Scenario 3");
        String answer = "Rank	Journal	Score\n1	Journal C	3.1\n2	Journal B	2.4\n";
        assertThat(displaySortJournalsWithExclusionFilter(YEAR_2008, journals, getReview())).isEqualTo(answer);
    }

    @Test
    public void testSortJournalsWithExcludedFilterForYear2009() {
        String answer = "Rank	Journal	Score\n1	Journal B	6.2\n";
        assertThat(displaySortJournalsWithExclusionFilter(YEAR_2009, journals, getReview())).isEqualTo(answer);
    }


    private List<JournalType> getReview() {
        return new ArrayList<>(singletonList(REVIEW));
    }
}