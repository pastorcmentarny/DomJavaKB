package dms.pastor.domain.exception;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GobshiteExceptionTest {

    @Test
    public void shouldThrowThisExceptionIfIDoSomethingStupid() {
        // when
        Assertions.assertThrows(GobshiteException.class, () -> {
            throw new GobshiteException(null);
        });
    }

}
