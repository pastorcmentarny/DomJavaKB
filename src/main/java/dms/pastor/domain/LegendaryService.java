package dms.pastor.domain;

import java.util.UUID;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class LegendaryService {

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
