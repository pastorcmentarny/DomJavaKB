package dms.pastor.game.dcs;

import org.junit.Test;

import static dms.pastor.game.dcs.ElementsBuilder.elementsBuilder;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ElementsBuilderTest {

    @Test
    public void buildWithoutSetCustomVariablesShouldReturnElementsWithZerosVariables() throws Exception {
        // given
        final Elements expectedElements = new Elements(0, 0, 0, 0, 0, 0);

        // when
        final Elements elements = elementsBuilder().build();

        // then
        assertThat(elements).isEqualTo(expectedElements);
    }

    @Test
    public void buildWithCustomVariablesShouldReturnElementsWithSetVariables() throws Exception {
        // given
        final int air = 1;
        final int earth = 2;
        final int fire = 3;
        final int water = 4;
        final int life = 5;
        final int death = 6;
        final Elements expectedElements = new Elements(air, earth, fire, water, life, death);

        // when
        final Elements elements = elementsBuilder()
                .air(air)
                .earth(earth)
                .fire(fire)
                .water(water)
                .life(life)
                .death(death)
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
        assertThat(elements.hasEnough(new Elements(1, 1, 1, 1, 1, 1)));
    }

}