package dms.pastor.examples.reactive;

import org.junit.jupiter.api.Test;

public class SubmissionPublisherExampleTest {

    @Test
    public void shouldRunExample() throws Exception {
        // when
        final var submissionPublisherExample = new SubmissionPublisherExample();
        submissionPublisherExample.example();

        //then example should not crash :)
    }
}