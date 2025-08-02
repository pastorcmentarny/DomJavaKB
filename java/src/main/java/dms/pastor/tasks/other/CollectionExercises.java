package dms.pastor.tasks.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
final class CollectionExercises {

    private CollectionExercises() {
    }

    static Map<Integer, String> convertListToMapUsingJava8(List<String> list) {

        if (list == null) {
            return new HashMap<>(0);
        }
        AtomicInteger count = new AtomicInteger(1);
        return list.stream()
                .collect(toMap((integer) -> count.getAndAdd(1), Function.identity()));
    }
}
