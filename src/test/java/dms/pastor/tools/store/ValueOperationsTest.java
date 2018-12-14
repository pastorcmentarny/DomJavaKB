package dms.pastor.tools.store;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueOperationsTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(printStream);
    }

    @Test
    public void displayValueForShouldDisplayValueForKeyTest() {
        // given
        StorageManager storageManager = new StorageManager(fileName);
        ValueOperations valueOperations = new ValueOperations(storageManager, "It is not a password1");
        assertThat(storageManager.size()).isZero();
        final String key = "key";
        final String value = "value";
        valueOperations.addValueForKey(key, value);

        // when
        valueOperations.displayValueFor(key);

        // then
        assertThat(outputStream.toString()).contains("value");

    }
}