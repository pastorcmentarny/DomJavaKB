package dms.pastor.tasks.manipulatedataapplication.questions;

import dms.pastor.tasks.manipulatedataapplication.data.Person;

import java.util.List;

import static dms.pastor.tasks.manipulatedataapplication.utls.Utils.calculateAverageAge;
import static java.lang.String.format;

/**
 * User: Pastor
 * Date: 23.07.13
 * Time: 21:38
 */
public class QuestionTwo extends Question {

    private int totalAge = 0;

    public QuestionTwo(List<Person> people) {
        super(people);
    }

    @Override
    public void processQuestion() {
        totalAge = people.stream().mapToInt(Person::getAge).sum();
    }

    @Override
    public String printAnswer() {
        return format("Average age of people is: %d. ", calculateAverageAge(totalAge, people.size()));
    }
}
