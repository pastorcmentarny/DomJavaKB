package dms.pastor.utils.randoms;

import dms.pastor.domain.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.ValidatorUtils.validateIfNotNull;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

/**
 * Author Dominik Symonowicz
 * Created 16/04/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class PersonalDataGenerator {
    private static final List<String> firstName;
    private static final List<String> surname;
    private static final Random random = new Random();

    static {
        firstName = new ArrayList<>();
        firstName.add("William");
        firstName.add("Richard");
        firstName.add("Walter");
        firstName.add("Henry");
        firstName.add("Clarence");
        firstName.add("Louis");
        firstName.add("Martha");
        firstName.add("Florence");
        firstName.add("Bertha");
        firstName.add("Sarah");
        surname = new ArrayList<>();
        surname.add("Breeden");
        surname.add("Cabbage");
        surname.add("Oakes");
        surname.add("Summer");
        surname.add("Sunshine");
        surname.add("Tattersall");
        surname.add("Thornton");
        surname.add("Rusty");
        surname.add("Wheaton");
        surname.add("Winterbottom");
        surname.add("Wordsworth");
    }

    public static String generateFirstName() {
        return firstName.get(random.nextInt(firstName.size()));
    }

    public static String generateSurname() {
        return surname.get(random.nextInt(surname.size()));
    }

    static Country getRandomCountry() {
        return Country.values()[random.nextInt(Country.values().length)];
    }

    // It is pseudo generator.
    public static String generateEmail() {
        return generateString(16) + '@' + generateString(8) + '.' + getRandomCountry().code().toLowerCase();
    }

    public static String generatePhoneNumberForPattern(String pattern) {
        validatePatternForPhone(pattern);

        StringBuilder result = new StringBuilder(EMPTY_STRING);
        final char[] chars = pattern.toCharArray();
        for (char character : chars) {
            if (character == 'X') {
                result.append(new Random().nextInt(10));
                continue;
            }
            result.append(character);
        }
        return result.toString();
    }

    private static void validatePatternForPhone(String pattern) {
        validateIfNotNull(pattern);
        Pattern regex = Pattern.compile("[0-9()-+X]");
        Matcher matcher = regex.matcher(pattern);

        //TODO improve it
        if (pattern.isEmpty()) {
            return;
        }

        if (!matcher.find()) {
            throw new IllegalArgumentException("Pattern for phone contains illegal character(s). Pattern provided: " + pattern);
        }
    }
}
