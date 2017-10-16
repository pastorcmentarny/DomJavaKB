package dms.pastor.tasks.manipulatedataapplication;

import dms.pastor.tasks.manipulatedataapplication.data.Person;
import dms.pastor.tasks.manipulatedataapplication.data.QAInterface;
import dms.pastor.tasks.manipulatedataapplication.questions.QuestionOne;
import dms.pastor.tasks.manipulatedataapplication.questions.QuestionThree;
import dms.pastor.tasks.manipulatedataapplication.questions.QuestionTwo;
import dms.pastor.tasks.manipulatedataapplication.utls.Utils;

import java.io.IOException;
import java.util.List;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:01
 */
class AnswerGenerator {

    private final List<Person> people;

    AnswerGenerator(String fileName) throws IOException {
        people = Utils.loadPeople(fileName);
        displayPeople();
    }

    Person getPerson(String personName) {
        for (Person person : people) {
            if (person.getFullName().equalsIgnoreCase(personName)) {
                return person;
            }
        }
        throw new PersonNotFoundException(personName);
    }

    private void displayPeople() {
        for (Person person : people) {
            System.out.print(person.toString());
        }
    }

    String generate() {

        QAInterface howManyMale = new QuestionOne(people);
        howManyMale.processQuestion();
        String result = howManyMale.printAnswer();

        QAInterface averageAge = new QuestionTwo(people);
        averageAge.processQuestion();
        result += averageAge.printAnswer();

        QAInterface daysDiff = new QuestionThree(people, getPerson("Jeff Briton"), getPerson("Tom Sawyer"));
        daysDiff.processQuestion();
        return result + daysDiff.printAnswer();
    }
}