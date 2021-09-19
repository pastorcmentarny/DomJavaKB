package dms.pastor.examples.patterns.nullobject;

import java.util.List;

public class StringProcessor implements Processor {
    private final List<String> data;

    public StringProcessor(List<String> data) {
        this.data = data;
    }

    public int process() {
        return data.stream()
                .map(String::length)
                .reduce(0, Integer::sum);
    }

}
