package dms.pastor.tasks.manipulatedataapplication.questions;

import dms.pastor.tasks.manipulatedataapplication.data.Person;
import dms.pastor.tasks.manipulatedataapplication.data.QAInterface;

import java.util.List;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:33
 */
abstract class Question implements QAInterface {

    final List<Person> people;

    Question(List<Person> people) {
        this.people = people;
    }
}
