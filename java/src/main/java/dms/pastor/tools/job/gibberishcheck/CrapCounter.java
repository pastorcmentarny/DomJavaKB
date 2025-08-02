package dms.pastor.tools.job.gibberishcheck;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class CrapCounter {
    private final Data data;

    public CounterResult count() {
        final long counter = data.job()
                .stream()
                .filter(word -> data.crapWords()
                        .stream()
                        .anyMatch(word::equalsIgnoreCase))
                .count();
        //for each word in job
        //check is word is
        return new CounterResult(Math.toIntExact(counter), data.job().size());
    }
}
