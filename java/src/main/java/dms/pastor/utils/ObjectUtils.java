package dms.pastor.utils;

import java.util.Objects;

public class ObjectUtils {
    private ObjectUtils() {
    }

    public static boolean areAllObjectsNull(Object... objects) {
        if (objects == null) {
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
