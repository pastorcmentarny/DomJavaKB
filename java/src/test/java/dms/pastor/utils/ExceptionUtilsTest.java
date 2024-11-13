package dms.pastor.utils;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExceptionUtilsTest {

    @Test
    public void isIgnorableExceptionReturnFalseForRuntimeException() {
        // given and when
        var notIgnorableException = ExceptionUtils.isIgnorableException(new RuntimeException());

        // then
        assertFalse(notIgnorableException);
    }

    @Test
    public void isIgnorableExceptionReturnTrueForFileNotFoundException() {
        // given and when
        var notIgnorableException = ExceptionUtils.isIgnorableException(new FileNotFoundException());

        // then
        assertTrue(notIgnorableException);
    }
}