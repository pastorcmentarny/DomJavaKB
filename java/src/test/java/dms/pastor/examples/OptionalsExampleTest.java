package dms.pastor.examples;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.examples.java8.OptionalsExample;
import dms.pastor.utils.PrintOutUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;


public class OptionalsExampleTest {

    @SuppressWarnings("ConstantConditions") //part of learning, I know it is stupid
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
    }

    @Test
    public void Java9OptionalMethodsExampleTest() {
        // when
        final var optional = OptionalsExample.getOptional(false);

        // when
        optional.ifPresentOrElse(System.out::println,
                () -> System.out.println("Empty"));
        assertThat(optional.or(() -> Optional.of(EMPTY_STRING)).orElse(null)).isEmpty();
        assertThat(optional.stream().count()).isZero();
    }

    @Test
    public void java10OptionalMethodsExampleTest() {
        // when
        Assertions.assertThrows(SomethingWentWrongException.class, () -> {
            final var optional = OptionalsExample.getOptional(false);
            optional.orElseThrow(SomethingWentWrongException::new);
        });

    }

    @Test
    public void java10OptionalOrElseThrowDefaultExceptionExampleTest() {
        // when
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            final var optional = OptionalsExample.getOptional(false);
            optional.orElseThrow();
        });
    }

}