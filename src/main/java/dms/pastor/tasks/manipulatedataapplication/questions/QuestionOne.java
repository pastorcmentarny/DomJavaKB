package dms.pastor.tasks.manipulatedataapplication.questions;

import dms.pastor.tasks.manipulatedataapplication.data.Person;

import java.util.List;

import static dms.pastor.tasks.manipulatedataapplication.data.Genre.MALE;
import static java.lang.String.format;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:28
 */
public class QuestionOne extends Question {

    private int counter = 0;

    public QuestionOne(List<Person> people) {
        super(people);
    }

    @Override
    public void processQuestion() {
        people.stream().filter(person -> person.getGenre() == MALE).forEach(person -> counter++);
    }

    @Override
    public String printAnswer() {
        return format("Number of male: %d. ", counter);
    }
}
