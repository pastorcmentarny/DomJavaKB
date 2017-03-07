package dms.pastor.exercises.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class CollectionExercises {

    static Map<Integer, String> convertListToMapUsingJava8(List<String> list) {

        if (list == null) {
            return new HashMap<>(0);
        }
        AtomicInteger count = new AtomicInteger(1);
        return list.stream()
                .collect(toMap((integer) -> count.getAndAdd(1), Function.identity()));
    }
}
