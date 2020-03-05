package dms.pastor.prototypes.rockpaperscissors;


import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.rockpaperscissors.Shapes.ROCK;
import static org.assertj.core.api.Assertions.assertThat;

class ShapesTest {

    @Test
    public void shouldThrowExceptionIfCharacterIsInvalid() {

        // expect
        Assertions.assertThrows(SomethingWentWrongException.class,
            () -> Shapes.getShapeFromCharacter('1'));

    }

    @Test
    public void shouldReturnShapeFromCharacter() {
        // given

        // when
        final Shapes result = Shapes.getShapeFromCharacter('R');

        // then
        assertThat(result).isEqualTo(ROCK);
    }


    @Test
    public void shouldReturnRandomShape() {
        // given

        // when
        final Shapes randomShape = Shapes.getRandomShape();

        // then
        assertThat(randomShape).isNotNull();

        // debug
        System.out.println(randomShape.name());


    }
}