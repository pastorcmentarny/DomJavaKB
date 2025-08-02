package dms.pastor.examples.mockito;

import dms.pastor.domain.Treasure;

import java.util.UUID;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * this class is used as example for mockito
 * tag-mockito
 * tag-argumentCaptor
 */
public class MockitoExampleService {

    public void create(UUID id, Treasure treasure) {
        System.out.printf("Created treasure %s with id: %s%n", treasure.name(), id.toString());
    }

    public String method(String first, String second, int number) {
        StringBuilder result = new StringBuilder(first);
        for (int i = 0; i < number; i++) {
            result.append(i);
        }
        return result + second;
    }
}
