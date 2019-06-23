package dms.pastor.examples.reactive;

import org.junit.jupiter.api.Test;

class SubmissionPublisherExampleTest {

    @Test
    void shouldRunExample() throws Exception {
        // when
        final var submissionPublisherExample = new SubmissionPublisherExample();
        submissionPublisherExample.example();

        //then example should not crash :)
    }
}