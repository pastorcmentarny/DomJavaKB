package dms.pastor.tools.crontab;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrontabGeneratorTest {

    @Test
    void toCrontabReturnExceptionIfNull() {
        // given, when & then
        assertThrows(SomethingWentWrongException.class, () -> CrontabGenerator.toCrontab(null));
    }

    @Test
    void toCrontabReturnExceptionIfEmpty() {
        // given, when & then
        assertThrows(SomethingWentWrongException.class, () -> CrontabGenerator.toCrontab(""));
    }

    @Test
    void toCrontabReturnFiveStartsForRunEveryMinuteEveryDay() {
        //given
        var expectedResult = "* * * * *";
        var input = "Run every minute of every day";

        // when
        var result = CrontabGenerator.toCrontab(input);

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void fromCrontabReturnExceptionIfNull() {
        // given, when & then
        assertThrows(SomethingWentWrongException.class, () -> CrontabGenerator.fromCrontab(null));
    }

    @Test
    void fromCrontabReturnExceptionIfEmpty() {
        // given, when & then
        assertThrows(SomethingWentWrongException.class, () -> CrontabGenerator.fromCrontab(""));
    }
}