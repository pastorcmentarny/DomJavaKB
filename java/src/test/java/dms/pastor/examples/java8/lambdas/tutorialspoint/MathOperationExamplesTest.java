package dms.pastor.examples.java8.lambdas.tutorialspoint;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MathOperationExamplesTest {

    @Test
    public void additionAcceptanceTest() {
        // given
        MathOperation addition = Integer::sum;

        // when
        var result = addition.operation(4,2);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void substractionAcceptanceTest() {
        // given
        MathOperation substraction = (a, b) -> a - b;

        // when
        var result = substraction.operation(4,2);

        // then
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void multiplicationAcceptanceTest() {
        // given
        MathOperation multiplication = (a, b) -> a * b;

        // when
        var result = multiplication.operation(4,2);

        // then
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void divisionAcceptanceTest() {
        // given
        MathOperation division = (a, b) -> a / b;

        // when
        var result = division.operation(4,2);

        // then
        assertThat(result).isEqualTo(2);
    }

}
