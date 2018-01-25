package dms.pastor.tasks.manipulatedataapplication.utls;

import dms.pastor.tasks.manipulatedataapplication.data.Genre;
import dms.pastor.tasks.manipulatedataapplication.data.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 03/07/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class Utils {
    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    private static final String WHITESPACES = "\\s";
    private static final String SPLIT_CHARACTER = "/";

    private Utils() {
    }

    public static LocalDate parseDate(String dateAsText) {
        String[] aDate = dateAsText.split(SPLIT_CHARACTER);
        return LocalDate.of(getValueFor(aDate[2]), getValueFor(aDate[1]), getValueFor(aDate[0]));
    }

    public static int calculateAverageAge(int totalAge, int numberOfPeople) {
        if (numberOfPeople > 0) {
            return totalAge / numberOfPeople;
        } else {
            return 0; //depend on case in some cause it should throw exception
        }
    }

    //TODO improve this!
    public static List<Person> loadPeople(String filename) throws IOException {
        List<Person> people = new ArrayList<>();
        File file = new File(filename);
        //TODO add validator for check if file exists
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                addPerson(people, line);
            }
        }
        return people;
    }

    private static void addPerson(List<Person> people, String line) {
        try {
            Person person = parsePerson(line);
            addPersonIfDoesNotExist(people, person);
        } catch (Exception e) {
            LOGGER.warn("not a valid person due " + e.getMessage());
        }
    }

    public static List<String> loadFileToArrayOfStrings(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath)).collect(Collectors.toList());
    }

    private static void addPersonIfDoesNotExist(List<Person> people, Person tmp) {
        if (isPersonNotExists(tmp, people)) {
            people.add(tmp);
        }
    }

    private static Integer getValueFor(String value) {
        return Integer.valueOf(value.replaceAll(WHITESPACES, EMPTY_STRING));
    }

    private static Person parsePerson(String line) {
        String[] columns = line.split(",");
        return new Person(columns[0], Genre.fromString(columns[1]), getValueFor(columns[2]), columns[3]);
    }

    private static boolean isPersonNotExists(Person newPerson, List<Person> people) {
        return people.stream().noneMatch(person -> person.equals(newPerson));

    }
}
