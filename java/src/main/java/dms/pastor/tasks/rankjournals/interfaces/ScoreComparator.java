package dms.pastor.tasks.rankjournals.interfaces;

import dms.pastor.tasks.rankjournals.models.Journal;

import java.util.Comparator;

/**
 * Author Dominik Symonowicz
 * Created 2013-06-18 at 22:50:17
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class ScoreComparator implements Comparator<Journal> {

    @Override
    public int compare(Journal a, Journal b) {
        int d = Double.compare(b.getScore(), a.getScore());
        return (d != 0) ? d : a.getName().compareTo(b.getName());
    }
}
