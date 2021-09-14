package dms.pastor.examples.patterns.nullobject;

import java.util.List;

public class ProcessorFactory {

    public static Processor selectProcessorFor(String type, List<String> data) {
        return switch (type) {
            case "I" -> new IntegerProcessor(data);
            case "S" -> new StringProcessor((data));
            default -> new NullProcessor();
        };
    }
}
