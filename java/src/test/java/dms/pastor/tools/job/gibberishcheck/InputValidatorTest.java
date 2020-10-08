package dms.pastor.tools.job.gibberishcheck;

import dms.pastor.TestConfig;
import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InputValidatorTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfArgsIsNull() {
        //expect
        expectedException.expect(SomethingWentWrongException.class);

        // when
        InputValidator.validateInput(null);
    }

    @Test
    public void shouldThrowExceptionIfArgsHasLessThanTwoElements() {
        //expect
        expectedException.expect(SomethingWentWrongException.class);

        // when
        InputValidator.validateInput(new String[]{"1"});
    }

    @Test
    public void shouldThrowExceptionIfArgsHasMoreThanTwoElements() {
        //expect
        expectedException.expect(SomethingWentWrongException.class);

        // when
        InputValidator.validateInput(new String[]{"1", "2", "3"});
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