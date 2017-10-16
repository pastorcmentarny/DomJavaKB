package dms.pastor.tasks.manipulatedataapplication.questions;

import dms.pastor.tasks.manipulatedataapplication.data.Person;
import dms.pastor.tasks.manipulatedataapplication.utls.Utils;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:38
 */

public class QuestionThree extends Question {

    private final Person first;
    private final Person second;
    private long timeDiff;

    public QuestionThree(List<Person> people, Person first, Person second) {
        super(people);
        this.first = first;
        this.second = second;
    }

    @Override
    public void processQuestion() {
        timeDiff = DAYS.between(Utils.parseDate(first.getDob()), Utils.parseDate(second.getDob())) - 1;
    }

    @Override
    public String printAnswer() {
        return String.format("%s is %d day(s) older than %s.", first.getFullName(), Math.abs(timeDiff), second.getFullName());
    }
}
