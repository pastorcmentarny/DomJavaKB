package dms.pastor.tasks.manipulatedataapplication.questions;

import dms.pastor.tasks.manipulatedataapplication.data.Person;
import dms.pastor.tasks.manipulatedataapplication.data.QAInterface;

import java.util.ArrayList;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:33
 */
public abstract class Question implements QAInterface {
    final ArrayList<Person> people;

    Question(ArrayList<Person> people) {
        this.people = people;
    }
}
