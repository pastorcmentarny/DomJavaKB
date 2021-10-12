package dms.pastor.tools.versionupdater;

import org.junit.jupiter.api.Test;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VersionUpdaterConfigTest {

    private static final String WITH_PREFIX = "B:\\GitHub\\DomKB";
    private static final String MODULE_NAME = "java";

    @Test
    void getPathForAcceptanceTest() {
        // given
        var expectedResult = "B:\\GitHub\\DomKB\\java\\build.gradle";

        // when
        final var result = VersionUpdateConfig.getPathFor(MODULE_NAME, WITH_PREFIX);

        // debug
        System.out.println(result);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    void getPathForShouldThrowExceptionIfModuleNameIsNull() {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> VersionUpdateConfig.getPathFor(null, WITH_PREFIX));
    }

    @Test
    void getPathForShouldThrowExceptionIfModuleNameIsEmpty() {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> VersionUpdateConfig.getPathFor(EMPTY_STRING, WITH_PREFIX));
    }


    @Test
    void getPathForShouldThrowExceptionIfWithPrefixIsNull() {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> VersionUpdateConfig.getPathFor(MODULE_NAME, null));
    }

    @Test
    void getPathForShouldThrowExceptionIfWithPrefixIsEmpty() {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> VersionUpdateConfig.getPathFor(MODULE_NAME, EMPTY_STRING));
    }
}