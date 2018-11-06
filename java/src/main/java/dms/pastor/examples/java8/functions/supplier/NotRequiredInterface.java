package dms.pastor.kb.java8.functions.supplier;

import java.util.function.Supplier;

public interface NotRequiredInterface {

    String NOT_REQUIRED = "Not required";

    static NotRequiredInterface create(Supplier<NotRequiredInterface> supplier) {
        return supplier.get();
    }

    default String notRequired() {
        return NOT_REQUIRED;
    }
}
