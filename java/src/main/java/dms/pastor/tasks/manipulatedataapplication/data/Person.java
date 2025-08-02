package dms.pastor.tasks.manipulatedataapplication.data;

import lombok.Getter;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:20
 * <p>
 * A simple 'model'
 */
@Getter
public class Person {

    private final String fullName;
    private final Genre genre;
    private final int Age;
    private final String dob;

    public Person(String fullName, Genre genre, int age, String dob) {
        this.fullName = fullName;
        this.genre = genre;
        Age = age;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person: " + fullName + '\n' +
                "\ngenre: " + genre +
                "\nage: " + Age +
                "\ndob: '" + dob + "\n\n";
    }
}
