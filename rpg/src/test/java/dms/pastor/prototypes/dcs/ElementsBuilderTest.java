package dms.pastor.prototypes.dcs;

import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.ElementsBuilder.elementsBuilder;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ElementsBuilderTest {

    @Test
    public void buildWithoutSetCustomVariablesShouldReturnElementsWithZerosVariables() {
        // given
        final Elements expectedElements = new Elements(0, 0, 0, 0);

        // when
        final Elements elements = elementsBuilder().build();

        // then
        assertThat(elements).isEqualTo(expectedElements);
    }

    @Test
    public void buildWithCustomVariablesShouldReturnElementsWithSetVariables() {
        // given
        final int air = 1;
        final int earth = 2;
        final int fire = 3;
        final int water = 4;
        final Elements expectedElements = new Elements(air, earth, fire, water);

        // when
        final Elements elements = elementsBuilder()
            .air(air)
            .earth(earth)
            .fire(fire)
            .water(water)
            .build();

        // then
        assertThat(elements).isEqualTo(expectedElements);
    }

    @Test
    public void setToOneForAllElementsShouldReturnElementsWithOneOfEachElement() {

        // when
        final Elements elements = elementsBuilder()
            .setToOneForAllElements()
            .build();
        // then
        assertThat(elements.hasEnough(new Elements(1, 1, 1, 1)));
    }

}