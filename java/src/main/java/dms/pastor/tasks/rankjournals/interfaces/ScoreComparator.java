package dms.pastor.tasks.rankjournals.interfaces;

import dms.pastor.tasks.rankjournals.models.Journal;

import java.util.Comparator;

/**
 * Author Dominik Symonowicz
 * Created 2013-06-18 at 22:50:17
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ScoreComparator implements Comparator<Journal> {

    @Override
    public int compare(Journal a, Journal b) {
        int d = Double.compare(b.getScore(), a.getScore());
        return (d != 0) ? d : a.getName().compareTo(b.getName());
    }
}
