package dms.pastor.tasks.rankjournal.rankjournals;


import dms.pastor.tasks.rankjournal.rankjournals.interfaces.ScoreComparator;
import dms.pastor.tasks.rankjournal.rankjournals.models.Journal;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Pastor Created 2013-06-18 at 22:19:02
 */
class RankJournalViewer {

    public static String displayJournalsList(ArrayList<Journal> journalList) {
        StringBuilder list = new StringBuilder("Rank\tJournal\tScore\tYear\n");
        int counter = 1;
        for (Journal journal : journalList) {
            list.append(String.valueOf(counter)).append('\t').append(journal.getName()).append('\t').append(journal.getScore()).append('\t').append(journal.getYear()).append('\n');
            counter++;
        }

        return list.toString();
    }

    public static String displaySortJournalsByScoreForYear(int year, ArrayList<Journal> journalList) {
        ArrayList<Journal> requestedList = journalList.stream().filter(journal -> journal.getYear() == year).collect(Collectors.toCollection(ArrayList::new));

        StringBuilder list = new StringBuilder("Rank\tJournal\tScore\n");
        int counter = 1;
        requestedList.sort(new ScoreComparator());
        for (Journal journal : requestedList) {
            list.append(String.valueOf(counter)).append('\t').append(journal.getName()).append('\t').append(journal.getScore()).append('\n');
            counter++;
        }
        System.out.println(list.toString());
        return list.toString();
    }

    /*
     * This method should be improved as too many if clauses in double for loop
     * (it should be one if statement only)
     */
    public static String displaySortJournalsWithExclusionFilter(int year, ArrayList<Journal> journalList, ArrayList<JournalType> excluded) {
        ArrayList<Journal> filteredList = new ArrayList<>();
        for (Journal journal : journalList) {
            boolean isNotExcluded = true;
            for (JournalType type : excluded) {
                if (journal.getType() == type) {
                    isNotExcluded = false;
                }
            }
            if (isNotExcluded) {
                filteredList.add(journal);
            }
        }
        return displaySortJournalsByScoreForYear(year, filteredList);
    }
}
