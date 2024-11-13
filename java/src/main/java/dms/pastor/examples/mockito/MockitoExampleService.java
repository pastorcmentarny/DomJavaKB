package dms.pastor.examples.mockito;

import dms.pastor.domain.Treasure;

import java.util.UUID;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * this class is used as example for mockito
 * tag-mockito
 * tag-argumentCaptor
 */
public class MockitoExampleService {

    public void create(UUID id, Treasure treasure) {
        System.out.printf("Created treasure %s with id: %s%n", treasure.getName(), id.toString());
    }

    public String method(String first, String second, int number) {
        StringBuilder result = new StringBuilder(first);
        for (int i = 0; i < number; i++) {
            result.append(i);
        }
        return result + second;
    }
}
