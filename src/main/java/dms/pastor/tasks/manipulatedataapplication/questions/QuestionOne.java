package dms.pastor.tasks.manipulatedataapplication.questions;

import dms.pastor.tasks.manipulatedataapplication.data.Genre;
import dms.pastor.tasks.manipulatedataapplication.data.Person;

import java.util.ArrayList;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:28
 */
public class QuestionOne extends Question {
    private int counter = 0;

    public QuestionOne(ArrayList<Person> people) {
        super(people);
    }

    @Override
    public void processQuestion() {
        people.stream().filter(person -> person.getGenre() == Genre.MALE).forEach(person -> counter++);
    }

    @Override
    public String printAnswer() {
        return "Number of male: " + counter;
    }
}
