package dms.pastor.examples.java8;

import java.util.Optional;

//see tests for examples
public class OptionalsExample {


    public static Optional<String> getOptional(boolean optional) {
        return optional ? Optional.of("Optional") : Optional.empty();
    }

}
