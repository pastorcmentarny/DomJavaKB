package dms.pastor.spring.exercises.calculator.models;

import dms.pastor.utils.randoms.RandomDataGenerator;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Addition {
    private static final AtomicInteger counter = new AtomicInteger();
    private final long id = randomPositiveInteger();
    private String[] numbers;

    public Result getAnswer() {
        int counter = 0;
        if (numbers == null) {
            throw new IllegalArgumentException("No numbers given.You need at least 1 number.");
        }
        for (String number : numbers) {
            counter += Integer.parseInt(number);
        }
        return new Result(id, counter);
    }


}
