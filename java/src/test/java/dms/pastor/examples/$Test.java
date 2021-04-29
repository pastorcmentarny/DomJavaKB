package dms.pastor.examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;


class $Test {
    private static final String EXPECTED_RESULT = "$";
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @BeforeEach
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void $isValidMethodName() {
        // when
        final var result = $.$();

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);

    }

    @Test
    public void $mainAcceptanceTest(){

        // when
        $.main(new String[0]);

        // then
        final String[] output = outputStream.toString().split(System.lineSeparator());
        assertThat(output[0]).isEqualTo(EXPECTED_RESULT);
    }

}