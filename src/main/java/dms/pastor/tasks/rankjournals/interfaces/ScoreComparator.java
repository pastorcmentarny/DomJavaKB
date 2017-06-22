package dms.pastor.tasks.rankjournals.interfaces;

import dms.pastor.tasks.rankjournals.models.Journal;

import java.util.Comparator;

/**
 * @author Pastor
 *         Created 2013-06-18 at 22:50:17
 */
public class ScoreComparator implements Comparator<Journal> {

    @Override
    public int compare(Journal a, Journal b) {
        int d = Double.compare(b.getScore(), a.getScore());
        return (d != 0) ? d : a.getName().compareTo(b.getName());
    }
}
