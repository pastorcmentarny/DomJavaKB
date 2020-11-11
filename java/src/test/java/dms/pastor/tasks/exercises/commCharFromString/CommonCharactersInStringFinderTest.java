package dms.pastor.tasks.exercises.commCharFromString;

import dms.pastor.tasks.exercises.string.CommonCharactersInStringFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 7/11/2014
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CommonCharactersInStringFinderTest {

    private static final String STRING_A = "together";
    private static final String STRING_B = "her";
    private CommonCharactersInStringFinder finder;

    @BeforeEach
    public void setUp() {
        finder = new CommonCharactersInStringFinder();
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void acceptanceCriteria() {
        String stringA = "xencnabfgvcdw";
        String stringB = "bvexmmdfraccm";

        assertThat(finder.getCommonCharN(stringA, stringB)).isEqualTo("xecabfvd");
        assertThat(finder.getCommonCharNSquared(stringA, stringB)).isEqualTo("xecabfvd");
    }

    @Test
    public void testGetCommonCharN() {
        // when
        final String actual = finder.getCommonCharN(STRING_A, STRING_B);

        // then
        assertThat(actual).isEqualTo("ehr");
    }

    @Test
    public void testGetCommonCharNSquared() {
        // when
        final String actual = finder.getCommonCharNSquared(STRING_A, STRING_B);

        // then
        assertThat(actual).isEqualTo("ehr");

    }
}