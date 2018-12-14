package dms.pastor.tools.store;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class StorageManagerTest {
    @Test
    public void displayValueForShouldDisplayValueForKeyTest() {
        // given
        StorageManager storageManager = new StorageManager(fileName);
        assertThat(storageManager.size()).isZero();
        final String key = "key";
        final String value = "value";
        storageManager.put(key, value);

        // when
        final Optional<String> result = storageManager.get(key);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result.orElseThrow(SomethingWentWrongException::new)).isEqualTo(value);

    }

    @Test
    public void addValueForKeyShouldAddValueTest() {
        // given
        StorageManager storageManager = new StorageManager(fileName);
        assertThat(storageManager.size()).isZero();
        final String key = "key";
        final String value = "value";

        // when
        storageManager.put(key, value);

        // then
        assertThat(storageManager.size()).isOne();
        assertThat(storageManager.get(key));
    }
}