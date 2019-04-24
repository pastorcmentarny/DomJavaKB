package dms.pastor.tasks.manipulatedataapplication;

import dms.pastor.tasks.manipulatedataapplication.data.Person;
import dms.pastor.tasks.manipulatedataapplication.data.QAInterface;
import dms.pastor.tasks.manipulatedataapplication.questions.QuestionOne;
import dms.pastor.tasks.manipulatedataapplication.questions.QuestionThree;
import dms.pastor.tasks.manipulatedataapplication.questions.QuestionTwo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static dms.pastor.tasks.manipulatedataapplication.utls.Utils.loadPeople;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:01
 */
class AnswerGenerator {

    private final List<Person> people;

    AnswerGenerator(String fileName) throws IOException {
        people = loadPeople(fileName);
        displayPeople();
    }

    Person getPerson(String personName) {
        final Optional<Person> result = people.stream()
            .filter(person -> person.getFullName().equalsIgnoreCase(personName))
            .findFirst();

        return result.orElseThrow(() -> new PersonNotFoundException(personName));
    }

    private void displayPeople() {
        people.forEach(System.out::println);
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