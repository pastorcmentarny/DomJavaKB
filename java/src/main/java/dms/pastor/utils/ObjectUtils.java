package dms.pastor.utils;

import java.util.Objects;

import static java.util.Objects.isNull;

public class ObjectUtils {
    private ObjectUtils() {
    }

    public static boolean areAllObjectsNull(Object... objects) {
        if (isNull(objects)) {
            return false;
        }
        for (Object object : objects) {
            if (Objects.nonNull(object)) {
                return false;
            }
        }
        return true;
    }
}
