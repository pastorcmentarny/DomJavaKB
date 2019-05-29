package dms.pastor.examples;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.PrintOutUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;


public class OptionalsExampleTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void optionalMethodsExampleWhenOptionalHasValueTests() {
        // given
        var optionalValue = "Optional";

        // when
        final var optional = OptionalsExample.getOptional(true);

        // then
        optional.ifPresent(PrintOutUtils::printSizeOfString);
        assertThat(Optional.of(optionalValue).orElseThrow()).isEqualTo(optionalValue);
        assertThat(Optional.ofNullable(null)).isEmpty(); //no idea what is purpose of ofNullable in real world scenarios
        // and then
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get()).isEqualTo(optionalValue); //don't use this method like that use ifPresent first!
        assertThat(optional.filter(string -> string.length() > 10).isEmpty()).isTrue();


    }

    @Test
    public void optionalMethodsExampleWhenOptionalDoNotHaveValueTests() {
        // given
        String text = "no value";

        // when
        final var optional = OptionalsExample.getOptional(false);

        // then
        assertThat(optional.orElse(text)).isEqualTo(text);
        //TODO optional.orElseGet(() -> return new )).isEqualTo(text);
    }

    @Test
    public void Java9OptionalMethodsExampleTest() {
        // when
        final var optional = OptionalsExample.getOptional(false);

        //when
        optional.ifPresentOrElse(System.out::println,
                () -> System.out.println("Empty"));
        assertThat(optional.or(() -> Optional.of(EMPTY_STRING)).orElse(null)).isEmpty();
        assertThat(optional.stream().count()).isZero();
    }

    @Test
    public void java10OptionalMethodsExampleTest() {
        //expect
        exception.expect(SomethingWentWrongException.class);

        // when
        final var optional = OptionalsExample.getOptional(false);

        //when
        optional.orElseThrow(SomethingWentWrongException::new);
    }

    @Test
    public void java10OptionalOrElseThrowDefaultExceptionExampleTest() {
        //expect
        exception.expect(NoSuchElementException.class);

        // when
        final var optional = OptionalsExample.getOptional(false);

        //when
        optional.orElseThrow();

    }

}