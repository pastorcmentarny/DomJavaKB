package dms.pastor.spring.exercises.calculator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import static dms.pastor.spring.DomUtils.randomPositiveInteger;


/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Addition {
    private final long id;
    private String[] numbers;

    public Addition(@JsonProperty("name") String[] numbers) {
        this.id = randomPositiveInteger();
        this.numbers = numbers;
    }

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
