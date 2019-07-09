package dms.pastor.examples.mockito;

import dms.pastor.domain.Treasure;

import java.util.UUID;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * this class is used as example for mockito
 * tag-mockito
 * tag-argumentCaptor
 */
public class MockitoExampleService {

    public void create(UUID id, Treasure treasure) {
        System.out.println(format("Created treasure %s with id: %s", treasure.getName(), id.toString()));
    }

    public String method(String first, String second, int number) {
        StringBuilder result = new StringBuilder(first);
        for (int i = 0; i < number; i++) {
            result.append(i);
        }
        return result + second;
    }
}
