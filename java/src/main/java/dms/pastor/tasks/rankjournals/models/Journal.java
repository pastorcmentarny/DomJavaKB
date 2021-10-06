package dms.pastor.tasks.rankjournals.models;

import dms.pastor.tasks.rankjournals.JournalType;

import static dms.pastor.tasks.rankjournals.JournalType.NORMAL;
import static dms.pastor.tasks.rankjournals.JournalType.REVIEW;

/**
 * Author Dominik Symonowicz
 * Created 2013-06-18 at 21:29:27
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Journal {

    private final String name;
    private final double score;
    private final int year;
    private JournalType type = NORMAL;

    public Journal(String name, double score, int year) {
        this.name = name;
        this.score = score;
        this.year = year;
    }

    public static Journal createReview(String name, double score, int year) {
        Journal reviewJournal = new Journal(name, score, year);
        reviewJournal.type = REVIEW;
        return reviewJournal;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public int getYear() {
        return year;
    }

    public JournalType getType() {
        return type;
    }

}
