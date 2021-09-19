package dms.pastor.examples.patterns.nullobject;

import dms.pastor.tools.converters.ToIntegerList;

import java.util.List;

public class IntegerProcessor implements Processor{
    private final List<Integer> data;

    public IntegerProcessor(List<String> data) {
        this.data = ToIntegerList.transform(data);
    }

    public int process() {
        return data.stream()
                .reduce(0, Integer::sum);

    }
}
