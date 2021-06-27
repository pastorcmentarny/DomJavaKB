package dms.pastor.utils.transformers;

import java.util.Objects;

public class ToPrimitiveBoolean {
    public static boolean from(Boolean booleanObject) {
        if(Objects.isNull(booleanObject)) {
            return false;
        }
        return booleanObject;
    }
}
