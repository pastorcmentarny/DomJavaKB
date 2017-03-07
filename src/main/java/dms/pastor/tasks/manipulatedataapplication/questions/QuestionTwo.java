package dms.pastor.tasks.manipulatedataapplication.questions;

import dms.pastor.tasks.manipulatedataapplication.data.Person;
import dms.pastor.tasks.manipulatedataapplication.utls.Utils;

import java.util.ArrayList;

/**
 * User: Pastor
 * Date: 23.07.13
 * Time: 21:38
 */
public class QuestionTwo extends Question {
    private int totalAge = 0;

    public QuestionTwo(ArrayList<Person> people) {
        super(people);
    }

    @Override
    public void processQuestion() {
        for (Person person : people) {
            totalAge += person.getAge();
        }
    }

    @Override
    public String printAnswer() {
        return " Average age of people is: " + Utils.calculateAverageAge(totalAge, people.size());
    }
}
