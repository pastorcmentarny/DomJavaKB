package dms.pastor.tools.job.gibberishcheck;

import dms.pastor.TestConfig;
import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    public void shouldThrowExceptionIfArgsIsNull() {
        // when
        Assertions.assertThrows(SomethingWentWrongException.class, () -> {

            InputValidator.validateInput(null);
        });

    }

    @Test
    public void shouldThrowExceptionIfArgsHasLessThanTwoElements() {
        // when
        Assertions.assertThrows(SomethingWentWrongException.class, () -> {

            InputValidator.validateInput(new String[]{"1"});
        });

    }

    @Test
    public void shouldThrowExceptionIfArgsHasMoreThanTwoElements() {
        // when
        Assertions.assertThrows(SomethingWentWrongException.class, () -> {
            InputValidator.validateInput(new String[]{"1", "2", "3"});
        });

    }

    @Test
    public void shouldNotThrowException() {
        // given
        String basePath = TestConfig.BASE_PATH;
        var args = new String[]{basePath + "job/recruiter-db.txt", basePath + "job/job-example.txt"};
        // when
        InputValidator.validateInput(args);
    }
}