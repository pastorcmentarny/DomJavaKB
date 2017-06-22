package dms.pastor.tasks.rankjournals;

import dms.pastor.tasks.rankjournals.interfaces.ScoreComparator;
import dms.pastor.tasks.rankjournals.models.Journal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pastor Created 2013-06-18 at 22:19:02
 */
class RankJournalViewer {

    private static final char TAB = '\t';

    static String getJournalListAsString(List<Journal> journalList) {
        StringBuilder list = new StringBuilder("Rank\tJournal\tScore\tYear\n");
        int counter = 1;
        for (Journal journal : journalList) {
            addJournalToList(list, counter, journal);
            counter++;
        }

        return list.toString();
    }

    static String displaySortJournalsByScoreForYear(int year, List<Journal> journalList) {
        ArrayList<Journal> requestedList = journalList.stream().filter(journal -> journal.getYear() == year).collect(Collectors.toCollection(ArrayList::new));

        StringBuilder list = new StringBuilder("Rank\tJournal\tScore\n");
        int counter = 1;
        requestedList.sort(new ScoreComparator());
        for (Journal journal : requestedList) {
            list.append(String.valueOf(counter)).append(TAB).append(journal.getName()).append(TAB).append(journal.getScore()).append('\n');
            counter++;
        }
        System.out.println(list.toString());
        return list.toString();
    }

    /*
     * This method should be improved as too many if clauses in double for loop
     * (it should be one if statement only)
     */
    static String displaySortJournalsWithExclusionFilter(int year, List<Journal> journalList, List<JournalType> excluded) {
        List<Journal> filteredList = new ArrayList<>();
        for (Journal journal : journalList) {
            boolean isNotExcluded = isJournalNotExcluded(excluded, journal);

            addJournalToFilterListIfNotExcluded(filteredList, journal, isNotExcluded);
        }
        return displaySortJournalsByScoreForYear(year, filteredList);
    }

    private static void addJournalToList(StringBuilder list, int counter, Journal journal) {
        list.append(String.valueOf(counter))
                .append(TAB)
                .append(journal.getName())
                .append(TAB)
                .append(journal.getScore())
                .append(TAB).append(journal.getYear())
                .append('\n');
    }

    private static boolean isJournalNotExcluded(List<JournalType> excluded, Journal journal) {
        boolean isNotExcluded = true;
        for (JournalType type : excluded) {
            if (journal.getType() == type) {
                isNotExcluded = false;
            }
        }
        return isNotExcluded;
    }

    private static void addJournalToFilterListIfNotExcluded(List<Journal> filteredList, Journal journal, boolean isNotExcluded) {
        if (isNotExcluded) {
            filteredList.add(journal);
        }
    }
}
