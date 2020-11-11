package dms.pastor.examples.java8.interfaces.defaultmethod;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CubicFormulaAcceptanceTest {

    @Test //default method
    public void calculateAcceptanceTest() {
        // given
        CubicFormula formula = new CubicFormula();
        // when
        double result = formula.calculate(9);

        // then
        assertThat(result).isEqualTo(27.0d);
    }

    @Test // implemented method
    public void sqrtAcceptanceTest() {
        // given
        CubicFormula formula = new CubicFormula();

        // and when
        double result = formula.sqrt(9);

        // then
        assertThat(result).isEqualTo(3.0d);
    }
}
