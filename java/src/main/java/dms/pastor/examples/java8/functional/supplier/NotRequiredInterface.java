package dms.pastor.examples.java8.functional.supplier;

import java.util.function.Supplier;

public interface NotRequiredInterface {

    String NOT_REQUIRED = "Not required";

    static NotRequiredInterface create(Supplier<NotRequiredInterface> supplier) {
        return supplier.get();
    }

    @SuppressWarnings("SameReturnValue")
    default String notRequired() {
        return NOT_REQUIRED;
    }
}
