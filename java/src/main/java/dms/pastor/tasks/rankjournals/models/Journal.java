package dms.pastor.tasks.rankjournals.models;

import dms.pastor.tasks.rankjournals.JournalType;
import lombok.Getter;

import static dms.pastor.tasks.rankjournals.JournalType.NORMAL;
import static dms.pastor.tasks.rankjournals.JournalType.REVIEW;

/**
 * Author Dominik Symonowicz
 * Created 2013-06-18 at 21:29:27
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
@Getter
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

}
