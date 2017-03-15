package dms.pastor.tasks.rankjournals.models;

import dms.pastor.tasks.rankjournals.JournalType;

import static dms.pastor.tasks.rankjournals.JournalType.NORMAL;

/**
 * @author Pastor
 *         Created 2013-06-18 at 21:29:27
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

    public Journal(String name, double score, int year, JournalType type) {
        this.name = name;
        this.score = score;
        this.year = year;
        this.type = type;
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
