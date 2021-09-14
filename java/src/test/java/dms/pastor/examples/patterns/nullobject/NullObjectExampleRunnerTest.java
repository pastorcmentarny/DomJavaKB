package dms.pastor.examples.patterns.nullobject;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NullObjectExampleRunnerTest {

    @Test
    void NullObjectAcceptanceTest() {
        NullObjectExampleRunner.main(null);
    }

    @Test
    void runExampleWithNullProcessor() {
        // when
        final int result = ProcessorFactory.selectProcessorFor("?", null).process();

        // then
        assertThat(result).isEqualTo(0);
    }


    @Test
    void runExampleWithIntegerProcessor() {
        // when
        final int result = ProcessorFactory.selectProcessorFor("I", List.of("1", "2")).process();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void runExampleWithStringProcessor() {
        // when
        final int result = ProcessorFactory.selectProcessorFor("S", List.of("one", "two")).process();

        // then
        assertThat(result).isEqualTo(6);
    }

}