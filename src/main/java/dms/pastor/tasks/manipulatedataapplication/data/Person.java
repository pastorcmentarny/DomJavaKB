package dms.pastor.tasks.manipulatedataapplication.data;

/**
 * User: Dominik Symonowicz
 * Date: 23.07.13
 * Time: 21:20
 * <p>
 * A simple 'model'
 */
public class Person {
    private final String fullName;
    private final Genre genre;
    private final int Age;
    private final String DOB;

    public Person(String fullName, Genre genre, int age, String DOB) {
        this.fullName = fullName;
        this.genre = genre;
        Age = age;
        this.DOB = DOB;
    }

    public String getFullName() {
        return fullName;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getAge() {
        return Age;
    }

    public String getDOB() {
        return DOB;
    }

    @Override
    public String toString() {
        return "Person: " + fullName + '\n' +
                "\ngenre: " + genre +
                "\nage: " + Age +
                "\nDOB: '" + DOB + "\n\n";
    }
}
