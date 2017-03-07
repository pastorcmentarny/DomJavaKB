package dms.pastor.tasks.manipulatedataapplication.questions;

import dms.pastor.tasks.manipulatedataapplication.data.Person;
import dms.pastor.tasks.manipulatedataapplication.utls.Utils;

import java.util.ArrayList;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:38
 */

public class QuestionThree extends Question {
    private final Person first;
    private final Person second;
    private long timeDiff;

    public QuestionThree(ArrayList<Person> people, Person first, Person second) {
        super(people);
        this.first = first;
        this.second = second;
    }

    @Override
    public void processQuestion() {
        long firstPerson = Utils.setDate(first.getDOB());
        long secondPerson = Utils.setDate(second.getDOB());
        timeDiff = firstPerson - secondPerson;

    }

    @Override
    public String printAnswer() {
        return first.getFullName() + " is " + Math.abs(timeDiff / Utils.DAY_FROM_MILLISECONDS) + " day(s) older than " + second.getFullName();
    }
}
