package dms.pastor.examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TemporaryFilesAndDirectoryExampleTest {

    @Test
    public void getCurrentTemporaryFilesPathExampleAcceptanceTest() {
        // when
        final var result = TemporaryFilesAndDirectoryExample.getCurrentTemporaryFilesPath();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotBlank();
    }

    @Test
    public void createTemporaryFileWithPrefixAndSuffixExampleAcceptanceTest() throws Exception {
        // when
        final var result = TemporaryFilesAndDirectoryExample.createTemporaryFileWithPrefixAndSuffix();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotBlank();
    }

    @Disabled //FIXME fix and make it work
    @Test
    public void createTemporaryStorageWithExitOnCloseExampleAcceptanceTest() throws Exception {
        // when
        final var result = TemporaryFilesAndDirectoryExample.createTemporaryStorageWithExitOnClose();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotBlank();
    }

}