package dms.pastor.tasks.manipulatedataapplication;

import dms.pastor.tasks.manipulatedataapplication.data.Person;
import dms.pastor.tasks.manipulatedataapplication.questions.Question;
import dms.pastor.tasks.manipulatedataapplication.questions.QuestionOne;
import dms.pastor.tasks.manipulatedataapplication.questions.QuestionThree;
import dms.pastor.tasks.manipulatedataapplication.questions.QuestionTwo;
import dms.pastor.tasks.manipulatedataapplication.utls.Utils;

import java.util.ArrayList;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:01
 */
class AnswerGenerator {
    private final ArrayList<Person> people;

    AnswerGenerator(String fileName) throws Exception {
        people = Utils.loadPeople(fileName);
        displayPeople();
    }

    Person getPerson(String personName) throws Exception {
        for (Person person : people) {
            if (person.getFullName().equalsIgnoreCase(personName)) {
                return person;
            }
        }
        throw new Exception("dms.pastor.domain.Person not found!");
    }

    private void displayPeople() {
        for (Person person : people) {
            System.out.print(person.toString());
        }
    }

    String generate() throws Exception {

        Question howManyMale = new QuestionOne(people);
        howManyMale.processQuestion();
        String result = howManyMale.printAnswer();

        Question averageAge = new QuestionTwo(people);
        averageAge.processQuestion();
        result += averageAge.printAnswer();

        Question daysDiff = new QuestionThree(people, getPerson("Jeff Briton"), getPerson("Tom Sawyer"));
        daysDiff.processQuestion();
        return result + daysDiff.printAnswer();
    }
}