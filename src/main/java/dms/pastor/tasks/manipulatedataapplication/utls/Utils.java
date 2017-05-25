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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

/**
 * Author Dominik Symonowicz
 * Created 03/07/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Utils {
    public static final long DAY_FROM_MILLISECONDS = 1000L * 60L * 60L * 24L;

    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    private static final String WHITESPACES = "\\s";
    private static final String EMPTY_STRING = "";

    private Utils() {
    }

    //TODO replace this method with Java8
    public static long setDate(String date) {
        String[] aDate = date.split("/");
        final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(aDate[0].replaceAll(WHITESPACES, EMPTY_STRING)));
        cal.set(Calendar.MONTH, Integer.valueOf(aDate[1].replaceAll(WHITESPACES, EMPTY_STRING)));
        cal.set(Calendar.YEAR, Integer.valueOf(aDate[2].replaceAll(WHITESPACES, EMPTY_STRING)));
        return cal.getTimeInMillis();
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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    Person tmp = addPerson(line);

                    if (isNotExists(tmp, people)) {
                        people.add(tmp);
                    }

                } catch (Exception e) {
                    LOGGER.warn("not a valid person  due " + e.getMessage());
                }
            }
        }
        return people;
    }

    private static Person addPerson(String line) {
        String[] columns = line.split(",");
        return new Person(columns[0], Genre.fromString(columns[1]), Integer.valueOf(columns[2].replaceAll(WHITESPACES, EMPTY_STRING)), columns[3]);
    }

    private static boolean isNotExists(Person person, List<Person> people) {
        for (Person p : people)
            if (p.equals(person)) {
                return false;
            }
        return true;

    }

    public static List<String> loadFileToArrayOfStrings(String filePath) throws IOException {
        return new ArrayList<>(Files.lines(Paths.get(filePath)).collect(Collectors.toList()));
    }
}
